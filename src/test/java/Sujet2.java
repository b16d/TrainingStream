import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Ignore;
import org.junit.Test;

public class Sujet2 {
	/**
	 * Given a list of words, create an output list that contains
	 * only the odd-length words, converted to upper case.
	 */
	@Test 
	public void d1_upcaseOddLengthWords() {
		List<String> input = Arrays.asList(
				"alfa", "bravo", "charlie", "delta", "echo", "foxtrot");

		List<String> result = input.stream()
				.filter(p -> p.length() %2 != 0)
				.map(c -> c.toUpperCase())
				.collect(Collectors.toList());
		
		result.forEach(System.out::println);
		assertEquals(Arrays.asList("BRAVO", "CHARLIE", "DELTA", "FOXTROT"), result);
	}

	/**
	 * Take the third through fifth words of the list, extract the
	 * second letter from each, and join them, separated by commas,
	 * into a single string. Watch for off-by-one errors.
	 */
	@Test
	public void d2_joinStreamRange() {
		List<String> input = Arrays.asList(
				"alfa", "bravo", "charlie", "delta", "echo", "foxtrot");

		String result = input.stream()
		.skip(2)
		.limit(3)
		.map(p -> "" + p.charAt(1)).collect(Collectors.joining(","));

		assertEquals("h,e,c", result);
	}

	/**
	 * Select the longest words from the input list. That is, select the words
	 * whose lengths are equal to the maximum word length.
	 */
	@Test
	public void d6_selectLongestWords() {
		List<String> input = Arrays.asList(
				"alfa", "bravo", "charlie", "delta", "echo", "foxtrot", "golf", "hotel");

		//Cas 1
//		Predicate<String> pre 
		OptionalInt test  = input.stream().mapToInt(e -> e.length()).max();
		
//		System.out.println(test);
		List<String> result = input.stream()
				.filter(p -> p.length() == test.getAsInt())
				.collect(Collectors.toList()); // TODO

		//Cas 2
		 List<String> map = input.stream()
		.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList())).lastEntry().getValue();	

	
		assertEquals(Arrays.asList("charlie", "foxtrot"), map);
	}


	/**
	 * Select the list of words from the input list whose length is greater than
	 * the word's position in the list (starting from zero) .
	 */
	@Test
	public void d7_selectByLengthAndPosition() {
		List<String> input = Arrays.asList(
				"alfa", "bravo", "charlie", "delta", "echo", "foxtrot", "golf", "hotel");

		List<String> result = null; // TODO
		result  = IntStream.range(0, input.size())
							.filter(i -> input.get(i).length() > i)
							.mapToObj( i -> input.get(i))
							.collect(Collectors.toList());
		assertEquals(Arrays.asList("alfa", "bravo", "charlie", "delta", "foxtrot"), result);

		//A ne pas faire car on perd l'ordre en cas de parallele stream
		AtomicInteger atomInt = new AtomicInteger();
		
		List<String> result2 = input.stream()
				.filter(p -> p.length() > atomInt.getAndIncrement())
				.collect(Collectors.toList());
		
		assertEquals(Arrays.asList("alfa", "bravo", "charlie", "delta", "foxtrot"), result2);


	}
}
