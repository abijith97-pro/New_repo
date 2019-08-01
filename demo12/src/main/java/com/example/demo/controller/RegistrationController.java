package com.example.demo.controller;

import com.example.demo.data.NewConnectionRepository;
import com.example.demo.model.RegistrationForm;
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
@RequestMapping("/registration")

public class RegistrationController {

    @Autowired
    private NewConnectionRepository connectrepo;

    @ModelAttribute
    @GetMapping
    public String show_register(Model model){
        model.addAttribute("registrationForm",new RegistrationForm());
        return "registration";
    }


    @PostMapping
    public String processRegister(@Valid RegistrationForm registrationForm, Errors errors) {
        if (errors.hasErrors()) {
            return "registration";
        }
        connectrepo.save(registrationForm);



        return "registration";
    }
}
