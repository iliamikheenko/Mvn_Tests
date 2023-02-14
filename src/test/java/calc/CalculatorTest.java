package calc;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class CalculatorTest {

    private final Calculator calc = new Calculator();

    @BeforeAll
    static void init(){
        System.out.println("Starting all tests...");
    }
    @BeforeEach
    void initBeforeEach(){
        System.out.println("Starting next test...");
    }
    @Test
    @DisplayName("Adding")
    public void calculateAddTest(){
        int first = 10;
        int second = 20;
        int expected = 30;
        int actual = calc.calculate(first,second, Operation.ADD);
        assertEquals(expected,actual);
    }
    @Test
    public void calculateSubtractTest(){
        int first = 10;
        int second = 20;
        int expected = -10;
        int actual = calc.calculate(first,second,Operation.SUBTRACT);
        assertEquals(expected,actual);
    }
    @Test
    public void calculateMultiplyTest(){
        int first = 10;
        int second = 20;
        int expected = 200;
        int actual = calc.calculate(first,second,Operation.MULTIPLY);
        assertEquals(expected,actual);
    }
    @Test
    public void calculateDivideTest(){
        int first = 10;
        int second = 20;
        int expected = 0;
        int actual = calc.calculate(first,second,Operation.DIVIDE);
        assertEquals(expected,actual);
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
    @Test
    public void calculateAddWithArraysArguments(){
        int[] first = {1,2,3,4,5,6,7,8,9,10};
        int[] second = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
        int expected = 0;
        for (int i = 0; i < 10; i++) {
            int actual = calc.calculate(first[i],second[i],Operation.ADD );
            assertEquals(expected,actual);
        }
    }
}

