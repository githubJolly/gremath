package com.gremath.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    @GetMapping("/games/murder-mystery")
    public String murderMysteryQuiz() {
        return "murder-mystery-quiz";
    }
}

