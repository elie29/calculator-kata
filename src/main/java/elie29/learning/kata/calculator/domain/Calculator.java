package elie29.learning.kata.calculator.domain;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Calculator
{
   private static final int MAX_AUTHORISED = 1000;
   private static final String DEFAULT_DELIMITER = ",|\n";
   private static final char MINUS = '-';

   public int sumOf(String s) throws Exception
   {
      if (s.length() == 0) {
         return 0;
      }

      String[] items = s.split(getDelimiter(s));

      if (toStream(items).anyMatch(item -> item < 0)) {
         throw new Exception("Numbers should be positive");
      }

      return toStream(items).sum();
   }

   private String getDelimiter(String s)
   {
      char c = s.charAt(0);
      return firstCharIsDelimiter(c, s) ? String.valueOf(c) : DEFAULT_DELIMITER;
   }

   private boolean firstCharIsDelimiter(char first, String s)
   {
      if (first == MINUS) {
         return isMinusSignDelimiter(s);
      }

      return !Character.isDigit(first);
   }

   private boolean isMinusSignDelimiter(String s)
   {
      long countMinusSign = s.chars().filter(ch -> ch == MINUS).count();

      if (countMinusSign <= 1) {
         // -512 -> not delimiter
         return false;
      }

      String[] items = s.substring(1).split("-");
      /*
       * -1,-2 -> not delimiter
       * -1-2-4 -> delimiter
       */
      return items.length == countMinusSign;
   }

   private IntStream toStream(String[] items)
   {
      return Arrays.stream(items)
         .filter(item -> item.length() > 0) // delete single char delimiter
         .mapToInt(Integer::parseInt)
         .filter(item -> item <= MAX_AUTHORISED);
   }
}
