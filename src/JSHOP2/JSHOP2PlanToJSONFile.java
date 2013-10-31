package JSHOP2;

import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;



/** 
 *
 *  @author Christian Tiefenau
 *  @version 0.0.1
*/
public class JSHOP2PlanToJSONFile {
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

  public static void generateJSON(){
    //-- Go thought the planList 
    ObjectMapper mapper = new ObjectMapper();
    int counter;
    counter = 0;
    Map<Object, Object> map = new HashMap<Object, Object>();
    for(PlanStepInfo x: planList){
      if(x.action=="STATECHANGED"){
        //-- Store the action name

        List<Atom> deleteList = new ArrayList<Atom>();
        List<Atom> addList = new ArrayList<Atom>();
        

        for(int i = 0; i < x.delAdd[0].size(); i++){
            String deleteAtom = x.delAdd[0].elementAt(i).toString().replaceAll("\\(", "").replaceAll("\\)","");
            ArrayList<String> tempDelete = new ArrayList<String>(Arrays.asList(deleteAtom.split(" ")));

            Atom cDelete = new Atom();
            cDelete.name = tempDelete.get(0);
            cDelete.parameters = tempDelete.subList(1,tempDelete.size());
            deleteList.add(cDelete);


        }

        for(int i = 0; i < x.delAdd[1].size(); i++){
            String addAtom = x.delAdd[1].elementAt(i).toString().replaceAll("\\(", "").replaceAll("\\)","");
            ArrayList<String> tempAdd = new ArrayList<String>(Arrays.asList(addAtom.split(" ")));
            Atom cAdd = new Atom();
            cAdd.name = tempAdd.get(0);
            cAdd.parameters = tempAdd.subList(1,tempAdd.size());
            addList.add(cAdd);


        }

        List<Object> list = new ArrayList<Object>();
        list.add(deleteList);
        list.add(addList);
        map.put(x.taskAtom.toString().replaceAll("\\(!", "").replaceAll("\\)",""), list);


      }
    
    try {
          // write JSON to a file
          mapper.writeValue(new File("plan.json"), map);
       
      } catch (Exception e) {
          e.printStackTrace();
      }
   } 
}
  
  /** Generate file with action name of the current plan with corresponding delete list and add list
   *
   *  @throws IOException
  */ 
public JSHOP2PlanToJSONFile(){

    }
  }

 