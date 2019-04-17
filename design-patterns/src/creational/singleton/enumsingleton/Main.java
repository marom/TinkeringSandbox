package creational.singleton.enumsingleton;

public class Main {

    public static void main(String[] args) {

        // One thing to remember here is, when serializing an enum, field variables are not getting serialized.
        // For example, if we serialize and deserialize the SingletonEnum class,
        // we will lose the value of the int value field

        EnumSingleton singleton = EnumSingleton.INSTANCE;
        System.out.println(singleton.getValue());
        singleton.setValue(2);
        System.out.println(singleton.getValue());
    }
}
