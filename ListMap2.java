import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ListMap2 {
    static ArrayList<Integer> NumRepite (ArrayList<Integer> nList1, int ntimes) {
        ArrayList<Integer> ResList = new ArrayList<>(10);
        HashMap<Integer, Integer> map = new HashMap<>(10 );  // Создали мар

        for (int j = 0; j <= 99; j++) {         //список содерж 1-10, что соотв ключам, значения - счетчики
            int mkey = nList1.get (j);         // Знач в диапазоне 1-10 из листа - это будет ключом

            if (map.containsKey (mkey)) {
                int chet = map.get(mkey);        //Вытащить знач(счетчик), соотв ключу
                //Ключ - знач из листа, ind - счетчик
                chet++;
                map.put(mkey, chet); // увелич и меняем счетч

                if (chet > ntimes) {
                    if (!ResList.contains (mkey)) {
                        ResList.add(mkey);
                }
            }
            else
                map.put(mkey, 1);
        }
        return  ResList;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int nTimes = 12;
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