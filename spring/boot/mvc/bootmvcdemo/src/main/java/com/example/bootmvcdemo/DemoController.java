package com.example.bootmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {


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


}
