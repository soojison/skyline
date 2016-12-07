import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;


public class SkyLine {

	public static ArrayList<Edge> getPoints(ArrayList<Building> input) {
		ArrayList<Edge> ret = new ArrayList<Edge>();
		for(Building b : input) {
			ret.add(new Edge(b.x1, b.y, true));
			ret.add(new Edge(b.x2, b.y, false));
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
		ArrayList<Edge> edges = getPoints(input); // needs to be sorted according to x coordinates
		Collections.sort(edges);
		ArrayList<Double> ret = new ArrayList<Double>();

		PriorityQueue<Double> q = new PriorityQueue<Double>();

		
		for(Edge currentEdge : edges) {
			if(currentEdge.isLeft) {
				if (q.isEmpty() || currentEdge.y > q.peek()) {
					ret.add(currentEdge.x);
					ret.add(currentEdge.y);
				}
				q.add(currentEdge.y);
			} else {
				q.remove(currentEdge.y);
				if(q.isEmpty()) {
					ret.add(currentEdge.x);
					ret.add(0.0);
				} else if (currentEdge.y > q.peek()) {
					ret.add(currentEdge.x);
					ret.add(q.peek());
				}
			}
		}
		ret.remove(ret.size()-1); // because the last edge will add 0.0 to the list
		return ret;
	}
	
	public static void printAList(ArrayList<Double> l) {
		for(double d : l) {
			System.out.println(d);
		}
	}
	
}
