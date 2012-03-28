package MyGCC;

public class ArithmeticResult<T> extends Expression{
  
  private T value;

  public ArithmeticResult(String op, T value){
      super();
      this.op = op;
      this.value = value;
    }
    
    public ArithmeticResult(String op, Expression l, Expression r){
      super();
      this.op = op;
      this.left = l;
      this.right = r;
    }
    
  public T getValue(){
    return value;
  }

}
