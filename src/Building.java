
public class Building {
	
	double x1;
	double x2;
	double y;
	
	/**
	 * Constructor for a Building object
	 * @param x1, left abscissa of the rectangle
	 * @param y, height of the rectangle
	 * @param x2, right abscissa of the rectangle
	 * Note that x1 > x2, and y > 0
	 */
	public Building(double x1, double y, double x2) {
		if(x1 < x2) {
			this.x1 = x2;
			this.x2 = x1;
		} else if (x1 > x2){
			this.x1 = x1;
			this.x2 = x2;
		} else {
			throw new IllegalArgumentException("The Building must have a width");
		}
		if (y <= 0) {
			throw new IllegalArgumentException("The Buildingm must have a height");
		} else {
			this.y = y;
		}
	}
	
}
