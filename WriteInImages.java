// Дополнить рисованием в центре изображения незаполненного квадрата,
//внутри которого будут написаны две строчки (вторая с новой строки):

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;                    // работы с массивами
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class WriteInImages {
    public static void RenImages(String ext1, String ext2) throws IOException {
        try {
            ArrayList<File> expand = new ArrayList<File>();
            File root = new File(".");
            BufferedImage img;
            BufferedImage newImage;
            Graphics2D gr;
            expand.addAll (Arrays.asList (root.listFiles()));

            File[] expandCopy = expand.toArray (new File [expand.size()]);
            expand.clear();

            ext2 = ext2.substring (1, 4);
            for (File file : expandCopy) {
                if (!file.isDirectory()) {

                    String fname = file.getName();

                    String extension = file.getName().substring (file.getName().indexOf("."));
                    if (extension.equals (ext1)) {

                        String fname2 = fname.substring (0, fname.length()-3) + ext2;
                        // Читаем из файла
                        img =  ImageIO.read (new File (fname));

                        // Создаем новое пустое с размерами прочитанного
                        newImage =  new BufferedImage (img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

                        gr = newImage.createGraphics();
                        gr.drawImage ( img, 0, 0, Color.WHITE, null);

                        int x = newImage.getWidth()/2;
                        int y = newImage.getHeight()/2;
                        int fontsize = y/10;

                        gr.setColor (Color.BLACK);
                        gr.drawRect (x/2, y/2, x, x);
                        gr.setColor (Color.RED);

                        gr.setFont (new Font("Courier New", Font.BOLD, fontsize));

                        gr.drawString ("Hello, ",3*x/4, 3*y/4);
                        gr.drawString ("world!", 3*x/4, 3*y/4 + fontsize);

                        ImageIO.write (newImage, ext2, new File (fname2));

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) throws IOException {
        RenImages ( ".jpg" , ".png");
    }
}