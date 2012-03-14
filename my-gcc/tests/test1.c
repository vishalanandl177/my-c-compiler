#include <stdio.h>
int global;

void affichage(int i){
  printf("value : %d ", global);
}

int main(int argc, char ** argv){
  int f(void);
  global = 0;
  affichage(global);
  return 0;
}
