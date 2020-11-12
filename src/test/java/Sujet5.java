import static org.assertj.core.api.Assertions.assertThat;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
 
public class Sujet5 {
 
    
    /**
     * Given a map whose keys are Integers and whose values are Strings,
     * set each value to upper case.
     */
    @Test
    public void j_map01() {
 
        final Map<Integer, String> map = new HashMap<>();
        map.put(1, "alfa");
        map.put(2, "bravo");
        map.put(3, "charlie");
 
        // XXX
        
        assertThat(map).hasSize(3);
        assertThat(map).containsKeys(1, 2, 3);
        assertThat(map).containsValues("ALFA", "BRAVO", "CHARLIE");
    }
 
    
    /**
     * For some reason the provided map doesn't have mappings for all the keys.
     * This is a problem, because if we call get() on a key that isn't present, it returns
     * null, and we need to add checks to protect against NullPointerException.
     * Write code to ensure that all missing keys are mapped to the empty string.
     */
    @Test
    public void j_map02() {
 
        final List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
 
        final Map<String, String> map = new HashMap<>();
        map.put("a", "alfa");
        map.put("b", "bravo");
        map.put("c", "charlie");
        map.put("d", "delta");
        map.put("e", null);
 
        keys.forEach(__ -> {}/* XXX */);
 
        assertThat(map).hasSize(7);
        assertThat(map)
                .contains(new AbstractMap.SimpleEntry<>("a", "alfa"))
                .contains(new AbstractMap.SimpleEntry<>("b", "bravo"))
                .contains(new AbstractMap.SimpleEntry<>("c", "charlie"))
                .contains(new AbstractMap.SimpleEntry<>("d", "delta"))
                .contains(new AbstractMap.SimpleEntry<>("e", ""))
                .contains(new AbstractMap.SimpleEntry<>("f", ""))
                .contains(new AbstractMap.SimpleEntry<>("g", ""));
    }
    
 
    /**
     * We are still dealing with a map with missing entries. For entries that
     * are present, we want to convert the value to upper case; and for keys
     * that are not present, we want to add an entry where the value is the
     * same as the key.
     */
    @Test
    public void j_map05() {
 
        final List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
 
        final Map<String, String> map = new HashMap<>();
        map.put("a", "alfa");
        map.put("b", "bravo");
        map.put("c", "charlie");
        map.put("d", "delta");
 
        keys.forEach(__ -> {}/* XXX */);
 
        assertThat(map).hasSize(7);
        assertThat(map)
                .contains(new AbstractMap.SimpleEntry<>("a", "ALFA"))
                .contains(new AbstractMap.SimpleEntry<>("b", "BRAVO"))
                .contains(new AbstractMap.SimpleEntry<>("c", "CHARLIE"))
                .contains(new AbstractMap.SimpleEntry<>("d", "DELTA"))
                .contains(new AbstractMap.SimpleEntry<>("e", "e"))
                .contains(new AbstractMap.SimpleEntry<>("f", "f"))
                .contains(new AbstractMap.SimpleEntry<>("g", "g"));
    }
 
    
    /**
     * The map now has several entries, some with valid values, and some
     * with values that are the empty string. This time, we want to convert
     * the non-empty values to upper case, but we want to remove the entries
     * for which the values are the empty string.
     */
    @Test
    public void j_map06() {
 
        final List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
 
        final Map<String, String> map = new HashMap<>();
        map.put("a", "alfa");
        map.put("b", "bravo");
        map.put("c", "charlie");
        map.put("d", "delta");
        map.put("e", "");
        map.put("f", "");
        map.put("g", "");
 
        keys.forEach(__ -> {}/* XXX */);
 
        assertThat(map).hasSize(4);
        assertThat(map)
                .contains(new AbstractMap.SimpleEntry<>("a", "ALFA"))
                .contains(new AbstractMap.SimpleEntry<>("b", "BRAVO"))
                .contains(new AbstractMap.SimpleEntry<>("c", "CHARLIE"))
                .contains(new AbstractMap.SimpleEntry<>("d", "DELTA"));
    }
    
    /**
     * Given a list of words, populate a map whose keys are the lengths of
     * each word, and whose values are list of words with that length.
     */
    @Test
    public void j_map07() {
 
        final List<String> list = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
 
        final Map<Integer, List<String>> result = new HashMap<>();
 
        list.forEach(__ -> {}/* XXX */);
 
        assertThat(result).hasSize(3);
        assertThat(result).containsKeys(3, 4, 5);
        assertThat(result)
                .contains(new AbstractMap.SimpleEntry<>(3, Arrays.asList("one", "two", "six", "ten")))
                .contains(new AbstractMap.SimpleEntry<>(4, Arrays.asList("four", "five", "nine")))
                .contains(new AbstractMap.SimpleEntry<>(5, Arrays.asList("three", "seven", "eight")));
    }
    
    /**
     * Given a list of words, populate a map whose keys are the lengths of each word, and whose values
     * the concatenation of words with that length, separated by a space.
     */
    @Test
    public void j_map09() {
 
        final List<String> list = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
 
        Map<Integer, String> result = new HashMap<>();
 
        list.forEach(__ -> {}/* XXX */);
 
        assertThat(result).hasSize(3);
        assertThat(result).containsKeys(3, 4, 5);
        assertThat(result)
                .contains(new AbstractMap.SimpleEntry<>(3, "one two six ten"))
                .contains(new AbstractMap.SimpleEntry<>(4, "four five nine"))
                .contains(new AbstractMap.SimpleEntry<>(5, "three seven eight"));
    }
    
    
    /**
     * Given a stream of int, retrieve the minimum and maximum
     */
    @Test
    public void h_stream01() {
       IntStream ints = new Random(1324365).ints(20);
             
       // XXX
       
       int min = -1;//XXX
       int max = -1;//XXX
       
       assertThat(min).isEqualTo(-1826591621);
       assertThat(max).isEqualTo(1904710026);
    }
}
