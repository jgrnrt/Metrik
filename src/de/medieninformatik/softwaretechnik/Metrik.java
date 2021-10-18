package de.medieninformatik.softwaretechnik;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Metrik-Class
 * Creates the Frame
 */

public class Metrik {

    private static Dialog d;
    private static TextField textfield;
    private static MyCanvas myCanvas;


    public Metrik() {
        // creating a frame
        Frame f = new Frame();

        // adding canvas to frame
        myCanvas = new MyCanvas();
        f.add(myCanvas);

        // setting layout, size and visibility of frame
        f.setLayout(null);
        f.setSize(1200, 800);
        f.setVisible(true);

        //close on X
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });

        //Menubar
        MenuBar mb = new MenuBar();
        Menu menu = new Menu("Hintergrundfarbe");
        Menu menu2 = new Menu("Kreis");
        MenuItem radius = new MenuItem("Radius bestimmen");
        MenuItem green = new MenuItem("Grün");
        MenuItem gray = new MenuItem("Grau");
        menu2.add(radius);
        menu.add(gray);
        menu.add(green);
        mb.add(menu);
        mb.add(menu2);
        f.setMenuBar(mb);

        //Backgroundcolors
        gray.addActionListener(e -> myCanvas.changeBackgroundColor(Color.gray));
        green.addActionListener(e -> myCanvas.changeBackgroundColor(Color.green));

        //set circle radius
        radius.addActionListener(e -> openDialogRadius());
    }

    /**
     * open dialog for user input
     */
    public static void openDialogRadius() {
        Frame f2 = new Frame();
        d = new Dialog(f2, "Dialog Example", true);
        d.setLayout(new FlowLayout());
        Button b = new Button("OK");
        b.addActionListener(e -> {
            changeRadius();
            d.setVisible(false);
        });

        textfield = new TextField();
        textfield.setText("Radius als Zahl eingeben");

        d.add(textfield);
        d.add(b);
        d.setSize(300, 300);
        d.setVisible(true);
    }

    /**
     * change circle radius in MyCanvas and check if textfield is an Integer
     */
    public static void changeRadius(){
        if (isInteger(textfield.getText())){
            int radius = Integer.parseInt(textfield.getText());
            myCanvas.setRadius(radius);
        }
    }

    /**
     * check if String is an int
     */
    public static boolean isInteger(String string) {
        try {
            Integer.valueOf(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
