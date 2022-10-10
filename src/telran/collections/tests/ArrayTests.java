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
	/**
	 * The method doesn't update a given array
	 * @param <T>
	 * @param array
	 * @return true if there is exactly one swap for getting sorted array
	 * examples: {1, 2, 3, 10, -1, 5, 6} -> false
	 * {1, 2, 3, 5, 6, 10} -> false
	 * {1,3,2,4, 3, 10} -> false
	 * {10, 2, 3, 4, 1} -> true
	 * {1, 2, 4, 3, 5, 10} -> true
	 * {1, 5, 3, 4, 2, 10} -> true
	 * {"lmn", "ab", "bc", "cd", "a"} -> true
	 * An Array should contain Comparable elements
	 */
	<T> boolean isOneSwapForSorted(T [] array) {
		if(array.length < 2) {
			return false;
		}
	    int indexOfNextElAfterFirst = 0, indexOfSecondEl = 0, numElOutOfOrder = 0;
	    for (int i = 1; i < array.length; i++) {
	        if (compare(array[i], array[i - 1]) < 0) {
	            numElOutOfOrder++;
	            if (indexOfNextElAfterFirst == 0) {
	                indexOfNextElAfterFirst = i;
	            } else {
	            	indexOfSecondEl = i;
	            }  
	        }
	    }
	    if (numElOutOfOrder == 0 || numElOutOfOrder > 2) {
	        return false;
	    }	   
	    return isSorted(array, indexOfNextElAfterFirst - 1, indexOfSecondEl, numElOutOfOrder);
	}
	private <T> boolean isSorted(T[] array, int indexOfFirstEl, int indexOfSecondEl, int numElOutOfOrder) {
		T[] helper = Arrays.copyOf(array, array.length);
	    if (numElOutOfOrder == 2) {
	    	helper = swap(helper, indexOfFirstEl, indexOfSecondEl);
	    } else {
	    	helper = swap(helper, indexOfFirstEl, indexOfFirstEl + 1);
	    }
	    for (int i = 1; i < helper.length; i++) {
	    	if (compare(helper[i], helper[i - 1]) < 0) {
	            return false;
	    	}
	    } 
		return true;
	}		
	private <T> T[] swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	    return array;
	}
	@SuppressWarnings("unchecked")
	private <T> int compare(T el1, T el2) {
		return ((Comparable<T>) el1).compareTo(el2);
	}
	
	@Test
	void isOneSwapTest() {		
		Integer arTrue1[] = {1, 6, 3, 4, 2, 10};
		Integer arTrue2[] = {1, 2, 4, 3, 6, 10};
		Integer arTrue3[] = {10, 2, 3, 4, 6, 1};
		Integer arTrue4[] = {3, 2, 3, 4, 6, 10};
		Integer arTrue5[] = {1, 2, 3, 4, 6, 10, 7};
		String[] arTrue6 = {"lmn", "ab", "bc", "cd", "a"};
		Integer arFalse1[] = {1, 10, 2, 3, 6, 4};
		Integer arFalse2[] = {1, 2, 4, 2, 10, 6};
		Integer arFalse3[] = {1, 2, 3, 4, 6, 10};
		
		assertTrue(isOneSwapForSorted(arTrue1));
		assertTrue(isOneSwapForSorted(arTrue2));
		assertTrue(isOneSwapForSorted(arTrue3));
		assertTrue(isOneSwapForSorted(arTrue4));
		assertTrue(isOneSwapForSorted(arTrue5));
		assertTrue(isOneSwapForSorted(arTrue6));
		assertFalse(isOneSwapForSorted(arFalse1));
		assertFalse(isOneSwapForSorted(arFalse2));
		assertFalse(isOneSwapForSorted(arFalse3));
				
		assertFalse(isOneSwapForSorted(new Integer[]{1}));
		assertFalse(isOneSwapForSorted(new Integer[]{1, 1, 1, 1, 1, 1}));
		assertFalse(isOneSwapForSorted(new String[]{"a", "ab", "bc", "cd", "lmn"}));
		assertFalse(isOneSwapForSorted(new String[]{"lmn", "ab", "cd", "bc", "a"}));
		assertFalse(isOneSwapForSorted(new String[]{"ab", "ab", "ab", "ab", "ab"}));
		assertTrue(isOneSwapForSorted(new String[]{"a", "ab", "cd", "bc", "lmn"}));
		
	}

}