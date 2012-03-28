package MyGCC;

import java.util.ArrayList;
import java.util.Map.Entry;


public class Function{
  
  private Type returnType;
  private ArrayList<Parameter> parameters = new ArrayList<Parameter>();
  private String name;
  public Body body;

  public Function(String name,
                  Type returnType,
                  ArrayList<Parameter> parameters,
                  Body body){
    this.name = name;
    this.returnType = returnType;
    this.parameters = parameters;
    this.body = body;
  }

  public String toString(){
    StringBuffer sb = new StringBuffer();
    sb.append(".globl "); sb.append(name); sb.append('\n');
    sb.append("\t.type\t"); sb.append(name); sb.append(", @function");
    return sb.toString();
  }
  
  /*public Type getReturn() {
    return this.retType;
  }
  
  public String getIdentifier() {
    return this.identifier;
  }
  
  public ArrayList<Entry<Type,String>> getArguments() {
    return this.arguments;
  }
  
  public Body getBody() {
    return this.body;
  }
  
  public void setReturn(Type t) {
    this.retType = t;
  }
  
  public void setIdentifier(String id) {
    this.identifier = id;
  }
  
  public void setArguments(ArrayList<Entry<Type,String>> args) {
    this.arguments = args;
  }

  public void setBody(Block b) {
    this.body = b;
  }*/
    
}
