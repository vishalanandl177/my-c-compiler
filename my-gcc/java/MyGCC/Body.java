package MyGCC;

import java.util.*;

public class Body {
  
  public ArrayList<Declaration> declarations;
  public Block block;
  
  public Body() {
    this.declarations = new ArrayList<Declaration>();
    this.block = new Block();
  }
  
  public Body(ArrayList<Declaration> dec, Block b) {
    this.declarations = dec;
    this.block = b;
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
  
  public void pushInstuctionToBlock(Instruction i) {
    if(this.block != null)
      if(i != null)
        this.block.instructions.add(i);
      else
        System.err.println("Object " + i.toString() + " is null");
    else
      System.err.println("this.block: " + this.block + " is null");
  }
  
  public void addBlock(){
    //TODO
  }
  
  public ArrayList<Declaration> getDeclarations() {
    return this.declarations;
  }

  public Block getBlock() {
    return this.block;
  }
}
