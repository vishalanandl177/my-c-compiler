package MyGCC;

public class LabelManager {
  
  static private int nbFunctions = 0;
  
  public static int getFunctionNumber(){
    return nbFunctions++;
  }
  
  public static String getBeginLabel(int i){
    return "LFB" + i;
  }
  
  public static String getEndLabel(int i){
    return "LFE" + i;
  }

}
