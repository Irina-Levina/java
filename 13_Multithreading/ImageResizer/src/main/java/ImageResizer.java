import org.imgscalr.Scalr;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageResizer implements Runnable {
    private String dstFolder;
    int newWidth;
    File file;


    public ImageResizer(String dstFolder, File file, int newWidth) {
        this.dstFolder = dstFolder;
        this.file = file;
        this.newWidth = newWidth;
    }

    @Override
    public void run() {

        try {
            BufferedImage image = ImageIO.read(file);
            if (image != null) {

                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth));

                BufferedImage newImage = Scalr.resize(image, newWidth, newHeight, null);
                File newFile = new File(dstFolder + "/" + file.getName());

                System.out.println(newFile.getName() + " Thread name: " + Thread.currentThread().getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
