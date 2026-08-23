package com.gremath.controller;

import com.gremath.config.LoginFailureHandler;
import com.gremath.dto.RegistrationForm;
import com.gremath.service.StudentService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    private final StudentService studentService;

    public AuthController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "unverified", required = false) String unverified,
                        HttpSession session,
                        Model model) {
        Object savedUser = session.getAttribute(LoginFailureHandler.LAST_USERNAME);
        if (savedUser != null) {
            model.addAttribute("loginUsername", savedUser);
            session.removeAttribute(LoginFailureHandler.LAST_USERNAME);
        }
        String reason = unverified != null ? "unverified" : error;
        model.addAttribute("loginError", LoginFailureHandler.messageFor(reason));
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        if (!model.containsAttribute("registrationForm")) {
            model.addAttribute("registrationForm", new RegistrationForm());
        }
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("registrationForm") RegistrationForm form,
                           BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        try {
            this.studentService.register(form);
        } catch (IllegalArgumentException ex) {
            model.addAttribute("error", ex.getMessage());
            return "register";
        }
        String email = URLEncoder.encode(form.getEmail(), StandardCharsets.UTF_8);
        return "redirect:/check-email?email=" + email;
    }

    @GetMapping("/check-email")
    public String checkEmail(@RequestParam(value = "email", required = false) String email, Model model) {
        model.addAttribute("email", email);
        return "check-email";
    }

    @GetMapping("/verify-email")
    public String verifyEmail(@RequestParam(value = "token", required = false) String token) {
        if (this.studentService.verifyEmail(token)) {
            return "redirect:/login?verified";
        }
        return "redirect:/login?verifyFailed";
    }
}
