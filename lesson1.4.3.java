 class AProtocol
  {
       String pr_name;
       int pr_type;  // Тип правил кодировки
       
       int pr_r_bytes; // сколько пришло в протокол - для обработки
       int pr_w_bytes; // Сколько надо записать в посылку
       boolean pr_error = false;
       
      char [] inp_buf; // для раскодировки
      char [] out_buf; // для кодировки по правилам протокола 
      
      AProtocol (String name, int type) {
        this.pr_name = name;
        this.pr_type = type;        
      }

      int type_of_message (char [] buf) {
       if (buf.length > 0)
        return ( Integer.valueOf (buf [0]) );
      else
        return -1;
     }        
 }

 public class Main
 {
    public static void main(String[] args) {
       
    int message_type = -1;
    char[] buf = { '1', 'i', '0' };
     AProtocol protocol1 = new AProtocol ("Protocol_1", 3);

    message_type = protocol1.type_of_message (buf);
     System.out.println (message_type);
  }
}
