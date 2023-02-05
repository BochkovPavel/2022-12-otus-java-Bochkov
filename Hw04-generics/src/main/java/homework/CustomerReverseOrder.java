package homework;


import java.util.LinkedList;

public class CustomerReverseOrder {

    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"
    private LinkedList<Customer> customerStack = new LinkedList<>();

    public void add(Customer customer) {
        customerStack.push(customer);
    }

    public Customer take() {
        return customerStack.pop();
    }
}
