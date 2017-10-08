// Chris Fietkiewicz. Draws fractal line. Based on Fractal.java by Michael Main.
import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Fractal2 extends JPanel {
    JFrame f = new JFrame();
	int randomGeneratorSeed = 100; // Seed for randomNumberGenerator
	Random rng = new Random(randomGeneratorSeed); // Random number generator
	final int STOP = 4;  // When length < EPSILON, draw a line segment

    public static void main(String[] args){
        Fractal2 f = new Fractal2();
    }

    public Fractal2(){
        f.add(this); // Add JPanel to JFrame
        f.setSize(1500, 1000);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure that program terminates when window is closed
        f.setVisible(true); // Call paintComponent()
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D drawingArea = (Graphics2D) g;
        drawingArea.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
		randomFractal(0, height/2, width, height/2, drawingArea);
    }

	public void randomFractal(int leftX, int leftY, int rightX, int rightY, Graphics2D drawingArea)	{
		int midX, midY;      // Midpoints in the x and y dimensions
		int delta;           // Amount to shift the line's midpoint up or down

		if ((rightX - leftX) <= STOP)
			drawingArea.draw(new Line2D.Double(leftX, leftY, rightX, rightY));
		else {
			midX = (leftX + rightX) / 2;
			midY = (leftY + rightY) / 2;
			delta = (int)((rng.nextDouble() - 0.5) * (rightX - leftX));
			midY += delta;
			randomFractal(leftX, leftY, midX,   midY,   drawingArea);
			randomFractal(midX,  midY,  rightX, rightY, drawingArea);
		}
	}
}