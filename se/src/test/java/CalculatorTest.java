import calculator.Calculator;
import calculator.UserException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jur on 04.01.2019.
 */
public class CalculatorTest {


    @Test
    public void div() throws UserException {
        final Calculator calculator = new Calculator();
        calculator.divide(4,2);
        assertEquals(2,calculator.getResult(),1);
    }

    @Test(expected = UserException.class)
    public void divException() throws UserException {
        final Calculator calculator = new Calculator();
        calculator.divide();
    }

    @Test(expected = RuntimeException.class)
    public void divRunTimeException() throws RuntimeException, UserException {
        final Calculator calculator = new Calculator();
        calculator.divide(4,0);
    }

    @Test
    public void mult(){
        final Calculator calculator = new Calculator();
        calculator.multiply(4,2);
        assertEquals(8,calculator.getResult(),1);
    }

    @Test
    public void add(){
        final Calculator calculator = new Calculator();
        calculator.add(4,2);
        assertEquals(6,calculator.getResult(),1);
    }

    @Test
    public void minus(){
        final Calculator calculator = new Calculator();
        calculator.minus(4,2);
        assertEquals(-6,calculator.getResult(),1);
    }

    @Test
    public void pow(){
        final Calculator calculator = new Calculator();
        calculator.stepen(4,2);
        assertEquals(16,calculator.getResult(),1);
    }

}
