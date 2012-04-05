#!/bin/sh
ant clean
ant

OUR_COMPILER="java -jar jar/Compiler.jar"

TEST4="tests/test4"

$OUR_COMPILER $TEST4.c

gcc $TEST4.s executor.c
