package de.medieninformatik.softwaretechnik;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

/**
 * MyCanvas class which inherits the Canvas class to create Canvas
 */

public class MyCanvas extends Canvas {

    private int firstX = 0; //Click Coordinates
    private int firstY = 0;
    private int count = 0; //Count for CLick Cycle
    private int radius = 100;

    private int[] Coordinate1 = new int[2];
    private int[] Coordinate2 = new int[2];

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
                        //first Circle, save coordinates
                        if(count==0){
                            Coordinate1[0] = e.getX();
                            Coordinate1[1] = e.getY();
                        } else {
                            //second circle
                            Coordinate2[0] = e.getX();
                            Coordinate2[1] = e.getY();
                            paintDistance(getGraphics());
                        }
                        paintCircle(getGraphics(), e);
                        showCoordinates(getGraphics());
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

    /**
     * change background color of canvas
     */
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

    /**
     * set circle radius
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Paint Circle on canvas
     */
    public void paintCircle(Graphics g, MouseEvent e) {
        g.setColor(Color.RED);
        g.fillOval(e.getX()-radius, e.getY()-radius, radius*2, radius*2);
    }

    /**
     * Print Coordinates on Canvas
     */
    public void showCoordinates(Graphics g) {
        g.setFont(new Font("Bold", Font.BOLD,20));
        if (count == 0) {
            g.drawString("Koordinate 1: "+ Arrays.toString(Coordinate1),100,100);
        } else {
            g.drawString("Koordinate 2: "+ Arrays.toString(Coordinate2),100,130);
        }
    }

    /**
     * calculates the distance of the two circles
     */
    public double calcDistance(){
        return Math.sqrt((Coordinate2[1] - Coordinate1[1]) * (Coordinate2[1] - Coordinate1[1]) +
                (Coordinate2[0] - Coordinate1[0]) * (Coordinate2[0] - Coordinate1[0]));
    }

    /**
     * paints the distance on the canvas as a double
     */
    public void paintDistance(Graphics g){
        g.setColor(Color.black);
        g.setFont(new Font("Bold", Font.BOLD,20));
        g.drawString("Distanz: " + calcDistance(),100,160);
    }

}
