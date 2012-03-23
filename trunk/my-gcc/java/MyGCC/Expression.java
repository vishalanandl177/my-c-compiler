package MyGCC;

public abstract class Expression extends ParsingResult{
  
    public Expression left;
    public Expression right;
    public String value;    //Registry
    public String op;
    
    public Expression(ResultType t){
      super(t);
      this.left = null;
      this.right = null;
    }
    
}
