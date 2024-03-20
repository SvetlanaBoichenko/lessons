package ports;
import myprotocol.MyAdam;

public class ComPort1 {

	int FSpeed;
	int FDevAddr;
	String FReadBuf;
	
    static MyAdam protAdam = new MyAdam();
	
	public ComPort1(int speed) {
		FSpeed = speed; 
        
	};

	public static String ReadPort(int nport){
     String retbuf = "#A9\r";     
	 return retbuf;

    } 
	
	public static int GetDevAddr (String buf) {
       return  protAdam.GetAddr(buf);     


	} 
	
} 


