package structural.decorator;

public class Garden extends HouseDecorator {

    public Garden(House house) {
        super(house);
    }

    @Override
    public String description() {
        return super.description() + upgrade();
    }

    private String upgrade() {
        return "[+garden]";
    }
}
