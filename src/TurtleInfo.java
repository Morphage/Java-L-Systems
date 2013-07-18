
public class TurtleInfo implements Cloneable {
	private double x;
	private double y;
	private double angle;
	
	/**
	 * Creates an information holder object about the turtle's state. The information
	 * includes the turtle's position (x,y) and its orientation, given as an angle.
	 * 
	 * @param x the turtle's x coordinates
	 * @param y the turtle's y coordinates
	 * @param angle the turtle's orientation
	 */
	public TurtleInfo(double x, double y, double angle) {
		this.x = x;
		this.y = y;
		this.angle = angle;
	}
	
	/**
	 * 
	 * @return the turtle's orientation
	 */
	public double getAngle() {
		return angle;
	}
	
	/**
	 * 
	 * @param angle the new orientation of the turtle
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}

	/**
	 * 
	 * @return the turtle's y coordinate
	 */
	public double getY() {
		return y;
	}

	/**
	 * 
	 * @param y the new y coordinate for the turtle
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * 
	 * @return the turtle's x coordinate
	 */
	public double getX() {
		return x;
	}

	/**
	 * 
	 * @param x the new x coordinate for the turtle
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Clones the turtle information into a new object. This method
	 * is necessary for the bracketed L-Systems where a stack is
	 * needed to save the turtle's previous state.
	 * 
	 * @return a cloned object of the turtle information 
	 */
	public TurtleInfo clone() {
		Object o = null;
		
		try {
			o = super.clone();
		} catch(CloneNotSupportedException cnse) {
			cnse.printStackTrace(System.err);
		}

		return (TurtleInfo) o;
	}
	
}
