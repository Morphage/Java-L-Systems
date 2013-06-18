
public class TurtleInfo implements Cloneable {
	private double x;
	private double y;
	private double angle;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param angle
	 */
	public TurtleInfo(double x, double y, double angle) {
		this.x = x;
		this.y = y;
		this.angle = angle;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getAngle() {
		return angle;
	}
	
	/**
	 * 
	 * @param angle
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}

	/**
	 * 
	 * @return
	 */
	public double getY() {
		return y;
	}

	/**
	 * 
	 * @param y
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * 
	 * @return
	 */
	public double getX() {
		return x;
	}

	/**
	 * 
	 * @param x
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * 
	 * @return 
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
