package MyGCC;

public class Instruction {
  
  public Expression lexpr;
  public Expression rexpr;
  public InstructionType instrType;
  public String assemblyStr;
  
  public Instruction(Expression r, InstructionType op){
    this.lexpr = null;
    this.rexpr = r;
    this.instrType = op;
    this.assemblyStr = null;
  }
  
  public Instruction(Expression l, Expression r, InstructionType op){
    this.lexpr = l;
    this.rexpr = r;
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
    ArithmeticResult tmpL = null;
    ArithmeticResult tmpR = null;  
    ArithmeticResult tmp = null;  
     
    if(instruct != null){
      if(instruct.rexpr == null){
        //sb.append("\tleave\n\tret\n"); Already handled in epilogue()
      }
      
      if(instruct.rexpr instanceof ArithmeticResult){
        tmpL = (ArithmeticResult)instruct.rexpr.left;
        tmpR = (ArithmeticResult)instruct.rexpr.right;
        tmp = (ArithmeticResult)instruct.lexpr;
        center = String.valueOf(tmp.getValue());
        left = String.valueOf(tmpL.getValue());
        right = String.valueOf(tmpR.getValue());
      }
      
      /*if(instruct.expr instanceof FunctionCall){
        //TODO
      }*/
      
      switch(instruct.instrType){
        
        case RETURN:
          sb.append("\tmovl " /*+ instr.rexpr.value*/ + ", %eax");
          break;
          
        case EXIT:
          //TODO
          break;
          
        case EQL:
          if(tmpL.getValue() instanceof Integer && tmpR.getValue() instanceof Integer){
            regR = Parser.regMan.addVariableToRegister(center, 'e');
            sb.append(handleIntInt((Integer)tmpL.getValue(), (Integer)tmpR.getValue(), instruct.rexpr.op, regR));
          }
        
          else if(tmpL.getValue() instanceof String && tmpR.getValue() instanceof String){
              regL = Parser.regMan.addVariableToRegister(left, 'e');
              regR = Parser.regMan.addVariableToRegister(right, 'e');
              sb.append("\tmovl %" + tmpL.getValue() + ", %" + regL.toString() + "\n");
              sb.append("\tmovl %" + tmpR.getValue() + ", %" + regR.toString() + "\n");
              sb.append("\t" + instruct.rexpr.op.toString() + " %" + regL.toString() + ", %" + regR.toString() + "\n");
          }
            
          else if(tmpL.getValue() instanceof Integer && tmpR.getValue() instanceof String){
              regR = Parser.regMan.addVariableToRegister(right, 'e');
              sb.append("\tmovl %" + tmpR.getValue() + ", %" + regR.toString() + "\n");
              sb.append("\t" + instruct.rexpr.op.toString() + " %" + tmpL.getValue() + ", %" + regR.toString() + "\n");
          }
            
          else if(tmpL.getValue() instanceof String && tmpR.getValue() instanceof Integer){
              regR = Parser.regMan.addVariableToRegister(left, 'e');
              sb.append("\tmovl %" + tmpL.getValue() + ", %" + regR.toString() + "\n");
              sb.append("\t" + instruct.rexpr.op.toString() + " %" + tmpR.getValue() + ", %" + regR.toString() + "\n");
          }
          
          sb.append("\tmovl %" + regR.toString() + ", -x(%rbp)" + "\n");
          
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
