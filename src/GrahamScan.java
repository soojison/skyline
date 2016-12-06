import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;


public class GrahamScan {

	public static ArrayList<Point> getPoints(ArrayList<Building> input) {
		ArrayList<Point> ret = new ArrayList<Point>();
		for(Building b : input) {
			ret.add(new Point(b.x1, b.y));
			ret.add(new Point(b.x2, b.y));
		}
		return ret;
	}
	
	/*
	 * Sort the points
	 * scan the points from left to right
	 * when we encounter a left edge of a rectangle add it to a data structure
	 * if the point in the same height is there, take the point out = this is one edge
	 * if the point of the same height does not exist, then the edge = current point x
	 * 
	 */
	public static ArrayList<Double> skyLine(ArrayList<Building> input) {
		ArrayList<Point> points = getPoints(input); // needs to be sorted according to x coordinates
		Collections.sort(points);
		ArrayList<Double> ret = new ArrayList<Double>();
		/*
		for(Point p: points) {
			p.print();
		}
		*/
		PriorityQueue<Point> q = new PriorityQueue<Point>();
		
		for(Point p : points) {
			if(q.isEmpty()) {
				q.add(p);
			} else {
				if(q.peek().y == p.y) {
					Point prev = q.poll();
					ret.add(prev.x);
					ret.add(p.x);
					ret.add(p.y);
				} else {
					ret.add(q.poll().x);
					ret.add(p.x - q.poll().x); // also need to get rid of the one that we've already seen
					ret.add(p.y - q.poll().y);
				}
			}
		}
		
		return ret;
	}
	
	public static void printAList(ArrayList<Double> l) {
		for(double d : l) {
			System.out.println(d);
		}
	}
	
	public static void main(String[] args) {
		Building b1 = new Building(1.0, 2.0, 2.0);
		Building b2 = new Building(3.0, 5.0, 1.0);
		Building b3 = new Building(4.0, 6.0, 2.0);
		ArrayList<Building> in = new ArrayList<Building>();
		in.add(b1);
		in.add(b2);
		in.add(b3);
		printAList(skyLine(in));
	}
}
