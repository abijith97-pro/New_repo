package com.example.demo.Controller;

import com.example.demo.Data.PrepaidPlanRepo;
import com.example.demo.model.PrepaidPlan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/prepaid")
public class PrepaidPlanController {
    @Autowired
    private PrepaidPlanRepo prerepo;
    @GetMapping
    public String show_register(Model model){
        List<PrepaidPlan> plans = new ArrayList<>();
        prerepo.findAll().forEach(i -> plans.add(i));
        model.addAttribute("plans",plans);
        return "prepaid";
    }
}
