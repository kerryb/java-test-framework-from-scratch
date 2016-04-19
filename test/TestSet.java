import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestSet {
    @Retention(RetentionPolicy.RUNTIME)
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

    public void run() throws Throwable {
        Method[] methods = getClass().getDeclaredMethods();
        int tests = 0;
        List<TestFailure> failures = new ArrayList<>();
        for (Method method: methods) {
            if (method.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    setup();
                    method.invoke(this);
                } catch (InvocationTargetException e) {
                    failures.add(new TestFailure(method.getName(), e.getCause().getMessage()));
                }
            }
        }
        System.out.println("Tests run: " + tests + "; tests failed: " + failures.size());
        if (!failures.isEmpty()) {
            for (TestFailure failure: failures) {
                failure.report();
            }
            System.exit(1);
        }
    }

    protected void setup() {}

    protected void assertEqual(final Object value, final Object expected) {
        if (!value.equals(expected)) {
            throw new RuntimeException("Expected '" + expected + "'; got '" + value + "'.");
        }
    }
}