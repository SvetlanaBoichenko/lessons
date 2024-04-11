import java.io.*;
import java.util.Random;

public class File10txt {
     public static void main(String[] args) {
         Random rand = new Random();
         int num = 0;
         String str_to_file = new String();
         String fname = new String();

         try {
            for (int i = 1; i<=10; i++) {
                fname = Integer.toString(i) + ".txt";

                File file = new File (fname);
                BufferedWriter writer = new BufferedWriter (new FileWriter(file));

                for (int j = 0; j <=2; j ++) {
                    num = rand.nextInt(10) + 1;
                    writer.write(Integer.toString(num));
                    writer.newLine();
                }
                        writer.close();

            }
                } catch (IOException e) {
                    System.out.println ("Ошибка при записи в файл");
                    e.printStackTrace();
                }
     }
}