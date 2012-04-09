package MyGCC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


public class Function{
  
  private Type returnType;
  private ArrayList<Parameter> parameters = new ArrayList<Parameter>();
  public String name;
  public Body body;
  /** Contain the "virtual" location of the parameters,
   *  for example: if the parameter <i>p</i> is in <i>-4(%rbp)</i>, the tuple will be <i>(p,-4)</i> **/
  private HashMap<Parameter,Integer> parametersLocations = new HashMap<Parameter,Integer>();
  /** Contain all the variables local to the function with their type **/
  private HashMap<String,Type> localVariables = new HashMap<String,Type>();
  /** Contain the "virtual" location of the variables,
   *  for example: if <i>a</i> is in <i>-4(%rbp)</i>, the tuple will be <i>(a,-4)</i> **/
  private HashMap<String,Integer> variablesLocations = new HashMap<String, Integer>();
  /** This is the place taken by all the local variables in bytes,
   *  Like with gcc, it is always a multiple of 16.
   **/
  private int variablesTotalSize;
  /** useful for a lazy-mecanism **/
  private boolean localVariablesLocated = false;
  private boolean parametersLocated = false;

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
    int i = LabelManager.getFunctionNumber();
    StringBuffer sb = new StringBuffer();
    sb.append(".globl "); sb.append(name); sb.append('\n');
    sb.append("\t.type\t"); sb.append(name); sb.append(", @function\n");
    sb.append(name); sb.append(":\n");
    sb.append('.'); sb.append(LabelManager.getBeginLabel(i)); sb.append(":\n");
    sb.append(prelude());
    sb.append(loadParameters());
    //sb.append(body.toString());
    sb.append(epilogue());
    sb.append('.'); sb.append(LabelManager.getEndLabel(i)); sb.append(":\n");
    sb.append("\t.size "); sb.append(name); sb.append(", .-"); sb.append(name); sb.append('\n');
    return sb.toString();
  }
  
  /**
   * When a function is called,
   * local variables will always be used like <i>-...(%rbp)</i>
   * We use a mapping in order to get the track of all this location
   */
  private void prepareLocalVariablesLocation(){
	  if (localVariablesLocated) return;
	  variablesTotalSize = 0;
	  for (Entry<String, Type> e : localVariables.entrySet()){
		  variablesTotalSize += e.getValue().size;
		  variablesLocations.put(e.getKey(), -variablesTotalSize);
	  }
	  variablesTotalSize = variablesTotalSize + (16 -variablesTotalSize % 16);
	  localVariablesLocated = true;
  }
  
  private void prepareParametersLocation(){
    if (parametersLocated) return;
    prepareLocalVariablesLocation();
	  int k = 1;
	  if (parameters != null){// TODO usually parameters should never be null but that's an issue coming from the parser
	    for (Parameter p : parameters){
	      if (k <= 6)
	        parametersLocations.put(p,-variablesTotalSize - 4 * k);
	      else
	        parametersLocations.put(p, (k - 7) * 8);
	      k++;
	    }
	  }
	  parametersLocated = false;
  }
  
  /** Initially, some parameters are left in some caller-saved Registers.
   *  This function return the String that ensure that the parameters are
   *  loaded before starting really the code **/
  private String loadParameters(){
    prepareParametersLocation();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < parameters.size(); i++){
      sb.append("\tmovl\t%");
      sb.append(Register.getArgumentRegister(i));
      sb.append(", ");
      sb.append(parametersLocations.get(parameters.get(i)));
      sb.append("(%rbp)\n");
    }
    return sb.toString();
  }
  
  //TODO this code is written, but not fully understood by it's writer, more work should be done on it
  private String prelude(){
    StringBuilder sb = new StringBuilder();
    sb.append("\t.cfi_startproc\n");
    sb.append("\tpushq\t%rbp\n");
    sb.append("\t.cfi_def_cfa_offset 16\n");
    sb.append("\tmovq\t%rsp, %rbp\n");
    sb.append("\t.cfi_offset 6, -16\n");
    sb.append("\t.cfi_def_cfa_register 6\n");
    return sb.toString();
  }
  
  //TODO this code is written, but not fully understood by it's writer, more work should be done on it
  private String epilogue(){
    StringBuilder sb = new StringBuilder();
    sb.append("\tleave\n");
    sb.append("\t.cfi_def_cfa 7, 8\n");
    sb.append("\tret\n");
    sb.append("\t.cfi_endproc\n");
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
