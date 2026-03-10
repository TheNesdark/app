#!/usr/bin/env bash
set -euo pipefail
ROOT_DIR="$(cd "$(dirname "$0")/.." && pwd)"
OUT_DIR="$ROOT_DIR/out-config"
DIST_DIR="$ROOT_DIR/dist"
rm -rf "$OUT_DIR"
mkdir -p "$OUT_DIR" "$DIST_DIR"

javac -encoding UTF-8 -d "$OUT_DIR" \
  "$ROOT_DIR/src/main/java/Utilidades/Validationerror.java" \
  "$ROOT_DIR/src/main/java/Acceso/VentanaConfig.java"

jar cfe "$DIST_DIR/genoma-configurator.jar" Acceso.VentanaConfig -C "$OUT_DIR" .

echo "Jar generado: $DIST_DIR/genoma-configurator.jar"
