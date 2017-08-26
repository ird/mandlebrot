package uk.ord.ird.mandlebrot;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        SimpleMB m = new SimpleMB(1800, 1200);
        try {
            m.drawPNG("blank.png");
        } catch (IOException e) {
            System.out.println("Couldn't write image: " + e.getMessage());
        }
    }
}
