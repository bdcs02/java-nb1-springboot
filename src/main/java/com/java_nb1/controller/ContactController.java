package com.java_nb1.controller;

import com.java_nb1.model.ContactFormModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = {"/contact"})
public class ContactController {

    @GetMapping("/contact")
    public String contactForm(Model model) { // Model model: Dependency injection
        model.addAttribute("attr1", new ContactFormModel());
        return "contactView";
    }
    @PostMapping("/contactResult")
    // MessageClass messageClass, Model model: Dependency injection
    public String contactSubmit(@ModelAttribute ContactFormModel uzenetOsztaly, Model model) {
        model.addAttribute("attr2", uzenetOsztaly);
        return "contactResultView";
    }
}
