package com.db.scrumtrackerapi.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.db.scrumtrackerapi.model.Customer;
import com.db.scrumtrackerapi.model.view.CustomerView;
import com.db.scrumtrackerapi.services.impl.CustomerService;

/**
 * Controller class for handling customer-related HTTP requests.
 *
 * <p>This controller provides endpoints for retrieving customer information.
 * The primary endpoint is designed to retrieve a customer by their email address.
 * The responses are formatted as JSON objects.
 *
 * <p> The base URL path for all endpoints defined in this controller is ("/customer").
 */
@RestController
public class CustomerController {
    
    /**
     * Service class responsible for business logic related to customers.
     */
    @Autowired
    CustomerService customerService;

    /**
     * Retrieves a customer by their email address.
     *
     * <p> This method handles HTTP GET requests for the specified endpoint ("/customer").
     *
     * @param email The email address of the customer to retrieve, it is provided as a 
     * query parameter in the request.
     * 
     * @return ResponseEntity containing the customer information in the response body
     * if the customer is found, or a 404 NOT_FOUND status if the customer is not found.
     */
    @RequestMapping(value="/customer", method=RequestMethod.GET)
    public ResponseEntity<CustomerView> getCustomerByEmail(@RequestParam("email") String email) {
        Optional<Customer> customer = customerService.findByEmail(email);
        if (customer.isPresent()) {
            CustomerView customerView = customer.get().toView();
            return new ResponseEntity<>(customerView, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
