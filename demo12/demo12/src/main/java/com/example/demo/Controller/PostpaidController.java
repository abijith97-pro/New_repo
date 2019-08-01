package com.example.demo.Controller;


import com.example.demo.Data.PostRepo;

import com.example.demo.Model.PostPaid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/postpaid")
public class PostpaidController {
    @Autowired
    private PostRepo postrepo;
    @GetMapping
    public String show_register(Model model){
        List<PostPaid> preplans = new ArrayList<>();
        postrepo.findAll().forEach(i -> preplans.add(i));
        model.addAttribute("plans",preplans);
        return "postpaid";
    }
}
