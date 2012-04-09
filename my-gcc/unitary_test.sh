#!/bin/sh
ant clean
ant

OUR_COMPILER="java -jar jar/Compiler.jar"

TEST="tests/test1"

#TEST4="tests/test4"

$OUR_COMPILER $TEST.c

gcc $TEST.s tests/executor.c
