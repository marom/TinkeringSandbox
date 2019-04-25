package structural.decorator;

public class SimpleHouse implements House {

    public SimpleHouse() {
        System.out.println("buy a house");
    }

    @Override
    public String description() {
        return "House";
    }
}
