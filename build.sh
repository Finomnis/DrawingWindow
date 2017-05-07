#!/bin/bash

SCRIPTPATH=$( cd $(dirname $0) ; pwd -P )
BUILDPATH=${SCRIPTPATH}/build

set -o xtrace

rm -rf ${BUILDPATH}
mkdir -p ${BUILDPATH}

javac src/DrawingWindow.java -d ${BUILDPATH}

jar cf DrawingWindow.jar -C ${BUILDPATH} org
