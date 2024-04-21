/*ф получает на вход два типа (расширения) графических форматов,
 находит в текущем каталоге все графические файлы, соответствующие первому расширению,
 и конвертирует их в графический формат по второму расширению.*/

import java.util.ArrayList;
import java.util.Arrays;                   
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Color;

public class RenameImages {
    public static void RenImages(String ext1, String ext2) throws IOException {
        try {
            ArrayList<File> expand = new ArrayList<File>();
            File root = new File(".");
            BufferedImage img;
            BufferedImage newImage;

            expand.addAll (Arrays.asList (root.listFiles()));

            File[] expandCopy = expand.toArray (new File [expand.size()]);
            expand.clear();

            ext2 = ext2.substring (1, 4);
            for (File file : expandCopy) {
                if (!file.isDirectory()) {

                    String fname = file.getName();

                    String extension = file.getName().substring (file.getName().indexOf("."));
                    if (extension.equals (ext1)) {       //&& ! r0.contains(file))

                        String fname2 = fname.substring (0, fname.length()-3) + ext2;

                        img = ImageIO.read (new File (fname));
                        newImage =  new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
                        newImage.createGraphics().drawImage(img, 0, 0, Color.WHITE, null);

                        ImageIO.write (newImage, ext2, new File (fname2));

                    }
                }
            }
        } catch(Exception e) {
             e.printStackTrace();

            }
        }

    public static void main(String[] args) throws IOException {
        RenImages ( ".jpg" , ".png");
    }
}
