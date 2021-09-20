/**
 * 
 */
package JavaBasicWk1Cap;

/**
 * This class represents the operations performed for Assignment 2 part 1.
 * 
 * @author mattb
 *
 */
public class Math {

	public boolean checker(PerformOperation p, int in) {
		return p.check(in);
	}

	public PerformOperation isOdd() {
		return in -> ((in & 1) == 1);
	}

	public PerformOperation isPrime() {
		return in -> {
			if (in < 2) {
				return false;
			} else {
				for (int i = 2; i <= in / 2; i++)
					if (in % i == 0)
						return false;
				return true;
			}
		};
	}

	public PerformOperation isPalindrome() {
		return in -> {
			String s1 = in + "";
			String s2 = new StringBuffer(s1).reverse().toString();
			return s1.equals(s2);
		};
	}
}
