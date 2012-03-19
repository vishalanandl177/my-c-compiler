package MyGCC;

public abstract class ParsingResult{
  
  public ResultType myType;

  protected ParsingResult(ResultType t){
    myType = t;
  }
}