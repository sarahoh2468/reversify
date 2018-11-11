import com.sun.imageio.plugins.gif.GIFImageReader;
import com.sun.imageio.plugins.gif.GIFImageReaderSpi;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class reversify {
    public static ArrayList<BufferedImage> getTotalFrames(File gif) throws IOException {
        ArrayList<BufferedImage> frames = new ArrayList<BufferedImage>();
        ImageReader ir = new GIFImageReader(new GIFImageReaderSpi());
        ir.setInput(ImageIO.createImageInputStream(gif));
        for (int i = 0; i < ir.getNumImages(true); i++) {
            frames.add(ir.getRawImageType(i).createBufferedImage(ir.getWidth(i), ir.getHeight(i)));
        }
        return frames;
    }

    public static int numberOfFrames(ArrayList frames) {
        int i = frames.size() / 10;
        return i;
    }

    public static ArrayList<BufferedImage> getFrames(ArrayList<BufferedImage> old) throws IOException {
        int i = numberOfFrames(old);
        ArrayList<BufferedImage> frames = new ArrayList<BufferedImage>(i);
        for (int j = 0; j < old.size(); j += i) {
            frames.add(old.get(j));
        }
        return frames;
    }

    public static void main(String[] args) throws IOException {
        //keywords represent the title or frequent words that came up in the search
        ArrayList<String> keywords = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        File file = new File(sc.next());
        ArrayList<BufferedImage> totalFrames = getTotalFrames(file);
        ArrayList<BufferedImage> result = getFrames(totalFrames);
        // for each image, there is a keyword(s) assigned
        for (int i = 0; i < result.size(); i++) {
            //search api for image
            // return keyword to keywords[i]
        }
        // for every keyword, count how many times it occurred in the set
        for (int i = 0; i < keywords.size(); i++) {
            for (int j = 0; j < keywords.size(); j++) {
                if (keywords[i] == keywords[j]) {
                    keywords[i][0] += 1;
                }
            }
        }
        // find the keyword(s) that occurred the most
        int largest=0;
        String s;
        for (int i = 0; i < keywords.size(); i++) {
            if (keywords[i][0] > largest) {
                largest = keywords[i][0];
                s = keywords[i];
            }
        }
        System.out.println(s);
    }
}
