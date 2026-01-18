# Why We Use Docker + clang + nano in This Course

## The Goal of This Course

The goal of this course is **not** to make you fast at writing code.

The goal is to help you **understand how programs actually work**:
- how source code becomes a running program
- how computers execute what you write
- how professional software environments really look

To achieve this, we intentionally use **simple tools** at the beginning.

---

## 1. Understanding What Really Happens When You Run a Program

When you write C or C++ code, the computer cannot run it directly.

Several steps must happen:
1. Your code is **compiled**
2. Object files are **linked**
3. An executable file is created
4. The operating system runs that executable

Using `clang` in the terminal makes these steps **visible**:
```bash
clang -c main.c
clang main.o -o app
./app
```

You see:
- where errors come from
- which step failed
- what files are created

If you start with a full IDE, these steps happen silently.  
That makes learning slower later, even if it feels easier now.

---

## 2. Everyone Has the Same Environment

Different computers behave differently:
- different operating systems
- different compiler versions
- different libraries

This causes confusion:
> “It works on my computer, but not on yours.”

Using **Docker** solves this problem:
- same Linux system
- same compiler
- same tools
- same results

Teacher and students work in **exactly the same environment**.

This means:
- fewer setup problems
- clearer explanations
- fair grading

---

## 3. Learning the Terminal Is a Core Skill

Professional developers use the terminal every day:
- running programs
- debugging
- building software
- working on servers
- using containers and cloud systems

By working in the terminal, you learn:
- how files are organized
- how programs are executed
- how errors are reported

These skills transfer to **any language and any job**.

---

## 4. Learning Linux Matters

Most real-world software runs on Linux:
- servers
- cloud platforms
- containers
- embedded systems

By working inside Docker, you naturally learn:
- Linux commands
- directory structure
- permissions
- standard tools

This knowledge will help you far beyond this course.

---

## 5. Why We Use a Simple Editor Like nano

Editors like nano do **not**:
- auto-complete code
- fix mistakes for you
- suggest solutions
- use AI assistance

This is intentional.

By writing everything manually, you:
- learn syntax properly
- read compiler errors carefully
- understand what each line does
- build confidence in your own knowledge

This may feel uncomfortable at first.  
That discomfort is part of learning.

Once you understand the fundamentals, advanced tools become **helpers**, not crutches.

---

## 6. When Do We Use an IDE Like CLion?

Later.

After you:
- understand compilation and linking
- know how programs run
- feel comfortable in the terminal

At that point, an IDE becomes a productivity tool — not a source of confusion.

---

## Final Message

We choose harder tools now so that:
- future courses feel easier
- debugging makes sense
- tools never hide understanding

This approach builds **strong programmers**, not just fast typists.
