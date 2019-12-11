package com.spring.childclinic.controllers;

import com.spring.childclinic.service.ParentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/parents")
@Controller
public class ParentController {

    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @RequestMapping({"", "/"})
    public String listParents(Model model){
        System.out.println("inside parent controller");
        model.addAttribute("parents", parentService.findAll());
        System.out.println("inside parent controller");
        return "parents/index";
    }
}
