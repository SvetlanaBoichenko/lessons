import java.io.*;
import java.util.Random;


public class Sum3 {
    public static void main(String[] args) {
        Random rand = new Random();
        int n1 =  0;
        int n2 =  0;

        while (n1 == n2) {
            n1 =  rand.nextInt(10) + 1;
            n2 =  rand.nextInt(10) + 1;
        }

         try {
            Sum3num (n1, n2);

       } catch (IOException e) {
            throw new RuntimeException(e);
       }
    }
    static void Sum3num (int a, int b)  throws  IOException {
        int sum = 0;
        String st = "";

        BufferedReader reader = null;

        String fname1 = new String();
        fname1 = Integer.toString(a) + ".txt";
        System.out.println(fname1);

        fname1 = ("C:\\BSV\\Java2\\IntelliJ\\Files1\\" + fname1);

        String fname2 = new String();
        fname2 = Integer.toString(b) + ".txt";
        System.out.println(fname2);
        fname2 = ("C:\\BSV\\Java2\\IntelliJ\\Files1\\" + fname2);


        File file1;
        for (int i = 0; i < 2; i++) {
            if (i == 0)
                file1 = new File(fname1);
            else
                file1 = new File(fname2);

            try {
                reader = new BufferedReader(new FileReader(file1));

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
                        return;
                    }
                }

            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла");
               //e.printStackTrace();
                return;
            } finally {
                if (reader != null) {
                    System.out.println("Закрыть файл  " + file1.getName());
                    reader.close();
                }
            }
        }
        System.out.println("Сумма =  " + sum);
    }


}
