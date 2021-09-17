package JUnitText;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class CalculatorTest {
	
	Calculator calc = new Calculator();
	
	@Test
	public void addNullTest() {
		assertNull(calc.add(10, null));
		assertNull(calc.add(null, 10));
	}
	
	@Test
	public void subNullTest() {
		assertNull(calc.sub(10, null));
		assertNull(calc.sub(null, 10));
	}
	
	@Test
	public void addNegTest() {
		assertNotEquals(new Integer(30), calc.add(10, 10));
		assertNotEquals(new Integer(10), calc.add(10, 10));
	}
	
	@Test
	public void subNegTest() {
		assertNotEquals(new Integer(30), calc.sub(10, 10));
		assertNotEquals(new Integer(10), calc.sub(10, 10));
	}
	
	@Test
	public void addTest() {
		assertEquals(new Integer(20), calc.add(10, 10));
	}
	
	@Test
	public void subTest() {
		assertEquals(new Integer(0), calc.sub(10, 10));
	}

}