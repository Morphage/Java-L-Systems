import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Main {
	
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 800;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	JFrame frame = new JFrame("Java L-Systems");
		    	
		    	LSystem system = new LSystem("sierpinski.txt");
		    	Turtle turtle = new Turtle(system.getTurtleInfo(), system);
		    	
		    	TurtlePanel turtlePanel = new TurtlePanel(WIDTH, HEIGHT, turtle);
		    	
		    	frame.setContentPane(turtlePanel);
		    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	frame.pack();
		    	frame.setVisible(true);
		    }
		});
	}
}
