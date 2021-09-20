/**
 * 
 */
package JavaBasicWk1Cap;

import java.util.Arrays;
import java.util.List;

/**
 * This class implements the 3 functional interfaces from Assignment 2
 * 
 * @author mattb
 *
 */
public class FunctImp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		RightMost test1 = (list1) -> {
			list1.replaceAll(num -> num % 10);
			return list1;
		};
		List<Integer> nums1 = Arrays.asList(44, 937, 9, 10, 0, 44447);
		for (Integer in : nums1)
			System.out.print(in + " ");
		test1.rightDigit(nums1);
		System.out.println("");
		for (Integer in : nums1)
			System.out.print(in + " ");

		Multiply test2 = (list2) -> {
			list2.replaceAll(num -> num * 2);
			return list2;
		};
		System.out.println("");
		List<Integer> nums2 = Arrays.asList(44, 937, 9, 10, 0, 44447);
		for (Integer in : nums2)
			System.out.print(in + " ");
		test2.multiply(nums2);
		System.out.println("");
		for (Integer in : nums2)
			System.out.print(in + " ");

		RemoveX test3 = (list3) -> {
			list3.replaceAll(s -> s.replace("x", ""));
			return list3;
		};
		System.out.println("");
		List<String> strings1 = Arrays.asList("xxx", " ", "Apple", "wxy", "Zebra", "SevXen", "sevxen");
		for (String s : strings1)
			System.out.print(s + " ");
		test3.removeX(strings1);
		System.out.println("");
		for (String s : strings1)
			System.out.print(s + " ");
	}
}
