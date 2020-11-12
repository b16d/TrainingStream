import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

public class Sujet4 {

	/**
	 * Write a lambda expression that wraps a string into parenthesis 
	 */
	@Test
	public void l_string01() {
		
		Function<String, String> func = s -> "(" + s + ")";
		
		assertThat(func.apply("alpha")).isEqualTo("(alpha)");
		assertThat(func.apply("")).isEqualTo("()");
	}
	
	/**
	 * Write a lambda expression that return the length of a string
	 * as a method reference 
	 */
	@Test
	public void l_string02() {
		
		Function<String, Integer> func = s -> s.length();
		
		assertThat(func.apply("alpha")).isEqualTo(5);
		assertThat(func.apply("")).isEqualTo(0);
	}
	
	/**
	 * Write a lambda expression that return an empty String if the given String is null
	 * and the given String otherwise
	 */
	@Test
	public void l_string03() {
		
		Function<String, String> func = Function.identity();
		
		assertThat(func.apply("alpha")).isEqualTo("alpha");
		assertThat(func.apply(null)).isEqualTo("");
	}

	/**
	 * Write a lambda expression that return the length of a string
	 * and 0 if the given string is null
	 * use l_string02 and l_string03
	 */
	@Test
	public void l_string04() {
		
		Function<String, String> func = Function.identity();
		
		assertThat(func.apply("alpha")).isEqualTo(5);
		assertThat(func.apply(null)).isEqualTo(0);
	}
	
	
	
	/**
	 * Remove the words that have odd lengths from the list.
	 */
	@Test
	public void h_collection01() {

		final List<String> list = new ArrayList<>(
				Arrays.asList("alfa", "bravo", "charlie", "delta", "echo", "foxtrot"));


		// XXX
		
		assertThat(list).hasSize(2);
		assertThat(list).contains("alfa", "echo");
	}

	/**
	 * Replace every null value in the list with an empty String.
	 */
	@Test
	public void i_list02() {

		final List<String> strings = Arrays.asList("alfa", null, "charlie", "delta", null, "foxtrot");

		// XXX

		assertThat(strings).containsExactly("alfa", "", "charlie", "delta", "", "foxtrot");
	}

	/**
	 * Sort the content of the list by the length of the strings. In case the length
	 * is the same, then use the alphabetical order.
	 */
	@Test
	public void i_list04() {

		final List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six");

		// XXX
		
		assertThat(strings).containsExactly("one", "six", "two", "five", "four", "three");
	}

	/**
	 * Write a Comparator that compares two people by age. Try to write the
	 * comparator so as to avoid boxing of primitives.
	 */
	@Test
	public void f_comparator07() {
		class Person {

			final String lastName, firstName;
			final int age;

			public Person(String lastName, String firstName, int age) {
				super();
				this.lastName = lastName;
				this.firstName = firstName;
				this.age = age;
			}

			public String getLastName() {
				return lastName;
			}

			public String getFirstName() {
				return firstName;
			}

			public int getAge() {
				return age;
			}
		}
		final Person michael = new Person("Michael", "Jackson", 51);
		final Person rod = new Person("Rod", "Stewart", 71);
		final Person paul = new Person("Paul", "McCartney", 74);
		final Person mick = new Person("Mick", "Jagger", 73);
		final Person jermaine = new Person("Jermaine", "Jackson", 61);

		Comparator<Person> compareByAge = null;

		assertThat(compareByAge.compare(michael, rod)).isLessThan(0);
		assertThat(compareByAge.compare(paul, paul)).isEqualTo(0);
		assertThat(compareByAge.compare(mick, jermaine)).isGreaterThan(0);
	}

	/**
	 * Modify class Person to allow Compartor.natural order
	 * Should sort on lastName, firstName then age
	 */
	@Test
	public void f_comparator08() {
		class Person {

			final String lastName, firstName;
			final int age;

			public Person(String lastName, String firstName, int age) {
				super();
				this.lastName = lastName;
				this.firstName = firstName;
				this.age = age;
			}

			public String getLastName() {
				return lastName;
			}

			public String getFirstName() {
				return firstName;
			}

			public int getAge() {
				return age;
			}
		}
		final Person michael = new Person("Michael", "Jackson", 51);
		final Person rod = new Person("Rod", "Stewart", 71);
		final Person paul = new Person("Paul", "McCartney", 74);
		final Person mick = new Person("Mick", "Jagger", 73);
		final Person jermaine = new Person("Jermaine", "Jackson", 61);

		Comparator<Person> natural = null;// Comparator.naturalOrder();

		assertThat(natural.compare(michael, rod)).isLessThan(0);
		assertThat(natural.compare(paul, paul)).isEqualTo(0);
		assertThat(natural.compare(mick, jermaine)).isGreaterThan(0);
	}

}