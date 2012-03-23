package MyGCC;

public class ParsingResult<T>{
  
  public ResultType type;
  private T value;

  protected ParsingResult(ResultType t,T value){
    type = t;
    this.value = value;
  }
  
  public T getValue(){
    return value;
  }
}