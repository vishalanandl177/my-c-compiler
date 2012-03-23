package MyGCC;

public enum OperationType{
  ADD("  add"),
  SUB("  sub"),
  MUL("  mul"),
  DIV("  div");
  
  public String name;

  private OperationType(String s){
    this.name = s;
  }
  
  public String toString(){
    return this.name;
  }

}
