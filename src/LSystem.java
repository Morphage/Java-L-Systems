import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class LSystem {
	
	private String axiom;
	
	private HashMap<String, String> rules;
	
	private double rotateAngle;
	
	private double distance;
	
	private TurtleInfo turtleInfo;
	
	private int iterations;
	
	private String currentRepresentation;
	
	/**
	 * Takes a L-System configuration file and creates an internal structure to hold
	 * all the parameters. This structure is used later on to generate the L-System,
	 * and by the turtle to initialize its position, its orientation, etc...
	 * 
	 * The configuration file has the following structure:
	 * The first line is the axiom, i.e. the starting point of the L-System.
	 * The second line is an integer n representing the number of production rules.
	 * The next n lines are the production rules of the L-System.
	 * The line after that is the angle to be used by the turtle during rotations.
	 * The line after that is the distance to be used by the turtle during move commands.
	 * The line after that is the turtle's initial x coordinate.
	 * The line after that is the turtle's initial y coordinate.
	 * The line after that is the turtle's initial orientation.
	 * The last line is the number of iterations to be performed on the L-System.
	 * 
	 * @param fileName the name of the L-systems configuration file
	 */
	public LSystem(String fileName) {
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}

		try {
			axiom = reader.readLine();
			
			int number = Integer.parseInt(reader.readLine());
			rules = new HashMap<String, String>();
			
			for (int i = 0; i < number; i++) {
				String line = reader.readLine();
				
				String lhs = "" + line.charAt(0);
				String rhs = line.substring(5);
				
				rules.put(lhs, rhs);
			}
			
			rotateAngle = Double.parseDouble(reader.readLine());
			
			distance = Double.parseDouble(reader.readLine());
			
			double x = Double.parseDouble(reader.readLine());
			double y = Double.parseDouble(reader.readLine());
			double a = Double.parseDouble(reader.readLine());
			
			turtleInfo = new TurtleInfo(x, y, a);
			
			iterations = Integer.parseInt(reader.readLine());
			
			currentRepresentation = axiom;
			
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	
	/**
	 * Uses the L-System's production rules to generate the next iteration from
	 * the current representation.
	 * 
	 * @return the generated L-System after one iteration of applying the production rules.
	 */
	public String rewrite() {
		String result = "";
		
		for (int i = 0; i < currentRepresentation.length(); i++) {
			String command = "" + currentRepresentation.charAt(i);
			result += rules.get(command);
		}
		
		currentRepresentation = result;
		
		return result;
	}
	
	/**
	 * Uses the L-System's production rules to generate the next n iterations
	 * from the current representation.
	 * 
	 * @param n the number of iterations
	 * @return the generated L-System after n iterations of applying the production rules.
	 */
	public String rewrite(int n) {
		String result = "";
		
		for (int i = 0; i < n; i++) {
			result = rewrite();
		}
		
		return result;
	}
	
	/**
	 * Gets the turtle's initial coordinates and orientation as specified by the
	 * L-System's configuration file.
	 * 
	 * @return the turtle's coordinates and orientation
	 */
	public TurtleInfo getTurtleInfo() {
		return turtleInfo;
	}
	
	/**
	 * Gets the number of iterations to apply on the production rules as specified
	 * by the L-System's configuration file.
	 * 
	 * @return number of iterations
	 */
	public int getIterations() {
		return iterations;
	}
	
	/**
	 * 
	 * @return the distance to move at each step.
	 */
	public double getDistance() {
		return distance;
	}
	
	/**
	 * 
	 * @return the angle to rotate by at every rotation.
	 */
	public double getRotateAngle() {
		return rotateAngle;
	}

}
