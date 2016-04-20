import java.util.IllegalFormatException;

public class FizzBuzzTests {
    private FizzBuzz fizzBuzz;

    public static void main(String[] args) {
        new FizzBuzzTests().run();
    }

    public void run() {
        fizzBuzz = new FizzBuzz();
        Runnable[] tests = {
                this::convertsThreeToFizz,
                this::convertsMultipleOfThreeAndFiveToFizzBuzz,
                this::convertsNormalNumberToString,
                this::alwaysFails
        };

        int failures = 0;
        int total = 0;
        for (Runnable test : tests) {
            try {
                total++;
                test.run();
            } catch (Exception e) {
                failures++;
                System.out.println("Something failed: " + e);
            }
        }
        System.out.println("Ran: " + total + "; failed: " + failures);
    }

    private void convertsNormalNumberToString() {
        assertEquals("1", fizzBuzz.say(1));
    }

    private void convertsMultipleOfThreeAndFiveToFizzBuzz() {
        assertEquals("fizzbuzz", fizzBuzz.say(15));
    }

    private void convertsThreeToFizz() {
        assertEquals("fizz", fizzBuzz.say(3));
    }

    private void alwaysFails()  {
        throw new RuntimeException("help!");
    }
    private void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            throw new RuntimeException("Expected: " + expected + "; got: " + actual);
        }
    }
}