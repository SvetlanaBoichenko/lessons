/*Напишите функцию с тремя параметрами (путь к каталогу, расширение файла и булев флажок),
 которая возвращает список из двух списков имён:
список всех файлов с заданным расширением в заданном каталоге (включая файлы из его подкаталогов одного уровня вложенности, если флажок = true),
и список всех подкаталогов в заданном каталоге (включая подкаталоги одного уровня вложенности, если флажок = true).*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;                    // работы с массивами
import java.nio.file.*;

public class SubDir2 {
    public static ArrayList <ArrayList<File>> f (String cPath, String ext,  boolean b)   //String mExt,
    {
        String curfile_path = "";
        int level = 1;

        ArrayList<File> myList1 = new ArrayList<File>(); // Создание списка 1 для файлов
        ArrayList<File> myList2 = new ArrayList<File>(); // Создание списка 2 для директориев

        ArrayList<File> curlist = new ArrayList<File>();

        ArrayList <ArrayList<File>> retList  = new ArrayList <> (); // Создание списка 2 для директориев

        File root = new File (cPath);                    // Созд объ типа File
        curlist.add (root);

        if (b) level = 2;
        for (int depth = 0; depth <= level; depth ++) {       // Цикл1 для 1 ур вложенности
            File[] fileArray = curlist.toArray (new File [curlist.size ()]); // сохранение списка в новый массив типа File
            curlist.clear();                                              // очищение самого списка expand

            for (File file : fileArray) {                   // Цикл2 по всем элементам массива внутри
                if (file.isDirectory ()) {                  // Если наткнулись на директорий :
                    curlist.addAll (Arrays.asList (file.listFiles() ));
                    if(depth != 0)
                        myList1.add(file);

                } else {
                       curfile_path = file.getPath();  //String.valueOf(file);
                       int len = curfile_path.length();

                        if (curfile_path.charAt(len - 4) != ext.charAt(0))
                            continue;
                        if (curfile_path.charAt(len - 3) != ext.charAt(1))
                            continue;
                        if (curfile_path.charAt(len - 2) != ext.charAt(2))
                            continue;
                        if (curfile_path.charAt(len - 1) != ext.charAt(3))
                            continue;

                        myList2.add (file);

                    }
                }
            }

        retList.add (myList2);
        retList.add(myList1);
        return retList;
    }


    public static void main(String[] args) {
        String CatalogPath = "c:\\BSV\\Java2\\IntelliJ\\Files1";  //"// c:\\BSV\\Java2\\IntelliJ\\Files1";
        String ext = ".txt";
        boolean b = true;

        ArrayList <ArrayList<File>> ListofList = f (CatalogPath, ext, b);

        System.out.println (ListofList);
    }
}


