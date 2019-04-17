package creational.singleton.threadsafesingleton;

public class DoubleLockingThreadSafeSingleton {

    //With implementation above, the synchronized lock is always checked, it makes down up performance.
    // Double Checking Implementation below will resolve the problem.

    private static DoubleLockingThreadSafeSingleton instance;

    private DoubleLockingThreadSafeSingleton() {}

    /**
     * For improve performance, implement with DoubleLocking
     */
    public static DoubleLockingThreadSafeSingleton getInstanceDoubleLocking(){
        if(instance == null){
            synchronized (DoubleLockingThreadSafeSingleton.class) {
                if(instance == null){
                    instance = new DoubleLockingThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
