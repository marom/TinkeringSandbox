package creational.singleton.eagersinleton;

public class EagerSingleton {
//
//    The Eager Singleton pattern is simple way, the Singleton Instance will be created at the class loading time.
//    Disadvantage is that the instance is created but application maybe NOT use it right after creating time.
//
    private String message;

    private static EagerSingleton instance = new EagerSingleton();

    /*
     * private Constructor for Singleton Pattern
     * so the class can Not be instantiate
     */
    private EagerSingleton(){
        message = "Hello World!";
    }

    public static EagerSingleton getInstance(){
        return instance;
    }

    public void showMessage() {
        System.out.println(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
