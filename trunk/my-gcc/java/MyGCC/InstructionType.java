package MyGCC;

public enum InstructionType{
  RETURN("ret"),
  EXIT("leave"), //TODO check corresponding instruction
  EQL("movl");
  
  public String name;

  private InstructionType(String s){
    this.name = s;
  }
  
  public String toString(){
    return this.name;
  }
}
