package calc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

public class CalculatorTest {
    private final Calculator calc = new Calculator();

    @Test
    public void calculateAddTest(){
        int first = 10;
        int second = 20;
        int expected = 30;
        int actual = calc.calculate(first,second, Operation.ADD);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void calculateSubtractTest(){
        int first = 10;
        int second = 20;
        int expected = -10;
        int actual = calc.calculate(first,second,Operation.SUBTRACT);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void calculateMultiplyTest(){
        int first = 10;
        int second = 20;
        int expected = 200;
        int actual = calc.calculate(first,second,Operation.MULTIPLY);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void calculateDivideTest(){
        int first = 10;
        int second = 20;
        int expected = 0;
        int actual = calc.calculate(first,second,Operation.DIVIDE);
        Assert.assertEquals(expected,actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void calculateDivideByZero(){
        int first = 10;
        int second = 0;
        calc.calculate(first,second,Operation.DIVIDE);
    }

    @DisplayName(value = "Test with null Operation")
    @Test(expected = NullPointerException.class)
    public void testNullOperation(){
        int first = 10;
        int second = 20;
        calc.calculate(first,second,null);
    }
    @Disabled("Not implemented yet")
    @Test
    public void calculateBigNumbersDisabledTest(){

    }
}
