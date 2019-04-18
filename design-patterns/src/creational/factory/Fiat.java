package creational.factory;

public class Fiat implements Car {

    String manufacturer;

    public Fiat(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String info() {
        return String.format("Hello World! I'm a new %s.", manufacturer);
    }
}
