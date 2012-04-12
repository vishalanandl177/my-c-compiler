package MyGCC;

import java.util.*;

public class Block {
  
  public Block parent = null;
  public LinkedList<Instruction> instructions;
  public LinkedList<Block> blocks;

  
  public Block() {
    this.instructions = new LinkedList<Instruction>();
    this.blocks = new LinkedList<Block>();
  }
  
  public Block(LinkedList<Instruction> ins, LinkedList<Block> bl) {
    this.instructions = ins;
    this.blocks = bl;
  }
  
  public void pushInstruction(Instruction e) {
    if(this.instructions != null)
      if(e != null)
        this.instructions.add(e);
      else
        System.err.println("The specified instruction is null");
    else
      System.err.println("this.Instructions: is null");
  }
  
  public void pushBlock(Block bl) {
    if(this.blocks != null)
      if(bl != null)
        this.blocks.add(bl);
      else
        System.err.println("The specified block is null");
    else
      System.err.println("this.blocks: is null");
  }

  public LinkedList<Instruction> getInstructions() {
    return this.instructions;
  }
  
  public LinkedList<Block> getBlocks() {
    return this.blocks;
  }
}
