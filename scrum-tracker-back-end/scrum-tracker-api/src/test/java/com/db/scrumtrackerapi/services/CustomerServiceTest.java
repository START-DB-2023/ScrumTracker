package com.db.scrumtrackerapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.db.scrumtrackerapi.models.Customer;
import com.db.scrumtrackerapi.models.enums.Role;
import com.db.scrumtrackerapi.repositories.CustomerRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    
    @Autowired
    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    private Customer expectedCustomer;

    private String email;

    @BeforeEach
    void setUp() {
        email = "joao@email.com";
        expectedCustomer = new Customer(email,"Joao","Ninguem","letmein123",Role.ADMIN);  
    }

    @Test
    @DisplayName("Assert Customer Service Invokes Customer Repository save Correctly")
    public void assertSaveInvokesCorrectMethod() {
        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        customerService.save(expectedCustomer);

        verify(customerRepository).save(customerArgumentCaptor.capture());
        Customer actualCustomer = customerArgumentCaptor.getValue();
        assertEquals(expectedCustomer, actualCustomer);
    }

    @Test
    @DisplayName("Assert Customer Service Invokes Customer Repository findByEmail Correctly")
    public void testFindByEmail(){
        when(customerRepository.findByEmail(eq(email))).thenReturn(List.of(expectedCustomer));

        Customer actualCustomer = customerService.findByEmail(email);
        assertEquals(expectedCustomer, actualCustomer);
    }

}
