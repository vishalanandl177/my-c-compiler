package MyGCC;

import java.util.Stack;
import java.util.LinkedList;
import java.io.*;

public class CodeGenerator{

  private LinkedList<Stack<Object>> myStack;
  private LinkedList<Prototype> globalPrototypes = new LinkedList<Prototype>();
  private LinkedList<Function> globalFunctions = new LinkedList<Function>();

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
    //globalPrototypes.add(new Prototype(
  }

  public void declareFunction(){
    //TODO
    /*Type returnType = null;
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
                       + "\nname : " + name);*/
  }

  public void generateArithmeticResult(Expression ar, PrintStream ps){
    ps.println(ar.op + " " + ar.left.value + ", " + ar.right.value);
  }

  
  public void generateArithmeticLoad(String id, String registry, PrintStream ps){
    ps.println("  load " + id + ", " + registry);
  }

  public String generateCode(){
    StringBuffer sb = new StringBuffer();
    for (Function f : globalFunctions){
      sb.append(f);
    }
    return sb.toString();
  }
  
  public void generateTypeLoad(String type, String registry, PrintStream ps){
    ps.println("  load " + type + ", " + registry);
  }
  
  public void generateReturn(Expression ar, PrintStream ps){
    if(ar != null)
      ps.println("  movl " + ar.value + ", %eax");
    ps.println("  leave\n  ret\n");
  }

}
