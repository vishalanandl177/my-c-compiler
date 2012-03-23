int addition(int,int);
int testing(int);
int basic(void);

int addition(int a,int b){
  int c;
  c = a+b;
  return c;
}

int ten_param(int a,
              int b,
              int c,
              int d,
              int e,
              int f,
              int g,
              int h,
              int i,
              int j){
  int r;
  r = a + b + c + d + e + f + g + h + i + j;
  return r;
}

int false_main(void){
  int n;
  int f;
  n = addition(2,3);
  f = ten_param(0,1,2,3,4,5,6,7,8,9);
  return n;
}
