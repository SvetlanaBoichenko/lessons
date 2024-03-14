//Дано предложение, в котором слова разделены ровно одним пробелом. Найти и //напечатать n-е слово, начиная с 1 (n вводится с клавиатуры).

import java.util.Scanner;
public class test4 {
  public static void main(String []args) {
         
  String s = "Я хочу в тихий город Кастейон";
  System.out.println (s); 
  System.out.println (' ');

    int len1 = s.length();   
    int count = -1;
    int pos = 0;
  
   System.out.println ("Введите номер слова"); 
   Scanner keyboard = new Scanner(System.in); 

    int n = keyboard.nextInt(); 
   
    for (int i = 0; i < len1; i++) {  
      if (i == 0 && s.charAt(0) != ' ')
         pos = 1;
      else
        if (s.charAt(i) == ' ')
            pos ++;
            
      if (pos == n) {  
        count++; 
        System.out.print(s.charAt(i)); 
      }
   }
  
   if (count < 0)
	System.out.println ("Номер слова не корректен"); 

  
 }
}