public class Main {
    private static FizzBuzz fizzBuzz;

    public static void main(String[] args) {
        fizzBuzz = new FizzBuzz();
        converts_3_to_fizz();
        converts_5_to_buzz();
        converts_multiples_of_three_to_fizz();
        converts_multiples_of_five_to_buzz();
        converts_multiples_of_three_and_five_to_fizzbuzz();
        leaves_other_numbers_alone();
    }

    private static void converts_3_to_fizz() {
        assertEqual(fizzBuzz.say(3), "fizz");
    }

    private static void converts_5_to_buzz() {
        assertEqual(fizzBuzz.say(5), "buzz");
    }

    private static void converts_multiples_of_three_to_fizz() {
        assertEqual(fizzBuzz.say(6), "fizz");
    }

    private static void converts_multiples_of_five_to_buzz() {
        assertEqual(fizzBuzz.say(10), "buzz");
    }

    private static void converts_multiples_of_three_and_five_to_fizzbuzz() {
        assertEqual(fizzBuzz.say(15), "fizzbuzz");
    }

    private static void leaves_other_numbers_alone() {
        assertEqual(fizzBuzz.say(1), "1");
    }

    private static void assertEqual(String value, String expected) {
        if (!value.equals(expected)) {
            throw new RuntimeException("Expected '" + expected + "'; got '" + value + "'.");
        }
    }
}