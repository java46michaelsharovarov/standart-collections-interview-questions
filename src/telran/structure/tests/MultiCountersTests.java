package telran.structure.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.structure.MultiCounters;
import telran.structure.MultiCountersImpl;

abstract class MultiCountersTests {
	
	MultiCounters multiCounters;
	abstract MultiCounters creatMultiCounters();
	
	@BeforeEach
	void setUp() {
		multiCounters = creatMultiCounters();
		Object[] array = {null, "A", "B", "B", "C", "C", "D", "D", "D", "E", "E", "E", "F", "F", "F", "F"};
		Arrays.stream(array).forEach(multiCounters::addItem);
	}
	
	@Test
	void testAddItem() {
		assertEquals(2, multiCounters.addItem(null));
		assertEquals(2, multiCounters.addItem("A"));
		assertEquals(3, multiCounters.addItem("B"));
		assertEquals(1, multiCounters.addItem("W"));
	}

	@Test
	void testGetValue() {
		assertEquals(1, multiCounters.getValue(null));
		assertEquals(1, multiCounters.getValue("A"));
		assertEquals(2, multiCounters.getValue("B"));
		assertEquals(4, multiCounters.getValue("F"));
		assertNull(multiCounters.getValue("W"));
	}

	@Test
	void testRemove() {
		assertTrue(multiCounters.remove("A"));
		assertFalse(multiCounters.remove("A"));
		assertTrue(multiCounters.remove(null));
		assertTrue(multiCounters.remove("F"));
		assertFalse(multiCounters.remove("F"));
		assertFalse(multiCounters.remove("W"));		
	}

	@Test
	void testGetMaxItems() {
		Set<Object> setOfMaxItems = Set.of("F");
		areSetsEqual(setOfMaxItems, multiCounters.getMaxItems());
		multiCounters.remove("F");
		setOfMaxItems = Set.of("D", "E");
		areSetsEqual(setOfMaxItems, multiCounters.getMaxItems());
		multiCounters = new MultiCountersImpl();
		areSetsEqual(Collections.emptySet(), multiCounters.getMaxItems());
	}
	private void areSetsEqual(Set<Object> setOfMaxItems, Set<Object> maxItems) {
		assertEquals(setOfMaxItems.size(), maxItems.size());
		for(Object item: setOfMaxItems) {
			assertTrue(maxItems.contains(item));
		}		
	}
}
