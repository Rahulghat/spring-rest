package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {


    private Map<UUID, Customer> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();
        Customer cust1 = Customer.builder().id(UUID.randomUUID()).customerName("Fisrt Customer").version("0.1").createdDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).build();
        Customer cust2 = Customer.builder().id(UUID.randomUUID()).customerName("second Customer").version("0.1").createdDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).build();
        Customer cust3 = Customer.builder().id(UUID.randomUUID()).customerName("third Customer").version("0.1").createdDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).build();
        Customer cust4 = Customer.builder().id(UUID.randomUUID()).customerName("Forth Customer").version("0.1").createdDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).build();
        this.customerMap.put(cust1.getId(), cust1);
        this.customerMap.put(cust2.getId(), cust2);
        this.customerMap.put(cust3.getId(), cust3);
        this.customerMap.put(cust4.getId(), cust4);
    }

    @Override
    public List<Customer> getCustomers() {
        return new ArrayList<>(this.customerMap.values());
    }

    @Override
    public Customer getCustomer(UUID id) {
        return this.customerMap.get(id);
    }
}
