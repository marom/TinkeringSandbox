package structural.adapter;

public class Main {

    public static void main(String[] args) {

        Person person = new Person("Jack Smith");

        Customer adapter = new PersonToCustomerAdapter(person);

        System.out.println(person);
        System.out.println("--- Customer Information ---");
        System.out.println("First Name: " + adapter.getFirstName() + " | Last Name: " + adapter.getLastName());
    }
}
