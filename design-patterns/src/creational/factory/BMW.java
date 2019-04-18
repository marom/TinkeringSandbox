package creational.factory;

public class BMW implements Car {

    String manufacturer;

    public BMW(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String info() {
        return String.format("Hello World! I'm a new %s.", manufacturer);
    }
}
