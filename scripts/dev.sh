#!/bin/bash

# Start a webserver serving the static resources in the background and capture the PID
python3 -m http.server --directory public/ > /dev/null &
SERVER="$!"

# Recompile CSS on save
lein sass watch &
SASS="$!"

echo "Hit <enter> to quit"
read -r _DONE

kill "$SERVER"
trap "kill $SERVER $SASS" SIGINT SIGTERM EXIT SIGSTOP

echo Done.
