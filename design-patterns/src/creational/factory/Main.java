package creational.factory;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<Car>();
        CarFactory carFactory = new CarFactory();
        cars.add(carFactory.produce(CarType.AUDI));
        cars.add(carFactory.produce(CarType.BMW));
        cars.add(carFactory.produce(CarType.FIAT));

        for(Car c: cars){
            System.out.println(c.info());
        }
    }
}
