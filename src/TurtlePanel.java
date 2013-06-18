import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class TurtlePanel extends JPanel {
	
	private Turtle turtle;
	
	/**
	 * Creates a TurtlePanel, an area where a turtle can draw a L-System.
	 * 
	 * @param width width of the panel
	 * @param height height of the panel
	 * @param turtle the turtle which will draw on the panel
	 */
	public TurtlePanel(int width, int height, Turtle turtle) {
		super();
		
		this.turtle = turtle;
		setPreferredSize(new Dimension(width, height));
	}
	
	/**
	 * Paints the component, sets up the drawing area for the turtle and then
	 * calls the turtle to execute the L-System program.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2D.setColor(Color.white);
		g2D.fillRect(0, 0, getWidth(), getHeight());
		
		g2D.setColor(Color.black);
		
		turtle.setGraphics2D(g2D);
		
		turtle.execute();
	}
}
