package MyGCC;

public class Instruction {
  
  public Expression expr;
  public InstructionType instrType;
  public String assemblyStr;
  
  public Instruction(Expression e, InstructionType op){
    this.expr = e;
    this.instrType = op;
    this.assemblyStr = null;
  }
  
  public static String instructionToAssembly(Instruction instruct){
    StringBuffer sb = new StringBuffer();
    String left = new String();
    String right = new String();
    Register regL, regR;
    ArithmeticResult tmpL, tmpR;
    
    if(instruct != null){
      if(instruct.expr == null)
        sb.append("\tleave\n\tret\n");
      
      if(instruct.expr instanceof ArithmeticResult){
        tmpL = (ArithmeticResult)instruct.expr.left;
        tmpR = (ArithmeticResult)instruct.expr.right;
        left = (String)tmpL.getValue();
        right = (String)tmpR.getValue();
      }
      
      switch(instruct.instrType){
        
        case RETURN:
          sb.append("\tmovl " /*+ instr.expr.value*/ + ", %eax").append("\tleave\n\tret\n");
          break;
          
        case EXIT:
          //TODO
          break;  
          
        case EQL:
          regL = Parser.regMan.addVariableToRegister(left);
          regR = Parser.regMan.addVariableToRegister(right);
          sb.append("\tmovl " + regL.toString() + ", " + regR.toString());
          System.out.println("MY INSTRUCTION: " + sb.toString());
          break;
          
        default:
          // case null, ie. for instructions like "1+2;"
          // optimize and don't calculate
          break;
      }
      
      instruct.assemblyStr = sb.toString();
      return instruct.assemblyStr;
    }
    else{
      System.err.println("ERROR: instruction is null");
      return null;
    }
  }
  
  
}
