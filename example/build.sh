#!/bin/bash

SCRIPTPATH=$( cd $(dirname $0) ; pwd -P )
BUILDPATH=${SCRIPTPATH}/build

set -e
set -o xtrace

rm -rf "${BUILDPATH}"
mkdir -p "${BUILDPATH}"

javac -cp "$SCRIPTPATH/../DrawingWindow.jar" "${SCRIPTPATH}/src/Main.java" -d "${BUILDPATH}"

jar cfm "${SCRIPTPATH}/example.jar" "${SCRIPTPATH}/Manifest.txt" -C "${BUILDPATH}" Main.class
