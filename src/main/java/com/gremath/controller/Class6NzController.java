package com.gremath.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Old Year 6 “standards” page. Year 6 now sits in the same year/subject grid as every other year.
 */
@Controller
public class Class6NzController {

    @GetMapping("/class6/nz/maths")
    public String year6MathsStandards() {
        return "redirect:/topics/class6-nz-mathematics";
    }
}
