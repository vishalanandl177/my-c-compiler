package MyGCC;

import java.util.Stack;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.io.*;

public class CodeGenerator{

  private LinkedList<Stack<Object>> myStack;
  private LinkedList<Prototype> globalPrototypes = new LinkedList<Prototype>();
  private LinkedList<Function> globalFunctions = new LinkedList<Function>();

  private Context globalContext;
  private Context actualContext;
  private Function currentFunction;

  public CodeGenerator(){
    myStack = new LinkedList<Stack<Object>>();
  }
  
  public void pushInstruction(Instruction i){
    currentFunction.body.pushInstuctionToBlock(i);
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
    System.out.println("FUNCTIION");
    Type returnType = null;
    String name = null;
    ArrayList<Parameter> parameters = null;
    Body body = null;

    Stack<Object> tmpStack = myStack.getLast();
    while (!tmpStack.isEmpty()){
      ParsingResult r = (ParsingResult) tmpStack.pop();
      switch (r.type){
      case TYPE :   returnType = ((ParsingResult<Type>)r).getValue(); break;
      case ID:          name       = ((ParsingResult<String>)r).getValue();       break;
      case PARAMETERS :   parameters = ((ParsingResult<ArrayList<Parameter>>)r).getValue();       break;
      case BODY:         body       = ((ParsingResult<Body>)r).getValue();       break;
      }
    }
    Function f = new Function(name, returnType, parameters, body);
    globalFunctions.add(f);
    this.currentFunction = f;
  }


  public void declareVariable() {
    /*Type type = null;
    String identifier = null; 
    int arraySize = 0;
    
    Stack<Object> tmpStack = myStack.getLast();
    while(!tmpStack.isEmpty()) {
      ParsingResult r = (ParsingResult) tmpStack.pop();
      switch(r.type) {
        case TYPE : type = ((ParsingResult<Type>)r).getValue(); break;
        case ID : identifier = ((ParsingResult<String>)r).getValue(); break;
        case ARITHMETIC : arraySize = ((ParsingResult<Integer>)r).getValue(); break;
      }
    }
    if(currentFunction != null)
      this.currentFunction.body.declarations.add(new Declaration(type, identifier, arraySize));*/
  }
  
  public void handleInstruction(){
    StringBuffer sb = new StringBuffer();
    Stack<Object> tmpStack = myStack.getLast();
    while(!tmpStack.isEmpty()){
      Instruction instr = (Instruction) tmpStack.pop();
      
      if(instr.expr == null)
        sb.append("\tleave\n\tret\n");
      
      switch(instr.instrType){
        case RETURN:
          sb.append("\tmovl " /*+ instr.expr.value*/ + ", %eax").append("\tleave\n\tret\n");
          break;
        case EXIT:
          //TODO
          break;  
        case EQL:
          //TODO
          break;
        default:
          // case null, ie. for instructions like "1+2;"
          // optimize and don't calculate?
          break;
      }
      
      instr.str = sb.toString();
      System.out.println("myInstruct: " + instr.str + "in: " + this.currentFunction.name);
      this.currentFunction.body.pushInstuctionToBlock(instr);
    }
}

  public String generateCode(){
    StringBuffer sb = new StringBuffer();
    for (Function f : globalFunctions){
      sb.append(f.toString());
    }
    return sb.toString();
  }
  
  public void closeFunction(){
    //TODO
  }
  
  public void openFunction(){
    //TODO
  }

}
