#!/bin/bash

SCRIPTPATH=$( cd $(dirname $0) ; pwd -P )
BUILDPATH=${SCRIPTPATH}/build

set -o xtrace

rm -rf ${BUILDPATH}
mkdir -p ${BUILDPATH}

javac -cp "$SCRIPTPATH/../DrawingWindow.jar" src/Main.java -d ${BUILDPATH}

jar cfm example.jar Manifest.txt -C ${BUILDPATH} Main.class
