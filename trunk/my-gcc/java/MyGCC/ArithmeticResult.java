package MyGCC;

public class ArithmeticResult extends Expression{

    public ResultType myType;


    public ArithmeticResult(String value, String op){
      super(ResultType.ARITHMETIC);
      this.op = op;
      this.value = value;
    }
    
    public ArithmeticResult(String value, String op, Expression l, Expression r){
      super(ResultType.ARITHMETIC);
      this.op = op;
      this.value = value;
      this.left = l;
      this.right = r;
    }

}
