# C++ Beginner Environment (Docker)

## What you need

- [**Docker Desktop**](https://www.docker.com/products/docker-desktop/) (Windows/macOS) or Docker Engine (Linux)
- A terminal (PowerShell/Command Prompt on Windows, Terminal on macOS/Linux)
- [`Dockerfile`](./Dockerfile) - file
- [`run.bat`](./run.bat) or [run.sh](./run.sh) file

Optional

- [`compile.sh`](./compile.sh) file for easier compiling

## Quick start

### macOS

![mac docker usage](./mac.gif)

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

The script will build the Docker image and open a shell inside the container.

## Inside the container

- Edit files:

```
nano mycode.cpp
```

- Compile and run:

```bash
clang++ -std=c++20 -Wall -Wextra mycode.cpp -o mycode
./application
```

or (if you have the [`compile.sh`](./compile.sh) file)

```bash
compile.sh mycode.cpp application
```

- Exit:

```
exit
```

See [`COMPILING.md`](./COMPILING.md) for a longer explanation and a scripting exercise.

## Troubleshooting

- “Docker not installed” or “Docker not running”:
  Install/start Docker Desktop and try again.
- If `./run.sh` says “permission denied”:
  Run `chmod +x run.sh` and try again.
