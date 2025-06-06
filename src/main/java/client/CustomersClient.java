package client;

import configuration.FeignConfig;
import models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

// Feign client for Customers Service (via ALB)
@FeignClient(name = "customers-service", url = "http://internal-bookstore-dev-InternalALB-178925506.us-east-1.elb.amazonaws.com:3000/customers", configuration = FeignConfig.class)
public interface CustomersClient {

    @PostMapping
    Object addCustomer(Customer customer);

    @GetMapping("/{id}")
    Object getCustomerById(@PathVariable("id") Long id);

    @GetMapping
    Object getCustomerByUserId(@RequestParam("userId") String userId);

    @GetMapping("/status")
    Object getStatus();
}
