package creational.abstractfactory.apple.phone;

import creational.abstractfactory.SmartPhone;

public class IPhone6Plus implements SmartPhone {

    @Override
    public String info() {
        return String.format("This is %s - %s.", "iPhone 6s Plus", "5.5-inch display");
    }
}
