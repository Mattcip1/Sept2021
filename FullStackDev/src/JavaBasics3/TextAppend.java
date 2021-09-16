/**
 * 
 */
package JavaBasics3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class appends text to the end of a given file.
 * @author mattb
 *
 */
public class TextAppend {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the file path you would like to append:");
		String path = scanner.nextLine();
		
		try(FileWriter fwriter = new FileWriter(path, true);
			BufferedWriter bwriter = new BufferedWriter(fwriter);
			PrintWriter pwriter = new PrintWriter(bwriter);) {
			
			System.out.println("Enter the text you want to append:");
			String in = scanner.nextLine();
			pwriter.println(in);
		}
		catch(IOException e) {
			e.printStackTrace();
			scanner.close();
		}
		scanner.close();
	}
}
