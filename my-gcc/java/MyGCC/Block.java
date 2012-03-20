package MyGCC;

import java.util.*;

public class Block {
  
  public ArrayList<Declaration> declarations;
  public ArrayList<Instruction> instructions;
  
  public Block() {
    this.declarations = new ArrayList<Declaration>();
    this.instructions = new ArrayList<Instruction>();
  }
  
  public Block(ArrayList<Declaration> dec, ArrayList<Instruction> ins) {
    this.declarations = dec;
    this.instructions = ins;
  }
  
  public void pushDeclaration(Declaration d) {
    if(this.declarations != null)
      if(d != null)
        this.declarations.add(d);
      else
        System.err.println("Object " + d.toString() + " is null");
    else
      System.err.println("this.declarations: " + this.declarations + " is null");
  }
  
  public void pushInstuction(Instruction i) {
    if(this.instructions != null)
      if(i != null)
        this.instructions.add(i);
      else
        System.err.println("Object " + i.toString() + " is null");
    else
      System.err.println("this.instructions: " + this.instructions + " is null");
  }
  
  public ArrayList<Declaration> getDeclarations() {
    return this.declarations;
  }

  public ArrayList<Instruction> getInstructions() {
    return this.instructions;
  }
}
