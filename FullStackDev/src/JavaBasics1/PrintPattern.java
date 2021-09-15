/**
 * 
 */
package JavaBasics1;

/**
 * This class prints out 4 specific patterns using loops.
 * @author mattb
 *
 */
public class PrintPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int row = 0;
		
		System.out.println("1)");		//#1
		for(int i = 0; i < 4; i++) {
			row++;
			for(int j = 0; j < row; j++)
				System.out.print('*');
			System.out.print("\n");
		}
		for(int i = 0; i < 9; i++)
			System.out.print('.');
		
		System.out.println("\n2)");		//#2
		for(int i = 0; i < 10; i++)
			System.out.print('.');	
		System.out.println();
		for(int i = 0; i < 4; i++) {
			for(int j = row; j >= 1; j--)
				System.out.print('*');
			System.out.print("\n");
			row--;
		}
		
		System.out.println("3)");		//#3
        for (int i = 0; i < 5; i++) {
            for (int j = 6; j > i; j--)
                System.out.print(" ");
            for (int k = 1; k < (i*2); k++)
                System.out.print("*");
            System.out.println();
        }
		for(int i = 0; i < 11; i++)
			System.out.print('.');
        
		System.out.println("\n4)");		//#4
		for(int i = 0; i < 12; i++)
			System.out.print('.');
		System.out.println();
		for (int i = 4; i > 0; i--) {
            for (int j = 6; j > i; j--)
                System.out.print(" ");
            for (int k = 1; k < (i*2); k++)
                System.out.print("*");
            System.out.println();
        }
	}
}
