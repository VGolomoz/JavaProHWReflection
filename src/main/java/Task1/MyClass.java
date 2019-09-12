package Task1;

public class MyClass {

    @MyAnnotation(a=2,b=5)
    public static void test(int a, int b) {
        System.out.println(a + b);
    }
}
