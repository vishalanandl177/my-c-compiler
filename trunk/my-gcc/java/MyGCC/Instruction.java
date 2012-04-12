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
  
  private static String handleIntInt(Integer lval, Integer rval, OperationType op, Register reg){
    Integer result = 0; //TODO shouldn't initialize to 0
    switch(op){
      case ADD:
        result = lval + rval;
        break;
                    
      case SUB:
        result = lval - rval;
        break; 
                    
      case MUL:
        result = lval * rval;
        break;
                    
      case DIV:
        result = lval / rval;
        break; 
        
      default:
        //Send error
        break;
      } 

    return "\tmovl %" + result + ", %" + reg.toString() + "\n"; //should use stack instead of immediate register
  }
  
  
  public static String instructionToAssembly(Instruction instruct){
    StringBuffer sb = new StringBuffer();
    String left = new String();
    String right = new String();
    String center = new String();
    Register regL = null;
    Register regR = null; 
    Register reg = null;
    ArithmeticResult tmpL = null;
    ArithmeticResult tmpR = null;  
    ArithmeticResult tmp = null;  
     
    if(instruct != null){
      if(instruct.expr == null){
        //sb.append("\tleave\n\tret\n"); Already handled in epilogue()
      }
      
      if(instruct.expr instanceof ArithmeticResult){
        tmpL = (ArithmeticResult)instruct.expr.left;
        tmpR = (ArithmeticResult)instruct.expr.right;
        tmp = (ArithmeticResult)instruct.expr;
        center = String.valueOf(tmp.getValue());
        left = String.valueOf(tmpL.getValue());
        right = String.valueOf(tmpR.getValue());
      }
      
      /*if(instruct.expr instanceof FunctionCall){
        //TODO
      }*/
      
      switch(instruct.instrType){
        
        case RETURN:
          sb.append("\tmovl " /*+ instr.expr.value*/ + ", %eax");
          break;
          
        case EXIT:
          //TODO
          break;  
          
        case EQL:
          if(tmpL.getValue() instanceof Integer && tmpR.getValue() instanceof Integer){
            reg = Parser.regMan.addVariableToRegister(center); //FIXME: center is null
            System.out.println("I-I INSTRUCTION:\n" + center);
            sb.append(handleIntInt((Integer)tmpL.getValue(), (Integer)tmpR.getValue(), instruct.expr.op, reg));
          }
        
          else if(tmpL.getValue() instanceof String && tmpR.getValue() instanceof String){
              regL = Parser.regMan.addVariableToRegister(left);
              regR = Parser.regMan.addVariableToRegister(right);
              sb.append("\tmovl %" + tmpL.getValue() + ", %" + regL.toString() + "\n");
              sb.append("\tmovl %" + tmpR.getValue() + ", %" + regR.toString() + "\n");
              sb.append("\t" + instruct.expr.op.toString() + " %" + regL.toString() + ", %" + regR.toString() + "\n");
              System.out.println("S-S INSTRUCTION:\n" + sb.toString());
          }
            
          else if(tmpL.getValue() instanceof Integer && tmpR.getValue() instanceof String){
              regR = Parser.regMan.addVariableToRegister(right);
              sb.append("\t" + instruct.expr.op.toString() + " %" + tmpL.getValue() + ", %" + regR.toString() + "\n");
              System.out.println("I-S INSTRUCTION:\n" + sb.toString());
          }
            
          else if(tmpL.getValue() instanceof String && tmpR.getValue() instanceof Integer){
              regL = Parser.regMan.addVariableToRegister(left);
              sb.append("\t" + instruct.expr.op.toString() + " %" + tmpR.getValue() + ", %" + regL.toString() + "\n");
              System.out.println("S-I INSTRUCTION:\n" + sb.toString());
          }
          
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
