/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.validation.Valid
 *  org.springframework.stereotype.Controller
 *  org.springframework.ui.Model
 *  org.springframework.validation.BindingResult
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.ModelAttribute
 *  org.springframework.web.bind.annotation.PostMapping
 */
package com.gremath.controller;

import com.gremath.dto.RegistrationForm;
import com.gremath.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final StudentService studentService;

    public AuthController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value={"/"})
    public String home() {
        return "index";
    }

    @GetMapping(value={"/login"})
    public String login() {
        return "login";
    }

    @GetMapping(value={"/register"})
    public String registerForm(Model model) {
        if (!model.containsAttribute("registrationForm")) {
            model.addAttribute("registrationForm", (Object)new RegistrationForm());
        }
        return "register";
    }

    @PostMapping(value={"/register"})
    public String register(@Valid @ModelAttribute(value="registrationForm") RegistrationForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        try {
            this.studentService.register(form);
        }
        catch (IllegalArgumentException ex) {
            model.addAttribute("error", (Object)ex.getMessage());
            return "register";
        }
        return "redirect:/login?registered";
    }
}

