package creational.singleton.threadsafesingleton;

public class ThreadSafeSingleton {

    // The lazy singleton implementation does NOT adapt with multi-threading programming environment.
    // So thread safe Singleton implementation will help us

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {}

    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
