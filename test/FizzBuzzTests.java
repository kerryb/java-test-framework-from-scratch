import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class FizzBuzzTests extends TestSuite {
    private static FizzBuzz fizzBuzz;

    public static void main(String[] args) throws Throwable {
        new FizzBuzzTests().run();
    }

    private void run() throws Throwable {
        fizzBuzz = new FizzBuzz();
        Method[] methods = getClass().getDeclaredMethods();
        int tests = 0;
        List<TestFailure> failures = new ArrayList<>();
        for (Method method: methods) {
            if (method.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    method.invoke(this);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    failures.add(new TestFailure(method.getName(), e.getCause().getMessage()));
                }
            }
        }
        System.out.println(pluralise(tests, "test") + "; " + pluralise(failures.size(), "failure") + ".");
        if (!failures.isEmpty()) {
            for (TestFailure failure: failures) {
                failure.report();
            }
            System.exit(1);
        }
    }


    @Test
    private void converts_3_to_fizz() {
        assertEqual(fizzBuzz.say(3), "fizz");
    }

    @Test
    private void converts_5_to_buzz() {
        assertEqual(fizzBuzz.say(5), "buzz");
    }

    @Test
    private void converts_multiples_of_three_to_fizz() {
        assertEqual(fizzBuzz.say(6), "fizz");
    }

    @Test
    private void converts_multiples_of_five_to_buzz() {
        assertEqual(fizzBuzz.say(10), "buzz");
    }

    @Test
    private void converts_multiples_of_three_and_five_to_fizzbuzz() {
        assertEqual(fizzBuzz.say(15), "fizzbuzz");
    }

    @Test
    private void leaves_other_numbers_alone() {
        assertEqual(fizzBuzz.say(1), "1");
    }
}