package creational.singleton.billpughsingleton;

import java.lang.reflect.Constructor;

public class Main {

    // Java Reflection to destroy Bill Pugh Singleton Pattern
    // The Bill Pugh Singleton is the best approach so far, but it can be easily
    // destroyed with the use of Java reflection.

    public static void main(String[] args) {
        BillPughSingleton instance1 = BillPughSingleton.getInstance();
        BillPughSingleton instance2 = null;
        try {
            Constructor[] cstr = BillPughSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : cstr) {
                //Setting constructor accessible
                constructor.setAccessible(true);
                instance2
                        = (BillPughSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}
