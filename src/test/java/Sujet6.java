import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class Sujet6 {

	class Actor {
		String name;

		public Actor(String name) {
			super();
			this.name = name;
		}

		@Override
		public int hashCode() {
			return Objects.hash(name);
		}

		@Override
		public boolean equals(Object obj) {
			return (obj instanceof Actor) && ((Actor) obj).name.equals(this.name);
		}

		@Override
		public String toString() {
			return name;
		}
	}

	class Movie {
		List<Actor> actors;
		String name;

		public Movie(String name, List<Actor> actors) {
			super();
			this.name = name;
			this.actors = actors;
		}

		public List<Actor> actors() {
			return actors;
		}
	}

	class Pair {
		Actor a, b;

		public Pair(Actor a, Actor b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int hashCode() {
			return Objects.hash(a, b);
		}

		@Override
		public boolean equals(Object obj) {
			return (obj instanceof Pair) && ((Pair) obj).a.equals(this.a) && ((Pair) obj).b.equals(this.b);
		}

		private String small() { List<String> donotuse = Arrays.asList(a.name, b.name); Collections.sort(donotuse); return donotuse.get(0); }

		private String big() { List<String> donotuse = Arrays.asList(a.name, b.name); Collections.sort(donotuse); return donotuse.get(1); }
	}

	/**
	 * Find the actor that played in the greatest number of movies
	 */
	@Test
	public void h_stream02() {

		Entry<Actor, Long> max = Stream
				.of(new Movie("On ne vit que deux fois",
						Arrays.asList(new Actor("Sean Connery"), new Actor("Mie Hama"))),
						new Movie("KingKong contre Godzilla",
								Arrays.asList(new Actor("Haruo Nakajima"), new Actor("Mie Hama"))),
						new Movie("Les diamants sont éternels",
								Arrays.asList(new Actor("Sean Connery"), new Actor("Lana Wood"),
										new Actor("Jill St John"))),
						new Movie("Five Fingers Exercise",
								Arrays.asList(new Actor("Jack Hawkins"), new Actor("Lana Wood"),
										new Actor("Rosalind Russell"))),
						new Movie("A majority of one",
								Arrays.asList(new Actor("Rosalind Russell"), new Actor("Alec Guiness"),
										new Actor("Ray Danton"))),
						new Movie("Haute voltige",
								Arrays.asList(new Actor("Sean Connery"), new Actor("Catherine Zeta-Jones"))))
				./* XXX */map(__ -> (Entry<Actor, Long>) null).findAny().get();

		assertThat(max.getKey()).isEqualTo(new Actor("Sean Connery"));
		assertThat(max.getValue()).isEqualTo(3);
	}

	/**
	 * Find the total number of unique pairs of actors who played together in a
	 * movie
	 */
	@Test
	public void h_stream03() {

		Number n = Stream
				.of(new Movie("On ne vit que deux fois",
						Arrays.asList(new Actor("Sean Connery"), new Actor("Mie Hama"))),
						new Movie("KingKong contre Godzilla",
								Arrays.asList(new Actor("Haruo Nakajima"), new Actor("Mie Hama"))),
						new Movie("Les diamants sont éternels",
								Arrays.asList(new Actor("Sean Connery"), new Actor("Lana Wood"),
										new Actor("Jill St John"))),
						new Movie("Five Fingers Exercise",
								Arrays.asList(new Actor("Jack Hawkins"), new Actor("Lana Wood"),
										new Actor("Rosalind Russell"))),
						new Movie("A majority of one",
								Arrays.asList(new Actor("Rosalind Russell"), new Actor("Alec Guiness"),
										new Actor("Ray Danton"))),
						new Movie( "Snatch : Tu braques ou tu raques",
								Arrays.asList(new Actor("Jason Statham"), new Actor("Stephen Graham"), new Actor("Brad Pitt"), new Actor("Jason Flemyng"))),
						new Movie(
								"Arnaques, crimes et botanique",
								Arrays.asList(new Actor("Jason Flemyng"), new Actor("Jason Statham"), new Actor("Nick Moran"), new Actor("Dexter Fletcher"))),
						new Movie("Haute voltige",
								Arrays.asList(new Actor("Sean Connery"), new Actor("Catherine Zeta-Jones"))))
				./* XXX */ count();

		assertThat(n.intValue()).isEqualTo(23);
	}

	/**
	 * Find the pair of actors that played the most together
	 */
	@Test
	public void h_stream04() {

		Entry<Pair, Long> entry = Stream
				.of(new Movie("On ne vit que deux fois",
						Arrays.asList(new Actor("Sean Connery"), new Actor("Mie Hama"))),
						new Movie("KingKong contre Godzilla",
								Arrays.asList(new Actor("Haruo Nakajima"), new Actor("Mie Hama"))),
						new Movie("Les diamants sont éternels",
								Arrays.asList(new Actor("Sean Connery"), new Actor("Lana Wood"),
										new Actor("Jill St John"))),
						new Movie("Five Fingers Exercise",
								Arrays.asList(new Actor("Jack Hawkins"), new Actor("Lana Wood"),
										new Actor("Rosalind Russell"))),
						new Movie("A majority of one",
								Arrays.asList(new Actor("Rosalind Russell"), new Actor("Alec Guiness"),
										new Actor("Ray Danton"))),
						new Movie("Snatch : Tu braques ou tu raques",
								Arrays.asList(new Actor("Jason Statham"), new Actor("Stephen Graham"),
										new Actor("Brad Pitt"), new Actor("Jason Flemyng"))),
						new Movie( "Arnaques, crimes et botanique",
								Arrays.asList(new Actor("Jason Flemyng"), new Actor("Jason Statham"), new Actor("Nick Moran"), new Actor("Dexter Fletcher"))),
						new Movie("Haute voltige",
								Arrays.asList(new Actor("Sean Connery"), new Actor("Catherine Zeta-Jones"))))
				./* XXX */ map(__ -> (Entry<Pair, Long>) null).findAny().get()
		;

		assertThat(entry.getValue()).isEqualTo(2l);
		assertThat(entry.getKey().small()).isEqualTo("Jason Flemyng");
		assertThat(entry.getKey().big()).isEqualTo("Jason Statham");
	}
}
