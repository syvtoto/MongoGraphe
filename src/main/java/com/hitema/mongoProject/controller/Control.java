package com.hitema.mongoProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/index")
public class Control {

    @GetMapping("/index")
    public String index(@RequestParam(name="name", required = false, defaultValue = "World")String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
	
}
