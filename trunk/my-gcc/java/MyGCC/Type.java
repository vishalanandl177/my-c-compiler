package MyGCC;

public enum Type {
  INT("int", true),
  VOID("void", false);
  
  private boolean isVarType;
  private String strType;
    
  private Type(String s, boolean ia) {
    this.isVarType = ia;
    this.strType = s;
  }
  
  public String toString(){
    return this.strType;
  }
    
}
