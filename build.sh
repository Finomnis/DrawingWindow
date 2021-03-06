#!/bin/bash

SCRIPTPATH=$( cd $(dirname $0) ; pwd -P )
BUILDPATH=${SCRIPTPATH}/build

set -e
set -o xtrace

rm -rf "${BUILDPATH}"
mkdir -p "${BUILDPATH}"

javac "${SCRIPTPATH}/src/DrawingWindow.java" \
      "${SCRIPTPATH}/src/ColorPalette.java" \
      "${SCRIPTPATH}/src/ColorMap.java" \
      -d "${BUILDPATH}"

#jar cf "${SCRIPTPATH}/DrawingWindow.jar" -C "${BUILDPATH}" org
cp ${SCRIPTPATH}/src/* ${BUILDPATH}/org/finomnis/common/graphics/
jar cf "${SCRIPTPATH}/DrawingWindow.jar" -C "${BUILDPATH}" org
