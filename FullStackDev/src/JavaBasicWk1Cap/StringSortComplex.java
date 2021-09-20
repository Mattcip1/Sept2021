/**
 * 
 */
package JavaBasicWk1Cap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class sorts an Array of strings by a given method.
 * @author mattb
 *
 */
public class StringSortComplex {

	private List<String> list = Arrays.asList("Bob", "Kevin", "Wednesday", "yy", "four");
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StringSortComplex sorter = new StringSortComplex();
		
		System.out.println("Sorting by length:");
		sorter.lengthSort();
		System.out.println("Sorting by length in reverse:");
		sorter.rLengthSort();
		System.out.println("Sorting alphabetically:");
		sorter.alphSort();
		System.out.println("Sorting by E:");
		sorter.eSort();
		
	}
	
	public void lengthSort() {
	    Comparator<String> comp = (stringa, stringb ) -> stringa.length() - stringb.length();
	    
	    list.stream().sorted(comp).forEach(System.out::println);
	}
	
	public void rLengthSort() {
	    Comparator<String> comp = (stringa, stringb ) -> stringb.length() - stringa.length();
	    
	    list.stream().sorted(comp).forEach(System.out::println);
	}
	
	public void alphSort() {  
	    Comparator<String> comp = (stringa, stringb ) -> stringa.charAt(0) - stringb.charAt(0);
		
		List<String> slist = list.stream().map(String::toUpperCase).collect(Collectors.toList());
		slist.stream().sorted(comp).forEach((string) -> System.out.println(string));
	}
	
	public void eSort() {
		
	}
}
