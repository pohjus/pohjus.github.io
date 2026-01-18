# Compiling and Running C++ with Clang

This short guide shows how to compile and run a C++ program with `clang++`,
what common options mean, and how to create a small helper script.

## Compile and run

Assume your source file is `mycode.cpp`.

Compile:
```
clang++ -std=c++20 -Wall -Wextra mycode.cpp -o mycode
```

Run:
```
./mycode
```

## What the options mean

- `-std=c++20`: Use the C++20 language standard.
- `-Wall`: Enable a broad set of useful warnings.
- `-Wextra`: Enable additional warnings beyond `-Wall`.
- `-o mycode`: Set the output file name (the compiled program).

## Exercise: make a compile script

Create a script named `compile.sh` to avoid retyping the full command.

1) Create the file:
```
nano compile.sh
```

2) Add this content (with comments so you see what each line does):
```
#!/usr/bin/env bash
# Run in bash. The container has bash installed.
set -euo pipefail
# -e: stop on error, -u: error on unset variables, -o pipefail: catch errors in pipes.

if [ "$#" -lt 1 ]; then
  # Require at least one argument: the .cpp file to compile.
  echo "Usage: ./compile.sh <file.cpp> [output]"
  exit 1
fi

# First argument is the source file.
SOURCE="$1"
# If an output name is not provided, drop the .cpp suffix.
OUTPUT="${2:-${SOURCE%.cpp}}"

# Compile with C++20 and common warnings enabled.
clang++ -std=c++20 -Wall -Wextra "$SOURCE" -o "$OUTPUT"
```

3) Make it executable:
```
chmod +x compile.sh
```

What is `chmod` and why do this?
- `chmod` changes file permissions on Linux.
- `+x` means “make it executable”, so you can run `./compile.sh`.
- In the container (Linux), scripts are not executable by default.
- Windows users: you still run this inside the Linux container, so `chmod +x`
  is needed there even if your host is Windows.

4) Use it:
```
./compile.sh mycode.cpp
```

Optional output name:
```
./compile.sh mycode.cpp mycode
```

And run your app

```
./mycode
```


