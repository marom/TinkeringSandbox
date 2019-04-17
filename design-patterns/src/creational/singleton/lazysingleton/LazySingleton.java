package creational.singleton.lazysingleton;

public class LazySingleton {
    private static LazySingleton instance;

    // Lazy Singleton Implementation will create Singleton Instance at the first time of Client call.

    public static LazySingleton getInstance(){
        if(null == instance){
            instance = new LazySingleton();
        }
        return instance;
    }
}
