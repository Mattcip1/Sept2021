package JavaBasicWk1Cap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LambdaTest {

	String s1 = "hello";
	String s2 = "World";
	String s3 = "Elephant";
	String s4 = "www";
	
	@Test
	void lSortTest() {
		assertNotNull(LambdaFiStreams.lSort(s1, s2));
	}
	
	@Test
	void rSortTest() {
		assertNull(LambdaFiStreams.rSort(null, null));
	}
	
	@Test
	void aSortTest() {
		assertNotNull(LambdaFiStreams.aSort(s3, s4));
	}
	
	@Test
	void eSortTest() {
		assertNotNull(LambdaFiStreams.eSort(s1, s4));
	}
}
