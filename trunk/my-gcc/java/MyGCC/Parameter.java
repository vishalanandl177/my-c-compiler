package MyGCC;


public class Parameter{
  
  public Type type;
  public String name;

  public Parameter(Type type,String name){
    this.type = type;
    this.name = name; 
  }
  
  /* Since Parameter can be a key of an HashMap, this function has to be overrided */
  public int hashCode(){
	  return name.hashCode();
  }

}