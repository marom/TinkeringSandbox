package structural.facade;

public class Consultation implements CustomerService {

    @Override
    public void serve(String name) {
        System.out.println("Consultation for customer: " + name);
    }
}


