package JavaBasicWk1Cap;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Month;

import org.junit.jupiter.api.Test;

class DateTimeTest {

	@Test
	void monthLengthTest() {
		assertThrows(NullPointerException.class, () -> DateTime.monthLength(null));
	}

	@Test
	void monthMondayTest() {
		assertThrows(NullPointerException.class, () -> DateTime.monthMonday(null));
	}
	
	@Test
	void FridayTest() {
		assertThrows(NullPointerException.class, () -> DateTime.testFriday(null));
	}
}
