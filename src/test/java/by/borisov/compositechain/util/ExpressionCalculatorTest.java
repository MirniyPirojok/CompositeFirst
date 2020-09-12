package by.borisov.compositechain.util;

import by.borisov.compositechain.exception.CustomException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ExpressionCalculatorTest {
    ExpressionsCalculator calculator;
    String expression;
    long i;
    long j;

    @BeforeClass
    public void setUp() {
        calculator = new ExpressionsCalculator();
        i = 1;
        j = 0;
        expression = "(2+2+ j++)+ --i";
    }

    @AfterClass
    public void tierDown() {
        expression = null;
    }

    @Test
    public void calculateExpressionsPositiveTest() throws CustomException {
        String expected = "4";
        String actual = calculator.calculateExpressions(expression, i, j);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateExpressionsNegativeTest() throws CustomException {
        String expected = "3";
        String actual = calculator.calculateExpressions(expression, i, j);
        assertNotEquals(actual, expected);
    }
}
