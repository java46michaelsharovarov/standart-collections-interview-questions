package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static telran.util.Anagram.*;

class AnagramTests {

	private static final String YELLOW = "yellow";

	@Test
	void testIsAnagram() {
		assertTrue(isAnagram(YELLOW, YELLOW));
		assertTrue(isAnagram(YELLOW, "wolely"));
		assertTrue(isAnagram(YELLOW, "lowlye"));
		assertTrue(isAnagram(YELLOW, "YeLwOl"));
		
		assertThrows(IllegalArgumentException.class, () -> isAnagram(YELLOW, "yello"));
		
		assertFalse(isAnagram(YELLOW, "yelllw"));
		assertFalse(isAnagram(YELLOW, "yeloow"));
		assertFalse(isAnagram(YELLOW, "aaaaaa"));
	}

}