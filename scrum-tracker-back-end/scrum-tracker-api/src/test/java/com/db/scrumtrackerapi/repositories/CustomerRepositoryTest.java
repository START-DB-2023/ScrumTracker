package com.db.scrumtrackerapi.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.db.scrumtrackerapi.models.Customer;
import com.db.scrumtrackerapi.models.enums.Role;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerRepositoryTest {
    
    @Autowired
    private CustomerRepository customerRepository;

    private Customer expectedCustomer = new Customer("joao@email.com", "João", "Ninguém", "password", Role.ADMIN);  

    @BeforeAll
    void setup () {
        customerRepository.save(expectedCustomer);
    }

    @Test
    @DisplayName("Assert Find By Email Is Working Correctly")
    void assertFindCustomerByEmail() {
        Customer actualCustomer = customerRepository.findByEmail("joao@email.com").get(0);
        assertEquals(expectedCustomer, actualCustomer);
    }
}
