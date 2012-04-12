package MyGCC;

public class ArithmeticResult<T> extends Expression{
  
  private T value;

  public ArithmeticResult(OperationType op, T value){
      super();
      this.op = op;
      this.value = value;
    }
    
    public ArithmeticResult(OperationType op, Expression l, Expression r){
      super();
      this.op = op;
      this.left = l;
      this.right = r;
    }
    
  public T getValue(){
    return value;
  }

}
