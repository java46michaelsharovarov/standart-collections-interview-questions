package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeSetTests {
	
	Integer numbers[] = {40, -10, 20, 30, 80, 45};
	TreeSet<Integer> tree;
	
	@BeforeEach
	void setUp() {
		tree = new TreeSet<>(Arrays.asList(numbers));
	}
	
	@Test
	void removeRangeTest() {
		Integer[] expected = {-10, 40, 45, 80};
//		tree.removeIf(n -> n >= 20 && n <= 30);
		tree.subSet(20, true, 30, true).clear();;
		assertArrayEquals(expected, tree.toArray(Integer[]::new));
	}

}
