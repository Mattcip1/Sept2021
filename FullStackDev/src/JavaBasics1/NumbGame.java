/**
 * 
 */
package JavaBasics1;

import java.util.*;

/**
 * This class is a random number game where the system chooses a random number and the user
 * must try to guess within a range, given a number of attempts.
 * @author mattb
 *
 */
public class NumbGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  
		  final int MAX = 100;
		  final int MIN = 1;
		  Random rand = new Random();
		  int randNum  = MIN + rand.nextInt(MAX);
		
		  int tries = 4;
		  
		  Scanner guesser = new Scanner(System.in);
		  System.out.println("Guess a # between 1 - 100:");
		  String guessS = guesser.nextLine();
		  int guess = Integer.parseInt(guessS);
		  
		  
		  while(tries > 0) {
			  for(int i = guess - 10; i <= guess + 10; i++) {
				  if(i == randNum) {
					  System.out.println("Your guess was within Range! The Random Number was: " + randNum);
					  return;
				  }
			  }
				  
				  tries--;
				  System.out.println("Try another guess:");
				  guessS = guesser.nextLine();
				  guess = Integer.parseInt(guessS);
		}
		  if(tries == 0)
			  System.out.println("Sorry, the answer was: " + randNum);
	}
}
