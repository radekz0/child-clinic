package com.spring.childclinic.controllers;

import com.spring.childclinic.service.ParentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/parents")
@Controller
public class ParentController {

    Logger logger = LoggerFactory.getLogger(ParentController.class);
    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        logger.info("logger Inside controller constructor-----------------------------------------------------------------------");
        this.parentService = parentService;
    }

    @GetMapping
    public String listParents(Model model){
        model.addAttribute("parents", parentService.findAll());
        return "parents/index";
    }
}
