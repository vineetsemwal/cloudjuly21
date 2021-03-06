package com.example.customermicroservice.service;

import com.example.customermicroservice.dao.ICustomerRepository;
import com.example.customermicroservice.dto.CreateCustomerRequest;
import com.example.customermicroservice.dto.CustomerDetails;
import com.example.customermicroservice.dto.ProductDetails;
import com.example.customermicroservice.dto.UpdateCustomerRequest;
import com.example.customermicroservice.entities.Customer;
import com.example.customermicroservice.exceptions.CustomerNotFoundException;
import com.example.customermicroservice.util.CustomerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService {
   private static final Logger Log= LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private ICustomerRepository customerRepo;

    @Autowired
    private CustomerUtil customerUtil;

    /**
     * at the start customer has not bought any product so products null
     *
     * @param request
     * @return
     */
    @Override
    public CustomerDetails add(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        LocalDate today=LocalDate.now();
        customer.setCreatedDate(today);
        customer = customerRepo.save(customer);
        CustomerDetails desired = customerUtil.toDetails(customer, null);
        return desired;
    }



    public Customer findById(Long id) {
        Log.debug("inside findbyid="+id);
        Optional<Customer> optional =customerRepo.findById(id);
        if(!optional.isPresent()){
            throw new CustomerNotFoundException("customer not found for id="+id);
        }
        Customer customer= optional.get();
        return customer;
    }

    @Override
    public CustomerDetails findCustomerDetailsById(Long id) {
        Customer customer = findById(id);
        Set<ProductDetails>details=customerUtil.fetchManyProductDetails(customer.getProducts());
        CustomerDetails desired = customerUtil.toDetails(customer,details);
        return desired;
    }

    @Override
    public CustomerDetails update(UpdateCustomerRequest request) {
        Customer customer = findById(request.getId());
        customer.setName(request.getName());
        customer = customerRepo.save(customer);

        Set<ProductDetails>details=customerUtil.fetchManyProductDetails(customer.getProducts());
        CustomerDetails response = customerUtil.toDetails(customer,details);
        return response;
    }

    @Override
    public void deleteById(Long id) {
        customerRepo.deleteById(id);
    }



    @Override
    public CustomerDetails buyProduct(Long customerId, Long productId) {
      Customer customer = findById(customerId);
      Set<Long> products=customer.getProducts();
      if(products==null){
         products=new HashSet<>();
      }
      products.add(productId);
      customer.setProducts(products);
      customer=customerRepo.save(customer);
      Set<ProductDetails>details=customerUtil.fetchManyProductDetails(products);
      CustomerDetails desired=customerUtil.toDetails(customer,details);
      return desired;
    }

}
