package MyGCC;

public class PrototypeResult extends ParsingResult{
  
  public Type retType;
  public String identifier;
  public LinkedList<Type> typeList;
  
  public PrototypeResult() {
    this.retType = new Type();
    this.identifier = new String();
    this.typeList = new LinkedList<Type>();
  }
  
  public PrototypeResult(Type t, String ident, LinkedList<Type> llt) {
    this.retType = t;
    this.identifier = s;
    this.typeList = llt;
  }
  
  public void setReturn(Type t) {
    this.retType = t;
  }
  
  public void setIdentifier(String s) {
    this.identifier = s;
  }
  
  public void pushType(Type t) {
    this.typeList.add(t);
  }
  
  public Type getReturn() {
    return this.retType;
  }
  
  public String getIdentifier() {
    return this.identifier;
  }
  
  public LinkedList<Type> getTypeList() {
    return this.typeList;
  }

}
