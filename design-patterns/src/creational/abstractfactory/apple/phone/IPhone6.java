package creational.abstractfactory.apple.phone;

import creational.abstractfactory.SmartPhone;

public class IPhone6 implements SmartPhone {

    @Override
    public String info() {
        return String.format("This is %s - %s." , "iPhone 6s", "4.7-inch display");
    }
}
