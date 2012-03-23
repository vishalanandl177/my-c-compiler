package MyGCC;

import java.util.LinkedList;

class Prototype{
  
  public Type retType;
  public String identifier;
  public LinkedList<Type> typeList;
  
  public Prototype() {
    this.retType = null;
    this.identifier = new String();
    this.typeList = new LinkedList<Type>();
  }
  
  public Prototype(Type t, String ident, LinkedList<Type> llt) {
    this.retType = t;
    this.identifier = ident;
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