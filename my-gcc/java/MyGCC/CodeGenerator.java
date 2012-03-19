package MyGCC;

import java.util.Stack;
import java.util.LinkedList;
import java.io.*;

public class CodeGenerator{

  private LinkedList<Stack<Object>> myStack;

  private Context globalContext;
  private Context actualContext;

  public CodeGenerator(){
    myStack = new LinkedList<Stack<Object>>();
  }

  public void pushInformation(Object o){
    if (myStack.size() == 0)
      openNewContext();
    myStack.getLast().push(o);
  }

  public void openNewContext(){
    myStack.add(new Stack<Object>());
  }

  public void declarePrototype(){
    Type returnType = null;
    String name = null;
    LinkedList<Type> parameters = null;

    Stack<Object> tmpStack = myStack.getLast();
    while (!tmpStack.isEmpty()){
      Object o = tmpStack.pop();
      if (o instanceof Type)
        returnType = (Type) o;
      else if (o instanceof String)
        name = (String) o;
      else if (o instanceof LinkedList)
        parameters = (LinkedList<Type>) o;
    }
    
    System.out.println("Declaring a prototype with :"
                       + "\nReturnType : " + returnType
                       + "\nname : " + name);
    
    
  }

  public void generateArithmeticResult(ArithmeticResult ar, PrintStream ps){
	ps.println(ar.getOp() + " " + ar.getLeft() + " " + ar.getRight());
  }

  
  public void generateArithmeticLoad(String id, String registry, PrintStream ps){
	ps.println("  load " + id + " " + registry);
  }
}
