package JSHOP2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/** Each axiom at run time is represented as a class derived from this abstract
 *  class.
 *
 *  @author Shpieva
 *  @version 1.0.3
*/
public class Atom 
{

  public  String name;
  
  public List<String> parameters;

  public Atom()
  {
      name = "";
      parameters  = null;
  }


  // public String getAtomName()
  // {
  //   return name;
  // }

  // public List<String> getAtomParameters()
  // {
  //   return parameters;
  // }

  //   public void setAtomName(String cName)
  // {
  //   name = cName;
  // }

  // public void setAtomParameters(List<String> cParameters)
  // {
  //   parameters = cParameters;
  // }

}
