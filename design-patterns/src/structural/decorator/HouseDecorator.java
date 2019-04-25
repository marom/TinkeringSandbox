package structural.decorator;

public abstract class HouseDecorator implements House{

    protected House house;

    public HouseDecorator(House house) {
        this.house = house;
    }

    @Override
    public String description() {
        return this.house.description();
    }
}
