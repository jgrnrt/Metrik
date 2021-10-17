package de.medieninformatik.softwaretechnik;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * MyCanvas class which inherits the Canvas class to create Canvas
 */

public class MyCanvas extends Canvas {

    private int firstX = 0; //Click Coordinates
    private int firstY = 0;
    private int count = 0; //Count for CLick Cycle

    /**
     * Constructs a new Canvas.
     */
    public MyCanvas() {
        setSize(1200, 800);

        //Click Event Cycle
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //first 2 mouse clicks
                if (count < 2) {
                    if (firstX == e.getX() && firstY == e.getY()){
                        paintCircle(getGraphics(), e);
                        count++;
                    } else {
                        //save old coordinates
                        firstX = e.getX();
                        firstY = e.getY();
                    }
                } else {
                    //if third time mouse clicked
                    repaint();
                    count = 0;
                }
            }
        });
    }

    public void changeBackgroundColor (Color c){
        setBackground(c);
    }


    /**
     * paint() method to draw inside the canvas
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public void paintCircle(Graphics g, MouseEvent e) {
        g.setColor(Color.RED);
        g.fillOval(e.getX()-100, e.getY()-100, 200, 200);
    }
}
