import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

public class Sujet1 {
	/**
     * Write a lambda expression that is a predicate
     * that tests whether a string is longer than four characters.
     */
    @Test 
    public void a_predicate1() {
        Predicate<String> pred = p -> p.length() > 4; 

        assertTrue(pred.test("abcde"));
        assertFalse(pred.test("abcd"));
    }

    /**
     * Write a lambda expression that is a predicate
     * that tests whether a string is empty.
     */
    @Test 
    public void a_predicate2() {
        Predicate<String> pred = p -> p.isEmpty(); // TODO

        assertTrue(pred.test(""));
        assertFalse(pred.test("a"));
    }

    /**
     * Write an unbound method reference that is a predicate
     * that tests whether a string is empty. An unbound method
     * reference has a class name on the left-hand side of the ::
     * operator:
     *
     *     classname::methodname
     */
    
    public static boolean isEmpty(String s) {
    	return s.isEmpty();
    }
    
    @Test 
    public void a_predicate3() {
        Predicate<String> pred = Sujet1::isEmpty; // TODO

        assertTrue(pred.test(""));
        assertFalse(pred.test("a"));
    }
    
     /**
     * Create a predicate that returns true if both predicates
     * startsWithJ and lengthIs7 hold.
     */
    @Test 
    public void a_predicate4() {
        Predicate<String> startsWithJ = s -> s.startsWith("J");
        Predicate<String> lengthIs7 = s -> s.length() == 7;

        Predicate<String> startsWithJAndLengthIs7 = startsWithJ.and(lengthIs7); 

        assertFalse(startsWithJAndLengthIs7.test("Hello"));
        assertFalse(startsWithJAndLengthIs7.test("HelloJ1"));
        assertFalse(startsWithJAndLengthIs7.test("Java1"));
        assertTrue(startsWithJAndLengthIs7.test("JavaOne"));
    }
    
     /**
     * Create a predicate that is true if the length of the provided string
     * is 9 or the provided string equals ERROR.
     */
    @Test 
    public void a_predicate5() {
        Predicate<String> lengthIs9 = s -> s.length() == 9;
        Predicate<String> equalsError = "ERROR"::equals;
        // Note: this could also be: Predicate.isEqual("ERROR")

        Predicate<String> lengthIs9orError = lengthIs9.or(equalsError);

        assertFalse(lengthIs9orError.test("Hello"));
        assertTrue(lengthIs9orError.test("Hello J1!"));
        assertTrue(lengthIs9orError.test("ERROR"));
        assertFalse(lengthIs9orError.test("Error"));
    }
    
    
     /**
     * Given two consumers, create a consumer that passes the String to the
     * first consumer, then to the second.
     */
    @Test 
    public void c_consumer4() {
        Consumer<List<String>> c1 = list -> list.add("first");
        Consumer<List<String>> c2 = list -> list.add("second");

        Consumer<List<String>> consumer = c1.andThen(c2); // TODO

        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        consumer.accept(list);
        assertEquals(Arrays.asList("a", "b", "c", "first", "second"), list);
    }
    
    
    
      /**
     * Write a lambda expression that returns a new, empty StringBuilder.
     */
    @Test 
    public void d_supplier2() {
        Supplier<StringBuilder> sup = () -> new StringBuilder(); // TODO

        assertEquals("", sup.get().toString());
    }

    /**
     * Write an unbound method reference that returns a new, empty StringBuilder.
     */
    public static StringBuilder newStringBuilder() {
    	return new StringBuilder();	
    }
    
    @Test 
    public void d_supplier3() {
     //  Supplier<StringBuilder> sup = Sujet1::newStringBuilder;
	  Supplier<StringBuilder> sup = StringBuilder::new;

        assertEquals("", sup.get().toString());
    }

    /**
     * Write a lambda expression that, given two strings, returns the result
     * of concatenating the first with the second, followed by the
     * first again.
     */
    @Test 
    public void e_bifunction1() {
       BiFunction<String, String, String> bifunc = (a, b) -> a + b + a; // TODO

        assertEquals("FirstSecondFirst", bifunc.apply("First", "Second"));
    }
    
}
