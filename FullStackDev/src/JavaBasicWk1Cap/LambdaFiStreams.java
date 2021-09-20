/**
 * 
 */
package JavaBasicWk1Cap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is for Assignment 1 part 1.
 * 
 * @author mattb
 *
 */
public class LambdaFiStreams {

	private static Integer[] ints = { 11, 8, 79, 134, 76, 97 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 1
		String[] list = { "Bob", "Kevin", "Wednesday", "yy", "four" };

		Arrays.sort(list, (s1, s2) -> s1.length() - s2.length());
		System.out.println("Sorting by length:");
		for (String s : list)
			System.out.println(s);

		Arrays.sort(list, (s1, s2) -> s2.length() - s1.length());
		System.out.println("Sorting by length in reverse:");
		for (String s : list)
			System.out.println(s);

		Arrays.sort(list, (s1, s2) -> s1.toUpperCase().charAt(0) - s2.toUpperCase().charAt(0));
		System.out.println("Sorting alphabetically:");
		for (String s : list)
			System.out.println(s);

		Arrays.sort(list, (s1, s2) -> {
			if (s1.contains("e") && s2.contains("e")) {
				return s1.compareTo(s2);
			} else if (s1.contains("e")) {
				return (s1.length() * -1);
			} else if (s2.contains("e")) {
				return s2.length();
			} else
				return 0;
		});
		System.out.println("Sorting by e:");
		for (String s : list)
			System.out.println(s);

		Arrays.sort(list, (s1, s2) -> LambdaFiStreams.lSort(s1, s2)); // helper
		System.out.println("Sorting by length with Helper:");
		for (String s : list)
			System.out.println(s);

		Arrays.sort(list, (s1, s2) -> LambdaFiStreams.rSort(s1, s2)); // helper
		System.out.println("Sorting by length in reverse with Helper:");
		for (String s : list)
			System.out.println(s);

		Arrays.sort(list, (s1, s2) -> LambdaFiStreams.aSort(s1, s2)); // helper
		System.out.println("Sorting alphabetically with Helper:");
		for (String s : list)
			System.out.println(s);

		Arrays.sort(list, (s1, s2) -> LambdaFiStreams.eSort(s1, s2)); // helper
		System.out.println("Sorting by e with Helper:");
		for (String s : list)
			System.out.println(s);

		// 2
		CommaInt CString = (list2) -> {
			String result = "";
			for (Integer in : list2) {
				if (in % 2 == 0) {
					result = result + "e" + in + ",";
				} else {
					result = result + "o" + in + ",";
				}
			}
			return result.substring(0, result.length() - 1);
		};
		System.out.println(CString.comma(ints));

		// 3
		List<String> list3 = Arrays.asList("apple", "Apple", "Bread", "yy", "Ape", "ape", "Kevin", "aaa", "aa", "and",
				"Done");
		List<String> list3a = list3.stream().filter(s -> s.startsWith("a") && s.length() == 3)
				.collect(Collectors.toList());
		list3a.forEach((s) -> System.out.println(s));
	}

	protected static Integer lSort(String s1, String s2) {
		return s1.length() - s2.length();
	}

	protected static Integer rSort(String s1, String s2) {
		try {
			return s2.length() - s1.length();
		} catch(NullPointerException e) {
			return null;
		}
	}

	protected static Integer aSort(String s1, String s2) {
		return s1.toUpperCase().charAt(0) - s2.toUpperCase().charAt(0);
	}

	protected static Integer eSort(String s1, String s2) {
		if (s1.contains("e") && s2.contains("e")) {
			return s1.compareTo(s2);
		} else if (s1.contains("e")) {
			return (s1.length() * -1);
		} else if (s2.contains("e")) {
			return s2.length();
		} else
			return 0;
	}
}
