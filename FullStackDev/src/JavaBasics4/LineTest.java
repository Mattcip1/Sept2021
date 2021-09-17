package JavaBasics4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LineTest {
	
	Line test1 = new Line(.0001, 1, 2, 3);
	Line test2 = new Line(0, 0, 0, 0);
	Line test3 = new Line(-4, -9, 2, 27);
	Line test4 = null;
	
	@Test
	void slopeTest() {
		assertNotNull(test1.getSlope());
		assertThrows(ArithmeticException.class, () -> test2.getSlope());
		assertNotNull(test3.getSlope());
		assertThrows(NullPointerException.class, () -> test4.getSlope());
	}

	@Test
	void DistanceTest() {
		assertNotNull(test1.getDistance());
		assertNotNull(test2.getDistance());
		assertNotNull(test3.getDistance());
		assertThrows(NullPointerException.class, () -> test4.getDistance());
	}
	
	@Test
	void ParallelTest() {
		assertThrows(ArithmeticException.class, () -> test1.parallelTo(test2));
		assertFalse(test1.parallelTo(test3));
		assertTrue(test3.parallelTo(test3));
		assertThrows(NullPointerException.class, () -> test4.parallelTo(test1));
	}
}
