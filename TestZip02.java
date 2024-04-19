// Добавление массива файлов в сужествующий архив

import java.util.zip.*;
import java.io.*;

public class TestZip02 {
    public static void addFilesToZip (File source, File[] files) {
        try {

            File tmpZip = File.createTempFile (source.getName(), null); // Созд реального врем файла на диске в опред месте
            boolean b = tmpZip.delete ();                                    // Удал его с диска, остается в памяти объект типа File - с описанием свойств- имени и тд
            if (!source.renameTo (tmpZip)) {                                 // перенесли по факту в temp каталог с использ имени исх файла(исх файл должен! быть на диске) - теперь его нет на старом месте
                throw new Exception ("Could not make temp file (" + source.getName() + ")");
            }
            byte[] buffer = new byte[1024];
            ZipInputStream zin = new ZipInputStream (new FileInputStream(tmpZip)); // Создаем поток типа zip - архивир- (на диске созд врем архив не пустой- сод "старые" записей)
            ZipOutputStream out = new ZipOutputStream (new FileOutputStream(source));// Создаем поток типа zip - для записи (на диске созд пустой архив с именем source для записи новых)

            for (int i = 0; i < files.length; i++) {  // Цикл по массиву файлов

                FileInputStream in = new FileInputStream (files [i]); // Созд поток для чтения их файлов из массива для записи в архив

                out.putNextEntry (new ZipEntry(files[i].getName()));  //Выделение места для объ типа ZipEtry(указыв на файл из массива) в вых zip для дальнейшей записи
                for (int read = in.read(buffer); read > -1; read = in.read(buffer)) {  // Выделение фикс порции заносимого в архив файла
                    out.write(buffer, 0, read);                                    //запись содержимого этого файла по частям
                }
                out.closeEntry();                                                       // Закрыли запись 1 файла
                in.close();                                                             // Закрыли поток  файла из массив
            }                                                                           // Итог-архив с исх именем source содержит пока только новые файлы из масива ф

            for (ZipEntry ze = zin.getNextEntry(); ze != null; ze = zin.getNextEntry()) {  // из исх арх source выделяем его старые части чтоб собрать в кучу старое иновое
                out.putNextEntry (ze);  // приготовили "место" для записи из врем ф старого содержимого исх архива
                for (int read = zin.read(buffer); read > -1; read = zin.read(buffer)) {
                    out.write(buffer, 0, read);    // записали к новым старое
                }
                out.closeEntry();                   // закрыли запись
            }

            out.close();            // закрыли поток
            tmpZip.delete();        // Удалили временный файл 

        } catch(Exception e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            File f = new File ("TextFiles2.zip"); // Создание объекта типа File Содержащий путь и пр атрибуты
            // Созд массив файлов
            File[] files = { new File ("P1.txt"),  new File("P11.txt"), new File("P12.txt") };

            addFilesToZip (f, files);

        }
    }

