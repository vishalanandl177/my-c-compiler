package MyGCC;

import java.util.Stack;
import java.util.LinkedList;

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

  
}