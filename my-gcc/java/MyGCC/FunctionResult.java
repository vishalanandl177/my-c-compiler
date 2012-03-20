package MyGCC;

import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

public class FunctionResult extends ParsingResult {
  
  public Type retType;
  public String identifier;
  public ArrayList<Entry<Type,String>> arguments = new ArrayList<Entry<Type,String>>();
  public Block body;
  
  public FunctionResult() {
    // shouldn't be used
    super(ResultType.FUNCTION);
    this.retType = null;
    this.identifier = new String();
    this.body = new Block();
  }
  
  public FunctionResult(Type t, String id, ArrayList<Entry<Type,String>>  args, Block b) {
    super(ResultType.FUNCTION);
    this.retType = t;
    this.identifier = id;
    this.arguments = args;
    this.body = b;
  }
  
  public Type getReturn() {
    return this.retType;
  }
  
  public String getIdentifier() {
    return this.identifier;
  }
  
  public ArrayList<Entry<Type,String>> getArguments() {
    return this.arguments;
  }
  
  public Block getBlock() {
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
  }
}
