package Task3;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Serializer {

    public static void serialize(String path, Object o) throws IllegalAccessException {

        Class<?> cls = o.getClass();
        StringBuilder sb = new StringBuilder();

        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(Save.class)) {
                if (Modifier.isPrivate(f.getModifiers())) f.setAccessible(true);
                sb.append(f.getName() + "=");

                if (f.getType() == int.class) sb.append(f.getInt(o));
                else if (f.getType() == String.class) sb.append((String) f.get(o));
                sb.append(";");
            }
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(sb.toString());
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }
}
