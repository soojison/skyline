
public class Edge implements Comparable<Edge>{
	
	double x;
	double y;
	boolean isLeft;
	
	/**
	 * Constructor for an Edge object
	 * @param x, the x coordinate for the edge
	 * @param y, the y coordinate for the edge
	 * @param b, boolean to check whether the edge is the left edge of the building
	 */
	public Edge(double x, double y, boolean b) {
		this.x = x;
		this.y = y;
		this.isLeft = b;
	}

	/**
	 * Comparison method to be used for sorting the edges
	 * @param o, the other edge to be compared
	 */
	public int compareTo(Edge o) {
		if(this.x != o.x) {
			return (int) (this.x - o.x);
		} else if (this.isLeft && o.isLeft) {
			return (int) (o.y - this.y);
		} else if (!this.isLeft && !o.isLeft) {
			return (int) (this.y - o.y);
		} else {
			if(this.isLeft) {
				return -1;
			} else {
				return 1;
			}
		}
	}
	
	/**
	 * Print method for debugging purposes
	 */
	public void print() {
		System.out.println("(" + this.x + ", " + this.y + ")");
	}
}
