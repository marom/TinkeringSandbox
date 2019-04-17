package creational.singleton.billpughsingleton;

public class BillPughSingleton {

    // Prior 5, Java memory model has lots of issues when having too many threads trying to get Instance
    // using the static inner helper class. Static inner classes are not loaded into memory
    // until their getInstance() methods are called

    private BillPughSingleton(){}

    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
