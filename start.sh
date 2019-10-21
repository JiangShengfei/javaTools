#!/bin/bash

CURRPATH=`pwd`
JARPATH="mysql-connector-java-5.1.39-bin.jar"
CLASSPATH="${CURRPATH}:${CURRPATH}/${JARPATH}"
export CLASSPATH
echo $CLASSPATH

if test -e ./DatabaseCheck.class
then
    java DatabaseCheck
else
    javac DatabaseCheck.java
    java DatabaseCheck
fi

