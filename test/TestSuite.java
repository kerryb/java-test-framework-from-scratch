import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TestSuite {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    protected @interface Test {}

    protected class TestFailure {
        private final String test;
        private final String message;

        public TestFailure(String test, String message) {
            this.test = test;
            this.message = message;
        }

        public void report() {
            System.out.println("'" + test.replaceAll("_", " ") + "' failed: " + message);

        }
    }

    protected void assertEqual(final String value, final String expected) {
        if (!value.equals(expected)) {
            throw new RuntimeException("Expected '" + expected + "'; got '" + value + "'.");
        }
    }

    protected String pluralise(final int number, final String label) {
        return number + " " + label + (number == 1 ? "" : "s");
    }
}