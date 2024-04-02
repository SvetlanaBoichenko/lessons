//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// Напишите программу, которая выделяет из строки подстроку --
//начиная с заданной позиции и заданной длины, и формирует из неё отдельную строку.
//
import java.util.logging.Logger;
import java.util.Scanner;

public class TestJUL
{

    public static void main (String[]args)
    {
        Logger log = Logger.getLogger(TestJUL.class.getName());

        log.info("Start");

        int len1 = 0;
        int pos  = 0;
        int len2 = 0;

        System.out.println ("Ввести исходную строку");

        Scanner inp = new Scanner(System.in);

        String S1 = inp.nextLine();         //Исходная строка in.nextLine();

        len1 = S1.length();
        assert len1 > 0 : "Длина строки = " + len1;  // test assert


        System.out.println ("Ввод позиции в строке");
        pos = inp.nextInt();  // Позиция в строке

        assert pos >= 0;         // test assert 2
        assert pos < len1 -1;

        System.out.println ("Ввод длины подстроки");

        len2 = inp.nextInt();
        assert pos + len2 <= len1 : "Длина подстроки = " + (pos + len2) ;

        if (pos + len2 > len1) {
            log.warning("Ошибка позиции или длины подстроки");
            len2 = 0;
        }

        char[] ca = new char [len2];

        for (int i = 0; i < len2; i++) {
            ca[i] = S1.charAt(pos);
            pos++;
        }

        if (len2 != 0) {
            assert len2 > 0; // абсурд
            String S2 = new String(ca);
            System.out.println(S2);
        }
        else
            log.severe("Ошибка при вводе данных");

    }
}
