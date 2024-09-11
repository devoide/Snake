#!/bin/bash

# Define the base directories
BASE_DIR=$(dirname "$0")
SRC_DIR="$BASE_DIR/src"
RES_DIR="$BASE_DIR/res"
BIN_DIR="$BASE_DIR/bin"

mkdir -p "$BIN_DIR"


echo "Compiling Java source files..."
javac -d "$BIN_DIR" -cp "$SRC_DIR" "$SRC_DIR/main/"*.java "$SRC_DIR/entity/"*.java

echo "Creating manifest.txt"
echo "Main-Class: main.Main" > "$BASE_DIR/manifest.txt"

echo "Packaging the JAR file..."
jar cvfm "$BASE_DIR/Snake.jar" "$BASE_DIR/manifest.txt" -C "$BIN_DIR" . -C "$RES_DIR" .

echo "Build completed."
read -p "Press enter to continue"



