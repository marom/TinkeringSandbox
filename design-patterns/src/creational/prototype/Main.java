package creational.prototype;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        SmartPhone note10 = new Samsung("Note10");
        SmartPhone iphoneX = new Apple("iPhoneX");

        System.out.println(note10);
        System.out.println(iphoneX);

        System.out.println("=== Products for VIPs ===");

        SmartPhone note10Gold = note10.clone();
        note10Gold.setAdditionalPrice(50);
        System.out.println(note10Gold);

        SmartPhone iphoneX128 = iphoneX.clone();
        iphoneX128.setAdditionalPrice(100);
        System.out.println(iphoneX128);
    }
}
