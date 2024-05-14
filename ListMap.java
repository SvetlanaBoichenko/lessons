import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ListMap {
    static ArrayList<Integer> NumRepite (ArrayList<Integer> nList1, int ntimes) {
        // Создали мар
        HashMap<Integer, Integer> map = new HashMap<>();
        // Заполняем ключами 1-10 и значениями - нулями
        for (int i = 1; i <= 10; i++) {
            map.put ( Integer.valueOf(i), 0);
        }
        // Смотрим в список,он содерж ч. 1-10, что соотв ключам, знач - счетчиками будут
        for (int j = 0; j <= 99; j++) {
            int listVal = nList1.get (j);  // Знач в диапазоне 1-10 из листа - оно будет ключом

            int ind = map.get (listVal); //Вытащить знач(счетчик), соотв ключу
            //Ключ - знач из листа, ind - счетчик
            ind++;
            map.put (listVal, ind); // ключ - число из листа 1-10, значение -  увеличиваем и меняем
        }

        nList1.clear(); //очмстим старые значения чтоб заполнить новыми - обработаными
        for (Integer i : map.keySet()) {
            if (map.get(i) >= ntimes) {
                nList1.add (i);

                System.out.println("число:" + i + " встречается: " + map.get(i) + " раз");
            }
        }
        return nList1;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int nTimes = 11;
        ArrayList<Integer> nList;
        ArrayList<Integer> nList2 = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            nList2.add (r.nextInt(10) + 1);
        }

        nList = NumRepite (nList2, nTimes);

        System.out.println ("Числа от 1 до 10 кот. в исходом массиве чисел встречается > " + nTimes +" раз ");
        for (int j = 0; j < nList.size(); j++) {
            System.out.println (nList.get (j));
        }
    }
}