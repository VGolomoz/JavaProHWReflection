package Task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        final Class<?> cls = MyClass.class;

        Method[] methods = cls.getDeclaredMethods();

        for (Method m : methods) {
            if (m.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation ma = m.getAnnotation(MyAnnotation.class);

                m.invoke(MyClass.class, ma.a(), ma.b());

            }
        }
    }
}
