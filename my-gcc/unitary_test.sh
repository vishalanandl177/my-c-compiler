#!/bin/sh
ant clean
ant

COMPILER = java -jar jar/Compiler.jar

${COMPILER} tests/test1.c

