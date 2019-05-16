package calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jur on 06.01.2019.
 */
public class CalculatorTest {
    @Test
    public void add() throws Exception {
        Calculator calculator = new Calculator();
        calculator.add(1, 1);
        assertEquals(2, calculator.getResult(),1);
    }

    @Test
    public void div() throws Exception {
        Calculator calculator = new Calculator();
        calculator.divide(4, 2);
        assertEquals(2, calculator.getResult(),0);
    }

}