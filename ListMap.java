//получает список из 100 значений
// (сгенерируйте его заранее с числами в диапазоне от 1 до 10)
// и число N, и выдаёт список из тех значений в этом списке,
// которые повторяются не менее N раз. Используйте словарь

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class ListMap {
    static ArrayList<Integer> Repetir (ArrayList<Integer> L1, int ntimes) {
        // Создали мар
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // Заполняем ключами 1-10 и значениями - нулями
        for (int i = 1; i <= 10; i++) {
             map.put ( Integer.valueOf(i), 0);
        }
        // Смотрим в список,он содерж ч. 1-10, что соотв ключам, знач - счетчиками будут
        for (int j = 0; j <= 99; j++) {
            int listVal = L1.get (j);  // Знач в диапазоне 1-10 из листа - оно будет ключом

            int ind = map.get (listVal); //Вытащить знач(счетчик), соотв ключу
            //Ключ - знач из листа, ind - счетчик
            ind++;
            map.put (listVal, ind); // ключ - число из листа 1-10, значение -  увеличиваем и меняем
        }

        L1.clear(); //очмстим старые значения чтоб заполнить новыми - обработаными
        for (Integer i : map.keySet()) {
            if (map.get(i) >= ntimes) {
                L1.add (i);

                System.out.println("число:" + i + " встречается: " + map.get(i) + " раз");
            }
        }
    return L1;
    }

    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> L2 = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            L2.add (r.nextInt(10) + 1);
         //   System.out.println(i + " " + L2.get(i));
        }
        L2 = Repetir (L2, 11);

        System.out.println ("Числа от 1 до 10 кот. в исходом массиве чисел встречается > 11 раз ");
        for (int j = 0; j < L2.size(); j++) {
            System.out.println (L2.get (j));
        }


    }
}