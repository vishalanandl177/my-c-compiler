package MyGCC;

public class Instruction {
  
  public Expression expr;
  public InstructionType instrType;
  public String str;
  
  public Instruction(Expression e, InstructionType op){
    this.expr = e;
    this.instrType = op;
    this.str = null;
  }
  
  
}
