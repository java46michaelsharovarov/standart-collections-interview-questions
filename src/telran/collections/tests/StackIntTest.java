package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.StackInt;

class StackIntTest {
	
	StackInt stack;	
	
	@BeforeEach
	void setUp() {
		stack = new StackInt();
	}
	@Test
	void testPop() {
		assertThrows(NoSuchElementException.class, () -> stack.pop());
		stack.push(1);
		stack.push(2);
		assertEquals(2, stack.pop());
	}

	@Test
	void testPush() {
		assertTrue(stack.isEmpty());
		stack.push(1);
		assertFalse(stack.isEmpty());
	}	

	@Test
	void testIsEmpty() {
		assertTrue(stack.isEmpty());
	}

	@Test
	void testGetMaxNumber() {
		assertThrows(NoSuchElementException.class, () -> stack.getMaxNumber());
		stack.push(1);
		stack.push(5);
		stack.push(2);
		stack.push(3);
		assertEquals(5, stack.getMaxNumber());
	}

}