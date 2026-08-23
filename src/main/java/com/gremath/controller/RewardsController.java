package com.gremath.controller;

import com.gremath.model.Student;
import com.gremath.reward.Goodie;
import com.gremath.reward.GoodieCatalog;
import com.gremath.service.RewardService;
import com.gremath.service.StudentService;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RewardsController {
    private final StudentService studentService;
    private final RewardService rewardService;

    public RewardsController(StudentService studentService, RewardService rewardService) {
        this.studentService = studentService;
        this.rewardService = rewardService;
    }

    @GetMapping("/rewards")
    public String shop(Principal principal, Model model,
                       @RequestParam(name = "msg", required = false) String msg) {
        Student student = this.rewardService.reload(this.studentService.getByUsername(principal.getName()));
        Map<Goodie, Boolean> owned = new LinkedHashMap<>();
        for (Goodie g : GoodieCatalog.all()) {
            owned.put(g, student.hasGoodie(g.id()));
        }
        model.addAttribute("student", student);
        model.addAttribute("owned", owned);
        model.addAttribute("goodies", GoodieCatalog.all());
        model.addAttribute("msg", msg);
        model.addAttribute("titleName", equippedName(student.getEquippedTitle()));
        model.addAttribute("petName", equippedName(student.getEquippedPet()));
        model.addAttribute("hatName", equippedName(student.getEquippedHat()));
        return "rewards";
    }

    @PostMapping("/rewards/buy")
    public String buy(@RequestParam String id, Principal principal, RedirectAttributes redirect) {
        Student student = this.studentService.getByUsername(principal.getName());
        redirect.addAttribute("msg", this.rewardService.buy(student, id));
        return "redirect:/rewards";
    }

    @PostMapping("/rewards/equip")
    public String equip(@RequestParam String id, Principal principal, RedirectAttributes redirect) {
        Student student = this.studentService.getByUsername(principal.getName());
        this.rewardService.equip(student, id);
        redirect.addAttribute("msg", "Equipped!");
        return "redirect:/rewards";
    }

    private static String equippedName(String id) {
        return GoodieCatalog.find(id).map(g -> g.emoji() + " " + g.name()).orElse("—");
    }
}
