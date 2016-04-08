public class FizzBuzz {
    public String say(final int number) {
        if (number % 3 == 0) {
            return "fizz";
        } else if (number % 5 == 0) {
            return "buzz";
        } else {
            return Integer.toString(number);
        }
    }
}