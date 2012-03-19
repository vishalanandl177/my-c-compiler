package MYGCC;

public class FunctionResult extends ParsingResult {
  
  public Type retType;
  public String identifier;
  public Tuple arguments;
  public Block body;
  
  public FunctionResult() {
    this.retType = new Type();
    this.identifier = new String();
    this.arguments = new Tuple();
    this.body = new Block();
  }
  
  public FunctionResult(Type t, String id, Tuple args, Block b) {
    this.retType = t;
    this.identifier = id;
    this.arguments = args;
    this.body = b;
  }
  
  public Type getReturn() {
    return this.retType;
  }
  
  public String getIdentifier() {
    return this.identifier;
  }
  
  public Tuple getArguments() {
    return this.arguments;
  }
  
  public Block getBlock() {
    return this.body;
  }
  
  public void setReturn(Type t) {
    this.retType = t;
  }
  
  public void setIdentifier(String id) {
    this.identifier = id;
  }
  
  public void setArguments(Tuple args) {
    this.arguments = args;
  }

  public void setBody(Block b) {
    this.body = b;
  }
}
