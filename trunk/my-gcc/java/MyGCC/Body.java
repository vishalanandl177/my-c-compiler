package MyGCC;

import java.util.*;

public class Body {
  
  public LinkedList<Declaration> declarations;
  public Block mainBlock;
  
  public Body() {
    this.declarations = new LinkedList<Declaration>();
    this.mainBlock = new Block();
  }
  
  public Body(LinkedList<Declaration> dec, Block b) {
    this.declarations = dec;
    this.mainBlock = b;
  }
  
  public void pushDeclaration(Declaration d) {
    if(this.declarations != null)
      if(d != null)
        this.declarations.add(d);
      else
        System.err.println("The specified declaration is null");
    else
      System.err.println("this.declarations: " + this.declarations + " is null");
  }
  
  public void pushInstructionToBlock(Instruction i) {
    if(this.mainBlock != null)
      if(i != null){
        this.mainBlock.instructions.add(i);
        System.out.println("instruction added to block");
      }
      else
        System.err.println("The specified instruction is null");
    else
      System.err.println("this.mainBlock: " + this.mainBlock + " is null");
  }
  
  public void addBlock(){
    //TODO
  }
  
  public LinkedList<Declaration> getDeclarations() {
    return this.declarations;
  }

  public Block getMainBlock() {
    return this.mainBlock;
  }

  public String toString(){
    StringBuffer sb = new StringBuffer();
    Instruction i;
    Iterator<Instruction> iter = mainBlock.instructions.iterator();
    
    while(iter.hasNext()){
      i = iter.next();
      sb.append(Instruction.instructionToAssembly(i));
    }
    
    return sb.toString();
  }
}
