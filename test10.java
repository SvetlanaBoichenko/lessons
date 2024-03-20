import myprotocol.MyAdam;
import ports.ComPort1; 

public class test10 {

  public static void main(String[] args){
    String Buf1 = "#B9\r"; 
	String Buf2 = ComPort1.ReadPort(1);
	
    int devaddr1 = MyAdam.GetAddr(Buf1);
    int devaddr2 = ComPort1.GetDevAddr (Buf2);   

	   System.out.print(devaddr1 + "  " + devaddr2 );
  }
}
