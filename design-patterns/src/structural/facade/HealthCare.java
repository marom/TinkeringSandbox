package structural.facade;

public class HealthCare implements CustomerService {

    @Override
    public void serve(String name) {
        System.out.println("Healthcare for customer: " + name);
    }
}
