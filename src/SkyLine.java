import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;


public class SkyLine {

	/**
	 * Get all the vertical Edges from the list of Buildings
	 * @param input, a list of Buildings
	 * @return an arrayList of Edges sorted according to the x coordinates in an ascending order
	 */
	public static ArrayList<Edge> getEdges(ArrayList<Building> input) {
		ArrayList<Edge> ret = new ArrayList<Edge>();
		for(Building b : input) {
			ret.add(new Edge(b.x1, b.y, true)); // left edge
			ret.add(new Edge(b.x2, b.y, false)); // right edge
		}
		Collections.sort(ret); // sort the list
		return ret;
	}
	
	/**
	 * A method that returns the skyline from the list of Buildings
	 * @param input, an arrayList of Buildings
	 * @return an arrayList of doubles which is an
	 * 			a) an odd-length list of real numbers
	 * 				(x1, y1, x2, y2, ..., xn-1, yn-1, xn)
	 * 			b) such that the skyline can be constructed by going from
	 * 				(x1,0), (x1, y1), (x2, y1), (x2, y2), (x3, y2), ... (xn-1, yn-1), (xn, yn-1), (xn, 0)
	 */
	public static ArrayList<Double> skyLine(ArrayList<Building> input) {
		ArrayList<Edge> edges = getEdges(input); // list sorted according to the x coordinates
		ArrayList<Double> ret = new ArrayList<Double>();
		PriorityQueue<Double> q = new PriorityQueue<Double>();
	
		// iterate over all the edges
		for(Edge currentEdge : edges) {
			// the current edge is the left edge
			if(currentEdge.isLeft) { // going right
				// either the edge occurs independently of other buildings
				// or the edge is higher than an already encountered left edge
				if (q.isEmpty() || currentEdge.y > q.peek()) {
					// add the x coordinate and the y coordinate
					ret.add(currentEdge.x);
					ret.add(currentEdge.y);
				}
				// add the height of the edge to be compared later
				q.add(currentEdge.y);
			} else { // coming down
				// the current edge is the right edge
				// remove the the info about the "left edge"
				q.remove(currentEdge.y);
				if(q.isEmpty()) {
					// coming down to 0 since we covered the building
					ret.add(currentEdge.x);
					ret.add(0.0);
				} else if (currentEdge.y > q.peek()) {
					// coming down to another building
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
