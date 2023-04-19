package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {
    List<Integer> numbers;

    @BeforeEach
            void init() {
        numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    }


    @Test
    void testTake1() {
        // BEGIN
        List<Integer> expected = new ArrayList<>((Arrays.asList(1, 2)));
        assertThat(App.take(numbers, 2)).isEqualTo(expected);
        // END
    }

    @Test
    void testTake2() {
        // BEGIN
        List<Integer> expected = new ArrayList<>((Arrays.asList(1, 2, 3, 4)));
        assertThat(App.take(numbers, 8)).isEqualTo(expected);
        // END
    }

    @Test
    void testTake3() {
        // BEGIN
        List<Integer> expected = new ArrayList<>((List.of()));
        assertThat(App.take(numbers, -2)).isEqualTo(expected);
        // END
    }

    @Test
    void testTake4() {
        // BEGIN
        List<Integer> expected = new ArrayList<>((List.of(1)));
        assertThat(App.take(numbers, 0)).isEqualTo(expected);
        // END
    }

}
