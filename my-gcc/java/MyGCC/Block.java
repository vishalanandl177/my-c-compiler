package MyGCC;

import java.util.*;

public class Block {
  
  public ArrayList<Declaration> declarations;
  public ArrayList<Expression> expressions;
  public ArrayList<Block> blocks;
  //in
  
  public Block() {
    this.declarations = new ArrayList<Declaration>();
    this.expressions = new ArrayList<Expression>();
    this.blocks = new ArrayList<Block>();
  }
  
  public Block(ArrayList<Declaration> dec, ArrayList<Expression> ins, ArrayList<Block> bl) {
    this.declarations = dec;
    this.expressions = ins;
    this.blocks = bl;
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
  
  public void pushExpression(Expression e) {
    if(this.expressions != null)
      if(e != null)
        this.expressions.add(e);
      else
        System.err.println("Object " + e.toString() + " is null");
    else
      System.err.println("this.expressions: " + this.expressions + " is null");
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
  
  public ArrayList<Declaration> getDeclarations() {
    return this.declarations;
  }

  public ArrayList<Expression> getExpressions() {
    return this.expressions;
  }
  
  public ArrayList<Block> getBlocks() {
    return this.blocks;
  }
}
