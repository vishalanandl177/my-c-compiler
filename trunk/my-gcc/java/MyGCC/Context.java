package MyGCC;

import java.util.LinkedList;

public class Context{
  
  private LinkedList<Context> heritedContext = new LinkedList<Context>();
  
  public Context(){
  }

  public Context(Context creator){
    heritedContext.add(creator);
  }
  
}
