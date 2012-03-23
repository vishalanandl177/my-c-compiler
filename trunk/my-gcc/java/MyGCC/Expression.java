package MyGCC;

public abstract class Expression{
  
    public Expression left;
    public Expression right;
    public String value;    //Registry
    public String op;
    
    public Expression(){
      this.left = null;
      this.right = null;
    }
    
}
