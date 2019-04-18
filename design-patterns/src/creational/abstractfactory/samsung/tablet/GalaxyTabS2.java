package creational.abstractfactory.samsung.tablet;

import creational.abstractfactory.Tablet;

public class GalaxyTabS2 implements Tablet {

    @Override
    public String info() {
        return String.format("This is %s - %s.", "Samsung - Galaxy Tab S2 8.0", "8.0-inches display");
    }
}
