

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SkyLineTest {

	ArrayList<Double> ret;
	ArrayList<Double> expected;
	
	@Test
	public void testLength1() {
		Building b1 = new Building(1.0, 2.0, 2.0);
		Building b2 = new Building(3.0, 7.0, 1.0);
		Building b3 = new Building(4.0, 6.0, 2.0);
		ArrayList<Building> in = new ArrayList<Building>();
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
		ArrayList<Building> in = new ArrayList<Building>();
		in.add(b1);
		in.add(b2);
		in.add(b3);
		
		ret = SkyLine.skyLine(in);
		expected = new ArrayList<Double>();
		
		Double[] answer = new Double[] {1.0, 2.0, 2.0, 0.0, 3.0, 1.0, 4.0, 2.0, 6.0, 1.0, 7.0};
		expected.addAll(Arrays.asList(answer));
		assertEquals(expected, ret);
	}

}
