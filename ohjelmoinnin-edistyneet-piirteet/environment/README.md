# C++ Beginner Environment (Docker)

This folder contains a ready-to-use C++ development environment for beginners.
You do not need to install a compiler on your computer; Docker provides it.

## What you need

- Docker Desktop (Windows/macOS) or Docker Engine (Linux)
- A terminal (PowerShell/Command Prompt on Windows, Terminal on macOS/Linux)

## Quick start

1) Open a terminal in this folder.
2) Run the script for your system:

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
```
clang++ -std=c++20 -Wall -Wextra mycode.cpp -o mycode
./mycode
```

- Exit:
```
exit
```

See `COMPILING.md` for a longer explanation and a scripting exercise.

## Troubleshooting

- “Docker not installed” or “Docker not running”:
  Install/start Docker Desktop and try again.
- If `./run.sh` says “permission denied”:
  Run `chmod +x run.sh` and try again.
