package telran.collections.tests;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Words;


class WordsTests {

	String words[]= {"abcdef","ab123","aaa","ab","ablmn","abbbb",
			"a", "ABd","bbb", "B12", "*/"};
	String wordsStartB[] = {"B12", "bbb"};
	String wordsStartAB[] = {"ab","ab123","abbbb","abcdef","ABd","ablmn"};
	String wordsStartABC[] = {"abcdef"};
	String wordsStartAsteric[] = {"*/"};
	Words elasticSearch;
	
	@BeforeEach
	void setUp() throws Exception {
		elasticSearch = new Words();
		for(String word: words) {
			elasticSearch.addWord(word);
		}				
	}

	@Test
	void test() {
		assertArrayEquals(wordsStartABC,
				elasticSearch.getWordsByPrefix("abc").toArray(String[]::new));
		assertArrayEquals(wordsStartB,
				elasticSearch.getWordsByPrefix("B").toArray(String[]::new));
		assertArrayEquals(wordsStartAB,
				elasticSearch.getWordsByPrefix("ab").toArray(String[]::new));
		assertArrayEquals(wordsStartAsteric,
				elasticSearch.getWordsByPrefix("*").toArray(String[]::new));
		
	}

}