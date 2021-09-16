/**
 * 
 */
package JavaBasics3;

import java.io.File;
import java.util.Scanner;

/**
 * This class lists all the file and directory names under a given directory path.
 * @author mattb
 *
 */
public class ListDirectory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File path;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the path that you want printed:");
		String in = scanner.nextLine();
		
		try {
			path = new File(in);
		}
		catch(Exception e) {
			System.out.println("The given path does not exist.");
			return;
		}
		if(path.isDirectory()) {
			for(File f: path.listFiles())
				System.out.println(f);
		}
	}
}
