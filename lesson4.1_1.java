 class AObject {
    private   String name; // Имя 
    protected   int num ;    // номер 
  
    AObject (String name, int num) {
        this.name = name;
        this.num = num;              
    } 

   public String Operate () { return "AObject";} 
 }
//-------------------------------------------------

 class AInterface extends AObject {
   
  protected  int type;    // Тип 
  boolean err;
  
  public AInterface (String name, int num, int type, int port_num) { 
    super (name, num); 
    this.type = type; 
  }

  public String read_data (int port_num) {
    
     if(port_num >= 0)
      return "Called From Port";
    else
      return "Interface port_num < 0";
   }
        
   public String GetReadBuf () {
      return "Interface Buf";  
    }
}
//-------------------------------------------

class APort  extends AObject {
  
    AInterface interface1;
    protected String buf1;
    protected int port_num;
      
    public APort (String name, int num) {
      super (name, num);  
      interface1 = new AInterface ("PortInterface", num + 100, 0, 0);        
      this.port_num  = num;
 
    } 

   public String Operate()  { 
     if (interface1.err == false)
       return interface1.read_data (port_num);
      
     interface1.err = true;        
     return "APort Error";
    } 
    
   public String GetReadBuf () {
      return "Port Buf" ;  
    };
}
//-----------------------------------------------

class ASensor extends AObject  {

  private int value; 
  
  ASensor (String name, int num) {
      super (name, num);
  
      this.num = 200 + num;
      this.value = -1;
   }
  
  public String Operate () { 
      if (value < 0) 
        return "Sensor Value Error1";

      return "Sensor Ok";
   }   
}
//----------------------------

class ADevice extends AObject  {
  
    ASensor sensor1;
    private int command;
    private boolean err;
  
    ADevice (String name, int num) {
      super (name, num);    
      this.num = 300 + num;
      err = true;
    }

    public void SetSensor (String name, int num) {
      sensor1 = new ASensor (name, num); 
      err = false;
    }  
    
    public String Operate () { 
        if (err) 
            return "Device Error1";
            
      return "Device Ok";        
    } 
}
//-------------------------------------------

public class Main {
     public static void main(String[] args) {
     String buf1, buf2, name_dev, name_sen; 

    APort port1 = new APort ("ComPort", 1);
    port1.Operate();
    port1.interface1.Operate();
    
    buf1 =  port1.GetReadBuf ();
    buf2 = port1.interface1.GetReadBuf ();
    System.out.println (buf1 + "  " + buf2);
    
    ADevice dev1 = new ADevice ("Device1", 1);
    dev1.SetSensor ("Sensor1", 1);
     dev1.Operate();
     
     name_dev = dev1.Operate();
     name_sen = dev1.sensor1.Operate();
    
     System.out.println (name_dev + "  " + name_sen);
  }
}
