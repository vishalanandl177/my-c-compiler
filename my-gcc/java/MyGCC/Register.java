package MyGCC;

import java.util.ArrayList;
import java.util.HashSet;
import java.lang.String;

public enum Register {
  
  EAX ("eax", "Return Value", RegisterType.CALLER_SAVED),
  EBX ("ebx", "", RegisterType.CALLEE_SAVED),
  ECX ("ecx", "4th Argument", RegisterType.CALLER_SAVED),
  EDX ("edx", "3rd Argument", RegisterType.CALLER_SAVED),
  ESI ("esi", "2nd Argument", RegisterType.CALLER_SAVED),
  EDI ("edi", "1st Argument", RegisterType.CALLER_SAVED),
  EBP ("ebp", "", RegisterType.SPECIAL), // Technically not a special variable, but will be treated as one
  ESP ("esp", "Stack Pointer", RegisterType.SPECIAL),
  R8D ("r8d", "5th Argument", RegisterType.CALLER_SAVED),
  R9D ("r9d", "6th Argument", RegisterType.CALLER_SAVED),
  R10D ("r10d", "", RegisterType.CALLEE_SAVED),
  R11D ("r11d", "Used for Linking", RegisterType.SPECIAL),
  //R12D ("Unused", RegisterType.UNUSED)  We have no need for this registry as we will only be compiling C
  R13D ("r13d", "", RegisterType.CALLEE_SAVED),
  R14D ("r14d", "", RegisterType.CALLEE_SAVED),
  R15D ("r15d", "", RegisterType.CALLEE_SAVED);
  
  private enum RegisterType {
    CALLEE_SAVED,
    CALLER_SAVED,
    SPECIAL;
    //UNUSED; Would be useful if ever we decided to compile additionnal languages
  }
  
  private String name;
  private String comment;
  private RegisterType type;
  private static HashSet<Register> calleeSaved = new HashSet<Register>();
  private static HashSet<Register> callerSaved = new HashSet<Register>();
  private static HashSet<Register> special = new HashSet<Register>();
  private static ArrayList<Register> arguments = new ArrayList<Register>();
  
  static {
    arguments.add(EDI);
    arguments.add(ESI);
    arguments.add(EDX);
    arguments.add(ECX);
    arguments.add(R8D);
    arguments.add(R9D);
    
    for (Register r : Register.values()){
      addRegister(r);
    }
  }
  
  public static Register getArgumentRegister(int i){
    return arguments.get(i);
  }
  
  private Register (String name, String comment, RegisterType t) {

    this.name = name;
    this.comment = comment;
    assignType(t);
  }
  
  private void assignType(RegisterType t) {
    this.type = t;
  }
  
  private static void addRegister(Register reg) {
    switch(reg.type) {
      case CALLEE_SAVED:
        calleeSaved.add(reg);
        break;
      case CALLER_SAVED:
        callerSaved.add(reg);
        break;
      case SPECIAL:
        special.add(reg);
        break;
      default:
        System.err.println("The RegisterType that was passed to this function is incorrect");
    }
  }
  
  @SuppressWarnings("unchecked")
public static HashSet<Register> getCalleeSaved() {
    return (HashSet<Register>)calleeSaved.clone();
  }
  
  @SuppressWarnings("unchecked")
public static HashSet<Register> getCallerSaved() {
    return (HashSet<Register>)callerSaved.clone();
  }
  
  @SuppressWarnings("unchecked")
public static HashSet<Register> getSpecial() {
    return (HashSet<Register>)special.clone();
  }
  
  public RegisterType getType() {
    return this.type;
  }
  
  public String getTypeString() {
    switch(this.type) {
      case CALLEE_SAVED:
        return new String("CALLEE_SAVED");
      case CALLER_SAVED:
        return new String("CALLER_SAVED");
      default:
        return new String("SPECIAL");
    }
  }
  
  public String toString() {
    return this.name;
  }
}

