package de.medieninformatik.softwaretechnik;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Metrik-Class
 * Creates the Frame
 */

public class Metrik{

    public Metrik() {
        // creating a frame
        Frame f = new Frame();
        // adding canvas to frame
        MyCanvas myCanvas = new MyCanvas();
        f.add(myCanvas);

        // setting layout, size and visibility of frame
        f.setLayout(null);
        f.setSize(1200, 800);
        f.setVisible(true);


        //close on X
        f.addWindowListener (new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                f.dispose();
            }
        });
    }
}
