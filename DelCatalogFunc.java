import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;                    // работы с массивами

public class DelCatalogFunc {
    public static boolean delFiles (String cPath)   //
    {
         ArrayList <ArrayList<File>> retList;

         retList = ScanD (cPath, ".*",  false); //

         if (retList.get(1).size() > 0 ) return false; // есть подкаталоги - ничего не удалять

        for (File file: retList.get(0))
            file.delete();

        return true;
    }


    public static ArrayList <ArrayList<File>> ScanD (String cPath, String ext,  boolean b)   //String mExt,
    {
        String curfile_path = "";
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
                    if(depth != 0)             //это сам корень
                        myList1.add(file);

                } else {
                    int ind = file.getName().indexOf(".");

                    if (ind > 0) {
                        String extension = file.getName().substring(ind);
                        if (ext.equals(".*") || extension.equals(ext))
                            myList2.add(file);
                    }
                }
            }
        }

        retList.add (myList2);
        retList.add(myList1);
        return retList;
    }


    public static void main(String[] args) {
        String cPath = "C:\\Temporal\\";
        boolean exito;
        exito = delFiles (cPath);
        if (exito)
            System.out.println("Удалено");
        else
            System.out.println("Файлы не удалены. Каталог не существует или содержит подкаталог");
    }
}