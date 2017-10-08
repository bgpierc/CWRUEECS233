// Chris Fietkiewicz. Draws fractal line with dots. Based on Fractal.java by Michael Main.
// Similar to Fractal2.java, but shows exact points. Also uses slightly
// different random number generation that is useful for the homework assignment.
import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Fractal3Chris extends JPanel {
    JFrame f = new JFrame();
	int randomGeneratorSeed = 10; // Ajusts seed for randomNumberGenerator
	Random rng = new Random(); // Random number generator
	int STOP = 100;  // When length < EPSILON, draw a line segment

    public static void main(String[] args){
        Fractal3 f = new Fractal3();
    }

    public Fractal3Chris(){
        f.add(this); // Add JPanel to JFrame
        f.setSize(1500, 1000);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure that program terminates when window is closed
        f.setVisible(true); // Call paintComponent() first time
		for (long i = 0; i < 1000000000; i++); // Delay before rerunning with new STOP value
		STOP = 10; // Go deeper with recursion
		f.repaint();  // Call paintComponent() again to rerun
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D drawingArea = (Graphics2D) g;
        drawingArea.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
		drawingArea.fill(new Ellipse2D.Double(-5, height/2-5, 10, 10));
		drawingArea.fill(new Ellipse2D.Double(width-5, height/2-5, 10, 10));
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
			rng.setSeed((long) (midX << randomGeneratorSeed)); // Seed random number generator based on x-pixel (useful for homework)
			delta = (int)((rng.nextDouble() - 0.5) * (rightX - leftX));
			midY += delta;
			drawingArea.setPaint(Color.BLACK);
			drawingArea.fill(new Ellipse2D.Double(midX-5, midY-5, 10, 10));
			randomFractal(leftX, leftY, midX,   midY,   drawingArea);
			randomFractal(midX,  midY,  rightX, rightY, drawingArea);
		}
	}
}