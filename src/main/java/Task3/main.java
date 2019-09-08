package Task3;

public class main {


    public static void main(String[] args) {

        String path = "d:\\file.txt";

        Test test = new Test();
        test.setName("Test");
        test.setYear(2019);
        test.setDay("monday");

        System.out.println(test);

        try {
            Serializer.serialize(path, test);
            test = Deserializer.deserialize(path, Test.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        System.out.println(test);
    }
}
