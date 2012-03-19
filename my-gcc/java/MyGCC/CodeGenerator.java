package MyGCC;

import java.util.Stack;
import java.util.LinkedList;
import java.io.*;

public class CodeGenerator{

  private LinkedList<Stack<ParsingResult>> myStack;

  private Context globalcontext;

  public CodeGenerator(){
    myStack = new LinkedList<Stack<ParsingResult>>();
  }

  public void pushInformation(ParsingResult p){
    if (myStack.size() == 0)
      openNewContext();
    myStack.getLast().push(p);
  }

  public void openNewContext(){
    myStack.add(new Stack<ParsingResult>());
  }

  public void declareFunction(){
    
  }

  public void generateArithmeticResult(ArithmeticResult ar, PrintStream ps){
	ps.println(ar.getOp() + " " + ar.getLeft() + " " + ar.getRight());
  }

  
  public void generateArithmeticLoad(String id, String registry, PrintStream ps){
	ps.println("  load " + id + " " + registry);
  }
}
