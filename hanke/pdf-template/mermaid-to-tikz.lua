-- Minimal mermaid "flowchart" -> TikZ converter.
-- No network/mermaid-cli available in this environment, so simple linear
-- flowcharts (the only kind used in this document) are redrawn natively in
-- LaTeX instead of being left as unrendered code text.

local function escape_latex(s)
  s = s:gsub("\\", "\\textbackslash{}")
  s = s:gsub("([%%#&_%$])", "\\%1")
  return s
end

local function convert_label(raw)
  local s = escape_latex(raw)
  s = s:gsub("<br%s*/?>", "\\\\")
  return s
end

local function build_tikz(code)
  local direction = code:match("flowchart%s+(%u+)") or "LR"
  local nodes = {}       -- ordered list of {id=, label=}
  local seen = {}
  local edges = {}       -- ordered list of {from=, to=, label=}

  local function register(id, label)
    if id and not seen[id] then
      seen[id] = true
      nodes[#nodes + 1] = { id = id, label = label and convert_label(label) or id }
    elseif id and label and seen[id] then
      for _, n in ipairs(nodes) do
        if n.id == id then n.label = convert_label(label) end
      end
    end
  end

  for line in code:gmatch("[^\r\n]+") do
    if not line:match("^%s*flowchart") then
      for id, label in line:gmatch('(%w+)%["([^"]-)"%]') do
        register(id, label)
      end
      -- Drop bracketed "...["label"]..." chunks so the arrow sits directly
      -- between bare node ids, regardless of whether this line also defines
      -- one of the nodes' labels.
      local stripped = line:gsub("%b[]", "")
      local from, elabel, to = stripped:match("(%w+)%s*%-%->|(.-)|%s*(%w+)")
      if not from then
        from, to = stripped:match("(%w+)%s*%-%->%s*(%w+)")
      end
      if from and to then
        register(from, nil)
        register(to, nil)
        edges[#edges + 1] = { from = from, to = to, label = elabel and convert_label(elabel) or nil }
      end
    end
  end

  if #nodes == 0 then return nil end

  local chain = (direction == "TD" or direction == "TB") and "below" or "right"
  local lines = {}
  lines[#lines + 1] = "\\begin{center}"
  lines[#lines + 1] = "\\begin{tikzpicture}[node distance=18mm and 18mm,"
  lines[#lines + 1] = "  box/.style={rectangle, draw=inknavy, thick, rounded corners=2pt,"
  lines[#lines + 1] = "    fill=tablestripe, text width=32mm, align=center, font=\\sffamily\\small,"
  lines[#lines + 1] = "    minimum height=13mm, inner sep=3pt},"
  lines[#lines + 1] = "  lbl/.style={font=\\sffamily\\scriptsize\\itshape, text=accent, fill=white,"
  lines[#lines + 1] = "    draw=none, inner sep=1.5pt}]"

  for i, n in ipairs(nodes) do
    if i == 1 then
      lines[#lines + 1] = string.format("\\node[box] (%s) {%s};", n.id, n.label)
    else
      lines[#lines + 1] = string.format("\\node[box, %s=of %s] (%s) {%s};", chain, nodes[i - 1].id, n.id, n.label)
    end
  end

  for _, e in ipairs(edges) do
    if e.label then
      lines[#lines + 1] = string.format(
        "\\draw[-{Latex[length=2mm]}, accent, thick] (%s) -- node[lbl] {%s} (%s);",
        e.from, e.label, e.to)
    else
      lines[#lines + 1] = string.format(
        "\\draw[-{Latex[length=2mm]}, accent, thick] (%s) -- (%s);", e.from, e.to)
    end
  end

  lines[#lines + 1] = "\\end{tikzpicture}"
  lines[#lines + 1] = "\\end{center}"
  return table.concat(lines, "\n")
end

-- Pandoc's automatic pipe-table column widths are proportional to raw
-- Markdown source length, which starves short label columns (e.g. a
-- "Näkökulma" row-label column next to long descriptive columns) and forces
-- ugly mid-word breaks. Give a 4-column table's first column a fixed,
-- readable share instead.
function Table(tbl)
  local n = #tbl.colspecs
  if n == 4 then
    local first = 0.15
    local rest = (1 - first) / (n - 1)
    for i, spec in ipairs(tbl.colspecs) do
      spec[2] = (i == 1) and first or rest
    end
  end
  return tbl
end

function CodeBlock(el)
  local classes = {}
  for _, c in ipairs(el.classes) do classes[c] = true end
  if classes["mermaid"] then
    local tikz = build_tikz(el.text)
    if tikz then
      return pandoc.RawBlock("latex", tikz)
    end
  end
  return nil
end
