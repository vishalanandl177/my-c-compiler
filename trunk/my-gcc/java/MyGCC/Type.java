package MyGCC;

public enum Type {
  INT(true),
  VOID(false);
  
  private Type(boolean ia) {
    this.isVarType = ia;
  }
  
  private boolean isVarType;
    
}
