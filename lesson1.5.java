 class ADevice {
    private   String name; // Имя 
    private   int num ;    // номер (порядковый)
    private   int type;    // Тип устр    
    private boolean error; // 
    char out_data = ' ';
}
//-----------------------------------
class APort extends ADevice {
      private int wait_time;  // сколько времени ждать ответ
      private int speed;     // Скорость обмена
          
     APort (String name, int num, int type, int speed) {
       super(name, num, type);
       this.speed  = speed;
       this.wait_time = 100; // mc
    }

    char write_out_data ()  {                 
        return (this.out_data = 'P');
    }
}
//------------------------------------- 
 class AInterface extends ADevice {
  private int mode;  // client-server 
  
  AInterface (String name, int num, int type, int m) { 
    super(name, num, type);
      this.mode = m;        
    }

   char write_out_data ()  {                 
       return (this.out_data = 'I');
   }
}
//----------------------------------------
class AProtocol extends ADevice {
      private int pr_type;  // Тип правил кодировки
 
      AProtocol (String name, int num, int type) {
        super(name, num, type);      
      }

     char write_out_data ()  {                 
       return (this.out_data = 'T');
     } 
  
      int type_of_message (char [] buf) {
       if (buf.length > 0)
          return ( Integer.valueOf (buf [0]) );
      else
          return -1;
     }        
 }
//---------------------------
public class Main {
     public static void main(String[] args) {
  
    APort port1 = new APort ("ComPort", 1, 2, 38400);
    char dev1 = port1.write_out_data ();
    
    AInterface iface1 = new AInterface ("i485", 2, 485, 0);
    char dev2 = iface1.write_out_data ();
    
    AProtocol protocol1 = new AProtocol ("MyProtocol1", 3, 0);
    char dev3 = protocol1.write_out_data ();
    
    System.out.println (dev1 + " " + dev2 + " " + dev3);
  }
}
