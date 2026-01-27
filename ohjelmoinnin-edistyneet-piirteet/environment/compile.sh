#!/usr/bin/env bash
set -euo pipefail

if [ "$#" -lt 1 ]; then
  echo "Usage: ./compile.sh <file.cpp> [output]"
  exit 1
fi

SOURCE="$1"
OUTPUT="${2:-${SOURCE%.cpp}}"

clang++ -std=c++20 -Wall -Wextra "$SOURCE" -o "$OUTPUT"
