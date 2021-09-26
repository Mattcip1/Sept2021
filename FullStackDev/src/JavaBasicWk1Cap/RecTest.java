package JavaBasicWk1Cap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecTest {

	private static Integer[] ints = {2,4,4,8};
	private static Recursion test = new Recursion();
	
	@Test
	void groupSumTest() {
		assertNotNull(test.groupSumClump(0, ints, 9));
		assertThrows(NullPointerException.class, () -> test.groupSumClump(null, ints, 4));
	}

}
