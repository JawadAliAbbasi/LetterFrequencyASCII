import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LetterFrequencyTest {
    @Test
    public void testMain() {

    }

    @Test
    public void testCalcLetterFrequency() {

        LetterFrequency test = new LetterFrequency();

        //This array is Alphabetically ordered just for tests
        int[] solution = {5, 1, 0, 1, 1, 0, 0, 1, 2, 1, 1, 1, 0, 3, 0, 1, 0, 1, 2, 1, 1, 0, 0, 0, 2, 0};

        assertArrayEquals(solution, test.calcLetterFrequency("Provinces.txt"));
        
    }
}
