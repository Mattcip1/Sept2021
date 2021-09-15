/**
 * 
 */
package JavaBasics2;

/**
 * The purpose of this class is to find the max number in a given 2D array and show
 * its position in the array.
 * @author mattb
 *
 */
public class Assign2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] array = {{35, 7, -11}, {7, 400, 1}, {0, -112, 4}, {780, 299, 110}};
		int max = 0;
		int r = 0;
		int c = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				if(array[i][j] > max) {
					max = array[i][j];
					r = i + 1;
					c = j + 1;
				}
			}
		}
		System.out.println("The maximum value in the array is: " + max);
		System.out.println("the max is located in row - " + r + "    column - " + c);
	}

}
