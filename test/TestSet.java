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

    public void run() throws Throwable {
        Method[] methods = getClass().getDeclaredMethods();
        int tests = 0;
        int failures = 0;
        for (Method method: methods) {
            if (method.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    setup();
                    method.invoke(this);
                } catch (InvocationTargetException e) {
                    failures++;
                    System.out.println("'" + method.getName() + "' failed: " + e.getCause().getMessage());
                }
            }
        }
        System.out.println("Tests run: " + tests + "; tests failed: " + failures);
        if (failures > 0) {
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