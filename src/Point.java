
public class Point implements Comparable<Point>{
	
	double x;
	double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double distance(Point two) {
		return Math.sqrt(
				Math.pow((this.x - two.x), 2) +
				Math.pow((this.y - two.y), 2));
	}
	
	public int compareTo(Point o) {
		if(this.x > o.x) {
			return 1;
		} else if (this.x == o.x) {
			return 0;
		} else {
			return -1;
		}
	}
	
	public void print() {
		System.out.println("(" + this.x + ", " + this.y + ")");
	}
}
