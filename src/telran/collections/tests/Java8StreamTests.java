package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Java8StreamTests {
	
	static class Programmer {
		String name;
		int age;
		String [] technolgies;

		public Programmer(String name, int age, String[] technolgies) {
			super();
			this.name = name;
			this.age = age;
			this.technolgies = technolgies;
		}	
		
		public String getName() {
			return name;
		}
		public int getAge() {
			return age;
		}
		public String[] getTechnolgies() {
			return technolgies;
		}	
	}

	@Test
	void testSumTwoDimArray() {
		int ar[][] = {{Integer.MAX_VALUE, 2}, {3, 4, 5}, {7}};
		assertEquals(Integer.MAX_VALUE + 21L, sumTwoDimArray(ar));
	}

	private Long sumTwoDimArray(int[][] ar) {		
		return Arrays.stream(ar).flatMapToInt(a -> Arrays.stream(a)).asLongStream().sum();
	}
	
	List<Programmer> programmers;
	String[] technologies1 = {"Java", "SQL", "C++"};
	String[] technologies2 = {"Java"};
	String[] technologies3 = {"Java", "React", "SQL"};
	int[] numbers = {125, 125, 346, 7};
	
	@BeforeEach
	void setUp() {
		programmers = Arrays.asList(new Programmer("Vasya", 30, technologies1),
				new Programmer("Petya", 25, technologies2),
				new Programmer("Sara", 35, technologies1));
	}
	
	@Test
	void averageProgrammersAgeTest() {
		assertEquals(30.0, getAverageAge());
	}
	private Double getAverageAge() {		
//		return programmers.stream().mapToInt(p -> p.getAge())
//				.average().getAsDouble();
		return programmers.stream().collect(Collectors.averagingInt(Programmer::getAge));
	}
	
	@Test
	void mostPopularTechnologyTest() {
		assertEquals("Java", getMostPopularTechnology());
	}
	private String getMostPopularTechnology() {		
		return programmers.stream().flatMap(p -> Arrays.stream(p.getTechnolgies()))
				.collect(Collectors.groupingBy(t -> t, Collectors.counting()))
				.entrySet().stream()
				.sorted((e1, e2) ->  Long.compare(e2.getValue(), e1.getValue()))
				.map(Map.Entry<String, Long>::getKey)
				.findFirst().orElse(null);
	}
	
	@Test
	void printDigitOccurrences() {
		new Random().ints(1_000_000, 0, Integer.MAX_VALUE)
		.boxed()
		.flatMap(n -> Arrays.stream(n.toString().split("")))
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet()
		.stream()
		.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
		.forEach(e -> System.out.printf("%s : <%s>\n", e.getKey(), e.getValue()));
		
		//generate 1_000_000 random numbers from 0 to Integer.MAX_VALUE
		//print digits occurrences in descending order of occurrences
		// 1: <occurrences>
		// 2: <occurrences>
		// ......
	}	

}