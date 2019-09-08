package Task3;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Deserializer {

    public static <T> T deserialize(String path, Class<T> cls) throws IllegalAccessException,
            InstantiationException, NoSuchFieldException {

        T obj = cls.newInstance();
        String fromFile = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            fromFile = (String) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        String[] pairs = fromFile.split(";");
        for (String p : pairs) {
            String[] nameValue = p.split("=");
            String name = nameValue[0];
            String value = nameValue[1];
            Field f = cls.getDeclaredField(name);

            if (f.isAnnotationPresent(Save.class)) {
                if (Modifier.isPrivate(f.getModifiers())) f.setAccessible(true);
                if (f.getType() == int.class) f.setInt(obj, Integer.parseInt(value));
                else if (f.getType() == String.class) f.set(obj, value);
            }

        }
        return obj;
    }
}
