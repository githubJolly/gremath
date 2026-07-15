package com.gremath.controller;

import com.gremath.model.Student;
import com.gremath.service.StudentService;
import com.gremath.service.StripeCheckoutService;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BillingController {
    private final StudentService studentService;
    private final StripeCheckoutService stripeCheckoutService;

    public BillingController(StudentService studentService, StripeCheckoutService stripeCheckoutService) {
        this.studentService = studentService;
        this.stripeCheckoutService = stripeCheckoutService;
    }

    @GetMapping("/pricing")
    public String pricing(@RequestParam(name = "required", required = false) String required, Principal principal, Model model) {
        model.addAttribute("required", required);
        model.addAttribute("trialDays", StudentService.NZ_TRIAL_DAYS);
        if (principal != null) {
            Student student = this.studentService.getByUsername(principal.getName());
            model.addAttribute("student", student);
            model.addAttribute("onTrial", student.hasActiveNzTrial() && !student.hasPaidNzSubscription());
            model.addAttribute("trialUntil", student.getNzTrialUntil());
            model.addAttribute("hasPaidNz", student.hasPaidNzSubscription());
        }
        return "pricing";
    }

    @GetMapping("/billing/checkout")
    public String checkout(@RequestParam(name = "plan", required = false, defaultValue = "class6-nz") String plan,
                           @RequestParam(name = "cancelled", required = false, defaultValue = "0") int cancelled,
                           Principal principal,
                           Model model) {
        // GRE/CAT hidden — NZ curriculum is the only public plan
        String normalized = "class6-nz";
        Student student = this.studentService.getByUsername(principal.getName());
        model.addAttribute("student", student);
        model.addAttribute("plan", normalized);
        model.addAttribute("planLabel", "NZ Curriculum (all years & subjects)");
        model.addAttribute("amount", 10);
        model.addAttribute("trialDays", StudentService.NZ_TRIAL_DAYS);
        model.addAttribute("onTrial", student.hasActiveNzTrial() && !student.hasPaidNzSubscription());
        model.addAttribute("trialUntil", student.getNzTrialUntil());
        model.addAttribute("cancelled", cancelled == 1);
        return "checkout";
    }

    @PostMapping("/billing/checkout")
    public String processCheckout(@RequestParam String plan,
                                  Principal principal,
                                  Model model) {
        String normalized = "class6-nz";
        Student student = this.studentService.getByUsername(principal.getName());
        try {
            String checkoutUrl = this.stripeCheckoutService.createCheckoutSession(student, normalized);
            return "redirect:" + checkoutUrl;
        } catch (IllegalStateException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("plan", normalized);
            model.addAttribute("planLabel", "NZ Curriculum (all years & subjects)");
            model.addAttribute("amount", 10);
            model.addAttribute("trialDays", StudentService.NZ_TRIAL_DAYS);
            model.addAttribute("student", student);
            return "checkout";
        }
    }

    @GetMapping("/billing/success")
    public String checkoutSuccess(@RequestParam(name = "session_id") String sessionId, Principal principal, Model model) {
        Student student = this.studentService.getByUsername(principal.getName());
        StripeCheckoutService.CheckoutSession session = this.stripeCheckoutService.retrieveCheckoutSession(sessionId);
        if (!String.valueOf(student.getId()).equals(session.clientReferenceId())) {
            throw new IllegalStateException("Stripe session does not belong to the logged-in student.");
        }
        if (!"paid".equals(session.paymentStatus())) {
            model.addAttribute("error", "Stripe payment is not marked as paid yet. Please try again after payment completes.");
            model.addAttribute("plan", "class6-nz");
            model.addAttribute("planLabel", "NZ Curriculum (all years & subjects)");
            model.addAttribute("amount", 10);
            model.addAttribute("trialDays", StudentService.NZ_TRIAL_DAYS);
            model.addAttribute("student", student);
            return "checkout";
        }
        LocalDate until = this.studentService.activateMonthlySubscription(student, "class6-nz");
        return "redirect:/dashboard?track=class6-nz&paid=1&until=" + until;
    }

    @PostMapping("/billing/webhook/stripe")
    public ResponseEntity<String> stripeWebhook(@RequestBody String payload,
                                                @RequestHeader(name = "Stripe-Signature", required = false) String signatureHeader) {
        if (!this.stripeCheckoutService.isValidWebhookSignature(payload, signatureHeader)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Stripe signature");
        }

        Map<String, Object> event = this.stripeCheckoutService.parsePayload(payload);
        if (this.stripeCheckoutService.isCheckoutCompletedEvent(event)) {
            StripeCheckoutService.CheckoutSession session = this.stripeCheckoutService.sessionFromWebhookEvent(event);
            if ("paid".equals(session.paymentStatus())) {
                Student student = this.studentService.getById(Long.parseLong(session.clientReferenceId()));
                this.studentService.activateMonthlySubscription(student, "class6-nz");
            }
        }
        return ResponseEntity.ok("ok");
    }
}
