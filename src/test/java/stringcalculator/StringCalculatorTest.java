package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void testAdd() {

        StringCalculator stringCalculator = new StringCalculator();

        String input = "";
        assertThat(0).isEqualTo(stringCalculator.add(input));

    }

}