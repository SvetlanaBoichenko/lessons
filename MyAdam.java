package myprotocol;

public class MyAdam {
 public MyAdam() {}; 

 public static int GetAddr(String buf) {
   char a = buf.charAt(1);

	int addr = (int)a;

	return addr;
  }
} 
