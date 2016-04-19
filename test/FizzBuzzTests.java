public class FizzBuzzTests extends TestSet {
    private static FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void converts_3_to_fizz() {
        assertEqual(fizzBuzz.say(3), "fizz");
    }

    @Test
    public void converts_5_to_buzz() {
        assertEqual(fizzBuzz.say(5), "buzz");
    }

    @Test
    public void converts_multiples_of_three_to_fizz() {
        assertEqual(fizzBuzz.say(6), "fizz");
    }

    @Test
    public void converts_multiples_of_five_to_buzz() {
        assertEqual(fizzBuzz.say(10), "buzz");
    }

    @Test
    public void converts_multiples_of_three_and_five_to_fizzbuzz() {
        assertEqual(fizzBuzz.say(15), "fizzbuzz");
    }

    @Test
    public void leaves_other_numbers_alone() {
        assertEqual(fizzBuzz.say(1), "1");
    }
}