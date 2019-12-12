package com.spring.childclinic.controllers;

import com.spring.childclinic.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/doctors")
@Controller
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public String listDoctors(Model model){
        System.out.println("Inside doctor controller");
        model.addAttribute("doctors",doctorService.findAll());
        return "doctors/index";
    }
}
