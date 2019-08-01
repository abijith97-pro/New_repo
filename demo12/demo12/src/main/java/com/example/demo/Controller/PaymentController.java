package com.example.demo.Controller;


import com.example.demo.Data.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/payment")
public class PaymentController {
    private PaymentRepository userCredentialsRepository;
    @Autowired
    public PaymentController(PaymentRepository userCredentialsRepository){
        this.userCredentialsRepository = userCredentialsRepository;
    }
    @ModelAttribute(name = "register")
    public com.example.demo.Model.Payment register(){
        return new com.example.demo.Model.Payment();
    }
   /* @GetMapping
    public String showRegistrationForm(Model model){
        prepaid userCredentials = new prepaid();
        model.addAttribute("userCredentials",userCredentials);
        return "customerRegister";
    }
    /*public String show_register(Model model){
         List<Register> mylist= Arrays.asList(
                 new register("varnika",999,"varnika@gmail.com","****")
         );
         model.addAttribute("account",mylist);

         return "register";

     }*/
    @ModelAttribute
    @GetMapping
    public String show_register(Model model){
        model.addAttribute("payment",new com.example.demo.Model.Payment());
        return "payment";
    }
/*
@GetMapping("/register")
public String showRegister(){
    return "register";
}
*/

    @PostMapping
    public String processRegister(@Valid com.example.demo.Model.Payment payment, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "payment";
        }
        else{
            userCredentialsRepository.save(payment);
            model.addAttribute("showDetails",payment);
            return "success";
        }

        // Save the taco design...
        // We'll do this in chapter 3
        /* log.info("Processing design: " + register);*/

        //return "success";
    }
}
