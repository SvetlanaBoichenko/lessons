public class MainClass {    
  static boolean sub_string (String s1, String s2)
  {   
   
    if (s1.length() < s2.length())  
      return false;
  
      boolean ret = false;

      for (int i = 0; i < s1.length(); i++) {
       if (ret) 
          return true;
      
       if (s1.charAt(i) == s2.charAt(0)) { 
         ret = true;        
 
         for (int j = 1; j < s2.length(); j++) {
           if (s2.charAt(j) != s1.charAt(i + j)) {             
             ret = false;
             break;
            }           
          }         
        }      
      }
    return false;    
  }
      
  public static void main(String[] args) {
    String s1 = "Мой свет - СССвввета!";
    String s2 = "Свввет";
    
    if(sub_string (s1,s2))
       System.out.println("Строка 1 содeржит в себе строку 2");
    else
      System.out.println("Строка 1 не содeржит строку2 или ее длина меньше длины строки 2");    
  }
}