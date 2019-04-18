package creational.abstractfactory.samsung.tablet;

import creational.abstractfactory.Tablet;

public class GalaxyTabA implements Tablet {

    @Override
    public String info() {
        return String.format("This is %s - %s.", "Galaxy Tab A", "9.7-inches display");
    }
}
