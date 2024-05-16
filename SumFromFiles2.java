import java.io.*;
import java.util.Random;

public class SumFromFiles2 {
    public static void main (String[] args) throws IOException {

        String fpath = "D:\\BSV\\Java2\\";
        int lasterr = 0;
        int curSum = 0;
        int nfiles = 222;
        int [] resultfunc = {0, 0};

     //   Create222files (fpath, nfiles);

        for (int i = 1; i <= nfiles; i++) {
            resultfunc = Sum1f(fpath, i);
            curSum = curSum + resultfunc [1];       //  Sum1f(fpath, i)[1];

            if(resultfunc [0] != 0)
                lasterr =  resultfunc [0];         //Sum1f(fpath, i)[0];
        }
            if (lasterr != 0)
                System.out.println("код последней ошибки  " + lasterr);

            System.out.println("Сумма =  " + curSum);
    }

    static int[] Sum1f (String fpath, int fnum) throws IOException {
        int sum = 0;
        int errcode = 0;
        int [] res  = {0, 0}; // первое- код ошибки, второе- сумма

        File file1;
        BufferedReader reader = null;

        String fname1 = (fpath + fnum + ".txt");

        try {
            file1 = new File (fname1);
            reader = new BufferedReader (new FileReader (file1));

            for (int j = 0; j <= 2; j++) {
                String  st = reader.readLine();

                sum = sum +  Integer.parseInt(st); //Integer.valueOf
            }
        }

        catch (FileNotFoundException  fe) { //fe.printStackTrace(); - убрала
            errcode = -1;
        }

        catch (IOException e) {
            errcode = -2;                       // ошибки чтения и записи в файл
        }

        catch (IllegalArgumentException ie) {
            errcode = -3;                       // обработка некорректного аргумента строки
        }

         finally {
            if (reader != null) {
                reader.close();
            }
        }
        res [0] = errcode;
        res [1] = sum;
        return res;
    }

    // Дополнительная функция для создания n числа файлов
    public static int Create222files (String path, int nf)  { //throws IOException
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