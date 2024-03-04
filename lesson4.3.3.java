 class ADevice {
 
     private String name;
      protected int state;
   // номер 
    protected int command;
    ADevice  (String name, int comm) {
        this.name = name;
        this.command = comm;   
        state = -1;
    } 

   public int foo () { return state;} 
 }
//-------------------------------------------------

class AKran extends ADevice {

 protected int state_sen1;
 protected int state_sen2;
 
 public AKran (String name, int comm) {
    super (name, comm); 
 state_sen1 = 1;
 state_sen2 = 3; 
 }   

 public int getState () { 
    state = state_sen1 + state_sen2;
    
    return state;  
  } 

 public int getState (int command) {
       state = command;
       return state;
    }  
}

//-------------------------------------------

public class Main {
     public static void main(String[] args) {
  
  int dev_state1, dev_state2;
  AKran kran = new AKran ("kran1", 1);
  
  dev_state1 = kran.getState ();
  dev_state2 = kran.getState (2);
  
      System.out.println ("state1 = " + dev_state1 +" " + "state2 = " + dev_state2);

 }
}
