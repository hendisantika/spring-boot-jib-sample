package id.my.hendisantika.jibsample.controller;

import id.my.hendisantika.jibsample.mock.MockData;
import id.my.hendisantika.jibsample.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jib-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 11/03/25
 * Time: 08.11
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {

    @GetMapping("all")
    public List<Customer> getAllCustomers() throws Exception {
        List<Customer> customerList = MockData.getCustomers();
        return customerList;
    }

    @GetMapping("maleCustomers")
    public List<Customer> getMaleCustomers() throws Exception {
        List<Customer> customerList = MockData.getCustomers();
        Predicate<Customer> customerPredicate = customer -> customer.getGender().equals("Male");

        List<Customer> maleCustomers = customerList.stream()
                .filter(customerPredicate)
                .collect(Collectors.toList());
        return maleCustomers;
    }
}
