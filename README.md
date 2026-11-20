public class Main {
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    char c;
    boolean bool;

    void displayDefaults() {
        System.out.println("Default values of primitive data type");
        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: '" + c + "'");
        System.out.println("boolean: " + bool);
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.displayDefaults();
    }
}
