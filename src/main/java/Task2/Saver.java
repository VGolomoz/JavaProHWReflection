package Task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Saver {

    public static void saveToFile(Object o) {

        Class<?> cls = o.getClass();

        try {
            if (cls.isAnnotationPresent(SaveTo.class)) {
                String path = cls.getAnnotation(SaveTo.class).path();

                Method[] methods = cls.getDeclaredMethods();
                for (Method m : methods) {
                    if (m.isAnnotationPresent(Save.class)) m.invoke(o, path);
                }
                System.out.println("Saving successful");
            } else System.err.println("Error");

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
