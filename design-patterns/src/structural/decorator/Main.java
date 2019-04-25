package structural.decorator;

public class Main {


    public static void main(String[] args) {

        House house = new SimpleHouse();

        System.out.println("--- pay more ---");

        house = new Garden(house);
        System.out.println(house.description());

        System.out.println("--- pay more ---");

        house = new Pool(house);
        System.out.println(house.description());

        System.out.println("=== Another Person ===");

        House newHouse = new SimpleHouse();
        System.out.println("--- pay more ---");

        newHouse = new Pool(newHouse);
        System.out.println(newHouse.description());
    }
}
