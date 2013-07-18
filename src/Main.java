import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Main {
	
	/* The width and height of the drawing area. */
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 800;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	JFrame frame = new JFrame("Java L-Systems");
		    	
		    	/* Load up an L-System from a file. */
		    	LSystem system = new LSystem("tree.txt");
		    	
		    	/* Create a turtle and supply it with the L-System
		    	 * a starting position and orientation. 
		    	 */
		    	Turtle turtle = new Turtle(system.getTurtleInfo(), system);
		    	
		    	/* Create the canvas and supply the turtle which will be used to draw
		    	 * on the canvas.
		    	 */
		    	TurtlePanel turtlePanel = new TurtlePanel(WIDTH, HEIGHT, turtle);
		    	
		    	/* Set up frame and display it. */
		    	frame.setContentPane(turtlePanel);
		    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	frame.pack();
		    	frame.setVisible(true);
		    }
		});
	}
}
