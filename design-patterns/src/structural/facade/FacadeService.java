package structural.facade;

public class FacadeService {


    private Consultation consultation;
    private HealthCare healthCare;

    public FacadeService() {
        consultation = new Consultation();
        healthCare = new HealthCare();
    }

    public void setServiceForCustomer(Customer customer) {
        registerCustomer(customer.getName());
        consultation.serve(customer.getName());
        healthCare.serve(customer.getName());
    }

    private void registerCustomer(String name) {
        System.out.println("register for customer: " + name);
    }
}
