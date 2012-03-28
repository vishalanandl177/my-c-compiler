package MyGCC;

public enum OperationType{
  ADD("addl"),
  SUB("subl"),
  MUL("imull"),
  DIV("idivl"),
  LESS("jl"),
  GREATER("jg"),
  EQUALS("je"),
  LEQL("jle"),
  GEQL("jge"),
  DIFF("jne"),
  MOD("mod"),
  OR("orl"),
  AND("andl");
  
  public String name;

  private OperationType(String s){
    this.name = s;
  }
  
  public String toString(){
    return this.name;
  }

}
