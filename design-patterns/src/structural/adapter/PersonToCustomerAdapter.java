package structural.adapter;

public class PersonToCustomerAdapter implements Customer {

    private Person person;

    public PersonToCustomerAdapter(Person person) {
        this.person = person;
    }

    @Override
    public String getFirstName() {
        return this.person.getFullName().split(" ")[0];
    }

    @Override
    public String getLastName() {
        return this.person.getFullName().split(" ")[1];
    }
}
