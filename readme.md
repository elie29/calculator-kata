# Best practices of OO and Object Calisthenics

## SOLID
  1. Single responsibility principle
  2. Open/closed principle
  3. Liskov substitution principle
  4. Interface segregation principle
  5. Dependency inversion principle

## 9 OC Rules
  1. Only One Level Of Indentation Per Method
  2. Don't Use The ELSE Keyword
  3. Wrap All Primitives And Strings
  4. First-Class Collections
  5. One Dot Per Line
  6. Don't Abbreviate
  7. Keep All Entities Small
  8. No Classes With More Than Two Instance Variables
  9. No Getters/Setters/Properties

## TDD
   1. Write the test
   2. Make it compile
   3. Watch it fail
   4. Make it pass
   5. Refactor
      a. SOLID
      b. 9 OC Rules
   6. Replay test

## String Calculator Problem
> The purpose consists in a method that given a delimited string, returns the sum of the values. 

### Rules

- An empty string returns zero
- A single number returns the value
- Two numbers, comma delimited, returns the sum
- Two numbers, newline delimited, returns the sum
- Three numbers, delimited either way, returns the sum
- Negative numbers throw an exception
- Numbers greater than 1000 are ignored
- A single char delimiter can be defined on the first line (e.g. //# for a ‘#’ as the delimiter)

## Run the tests
mvn clean test
