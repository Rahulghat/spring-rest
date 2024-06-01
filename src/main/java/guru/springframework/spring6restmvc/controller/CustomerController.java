package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Customer;
import guru.springframework.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/custs")
public class CustomerController {
    private CustomerService customerService;

    @PostMapping("/v1/custs" )
    public ResponseEntity saveCustomer(Customer customer){
        Customer savedCustomer = customerService.saveCustomer(customer);
        HttpHeaders header = new HttpHeaders();
        header.add("Location","/v1/custs"+ savedCustomer.getId().toString() );
        return new ResponseEntity(header,HttpStatus.CREATED);

    }
    @RequestMapping("/v1/custs")
    public List<Customer> getCustomer() {
        return this.customerService.getCustomers();
    }

    @RequestMapping("/v1/cust/{id}")
    public Customer getCustomer(@PathVariable("id") UUID id){
        Customer customer = this.customerService.getCustomer(id);
        return customer;
    }
}
