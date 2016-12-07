

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SkyLineTest {

	ArrayList<Building> in = new ArrayList<Building>();
	ArrayList<Double> ret;
	ArrayList<Double> expected = new ArrayList<Double>();
	Double[] answer;
	
	@Test
	public void testLength1() {
		Building b1 = new Building(1.0, 2.0, 2.0);
		Building b2 = new Building(3.0, 7.0, 1.0);
		Building b3 = new Building(4.0, 6.0, 2.0);
		Building b4 = new Building(1.0, 5.5, 3.2);
		in.add(b1);
		in.add(b2);
		in.add(b3);
		ret = SkyLine.skyLine(in);
		assertTrue(ret.size() % 2 != 0);
	}
	
	@Test
	public void testNormal() {
		Building b1 = new Building(1.0, 2.0, 2.0);
		Building b2 = new Building(3.0, 1.0, 7.0);
		Building b3 = new Building(4.0, 2.0, 6.0);
		in.add(b1);
		in.add(b2);
		in.add(b3);
		ret = SkyLine.skyLine(in);
		answer = new Double[] {1.0, 2.0, 2.0, 0.0, 3.0, 1.0, 4.0, 2.0, 6.0, 1.0, 7.0};
		expected.addAll(Arrays.asList(answer));
		assertEquals(expected, ret);
	}
	
	@Test
	public void testEdges() {
		Building b1 = new Building(3.0, 1.0, 4.0);
		Building b2 = new Building(4.0, 2.0, 6.0);
		Building b3 = new Building(6.0, 1.0, 7.0);
		in.add(b1);
		in.add(b2);
		in.add(b3);
		ret = SkyLine.skyLine(in);
		answer = new Double[] {3.0, 1.0, 4.0, 2.0, 6.0, 1.0, 7.0};
		expected.addAll(Arrays.asList(answer));
		assertEquals(expected, ret);
	}

	@Test
	public void testNegative() {
		Building b1 = new Building(-3.2, 7.7, 11.2);
		Building b2 = new Building(-2.1, 2.2, -1.1);
		Building b3 = new Building (3.6, 4.4, 12.0);
		in.add(b1);
		in.add(b2);
		in.add(b3);
		ret = SkyLine.skyLine(in);
		answer = new Double[] {-3.2, 7.7, 11.2, 4.4, 12.0};
		expected.addAll(Arrays.asList(answer));
		assertEquals(expected, ret);
	}
}
