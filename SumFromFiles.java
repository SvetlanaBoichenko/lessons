import java.io.*;
import java.util.Random;


public class SumFromFiles {
    public static void main (String[] args) {
        Random rand = new Random();
        String fpath = "C:\\BSV\\Java2\\IntelliJ\\Files1\\";
        int n1 =  0;
        int n2 =  0;
        int curSum = 0;

        while (n1 == n2) {
            n1 =  rand.nextInt (10) + 1;
            n2 =  rand.nextInt (10) + 1;
        }

        try {
            curSum = Sum2f (fpath, n1, n2);

       } catch (IOException e) {
            System.out.println ("Ошибка файла");

            throw new RuntimeException (e);

       }

        System.out.println("Сумма =  " + curSum);
    }
    static int Sum2f ( String fpath, int a, int b)  throws  IOException {
        int sum = 0;
        String st = "";

        BufferedReader reader = null;

        String fname1;// = new String();
         fname1 = Integer.toString(a) + ".txt";
        fname1 = (fpath + fname1);
         System.out.println(fname1);



        String fname2 = new String();
          fname2 = Integer.toString (b) + ".txt";

        fname2 = (fpath + fname2);
        System.out.println(fname2);

        File file1 = null;
        for (int i = 0; i < 2; i++) {
            if (i == 0)
                file1 = new File(fname1);
            else
                file1 = new File(fname2);

               try {
            reader = new BufferedReader (new FileReader (file1));

            for (int j = 0; j <= 2; j++) {
                st = reader.readLine();

                if (st == null) {
                    System.out.println("Число строк меньше 3");
                    reader.close();
                }
                      try {
                sum = sum + Integer.valueOf(st);

                      } catch (IllegalArgumentException ae) {
                 System.out.println("Строка не в норме. Выход");
                  ae.printStackTrace();
                        return -1;
                     }
                  }

                   } catch (IOException e) {
                   System.out.println("Ошибка при чтении файла");
                 e.printStackTrace();
                 return -1;
                  } finally {
                if (reader != null) {
                    System.out.println("Закрыть файл  " + file1.getName());
                    reader.close();
                }
                //       }
            }
        }
        return sum;
    }
}
