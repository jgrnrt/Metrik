package de.medieninformatik.softwaretechnik;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        //Menubar
        MenuBar mb = new MenuBar();
        Menu menu = new Menu("Hintergrundfarbe");
        Menu menu2 = new Menu("Kreis-Radius bestimmen");
        MenuItem green = new MenuItem("Grün");
        MenuItem gray = new MenuItem("Grau");
        menu.add(gray);
        menu.add(green);
        mb.add(menu);
        mb.add(menu2);
        f.setMenuBar(mb);


        //Backgroundcolors
        gray.addActionListener(e -> myCanvas.changeBackgroundColor(Color.gray));

        green.addActionListener(e -> myCanvas.changeBackgroundColor(Color.green));

        //set circle radius
        menu2.addActionListener(e -> {
            //int radius
            // dialog fenster
            // abfrage eingabe nutzer
            //mycanvas.setradius(radius)

        });
    }
}
