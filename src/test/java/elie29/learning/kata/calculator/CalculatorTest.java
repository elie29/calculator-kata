package elie29.learning.kata.calculator;

import elie29.learning.kata.calculator.domain.Calculator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest
{
   private Calculator calculator;

   @Before
   public void setUp()
   {
      calculator = new Calculator();
   }

   @Test
   @Parameters({
      ", 0",               // An empty string returns zero
      "5, 5",              // A single number returns the value
      "241, 241",          // A single number returns the value
      // Escape comma for the first parameter
      "1\\,2, 3",          // Two numbers, comma delimited, returns the sum
      "10\\,205, 215",     // Two numbers, comma delimited, returns the sum
      "1\n2, 3",           // Two numbers, newline delimited, returns the sum
      "10\n205, 215",      // Two numbers, newline delimited, returns the sum
      "10\n11\\,12, 33",   // Two numbers, newline delimited, returns the sum
      "10\n11\\,1200, 21", // Numbers greater than 1000 are ignored
      "#2#10, 12",         // A single char delimiter can be defined on the first line
      "'2'10, 12",         // A single char delimiter can be defined on the first line
      "-2-1-3, 6",         // - could not be used as delimiter
      "-200-150-32, 382",  // - could not be used as delimiter
   })
   public void shouldSumValidString(String s, int expected) throws Exception
   {
      Calculator calculator = new Calculator();
      int result = calculator.sumOf(s);

      assertThat(result, is(expected));
   }

   @Test(expected = Exception.class)
   @Parameters({
      "-152",
      "-2\n0",
      "-1\\,-2",
      "2\n-5",
      "#2#-1",
   })
   public void shouldThrowAnExceptionWithNegativeNumber(String s) throws Exception
   {
      calculator.sumOf(s);
   }
}
