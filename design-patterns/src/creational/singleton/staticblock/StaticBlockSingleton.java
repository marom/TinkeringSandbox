package creational.singleton.staticblock;

public class StaticBlockSingleton {
//
//    The Static Block Singleton Implementation is same Eager Singleton Implementation, Instance is created at the Class loading time.
//
    private static StaticBlockSingleton instance;

    private StaticBlockSingleton(){};

    static{
        try{
            instance = new StaticBlockSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception Error when creating Static Blocking Singleton!");
        }
    }

    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}
