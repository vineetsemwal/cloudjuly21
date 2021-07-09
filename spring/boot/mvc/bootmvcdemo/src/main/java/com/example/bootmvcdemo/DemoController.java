package com.example.bootmvcdemo;

import com.example.bootmvcdemo.entities.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DemoController {

    private Map<Long, Customer>map = new HashMap<>();

    public DemoController(){
        Customer customer1=new Customer();
        customer1.setId(1l);
        customer1.setName("abhro");
        map.put(1l, customer1);

        Customer customer2=new Customer();
        customer2.setId(2l);
        customer2.setName("kalyan");
        map.put(2l, customer2);


        Customer customer3=new Customer();
        customer3.setId(2l);
        customer3.setName("hemant");
        map.put(3l, customer3);
    }

    @GetMapping("/welcome")
    public ModelAndView welcome(){
          ModelAndView response = new ModelAndView("demo");
          return response;
    }

    @GetMapping("/hello")
    public ModelAndView hello(){
        String message="hello gcp batch";
        ModelAndView response = new ModelAndView("hellomsg","msg" , message);
        return response;
    }

    @GetMapping("/customerprofile")
    public ModelAndView customerInfo(@RequestParam("id") long id){
        Customer customer= map.get(id);
        ModelAndView response=new ModelAndView("customerprofile","customer",customer);
        return response;
    }

    @GetMapping("/getprofile")
    public ModelAndView getCustomerProfile() {
        ModelAndView response=new ModelAndView("getprofile");
        return response;
    }

    }
