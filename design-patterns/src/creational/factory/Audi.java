package creational.factory;

public class Audi implements Car {

    String manufacturer;

    public Audi(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String info() {
        return String.format("Hello World! I'm a new %s.", manufacturer);
    }
}
