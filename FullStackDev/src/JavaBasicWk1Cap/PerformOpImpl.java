/**
 * 
 */
package JavaBasicWk1Cap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class is for Assignment 2 part 1.
 * 
 * @author mattb
 *
 */
public class PerformOpImpl {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Math test = new Math();
		PerformOperation op;
		Boolean bool = false;
		FileReader fr = new FileReader("C:\\Users\\mattb\\git\\Sept2021\\FullStackDev\\src\\JavaBasicWk1Cap\\test");
		BufferedReader br = new BufferedReader(fr);
		Integer cases = Integer.parseInt(br.readLine());
		String[] splits = new String[2];
		Integer[] values = new Integer[2];

		while (cases > 0) {
			splits = br.readLine().split(" ");
			for (int i = 0; i < splits.length; i++)
				values[i] = Integer.parseInt(splits[i]);
			if (values[0] == 1) {
				op = test.isOdd();
				bool = test.checker(op, values[1]);
				if(bool == true) {
					System.out.println("ODD");
				} else {
					System.out.println("EVEN");
				}
			} else if (values[0] == 2) {
				op = test.isPrime();
				bool = test.checker(op, values[1]);
				if(bool == true) {
					System.out.println("PRIME");
				} else {
					System.out.println("COMPOSITE");
				}
			} else if (values[0] == 3) {
				op = test.isPalindrome();
				bool = test.checker(op, values[1]);
				if(bool == true) {
					System.out.println("PALINDROME");
				} else {
					System.out.println("NOTPALINDROME");
				}
			}
			cases--;
		}
		br.close();
	}
}
