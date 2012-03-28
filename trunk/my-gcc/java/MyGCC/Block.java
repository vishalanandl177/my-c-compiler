package MyGCC;

import java.util.*;

public class Block {
  
  public ArrayList<Instruction> instructions;
  public ArrayList<Block> blocks;

  
  public Block() {
    this.instructions = new ArrayList<Instruction>();
    this.blocks = new ArrayList<Block>();
  }
  
  public Block(ArrayList<Instruction> ins, ArrayList<Block> bl) {
    this.instructions = ins;
    this.blocks = bl;
  }
  
  public void pushInstruction(Instruction e) {
    if(this.instructions != null)
      if(e != null)
        this.instructions.add(e);
      else
        System.err.println("Object " + e.toString() + " is null");
    else
      System.err.println("this.Instructions: " + this.instructions + " is null");
  }
  
  public void pushBlock(Block bl) {
    if(this.blocks != null)
      if(bl != null)
        this.blocks.add(bl);
      else
        System.err.println("Object " + bl.toString() + " is null");
    else
      System.err.println("this.blocks: " + this.blocks + " is null");
  }

  public ArrayList<Instruction> getInstructions() {
    return this.instructions;
  }
  
  public ArrayList<Block> getBlocks() {
    return this.blocks;
  }
}
