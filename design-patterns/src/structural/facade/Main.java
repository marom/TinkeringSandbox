package structural.facade;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("Jack Smith");

        FacadeService service = new FacadeService();
        service.setServiceForCustomer(customer);
    }
}
