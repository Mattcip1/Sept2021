package JUnitText;

public class Calculator {

	public Integer add(Integer a, Integer b) {
		if (a != null & b != null) {
			return a + b;
		}
		return null;
	}

	public Integer sub(Integer a, Integer b) {
		if (a != null & b != null) {
			return a - b;
		}
		return null;
	}
}