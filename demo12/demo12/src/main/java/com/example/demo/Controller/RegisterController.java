package com.example.demo.Controller;
        import com.example.demo.Model.Register;

        import com.example.demo.Model.Register1;
        import com.example.demo.Data.UserCredentialsRepository;
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
        import java.util.List;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegisterController {
    private UserCredentialsRepository userCredentialsRepository;
    @Autowired
    public RegisterController(UserCredentialsRepository userCredentialsRepository) {
        this.userCredentialsRepository = userCredentialsRepository;
    }

    @ModelAttribute
    @GetMapping
    public String show_register(Model model) {
        model.addAttribute("register", new Register());
        return "register";
    }


    @PostMapping
    public String processRegister(@Valid Register register, Errors errors,Model model) {
        if (errors.hasErrors()) {
            return "register";
        } else {
            List<Register1> user = userCredentialsRepository.findByNameAndPassword(register.getName(), register.getPassword());
            if (user.isEmpty()) {
                return "register";
            } else {
             model.addAttribute("user", user);
                return "hey";
            }

            //return "register";
        }
    }
}