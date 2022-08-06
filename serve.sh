#!/usr/bin/env bash

cd public || exit 1
python3 -m http.server
