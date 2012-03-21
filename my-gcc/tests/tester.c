#include <stdio.h>
#include "test1.h"

int main(int argc, char ** argv){

  int a;
  int b;

  a = 5;
  b = 9;

  if(a % 5 == 0)
    b++;
  return 0;
}
