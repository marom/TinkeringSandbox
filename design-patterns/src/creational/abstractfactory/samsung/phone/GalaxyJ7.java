package creational.abstractfactory.samsung.phone;

import creational.abstractfactory.SmartPhone;

public class GalaxyJ7 implements SmartPhone {

    @Override
    public String info() {
        return String.format("This is %s - %s.", "Samsung Galaxy J7", "5.5-inches display");
    }
}
