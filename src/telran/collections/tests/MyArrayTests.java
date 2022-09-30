package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.MyArray;

class MyArrayTests {

	MyArray<Integer> array;
	private static final int INITIAL_SIZE = 10;
	private static final int LARGE_INITIAL_SIZE = 30_000_000;	
	private static final int WRONG_INITIAL_SIZE = -1;
	private static final int VALUE_1 = 1;
	private static final int VALUE_2 = 2;
	private static final int VALUE_3 = 3;
	private static final int INDEX_0 = 0;
	private static final int INDEX_5 = 5;
	private static final int NEGATIVE_INDEX = -1;
	
	@BeforeEach
	void setUp() {
		array = new MyArray<>(INITIAL_SIZE);
	}
	
	@Test
	void testMyArray() {
		assertThrows(IllegalArgumentException.class, ()-> new MyArray<>(WRONG_INITIAL_SIZE));
		array = new MyArray<>(LARGE_INITIAL_SIZE);
		checkAfterSetAll(null);
	}

	@Test
	void testSetAll() {
		array.setAll(VALUE_1);
		checkAfterSetAll(VALUE_1);
		array.setAll(VALUE_3);
		checkAfterSetAll(VALUE_3);
		array.set(INDEX_0, VALUE_2);
		array.set(INDEX_5, VALUE_1);
		assertEquals(VALUE_2, array.get(INDEX_0));
		assertEquals(VALUE_1, array.get(INDEX_5));
		array.setAll(null);
		checkAfterSetAll(null);
		array.set(INDEX_0, VALUE_2);
		assertEquals(VALUE_2, array.get(INDEX_0));
		assertEquals(null, array.get(7));
	}
	private void checkAfterSetAll(Integer value) {
		for(int i = 0; i < array.getSize(); i++) {
			assertEquals(value, array.get(i));
		}
	}

	@Test
	void testGet() {
		assertNull(array.get(NEGATIVE_INDEX));
		assertNull(array.get(array.getSize()));
		array.set(INDEX_0, VALUE_2);
		assertEquals(VALUE_2, array.get(INDEX_0));
	}

	@Test
	void testSet() {
		assertThrows(IndexOutOfBoundsException.class, ()-> array.set(NEGATIVE_INDEX, VALUE_3));
		assertThrows(IndexOutOfBoundsException.class, ()-> array.set(array.getSize(), VALUE_3));
		array.set(array.getSize() - 1, VALUE_3);
		assertEquals(VALUE_3, array.get(array.getSize() - 1));
	}

}