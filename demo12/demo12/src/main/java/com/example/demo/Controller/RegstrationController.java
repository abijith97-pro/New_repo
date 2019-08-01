package com.example.demo.Controller;

import com.example.demo.Data.Registrationrepo;
import com.example.demo.Model.Registration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/registration")
@SessionAttributes("registration")
public class RegstrationController {
    private Registrationrepo registrationrepo;

    @Autowired
    public RegstrationController(Registrationrepo registrationrepo)
    {
        this.registrationrepo = registrationrepo;
    }
    @ModelAttribute(name="registration")
    public Registration register()
    {
        return new Registration();
    }
    @GetMapping
    public String show_register(Model model){
        model.addAttribute("registration",new Registration());
        return "registration";
    }
/*
@GetMapping("/register")
public String showRegister(){
    return "register";
}
*/

    @PostMapping
    public String processRegister(@Valid Registration registration, Errors errors,Model model) {
        if (errors.hasErrors()) {
            return "registration";
        }
        else
        {
            registrationrepo.save(registration);

            return "result";
        }

        // Save the taco design...
        // We'll do this in chapter 3
        /* log.info("Processing design: " + register);*/


    }
}
