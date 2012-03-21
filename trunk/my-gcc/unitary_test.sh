#!/bin/sh
ant clean
ant

OUR_COMPILER="java -jar jar/Compiler.jar"

TEST1="tests/test1"

$OUR_COMPILER $TEST1.c

gcc $TEST1.s executor.c