import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;                    // работы с массивами
import java.nio.file.*;

/*Напишите функцию, которая удаляет заданный каталог (возможно, непустой)и все файлы внутри него.
  Если внутри каталога есть подкаталоги, ничего удалять не надо. Функция возвращает флажок успешно/неудача.*/
public class DelCatalog {
    public static boolean b (String cPath)   //
    {
        //File file1 = new File("");

        ArrayList<File> myList = new ArrayList<File>();

        File curDir = new File(cPath);                    // Созд объ типа File
        if (!curDir.exists()) {
            return false;
        }

        myList.add(curDir);

        for (int depth = 0; depth <= 1; depth++) {       // Цикл1 для 1 ур вложенности
            File[] fileArray = myList.toArray(new File[myList.size()]);
            myList.clear();

            for (File file1 : fileArray) {
                //file1 = fileArray[i];
                System.out.println (file1);
                if (file1.isDirectory() && depth == 1) {
                    return false;
                }

                if (depth == 0)
                    myList.addAll(Arrays.asList(file1.listFiles()));
            }

            if (depth == 1)
              for (File file : fileArray) {
                    file.delete();
              }

        }
         curDir.delete();
        return true;
    }




    public static void main(String[] args) {
        String cPath = "c:\\Temporal\\";
        boolean exito;
        exito = b (cPath);
        if (exito)
            System.out.println("Удалено");
        else
            System.out.println("Файлы не удалены. Каталог не существует или содержит подкаталог");
    }
}