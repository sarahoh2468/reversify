import com.sun.imageio.plugins.gif.GIFImageReader;
import com.sun.imageio.plugins.gif.GIFImageReaderSpi;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
public class reversify {

    public static ArrayList<BufferedImage> getFrames(File gif) throws IOException{
        ArrayList<BufferedImage> frames = new ArrayList<BufferedImage>();
        ImageReader ir = new GIFImageReader(new GIFImageReaderSpi());
        ir.setInput(ImageIO.createImageInputStream(gif));
        for(int i = 0; i < ir.getNumImages(true); i++)
            frames.add(ir.getRawImageType(i).createBufferedImage(ir.getWidth(i), ir.getHeight(i)));
        return frames;
    }

    public static int numberOfFrames(ArrayList frames) {
        int i = frames.size();
        return i;
    }

    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        //String s = sc.next();
        File file = new File("C:\\cat.gif");
        ArrayList frames = getFrames(file);
        int n = numberOfFrames(frames);
        System.out.println(n);

    }
}