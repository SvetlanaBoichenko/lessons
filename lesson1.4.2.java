 class AInterface { 
    
       String i_name;
       int i_type;  // UDP, TCP, 485..
       int i_mode;  // client-server 
       
       int i_r_bytes;  //  сколько прочитала
       int i_w_bytes;   // сколько записать
     
       char [] inp_buf; // для выделения посылки из порта 
       char [] out_buf; // для формирования посылки в порт по правилам интерфейса
       
      AInterface (int t, int m) {
        this.i_type = t;
        this.i_mode = m;        
      }

      int read_buf_len () {
        return this.i_r_bytes;
     }
  }

 public class Main
 {
    public static void main(String[] args) {
       
    int buf_len = 0;
    AInterface com_iface = new AInterface (485, 0);

    buf_len = com_iface.read_buf_len ();
     System.out.println (buf_len);
  }
}
