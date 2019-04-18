package creational.abstractfactory.apple.tablet;

import creational.abstractfactory.Tablet;

public class IPadMini4 implements Tablet {

    @Override
    public String info() {
        return String.format("This is %s - %s.", "iPad mini 4", "7.9-inches display");
    }
}
