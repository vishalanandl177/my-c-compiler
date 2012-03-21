package MyGCC;

import java.util.LinkedList;
import java.util.Map.Entry;


public class Function{
  
  private Type returnType;
  private LinkedList<Entry<String,Type>> parameters = new LinkedList<Entry<String,Type>>();
  private String name;
  private Block body;

  public Function(String name, Type returnType, LinkedList<Entry<String,Type>> parameters){
    this.name = name;
    this.returnType = returnType;
    this.parameters = parameters;
  }

  public String toString(){
    StringBuffer sb = new StringBuffer();
    sb.append(".globl "); sb.append(name);
    sb.append("\t.type\t"); sb.append(name); sb.append(", @function");
    return sb.toString();
  }
    
}