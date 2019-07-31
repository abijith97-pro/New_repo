package com.example.demo.controller;
        import com.example.demo.model.Register;

        import lombok.extern.slf4j.Slf4j;

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
@RequestMapping("/register")
public class RegisterController {



    @ModelAttribute
    @GetMapping
    public String show_register(Model model){
        model.addAttribute("register",new Register());
        return "register";
    }


    @PostMapping
    public String processRegister(@Valid Register register, Errors errors) {
        if (errors.hasErrors()) {
            return "register";
        }


       return "register";
    }
}