package MyGCC;

public class Declaration {
  
  public Type type;
  public String identifier;
  public int arraySize;
  
  public Declaration(Type t, String id, int arraySize) {
    this.type = t;
    this.identifier = id;
    this.arraySize = arraySize;
  }
  
  public Type getType() {
    return this.type;
  }
  
  public String getIdentifier() {
    return this.identifier;
  }
  
  public int getArraySize() {
    return this.arraySize;
  }  
  
}
