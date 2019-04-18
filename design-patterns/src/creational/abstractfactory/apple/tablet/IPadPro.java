package creational.abstractfactory.apple.tablet;

import creational.abstractfactory.Tablet;

public class IPadPro implements Tablet {

    @Override
    public String info() {
        return String.format("This is %s - %s.", "iPad Pro", "12.9-inches display");
    }
}
