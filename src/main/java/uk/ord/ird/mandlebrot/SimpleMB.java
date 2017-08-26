package uk.ord.ird.mandlebrot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SimpleMB {
    // for rendering a simple mandlebrot set image
    public SimpleMB(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void drawPNG(String filepath) throws IOException {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for(int row=0; row < width; ++row) {
            for(int col=0; col < height; ++col) {
                Complex c = new Complex((3.5*row/width) - 2.5, 1.0-(2.0*col/height));
                Complex z = new Complex(0, 0);
                int i = 0;
                while(z.mag() < 2 && i < 100) {
                    z = z.sq().add(c);
                    ++i;
                }
                if(i < 100) {
                    image.setRGB(row, col, 0xff0f0f0f | i * 1000); //escapes
                } else {
                    image.setRGB(row, col, 0xff000000); //converges
                }
            }
        }

        ImageIO.write(image, "png", new File(filepath));
    }

    private int width;
    private int height;
}
