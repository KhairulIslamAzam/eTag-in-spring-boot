package com.example.eTag.controller;

import com.example.eTag.domain.Customer;
import com.example.eTag.service.CustomerSerive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Khairul Islam Azam
 * @since 1.0
 */
@RestController
@Slf4j
public class EtagFilterController {

    private final CustomerSerive customerSerive;

    public EtagFilterController(CustomerSerive customerSerive) {
        this.customerSerive = customerSerive;
    }

    @PostMapping("/save")
    public void saveCustomer(@RequestBody Customer customer) {
        String message;
        message = customerSerive.saveCustomer(customer);
        log.info(" customer {} is {}  ", customer, message);
    }

    @GetMapping("/list-customer")
    public List<Customer> getWithoutEtagInfo() {
        return customerSerive.customerList();
    }

    @GetMapping("/noEtag")
    public String noEtag(){
        return "this mapping is without eTag";
    }

    @GetMapping("/OwnEtag")
    public ResponseEntity<String> getOwnEtagInfo(@RequestParam("name") String name) {
        return ResponseEntity.ok().eTag(name).body("Own Etag config " + name);

    }
}
