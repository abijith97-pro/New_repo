package com.example.demo.Controller;

import com.example.demo.Data.DongleRepo;
import com.example.demo.Data.OrderRepo;
import com.example.demo.Model.Dongle;
import com.example.demo.Model.Order;
import com.example.demo.Model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dongle")
public class DongleController {
    @Autowired
    private DongleRepo donglerepo;
    @Autowired
    private OrderRepo orderRepo;
    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "design")
    public Dongle design() {
        return new Dongle("plan","300","234");
    }
    @GetMapping
    public String show_register(Model model){
        List<Dongle> plans = new ArrayList<>();
        donglerepo.findAll().forEach(i -> plans.add(i));
        model.addAttribute("plans",plans);
        return "dongle";
    }
    @PostMapping
    public String processDesign(
            @Valid Order order, Errors errors,
            @ModelAttribute Dongle dongles) {



        Order saved = orderRepo.save(order);

        return "dongle";
    }

}
