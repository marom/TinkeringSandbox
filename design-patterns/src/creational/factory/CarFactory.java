package creational.factory;

public class CarFactory {

    public Car produce(CarType carType) {

        Car car = null;

        switch (carType) {
            case AUDI:
                car = new Audi(carType.name());
                break;
            case BMW:
                car = new BMW(carType.name());
                break;
            case FIAT:
                car = new Fiat(carType.name());
                break;
            default:
                break;
        }
        return car;
        }
    }

