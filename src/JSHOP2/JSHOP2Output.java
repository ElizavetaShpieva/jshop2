package JSHOP2;

import java.io.*;
import java.util.ArrayList;



/** 
 *
 *  @author Christian Tiefenau
 *  @version 0.0.1
*/
public class JSHOP2Output {
   /** A <code>ArrayList</code> of actions of the generated plan.
   *  Each member is of type <code>PlanStepInfo</code>.
  */
  protected static ArrayList<PlanStepInfo> planList;
  /** The number of solution plans per planning problem.
  */
  protected static int planCount;

  /** To set the generated plans.
   *
   *  @param setPlans
   *          the plans generated for domain.
  */
  public static void setPlans(ArrayList<PlanStepInfo> plans){
  planList = plans;
 }
  /** To set the number of the generated plans.
   *
   *  @param setPlanCount
   *          the number of the generated plans for planning domain.
  */
  public static void setPlanCount(int count){
	planCount = count;
}
  
  /** Generate file with action name of the current plan with corresponding delete list and add list
   *
   *  @throws IOException
  */ 
public JSHOP2Output(){
  try{
    //-- Create a file
    File statText = new File("plan.txt");
    FileOutputStream is = new FileOutputStream(statText);
    OutputStreamWriter osw = new OutputStreamWriter(is);    
    Writer w = new BufferedWriter(osw);
    //-- Go thought the planList 
    for(PlanStepInfo x: planList){
      if(x.action=="STATECHANGED"){
        //-- Store the action name
        w.write("action:"+x.taskAtom+"\n");
        //-- Store delete list
        String delete = "";
          for(int i = 0; i < x.delAdd[0].size(); i++){
            delete += x.delAdd[0].elementAt(i)+", ";
          }
        if(delete.length()>0)
        delete = delete.substring(0, delete.length()-2);
        w.write("delete:"+delete+"\n");
        //-- Store add list
        String add = "";
          for(int i = 0; i < x.delAdd[1].size(); i++){
            add += x.delAdd[1].elementAt(i)+", ";
          }
        if(add.length()>0)
        add = add.substring(0, add.length()-2);
        w.write("effect:"+add+"\n");
        w.write("------------------------------\n");    
      }
    }
      w.close();
    } catch(Exception e){
    }
    }
  }

 