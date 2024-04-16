import java.io.*; // Подключение библиотек для: работы с файлами
import java.util.ArrayList;                 // работы со списком
import java.util.Arrays;                    // работы с массивами

public class SubCatalog {
    public static void main(String[] args) {
        File root = new File(".");  // Созд объекта класса File,связанного с текущим корневым каталогом
        System.out.println("File exists : " + root.exists()); // Существует ли объект root? - вывести на консоль
        ArrayList<File> expand = new ArrayList<File>();       // создание списка expand, для объектов типа File
        expand.add(root);                                     // Добавить в этот список объект root

        for(int depth = 0; depth < 10; depth++) {       // Цикл1 для 10 уолвней вложенности
            File[] expandCopy = expand.toArray (new File[expand.size()]); // сохранение(копирование) списка expand в новый массив типа File expandCopy
            expand.clear();                                              // очищение самого списка expand
            for (File file : expandCopy) {                               // Цикл2 по всем элементам массива expandcopy внутри depth- уровня вложенности
                System.out.println(depth + " " + file);                  // Печать уровня вложенности (1-10) и пути файла или директории
                if (file.isDirectory () ) {                              // Если наткнулись на директорий :
                    expand.addAll(Arrays.asList (file.listFiles()));     // 1.Определить новый массив имен этой директории  - file.listFiles()
                                                                         // 2.Преобр. ЭТОТ массив имен в список  - Arrays.asList(file.listFiles())
                                                                         // 3.Добавить его список expand и продолжить Цикл2 для СЛЕД. элемента из expandcopy
                                                                         // повторить 1.-2.-3. для всех элементов Цикла2 - пройти уровень вложенности depth
                                                                         //  Перейти на след ур depth в Цикл1
                }
            }
        }

    }
}