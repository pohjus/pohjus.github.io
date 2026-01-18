# C++ Beginner Environment (Docker)

## Why not Clion?

You have started to learn the concepts using professional IDE like Clion. That approach is widely used and completely valid, especially when the goal is to help students become productive quickly.

In this part of the course, the goal is slightly different.

Our focus is on **making the fundamentals visible first**, before relying on advanced tools that automate many steps.

This approach can be more complicated but we do at a reason

- Understanding what happens running an program
- Everyone has the same environment: linux and clang
- Learning the terminal is a core skill, expecially Linux
- By writing everything manually instead of AI and auto completion you will gain a deeper understanding

See [Why We Use Docker + clang + nano in this part of the Course](./why.md).

## What you need

- [**Docker Desktop**](https://www.docker.com/products/docker-desktop/) (Windows/macOS) or Docker Engine (Linux)
- A terminal (PowerShell/Command Prompt on Windows, Terminal on macOS/Linux)
- [`Dockerfile`](./Dockerfile) - file
- [`run.bat`](./run.bat) or [run.sh](./run.sh) file

Optional

- [`compile.sh`](./compile.sh) file for easier compiling

## Quick start

### Windows

1. Open a terminal in this folder.
2. Run the script for your system:

Windows:

```
run.bat
```

macOS/Linux:

```
./run.sh
```

The script will build the Docker image and open a shell inside the container. Basically it will create a linux environment with clang compiler and nano text editor.

[**Why this instead of clion?**]

## Inside the container

### Edit files:

```
nano mycode.cpp
```

`ctrl-w` saves, `ctrl-o` exits

### Compile and run:

```bash
clang++ -std=c++20 -Wall -Wextra mycode.cpp -o mycode
./application
```

or (if you have the [`compile.sh`](./compile.sh) file) you can do it easier (basically gives the same command):

```bash
compile.sh mycode.cpp application
```

### Exit:

```
exit
```

See [`COMPILING.md`](./COMPILING.md) for a longer explanation and a scripting exercise.

### Windows

![windows docker usage](./windows.gif)

### macOS

![mac docker usage](./mac.gif)

## Troubleshooting

- “Docker not installed” or “Docker not running”:
  Install/start Docker Desktop and try again.
- If `./run.sh` says “permission denied”:
  Run `chmod +x run.sh` and try again.
