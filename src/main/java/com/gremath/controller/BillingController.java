package com.gremath.controller;

import com.gremath.model.Student;
import com.gremath.service.StudentService;
import java.security.Principal;
import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BillingController {
    private final StudentService studentService;

    public BillingController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/pricing")
    public String pricing(@RequestParam(name="required", required=false) String required, Principal principal, Model model) {
        model.addAttribute("required", required);
        if (principal != null) {
            Student student = this.studentService.getByUsername(principal.getName());
            model.addAttribute("student", student);
        }
        return "pricing";
    }

    @GetMapping("/billing/checkout")
    public String checkout(@RequestParam(name="plan", required=false, defaultValue="gre-cat") String plan, Principal principal, Model model) {
        String normalized = "class6-nz".equalsIgnoreCase(plan) ? "class6-nz" : "gre-cat";
        Student student = this.studentService.getByUsername(principal.getName());
        model.addAttribute("student", student);
        model.addAttribute("plan", normalized);
        model.addAttribute("planLabel", "class6-nz".equals(normalized) ? "Class 6 (New Zealand Curriculum)" : "GRE/CAT Track");
        model.addAttribute("amount", "class6-nz".equals(normalized) ? 10 : 20);
        return "checkout";
    }

    @PostMapping("/billing/checkout")
    public String processCheckout(@RequestParam String plan,
                                  @RequestParam String cardName,
                                  @RequestParam String cardNumber,
                                  @RequestParam String expiry,
                                  @RequestParam String cvv,
                                  Principal principal,
                                  Model model) {
        String normalized = "class6-nz".equalsIgnoreCase(plan) ? "class6-nz" : "gre-cat";
        if (cardName.isBlank() || cardNumber.replaceAll("\\s+", "").length() < 12 || expiry.isBlank() || cvv.length() < 3) {
            model.addAttribute("error", "Please enter valid payment details.");
            model.addAttribute("plan", normalized);
            model.addAttribute("planLabel", "class6-nz".equals(normalized) ? "Class 6 (New Zealand Curriculum)" : "GRE/CAT Track");
            model.addAttribute("amount", "class6-nz".equals(normalized) ? 10 : 20);
            model.addAttribute("student", this.studentService.getByUsername(principal.getName()));
            return "checkout";
        }

        Student student = this.studentService.getByUsername(principal.getName());
        LocalDate until = this.studentService.activateMonthlySubscription(student, normalized);
        String track = "class6-nz".equals(normalized) ? "class6-nz" : "gre-cat";
        return "redirect:/dashboard?track=" + track + "&paid=1&until=" + until;
    }
}

