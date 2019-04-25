package structural.decorator;

public class Pool extends HouseDecorator {

    public Pool(House house) {
        super(house);
    }

    @Override
    public String description() {
        return super.description() + upgrade();
    }

    private String upgrade() {
        return "[+pool]";
    }
}
