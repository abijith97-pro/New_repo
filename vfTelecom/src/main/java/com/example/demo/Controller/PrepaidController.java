package com.example.demo.Controller;


import com.example.demo.Data.UserCredentialsRepository;
import com.example.demo.Model.Prepaid;
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
@RequestMapping("/prepaid")
public class PrepaidController {
    private UserCredentialsRepository userCredentialsRepository;
    @Autowired
    public PrepaidController(UserCredentialsRepository userCredentialsRepository){
        this.userCredentialsRepository = userCredentialsRepository;
    }
    @ModelAttribute(name = "register")
    public Prepaid register(){
        return new Prepaid();
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
        model.addAttribute("prepaid",new Prepaid());
        return "prepaid";
    }
/*
@GetMapping("/register")
public String showRegister(){
    return "register";
}
*/

    @PostMapping
    public String processRegister(@Valid Prepaid prepaid, Errors errors,Model model) {
        if (errors.hasErrors()) {
            return "prepaid";
        }
        else{
            userCredentialsRepository.save(prepaid);
            model.addAttribute("showDetails",prepaid);
            return "success";
        }

        // Save the taco design...
        // We'll do this in chapter 3
        /* log.info("Processing design: " + register);*/

        //return "success";
    }
}
