public class Main {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        testValue(fizzBuzz.say(1));
        testValue(fizzBuzz.say(2));
        testValue(fizzBuzz.say(3));
        testValue(fizzBuzz.say(4));
        testValue(fizzBuzz.say(5));
        testValue(fizzBuzz.say(6));
        testValue(fizzBuzz.say(7));
        testValue(fizzBuzz.say(10));
        testValue(fizzBuzz.say(15));
    }

    private static void testValue(String value) {
        System.out.println(value);
    }
}