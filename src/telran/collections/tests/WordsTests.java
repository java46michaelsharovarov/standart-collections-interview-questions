package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.util.Words;

class WordsTest {

	@Test
	void testAddWord() {
		assertTrue(Words.addWord("Hello"));
		assertFalse(Words.addWord("Hello"));
	}

	@Test
	void testGetWordsByPrefix() {
		//TODO
	}

}