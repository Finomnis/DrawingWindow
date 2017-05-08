#!/bin/bash

SCRIPTPATH=$( cd $(dirname $0) ; pwd -P )
BUILDPATH=${SCRIPTPATH}/build

set -e
set -o xtrace

rm -rf "${BUILDPATH}"
mkdir -p "${BUILDPATH}"

javac "${SCRIPTPATH}/src/DrawingWindow.java" -d "${BUILDPATH}"

jar cf "${SCRIPTPATH}/DrawingWindow.jar" -C "${BUILDPATH}" org
