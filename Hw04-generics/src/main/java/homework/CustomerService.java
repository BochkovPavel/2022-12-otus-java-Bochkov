package homework;


import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    TreeMap<Customer, String> customerServiceTreeMap = new TreeMap<>(Comparator.comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        return copyCustomerServiceTreeMap(customerServiceTreeMap.firstEntry());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return copyCustomerServiceTreeMap(customerServiceTreeMap.higherEntry(customer));
    }

    public void add(Customer customer, String data) {
        customerServiceTreeMap.put(customer, data);
    }

    private Map.Entry<Customer, String> copyCustomerServiceTreeMap(Map.Entry<Customer, String> copy) {
        if (copy == null) return null;
        CustomerService customerService = new CustomerService();
        customerService.add(new Customer(copy.getKey().getId(), copy.getKey().getName(), copy.getKey().getScores()), copy.getValue());
        return customerService.customerServiceTreeMap.firstEntry();
    }
}
