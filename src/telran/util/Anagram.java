package telran.util;

import java.util.Arrays;
import java.util.HashMap;

public class Anagram {
/**
 * 
 * @param word
 * @param anagram
 * @return true if anagram is one of the possible anagrams of a given word
 * anagram is a string containing all symbols from a given word with different order
 * Example: yellow (wolely, lowlye, yellow) , wrong anagrams (yello, yelllw)
 */
	public static boolean isAnagram(String word, String anagram) {
		if(word.length() != anagram.length() || word.isEmpty()) {
			throw new IllegalArgumentException();
		}
		String[] wordChars = word.toLowerCase().split("");
		String[] anagramChars = anagram.toLowerCase().split("");
		HashMap<String, Integer> helper = new HashMap<>(); 
		Arrays.stream(wordChars).forEach(c -> helper.merge(c, 1, Integer::sum));
		for(String c : anagramChars) {
			if(helper.compute(c, (k, v) -> v == null ? -1 : --v) < 0) {
				return false;
			}
		}
		return true;
	}
	
}