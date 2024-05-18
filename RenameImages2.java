import java.util.ArrayList;
import java.util.Arrays;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class RenameImages2 {
    public static void RenImages(String ext1, String ext2) throws IOException {

        BufferedImage img;
        BufferedImage newImage;

        ArrayList<ArrayList<File>> fileList;

        fileList = ScanD (".", ext1, false); // поиск файлов в тек каталоге

        if (fileList.get(0).size() <= 0 ) return;

        for (File fil : fileList.get(0)) {
            img = ImageIO.read(fil);

            int ind = fil.getName().indexOf (".");
            String fnewname = ".\\" + fil.getName().substring (0, ind) + ext2;
            File newf = new File (fnewname);    // для нового файла заготовка

            String typeoffile = "";             // для указания типа файла БЕЗ .

            if (ext2.length() > 1) {           // на всякий случай
                typeoffile = ext2.substring (1);
                ImageIO.write (img, typeoffile, newf);
            }
        }
    }

    public static ArrayList <ArrayList<File>> ScanD (String cPath, String ext,  boolean b)   //String mExt,
    {
        int level = 1;

        ArrayList<File> myList1 = new ArrayList<File>(); // Создание списка 1 для файлов
        ArrayList<File> myList2 = new ArrayList<File>(); // Создание списка 2 для директориев

        ArrayList<File> curlist = new ArrayList<File>();
        ArrayList <ArrayList<File>> retList  = new ArrayList <> (); // Создание списка 2 для директориев

        File root = new File (cPath);                    // Созд объ типа File
        curlist.add (root);
        // curlist.addAll(Arrays.asList(root.listFiles()));
        if (b) level = 2;
        for (int depth = 0; depth <= level; depth ++) {       // Цикл1 для 1 ур вложенности
            File[] fileArray = curlist.toArray (new File [curlist.size ()]); // сохранение списка в новый массив типа File
            curlist.clear();                                              // очищение самого списка expand

            for (File file : fileArray) {                   // Цикл2 по всем элементам массива внутри
                if (file.isDirectory ()) {                  // Если наткнулись на директорий :
                    curlist.addAll (Arrays.asList (file.listFiles() ));
                    if(depth != 0)                          //это сам корень
                        myList1.add(file);

                } else {
                    int ind = file.getName().indexOf(".");

                    if (ind > 0) {
                        String real_extension = file.getName().substring(ind);
                        if (ext.equals(".*") || real_extension.equals(ext))
                            myList2.add(file);
                    }
                }
            }
        }
        retList.add (myList2);
        retList.add(myList1);
        return retList;
    }

    public static void main(String[] args) throws IOException {
        RenImages ( ".jpg" , ".png");
    }
}
