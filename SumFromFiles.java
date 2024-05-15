import java.io.*;
import java.util.Random;

public class SumFromFiles {
    public static void main (String[] args) throws IOException {

        String fpath = "C:\\BSV\\Java2\\IntelliJ\\Files1\\";

        int curSum = 0;
        int nfiles = 222;

       Create222files (fpath, nfiles);

       for (int i = 1; i <= nfiles; i++)
           curSum = curSum + Sum1f(fpath, i);

       System.out.println("Сумма =  " + curSum);
    }

    static int Sum1f (String fpath, int fnum) throws IOException {
        int sum = 0;

        File file1 = null;
        BufferedReader reader = null;

        String fname1 = (fpath + fnum + ".txt");

        try {
            file1 = new File (fname1);
            reader = new BufferedReader (new FileReader (file1));

            for (int j = 0; j <= 2; j++) {
                String  st = reader.readLine();

                sum = sum + Integer.valueOf (st);
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return sum;
    }

    // Дополнительная функция для создания n числа файлов
    public static int Create222files (String path, int nf) throws IOException {
        Random rand = new Random();
        int filecount = 0;
        int num = 0;

        try {
            for (int i = 1; i <= nf; i++) {
                File file = new File (path + i + ".txt");
                BufferedWriter writer = new BufferedWriter (new FileWriter (file));

                for (int j = 0; j <= 2; j++) {     // запись в файл 3х строк
                    num = rand.nextInt(10) + 1;
                    writer.write (Integer.toString (num));
                    writer.newLine();
                }
                writer.close();
                filecount ++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return filecount;
    }
}

