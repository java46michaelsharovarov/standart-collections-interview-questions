package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class ArrayTests {

	@Test
	void halfSum() {
		int arWithHalfSum[] = {40, -20, 50, 10, 20}; //sum = 100, 40 + 10 = 50
		int arWithHalfSum1[] = {25, -20, 50, 20, 25};
		int arWithNoHalfSum[] = {15, 15, 10, 5, 25, 30};
		int arWithNoHalfSum1[] = {40, -20, 50, 5, 25}; //sum = 100 , no two numbers with sum = 50
		int arWithNoHalfSum2[] = {20, 15, 15, 20, 5, 25};
		assertTrue(isHalfSumTwoNumbers(arWithHalfSum));
		assertFalse(isHalfSumTwoNumbers(arWithNoHalfSum));
		assertTrue(isHalfSumTwoNumbers(arWithHalfSum1));
		assertFalse(isHalfSumTwoNumbers(arWithNoHalfSum1));
		assertFalse(isHalfSumTwoNumbers(arWithNoHalfSum2));
	}
	/**
	 * 
	 * @param array with no limitations of the number values
	 * @return true if there are two numbers with sum equaled 
	 * half of total sum of a given array
	 */
	private boolean isHalfSumTwoNumbers(int[] array) {
		int halfSum = Arrays.stream(array).sum() / 2;
		HashSet<Integer> helper = new HashSet<>();
		for(Integer num : array) {
			if(helper.contains(halfSum - num)) {
				return true;
			}
			helper.add(num);
		}
		return false;
	}
	
	@Test
	void valueWithMaxNegativeTest() {
		int arWithNegative[] = {10, 20000000, 2, 4, 40, -4, 10, -20000000, -2};
		int arWithNoNegative[] = {10, 20, 2, 4, 40, -14, 10, -21, -3};
		assertEquals(20000000, valueWithMaxNegative(arWithNegative));
		assertEquals(-1, valueWithMaxNegative(arWithNoNegative));
	}
	/**
	 * 
	 * @param array with numbers that may have the huge values
	 * @return maximal value with existing negative image (negative value with same absolute value)
	 * if no value with its negative image the function returns -1
	 */
	private Integer valueWithMaxNegative(int[] array) {
		HashSet<Integer> helper = new HashSet<>();
		int res = -1;
		for(int num : array) {
			int absNum = Math.abs(num);
			if(helper.contains(-num) && absNum > res) {
				res = absNum;
			}
			helper.add(num);
		}	
		return res;
	}

}