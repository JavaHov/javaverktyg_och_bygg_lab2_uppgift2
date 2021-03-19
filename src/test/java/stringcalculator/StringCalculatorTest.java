package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void testAdd() {

        StringCalculator stringCalculator = new StringCalculator();

        String input = "1;2\n3:4-5";
        assertThat(15).isEqualTo(stringCalculator.add(input));

    }

}