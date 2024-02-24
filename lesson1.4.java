 class APort 
  {
     String p_name; // Имя
     int p_num ;     // номер (порядковый)
     int p_type;    // Ethernet, Com,..
     int p_wait_time;  // сколько времени ждать ответ
     
     int p_speed;     // Скорость обмена
     boolean p_error; // нет обмена
        
      int p_r_bytes;  //  сколько прочитала
      int p_w_bytes;   // сколько записать
      int p_max_buf_size;
      int p_exch_mode; // Master-Slave
     
      char [] p_inp_buf;  // что пришло
      char [] p_out_buf;  // что передать
      
    APort (String name,int num, int type, int speed, int max_buf_size) 
    {
      this.p_name = name;
      this.p_num = num;
      this.p_type = type;
      this.p_speed  = speed;
      
      this.p_wait_time = 100; // mc
      this.p_error = false;
      this.p_exch_mode = 1;
      this.p_max_buf_size = max_buf_size;
      
      this.p_inp_buf = new char [max_buf_size];
      this.p_out_buf = new char [max_buf_size];
    }

      int write_out_data (char [] out_buf) 
      { 
        if (out_buf.length > this.p_max_buf_size)
          return -1;
           
        this.p_out_buf = out_buf; 
        return out_buf.length;        
      }
}

 public class Main
{
     public static void main(String[] args) {
       
    char [] buf_out = {'A', '2', '3', '1', '0', '\r'};
    int buf_len = 0;
   
    APort port1 = new APort ("ComPort", 1, 485, 38400, 10);
     buf_len = port1.write_out_data (buf_out);
   
   if ( buf_len > 0) 
    System.out.println (buf_out);
  else
    System.out.println ("OUT_BUF ERROR");
  }
}
