# C++ Beginner Environment (Docker)

## IDE vs Docker + Clang

You have started to learn the concepts using a professional IDE like Clion. That approach is widely used and completely valid, especially when the goal is to help students become productive quickly.

In this part of the course, the goal is slightly different. We focus on **making the fundamentals visible first**, before relying on advanced tools that automate many steps.

This approach can be more complicated, but we do it for a reason:
See more reasoning about this topic in [`why.md`](./why.md).

- Understanding what happens when running a program
- Everyone has the same environment: Linux and Clang
- Learning the terminal is a core skill, especially on Linux
- By writing everything manually instead of AI and autocompletion you will gain a deeper understanding

## What you need

- [**Docker Desktop**](https://www.docker.com/products/docker-desktop/) (Windows/macOS) or Docker Engine (Linux)
- A terminal (PowerShell/Command Prompt on Windows, Terminal on macOS/Linux)
- [`Dockerfile`](./Dockerfile) - file
- [`run.bat`](./run.bat) or [run.sh](./run.sh) file

### Optional

- [`compile.sh`](./compile.sh) file for easier compiling

## Quick start

- [Install Docker Desktop](https://www.docker.com/products/docker-desktop/) and start Docker
- Verify it works: run `docker --version` or `docker run hello-world`
- Download [`Dockerfile`](./Dockerfile) and [`run.bat`](./run.bat) or [run.sh](./run.sh)
  - `.bat` → win, `.sh` → macOS or linux
- Place the `Dockerfile` and `run.sh|.bat` file in the same directory
- Open terminal (cmd) within that directory
- Run the script either: `./run.sh` or `run.bat` (PowerShell: `.\run.bat`)

The script will build the Docker image and open a shell inside the container. This creates a Linux environment with the Clang compiler and Nano text editor.

Once ready, you will be inside a Linux environment with the `clang` compiler and the Nano text editor.

## Inside the container

### Edit files:

```
nano mycode.cpp
```

`ctrl-o` saves, `ctrl-x` exits

### Compile and run:

```bash
clang++ -std=c++20 -Wall -Wextra mycode.cpp -o application
./application
```

What?

- `-std=c++20`: Use the C++20 language standard.
- `-Wall`: Enable a broad set of useful warnings.
- `-Wextra`: Enable additional warnings beyond `-Wall`.
- `-o application`: Set the output file name (the compiled program).

Since this is a rather long command you can do it a bit easier.
Download a [`compile.sh`](./compile.sh) file which will give the same command:

```bash
compile.sh mycode.cpp application
```

### Exit:

```
exit
```

## Gif - animations

### Windows

![windows docker usage](./windows.gif)

### macOS

![mac docker usage](./mac.gif)

## Troubleshooting

- “Docker not installed” or “Docker not running”:
  Install/start Docker Desktop and try again.
- If `./run.sh` says “permission denied”:
  Run `chmod +x run.sh` and try again.
