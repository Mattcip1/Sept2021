/**
 * 
 */
package JavaBasicWk1Cap;

/**
 * This class sums the given array of ints to the target, adding ints that are
 * clumped together.
 * 
 * @author mattb
 *
 */
public class Recursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Recursion rec = new Recursion();
		Integer[] test1 = {2,4,8};
		Integer[] test2 = {1,2,4,8,1};
		Integer[] test3 = {2,4,4,8};
		Integer[] test4 = {1,2,1,1,6};
		
		System.out.println(rec.groupSumClump(0, test1, 10));
		System.out.println(rec.groupSumClump(0, test2, 14));
		System.out.println(rec.groupSumClump(0, test3, 14));
		System.out.println(rec.groupSumClump(1, test4, 8));
		System.out.println(rec.groupSumClump(0, test4, 0));
	}

	public boolean groupSumClump(Integer start, Integer[] ints, Integer target) {
		if(start == null || ints == null || target == null)
			throw new NullPointerException();
		if (start >= ints.length)
			return target == 0;
		if (start < ints.length - 1 && ints[start] == ints[start + 1]) {
			return groupSumClump(start + 2, ints, target);
		}
		if (groupSumClump(start + 1, ints, target - ints[start]))
			return true;
		if (groupSumClump(start + 1, ints, target))
			return true;
		return false;
	}
}
