import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.Ignore;
import org.junit.Test;

public class Sujet3 {

	/**
	 * Convert a list of strings into a list of characters.
	 */
	@Test
	public void e1_stringsToCharacters() {
		List<String> input = Arrays.asList("alfa", "bravo", "charlie");

		String result2 =  input.stream().collect(Collectors.joining());
		List<Character> result = result2.chars().mapToObj(s -> (char)s).collect(Collectors.toList());

		List<Character> result3 = input
				.stream()
				.collect(Collectors.joining())
				.chars()
				.mapToObj(s -> (char)s)
				.collect(Collectors.toList());

		//flatMap();
		List<Character> result4 = input
				.stream()
				.flatMap(s -> s.chars().mapToObj(c -> Character.valueOf((char) c)))
				.collect(Collectors.toList());        		


		assertEquals("[a, l, f, a, b, r, a, v, o, c, h, a, r, l, i, e]", result4.toString());
		assertTrue(result4.stream().allMatch(x -> x instanceof Character));
	}

	/**
	 * Compute the value of 21!, that is, 21 factorial. This value is larger than
	 * Long.MAX_VALUE, so you must use BigInteger.
	 */
	@Test
	public void e6_bigFactorial() {
		BigInteger result = BigInteger.ONE; // TODO

		for (int i = 2; i < 22; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}

		BigInteger result2 = Stream
				.iterate(BigInteger.ONE, i -> i.add(BigInteger.ONE))
				.limit(21)
				.reduce(BigInteger.ONE, BigInteger::multiply);

		BigInteger result3 = LongStream
				.rangeClosed(1, 21)
				.mapToObj(l -> BigInteger.valueOf(l))
				.reduce(BigInteger.ONE, BigInteger::multiply);

		assertEquals(new BigInteger("51090942171709440000"), result3);
	}



	/**
	 * Create a list containing ArrayList.class and all its super classes.
	 */
	@Test
	public void e8_selectTheSuperClassesOfArrayList() {
		Class<?> origin = ArrayList.class;

		List<Class<?>> result = Stream.
			<Class<?>>iterate(origin,Objects::nonNull,  Class::getSuperclass)
//			.takeWhile(Objects::nonNull)
			.collect(Collectors.toList());
			
//		List<Class<?>> result = null; // TODO

		Class<?> test  = origin.getSuperclass();
		
		List<Class<?>> classes = Arrays.asList(ArrayList.class, AbstractList.class, AbstractCollection.class, Object.class);
		assertEquals(classes, result);
	}


	/**
	 * Given a stream of integers, compute separate sums of the even and odd values
	 * in this stream. Since the input is a stream, this necessitates making a single
	 * pass over the input.
	 */
	@Test
	public void f5_separateOddEvenSums() {
		IntStream input = new Random(987523).ints(20, 0, 100);

		Map<Boolean, Integer> result = input
				.mapToObj(i -> (Integer) (i))
				.collect(Collectors
						.partitioningBy((i -> i  %2 == 0)
							,Collectors.summingInt((i -> i))));
		
		assertEquals(516, result.get(Boolean.TRUE));
		assertEquals(614, result.get(Boolean.FALSE));
	}


	/**
	 * Given a stream of strings, accumulate (collect) them into the result string
	 * by inserting the input string at both the beginning and end. For example, given
	 * input strings "x" and "y" the result should be "yxxy". Note: the input stream
	 * is a parallel stream, so you MUST write a proper combiner function to get the
	 * correct result.
	 */
	@Test
	public void f6_insertBeginningAndEnd() {
		Stream<String> input = Arrays.asList(
				"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t")
				.parallelStream();

		String result = input.collect(null, null, null).toString();
		// TODO fill in lambda expressions or method references
		// in place of the nulls in the line above.

		assertEquals("tsrqponmlkjihgfedcbaabcdefghijklmnopqrst", result);
	}
}
