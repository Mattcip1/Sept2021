/**
 * 
 */
package JavaBasics2;

/**
 *This class takes multiple values from a Command Line Argument and adds them together,
 *printing the result
 * @author mattb
 *
 */
public class Assign1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer total = 0;
		
		for(String a: args) {
			try {
			total = total + Integer.parseInt(a);
			} catch(Exception e) {
				System.out.println(a + " is not an Integer, discarded");
			}
		}
		System.out.println("The sum of the Integers is: " + total);
	}

}
