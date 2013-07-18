import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.Stack;


public class Turtle {
	private TurtleInfo turtleInfo;
	
	private Graphics2D g2D;
	
	private String program;
	
	private Stack<TurtleInfo> turtleStack;
	
	private double distance;
	
	private double rotateAngle;
	
	/**
	 * Creates a turtle object able to execute and L-System and draw it on a
	 * 2D Graphics environment.
	 * 
	 * @param turtleInfo the original position and orientation of the turtle
	 */
	public Turtle(TurtleInfo turtleInfo, LSystem system) {
		this.turtleInfo = turtleInfo;
		
		/* Generate the commands to be executed by the Turtle
		 * and set up the parameters. 
		 */
		program = system.rewrite(system.getIterations());
		distance = system.getDistance();
		rotateAngle = system.getRotateAngle();
		
		turtleStack = new Stack<TurtleInfo>();
	}
	
	/**
	 * The turtle moves forward a certain distance while drawing a line
	 * on the drawing area.
	 * 
	 * @param distance the distance the turtle should move
	 */
	public void moveForward(double distance) {
		double oldX = turtleInfo.getX();
		double oldY = turtleInfo.getY();
		
		double radians = Math.toRadians(turtleInfo.getAngle());
		
		turtleInfo.setX(oldX + distance * Math.cos(radians));
		turtleInfo.setY(oldY + distance * Math.sin(radians));
		
		Shape line = new Line2D.Double(oldX, oldY, turtleInfo.getX(), turtleInfo.getY());
		g2D.draw(line);
	}
	
	/**
	 * The turtle rotates either left or right depending on the sign of the angle.
	 * 
	 * @param angle the angle the turtle should rotate by
	 */
	public void rotate(double angle) {
		turtleInfo.setAngle(turtleInfo.getAngle() - angle);
	}
	
	/**
	 * Sets up the 2D Graphics environment received by the Turtle Panel
	 * so that the turtle can draw.
	 * 
	 * @param g2D the 2D Graphics environment
	 */
	public void setGraphics2D(Graphics2D g2D) {
		this.g2D = g2D;
	}
	
	/**
	 * The turtle executes the program it was given by the L-System, carrying out all
	 * the commands until none are left.
	 */
	public void execute() {
		for (int i = 0; i < program.length(); i++) {
			char command = program.charAt(i);
			
			if (command == 'F' || command == 'G') {
				moveForward(distance);
			} else if (command == '+') {
				rotate(rotateAngle);
			} else if (command == '-') {
				rotate(-rotateAngle);
			} else if (command == '[') {
				turtleStack.push(turtleInfo.clone());
			} else if (command == ']') {
				turtleInfo = turtleStack.pop();
			}
		}
	}
	
}
