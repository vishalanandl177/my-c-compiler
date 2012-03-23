package MyGCC;

public class Instruction {
  
  public Expression expr;
  public InstructionType instrType;
  
  public Instruction(Expression e, InstructionType op){
    this.expr = e;
    this.instrType = op;
  }
  
  
  
}
