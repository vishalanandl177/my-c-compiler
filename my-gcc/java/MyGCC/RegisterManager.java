package MyGCC;

import java.util.*;
import java.util.AbstractMap.*;

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
    
    ArrayList<HashSet<Register>> al = new ArrayList<HashSet<Register>>(); 
    HashSet<Register> list = Register.getCallerSaved();
    al.add(list);
    list = Register.getCalleeSaved();
    al.add(list);
    
    Register r;
    Iterator<Register> iter;
    
    for(HashSet<Register> hsr : al) {
      iter = hsr.iterator();
      
      while(iter.hasNext()) {
        r = iter.next();
        if(!this.usedRegisters.containsKey(r))
          return r;
      }
    }

    System.err.println("No free registers were found.");
    return null;
  }
  
  public SimpleEntry<Register, Register> getTwoRegisters() {
    
    ArrayList<HashSet<Register>> al = new ArrayList<HashSet<Register>>();   
    HashSet<Register> list = Register.getCallerSaved();
    al.add(list);
    list = Register.getCalleeSaved();
    al.add(list);

    
    Iterator<Register> iter;
    Register r = null;
    Register r1 = null;
    Register r2 = null;
    
    for(HashSet<Register> hsr : al) {
      iter = hsr.iterator();
    
      while(iter.hasNext()) {
        r = iter.next();
        if(!this.usedRegisters.containsKey(r))
          if(r1 == null)
            r1 = r;
          else
            r2 = r;
      }
    
      if(r1 != null && r2 != null)
        return (new SimpleEntry<Register, Register>(r1, r2));
    }

    System.out.println("Assigning two registers failed");
    
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
  
  public static void main(String[] args) {
    RegisterManager rm = new RegisterManager();
    Register r = rm.getFreeRegister();
    System.out.println(r.toString());    
  }
}
