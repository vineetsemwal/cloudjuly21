package com.example.customermicroservice.util;

import com.example.customermicroservice.dto.CustomerDetails;
import com.example.customermicroservice.dto.ProductDetails;
import com.example.customermicroservice.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
public class CustomerUtil {

    @Value("${product.baseurl}")
    private String productBaseUrl;

    @Autowired
    private RestTemplate restTemplate;


    public CustomerDetails toDetails(Customer customer,Set<ProductDetails> products) {
        CustomerDetails desired = new CustomerDetails();
        desired.setId(customer.getId());
        desired.setName(customer.getName());
        desired.setProducts(products);
        return desired;
    }



    public Set<ProductDetails>fetchManyProductDetails(Collection<Long>productsId){
        if(productsId==null) {
         return new HashSet<>();
        }
        Set<ProductDetails>set=new HashSet<>();
        for (Long productId:productsId){
           ProductDetails details= fetchProductDetails(productId);
           set.add(details);
        }
        return set;
    }

    /**
     * @Todo correct in integration ,fetch product from product service
     * @param productId
     * @return ProductDetails
     */
    public ProductDetails fetchProductDetails(Long productId){
        ProductDetails details=new ProductDetails();
        details.setId(productId);
        details.setName("samsung");
       return details;
    }

}
