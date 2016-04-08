public class Main {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        testValue(fizzBuzz.say(1), "1");
        testValue(fizzBuzz.say(2), "2");
        testValue(fizzBuzz.say(3), "fizz");
        testValue(fizzBuzz.say(4), "4");
        testValue(fizzBuzz.say(5), "buzz");
        testValue(fizzBuzz.say(6), "fizz");
        testValue(fizzBuzz.say(7), "7");
        testValue(fizzBuzz.say(10), "buzz");
        testValue(fizzBuzz.say(15), "fizzbuzz");
    }

    private static void testValue(String value, String expected) {
        if (value.equals(expected)) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL: Expected '" + expected + "'; got '" + value + "'.");
        }
    }
}