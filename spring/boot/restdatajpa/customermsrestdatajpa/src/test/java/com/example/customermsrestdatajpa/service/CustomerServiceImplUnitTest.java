package com.example.customermsrestdatajpa.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.customermsrestdatajpa.dao.ICustomerRepository;
import com.example.customermsrestdatajpa.entities.Customer;
import com.example.customermsrestdatajpa.exceptions.CustomerNotFoundException;
import com.example.customermsrestdatajpa.util.CustomerUtil;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplUnitTest {

   @Mock
   ICustomerRepository repository;

   @Mock
   CustomerUtil customerUtil;

   @InjectMocks
   @Spy
   CustomerServiceImpl service;

    /**
     * scenairo : customer found
     *
     */
   @Test
   public void testFindById_1(){
       long id=10;
       Customer customer=mock(Customer.class);
       Optional<Customer>optional=Optional.of(customer);
       when(repository.findById(id)).thenReturn(optional);
       Customer result=service.findById(id);
       assertEquals(customer,result);
       verify(repository).findById(id);
   }

    /**
     * scenairo : customer Not found
       expectation : CustomerNotFoundException is thrown
     *
     */
    @Test
    public void testFindById_2(){
        long id=10;
         Executable executable=()->{
             Optional<Customer>optional=Optional.empty();
             when(repository.findById(id)).thenReturn(optional);
             service.findById(id);
         };

        assertThrows(CustomerNotFoundException.class, executable);

    }

}
