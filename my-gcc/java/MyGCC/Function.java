package MyGCC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


public class Function{
  
  private Type returnType;
  private ArrayList<Parameter> parameters = new ArrayList<Parameter>();
  public String name;
  public Body body;
  /** Contain all the variables local to the function with their type **/
  private HashMap<String,Type> localVariables = new HashMap<String,Type>();
  /** Contain the "virtual" location of the variables,
   *  for example: if <i>a</i> is in <i>-4(%rbp)</i>, the tuple will be <i>(a,-4)</i> **/
  private HashMap<String,Integer> variablesLocations = new HashMap<String, Integer>();
  /** This is the place taken by all the local variables in bytes,
   *  Like with gcc, it is always a multiple of 16.
   **/
  private int variablesTotalSize;

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
    sb.append(body.toString());
    return sb.toString();
  }
  
  /**
   * When a function is called,
   * local variables will always be used like <i>-...(%rbp)</i>
   * We use a mapping in order to get the track of all this location
   */
  private void prepareLocalVariablesLocation(){
	  variablesTotalSize = 0;
	  for (Entry<String, Type> type : localVariables.entrySet()){
		  variablesTotalSize += type.getValue().size;
	  }
	  variablesTotalSize = variablesTotalSize + (16 -variablesTotalSize % 16);
	  
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
