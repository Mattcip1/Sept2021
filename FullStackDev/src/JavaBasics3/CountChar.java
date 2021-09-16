/**
 * 
 */
package JavaBasics3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * This Class counts the number of times a specific character appears in a given file.
 * @author mattb
 *
 */
public class CountChar {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner scanner = new Scanner(System.in);
		
		int count = 0;
		String line;
		
		System.out.println("Enter the file you want to search:");
		String in = scanner.nextLine();
		
		File path = new File(in);
		
		System.out.println("Enter the character you want to count:");
		char c = scanner.nextLine().charAt(0);
		
		try { 
			FileReader freader = new FileReader(path);
			BufferedReader breader = new BufferedReader(freader);
			
			line = breader.readLine();
			if(line == null) {
				System.out.println("This file is empty.");
				return;
			}
			
			while(line != null) {
				for(char ch: line.toCharArray()) {
					if(c == ch)
						count++;
				}
				line = breader.readLine();
			}
		System.out.println("The total number of " + c + "'s in this file is: " + count);
		} catch (FileNotFoundException e) {
			System.out.println("The specified file does not exist.");
		}
	}
}

