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
  
    class AProtocol
    {
       String pr_name;
       int pr_type;  // Тип правил кодировки
       
       int pr_r_bytes; // сколько пришло в протокол - для обработки
       int pr_w_bytes; // Сколько надо записать в посылку
       boolean pr_error = false;
       
      char [] inp_buf; // для раскодировки
      char [] out_buf; // для кодировки по правилам протокола
        
    }
  
    APort Port1 = new APort();
    Port1.p_name = "Com Port";
    Port1.p_speed = 9600;
    
    APort Port2 = new APort();
    Port2.p_wait_time = 10;
    Port2.p_num = 2;
    
     AInterface iface232 = new AInterface();
     iface232.i_type = 232;
     
     AProtocol my_protocol = new AProtocol();
     my_protocol.pr_type = 3; //один из моих протоколов
     my_protocol.pr_error  = true;// ошибка в посылкеж
  }
}
