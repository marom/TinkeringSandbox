package creational.abstractfactory.samsung.phone;

import creational.abstractfactory.SmartPhone;

public class Galaxy7 implements SmartPhone {

    @Override
    public String info() {
        return String.format("This is %s - %s.", "Samsung Galary 7", "5.5-inches display");
    }
}
