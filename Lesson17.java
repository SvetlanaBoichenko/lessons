
// Согласно Руководству по стилю Google Java, сделано:
// Имена параметров переведены в нижний регистр
// Отделены if от (  
// Отделены for от (
// Отделены else от {
// Введены пробелы между int и [ при объявлении массива
// Каждое объявление объявляет только 1 переменную
// Использованы скобки { } с if, else, for, do, while всегда
//В имени обычных переменных использованы строчные ascii символы

public class Main
{
    static int MaxMin ( int [] matrice, boolean ismax ) {   
        int len = matrice.length; 
        int min = matrice[0];     // 
        int max = matrice [0];

    for ( int i = 1; i < len; i ++ ) {
        if ( matrice[i] > max )
            max = matrice[i];
        
        if ( matrice[i] < min )
           min = matrice[i];
    }
      
    if ( ismax ) {
        return max;
    }
    else {
        return min; 
    }
  }

  public static void main ( String [] args ) {
    int [] array1 = { 1, 10, -1, 11, 1 };
    boolean fmax = false;
    
    int m = MaxMin ( array1, fmax );
       
    System.out.println ( m );
  }
}