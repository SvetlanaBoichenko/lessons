import java.util.Random;

public class test2 {
     public static void main(String[] args) {
  
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

 public int foo () { 
  if (command == 1)
    return state = state_sen1 + state_sen2;
    
  return 100;  
  } 
}

//----------------------------------------------
class AKlapan extends ADevice {
 
 public AKlapan (String name, int comm) {
    super (name, comm);  
 }   

 public int foo ()  { 
    if (command > 0) {
       state = command;
       return state;
    }  
    return 200;  
  } 

}
//-------------------------------------------

  int dev_state;
  int j = 0;

  ADevice [] devtab = new ADevice [10];
  
  Random rand = new Random();
  
  for (int i = 0; i < 10; i++) {
    j = rand.nextInt(2) - 1;
    if(j == 0)
      devtab[i] = new AKlapan ("klapan1", 3);
    else
       devtab[i] = new AKran ("kran1", 1);
  
  }
   for (int i = 0; i < 10; i++) {
      dev_state = devtab[i].foo();
  
      System.out.println ("Состояние устройства = " + dev_state);
  }

}
}