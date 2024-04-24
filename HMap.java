//добавляет в словарь 100 случайных пар (предварительно в массив например ключи записываем)
//целый ключ + значение строка,
//затем считывает по ключам все значения и выводит, и затем удаляет все пары.


import java.util.HashMap; // import the HashMap class
import java.util.*;
import java.util.Arrays;
import java.util.Random;

public class HMap {
    public static void main(String[] args) {
    // Create a HashMap object called cap
        HashMap<Integer, String> cap = new HashMap<Integer, String>();

        int nextNum = 0;
        Random r =  new Random();
        int [] rNumarray  = new int [100];
        char [] chArray = {'q','w','e','r','t','y','1','2','3','4'};
        String str = "";
        int j = 0;
        boolean b = true;

        for (int i = 0; i < 100; i++ ) {
            rNumarray[i] = r.nextInt(1000000);// массив неповтряющихся значений int

            if (i > 0) {
                j = 0;
                while (j < i) {                          // Проверка на неповторяемость
                    if (rNumarray[j] == rNumarray[i]) {
                        i--;
                        b = false;;
                        break;
                    }
                    j++;
                }
            }

           if (!b) {
               b = true;
               continue;
           }

           str = "";
           for (int k = 0; k < 5; k++) {            // Формиров строк из массива символов
              int z =  r.nextInt(10);
               str = str + chArray [z] ;
           }

            cap.put (rNumarray[i] , str);
        }
        for (Integer i : cap.keySet()) {
            System.out.println("key: " + i + " value: " + cap.get(i));
        }
        cap.clear ();

    }

}





