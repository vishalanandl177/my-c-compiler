package MyGCC;

import java.util.*;

public class RegisterManager {
  private HashMap<Register, String> usedRegisters;
  //private HashSet<Register> freeRegisters;
  
  public RegisterManager() {
    this.usedRegisters = new HashMap<Register, String>();
    /*this.freeRegisters = Register.getCallerSaved();
    this.freeRegisters.*/
  }
  
  public boolean isListedVariable(String var) {
    return this.usedRegisters.containsValue(var);
  }
  
  public boolean isRegisterUsed(Register r) {
    return this.usedRegisters.containsKey(r);
  }
  
  public Register getFreeRegister() {
    HashSet<Register> list = Register.getCallerSaved();
    Iterator<Register> iter;
    iter = list.iterator();
    Register r;
    
    while(iter.hasNext()) {
      r = iter.next();
      if(!this.usedRegisters.containsKey(r))
        return r;
    }

    list = Register.getCalleeSaved();
    iter = list.iterator();
    while(iter.hasNext()) {
      r = iter.next();
      if(!this.usedRegisters.containsKey(r))
        return r;
    }
    
    System.err.println("No free registers were found.");
    return null;
  }
  
  public Register addVariableToRegister(String var) {
    if(!isListedVariable(var)) {
      Register r = getFreeRegister();
      this.usedRegisters.put(r, var);
      return r;
    } else {
      Set<Register> regSet = this.usedRegisters.keySet();
      for(Register reg : regSet)
        if(this.usedRegisters.get(reg).equals(var))
          return reg;
    }
    return null;
  }
  
  public void freeRegister(Register r) {
    if(this.usedRegisters.containsKey(r))
      this.usedRegisters.remove(r);
    else
      System.err.println("The Register did not have any variables set to it.");
  }
  
  public void freeVariable(String var) {
    Set<Register> regSet = new HashSet<Register>();
    if(this.usedRegisters.containsValue(var))
      regSet = this.usedRegisters.keySet();
      for(Register reg : regSet)
        if(this.usedRegisters.get(reg).equals(var))
          this.usedRegisters.remove(reg);
    else
      System.err.println("The variable was not set to any registers.");
  }
}
