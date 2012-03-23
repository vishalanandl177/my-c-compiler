package MyGCC;

public class ArithmeticResult extends Expression{


    public ArithmeticResult(String value, String op){
      super();
      this.op = op;
      this.value = value;
    }
    
    public ArithmeticResult(String value, String op, Expression l, Expression r){
      super();
      this.op = op;
      this.value = value;
      this.left = l;
      this.right = r;
    }

}
