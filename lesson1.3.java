import java.util.Scanner;
public class MainClass {
  public static void main(String[] args) { 
   
   class APort
   {
     String p_name; // Имя
     int p_num = 1;     // номер (порядковый)
     int p_type;    // Ethernet, Com,..
     int p_wait_time;  // сколько времени ждать ответ
     
     int p_speed;     // Скорость обмена
     boolean p_error; // нет обмена
        
      int p_r_bytes;  //  сколько прочитала
      int p_w_bytes;   // сколько записать
      int p_exch_mode; // Master-Slave
     
      char [] p_inp_buf;  // что пришло
      char [] p_out_buf;  // что передать
     }
 
   class AInterface
   {
       String i_name;
       int i_type;  // UDP, TCP, 485..
       int i_mode;  // client-server 
       
       int i_r_bytes;  //  сколько прочитала
       int i_w_bytes;   // сколько записать
     
       char [] inp_buf; // для выделения посылки из порта 
       char [] out_buf; // для формирования посылки в порт по правилам интерфейса       
     }
  
    APort Port1 = new APort();
    Port1.p_name = "ComPort 1";
    Port1.p_speed = 9600;
    System.out.println(" Port1.p_name = " + Port1.p_name + ", Port1.p_speed = " +  Port1.p_speed); 
 
    APort Port2 = Port1;
    Port2.p_name = "ComPort 2";
    Port2.p_speed = 11200;
    System.out.println(" Port1.p_name = " + Port1.p_name + ", Port1.p_speed = " +  Port1.p_speed);
    
    AInterface iface1 = new AInterface();
    iface1.i_name = "UDP";
    System.out.println("iface1.i_name = " + iface1.i_name);

   AInterface iface2 = iface1;
   iface2.i_name = "TCP IP";
   System.out.println("iface1.i_name = " + iface1.i_name);
   }
}
