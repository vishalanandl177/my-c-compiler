package MyGCC;

import java.util.HashSet;
import java.lang.String;

public enum Register {
  
  EAX ("eax", "Return Value", RegisterType.CALLER_SAVED),
  EBX ("ebx", "", RegisterType.CALLEE_SAVED),
  ECX ("ecx", "4th Argument", RegisterType.CALLER_SAVED),
  EDX ("edx", "3rd Argument", RegisterType.CALLER_SAVED),
  ESI ("esi", "2nd Argument", RegisterType.CALLER_SAVED),
  EDI ("edi", "1st Argument", RegisterType.CALLER_SAVED),
  EBP ("ebp", "", RegisterType.CALLEE_SAVED),
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
  
  private static String name;
  private static String comment;
  private static RegisterType type;
  private static HashSet<Register> calleeSaved = new HashSet<Register>();
  private static HashSet<Register> callerSaved = new HashSet<Register>();
  private static HashSet<Register> special = new HashSet<Register>();
  
  private Register (String name, String comment, RegisterType t) {
    name = name;
    comment = comment;
    assignType(t);
    
    Register.addRegister(this, t);
  }
  
  private static void assignType(RegisterType t) {
    type = t;
  }
  
  private static void addRegister(Register reg, RegisterType t) {
    switch(t) {
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
  
  public static HashSet<Register> getCalleeSaved() {
    return (HashSet<Register>)calleeSaved.clone();
  }
  
  public static HashSet<Register> getCallerSaved() {
    return (HashSet<Register>)callerSaved.clone();
  }
  
  public static HashSet<Register> getSpecial() {
    return (HashSet<Register>)special.clone();
  }
  
  public String toString() {
    return this.name;
  }
}

