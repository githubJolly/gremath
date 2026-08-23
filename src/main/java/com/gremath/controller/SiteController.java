package com.gremath.controller;

import com.gremath.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SiteController {
    private final EmailService emailService;

    public SiteController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping({"/games/murder-mystery", "/games/mystery-quiz"})
    public String retiredQuiz() {
        return "redirect:/";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/how-it-works")
    public String howItWorks() {
        return "how-it-works";
    }

    @GetMapping("/privacy")
    public String privacy() {
        return "privacy";
    }

    @GetMapping("/terms")
    public String terms() {
        return "terms";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/contact")
    public String sendContact(@RequestParam(name = "name", required = false) String name,
                              @RequestParam(name = "email", required = false) String email,
                              @RequestParam(name = "message", required = false) String message,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        if (email == null || email.isBlank() || message == null || message.isBlank()) {
            model.addAttribute("error", "Please include your email and a short message.");
            model.addAttribute("name", name);
            model.addAttribute("email", email);
            model.addAttribute("message", message);
            return "contact";
        }
        this.emailService.sendContactEmail(name, email.trim(), message.trim());
        redirectAttributes.addFlashAttribute("sent", true);
        return "redirect:/contact";
    }
}
