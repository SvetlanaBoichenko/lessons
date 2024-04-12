import java.io.*;
import java.util.ArrayList;

class Cats {
    int type = 0;
    String name = "";
    float massa = 0;
    int alength = 0;

    Cats() {
    }

    boolean SetName(String n) {
        if (n != "") {
            this.name = n;
            return true;
        } else
            return false;

    }

    boolean SetMassa(float m) {
        if (m > 0) {
           this.massa = m;
            return true;
        } else
            return false;
    }

    boolean SetLength(int l) {
        if (l > 0) {
            this.alength = l;
            return true;
        } else
            return false;
    }
}

public class ObjList {
    public static void main(String[] args) throws  IOException {
        Cats catobject = null;
        boolean legalprop = true;

        String st = "";
        String prop = "";

        ArrayList CatList = new ArrayList ();

        BufferedReader reader = null;
        File file1 = new File("Propities.txt");

        try {
             reader = new BufferedReader (new FileReader(file1));

        } catch (IOException e) {
            System.out.println("Ошибка файла");
            e.printStackTrace();
            reader.close();
            return;
        }

        st = reader.readLine();

        while ( st != null ) {

            catobject = new Cats();

            String[] arrSplit = st.split(", ");
            try {
                if (arrSplit.length >= 3) {
                    String n = arrSplit[0];
                    legalprop = catobject.SetName(n);

                    float m = Float.valueOf(arrSplit[1]);
                    legalprop = catobject.SetMassa(m);

                    int l = Integer.valueOf(arrSplit[2]);
                    legalprop = catobject.SetLength(l);

                    if (legalprop)
                        CatList.add (catobject);
                }
            } catch (NullPointerException en) {
                en.printStackTrace();
                System.out.println ("Объект класса Cats = 0");
                reader.close();
            }
            st = reader.readLine();
        }


        for (int j = 0; j < CatList.size(); j++) {
            Cats nextcat = (Cats) CatList.get(j);
            System.out.println("Имя: " + nextcat.name);
        }

        if (reader != null) {
            reader.close();
        }
    }
}