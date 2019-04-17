package creational.singleton.eagersinleton;

public class Main {

    public static void main(String[] args) {

        EagerSingleton eagerSingleton = EagerSingleton.getInstance();

        eagerSingleton.showMessage();
        eagerSingleton.setMessage("New message");
        EagerSingleton newSingleton = EagerSingleton.getInstance();
        newSingleton.showMessage();

    }
}
