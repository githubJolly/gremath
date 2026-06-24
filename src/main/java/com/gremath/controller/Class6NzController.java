package com.gremath.controller;

import com.gremath.model.Student;
import com.gremath.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class Class6NzController {
    private final StudentService studentService;

    public Class6NzController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/class6/nz/maths")
    public String year6MathsStandards(Principal principal, Model model) {
        if (principal == null) {
            return "redirect:/login";
        }
        Student student = this.studentService.getByUsername(principal.getName());
        if (!this.studentService.hasTrackAccess(student, "class6-nz")) {
            return "redirect:/pricing?required=class6-nz";
        }

        model.addAttribute("strandGroups", buildYear6Strands());
        return "class6-nz-maths";
    }

    private List<StrandGroup> buildYear6Strands() {
        return List.of(
                new StrandGroup(
                        "Number",
                        "Number structures, operations and rational numbers",
                        List.of(
                                new SkillCard("Y6-N-01", "Place value and number order", "Read, write, compare and order whole numbers using base-10 structure.", "Beginner", "[| || |||]", href("c6nz-place-value")),
                                new SkillCard("Y6-N-02", "Rounding and estimation", "Estimate sums, differences, products and quotients for reasonableness checks.", "Beginner", "[10k -> 11k]", href("c6nz-place-value")),
                                new SkillCard("Y6-N-03", "Factor pairs and multiples", "Find factor pairs and use divisibility to solve number problems.", "Intermediate", "[1x24, 2x12...]", href("c6nz-operations")),
                                new SkillCard("Y6-N-04", "Fractions, decimals and percentages", "Convert and compare fractions, decimals and percents in context.", "Intermediate", "[3/4 = 0.75 = 75%]", href("c6nz-fdp")),
                                new SkillCard("Y6-N-05", "Mixed operations and order of operations", "Evaluate expressions with brackets and multiple operations correctly.", "Advanced", "[ ( ) , x, /, +, - ]", href("c6nz-operations"))
                        )
                ),
                new StrandGroup(
                        "Algebra",
                        "Pattern rules, equations and simple coordinate reasoning",
                        List.of(
                                new SkillCard("Y6-A-01", "Number patterns and rules", "Identify and extend growing patterns using words and symbols.", "Beginner", "[+3, +3, +3]", href("c6nz-patterns")),
                                new SkillCard("Y6-A-02", "Open sentences and inequalities", "Check and complete number sentences with unknown values.", "Intermediate", "[x + 7 = 23]", href("c6nz-patterns")),
                                new SkillCard("Y6-A-03", "Two-variable tables", "Use rule tables to describe relationships between quantities.", "Intermediate", "[n -> 2n+1]", href("c6nz-patterns")),
                                new SkillCard("Y6-A-04", "Coordinate grids and pathways", "Plot points, read simple maps and follow coordinate directions.", "Advanced", "[(2,5), (3,7)]", href("c6nz-patterns"))
                        )
                ),
                new StrandGroup(
                        "Measurement",
                        "Length, mass, capacity, time, area, volume and angles",
                        List.of(
                                new SkillCard("Y6-M-01", "Metric unit choice and conversion", "Choose appropriate units and convert between related metric units.", "Beginner", "[km-m-cm-mm]", href("c6nz-measurement")),
                                new SkillCard("Y6-M-02", "Time and elapsed duration", "Convert between 12/24-hour formats and solve elapsed-time tasks.", "Intermediate", "[14:20 -> +95m]", href("c6nz-measurement")),
                                new SkillCard("Y6-M-03", "Area of rectangles and right triangles", "Estimate and calculate area in square units.", "Intermediate", "[A = l x w]", href("c6nz-measurement")),
                                new SkillCard("Y6-M-04", "Volume of prisms", "Find and compare volumes of cubes and rectangular prisms.", "Advanced", "[V = l x w x h]", href("c6nz-measurement")),
                                new SkillCard("Y6-M-05", "Angles and angle relationships", "Measure and reason with angles on lines, at points and in shapes.", "Advanced", "[180 / 360 facts]", href("c6nz-geometry"))
                        )
                ),
                new StrandGroup(
                        "Geometry and Spatial Reasoning",
                        "Shape properties, symmetry, transformations and location",
                        List.of(
                                new SkillCard("Y6-G-01", "Classify 2D and 3D shapes", "Sort shapes by properties such as sides, angles, faces and edges.", "Beginner", "[sides/faces/edges]", href("c6nz-geometry")),
                                new SkillCard("Y6-G-02", "Triangles and quadrilaterals", "Describe and compare special shape families and their properties.", "Intermediate", "[triangle families]", href("c6nz-geometry")),
                                new SkillCard("Y6-G-03", "Lines and rotational symmetry", "Identify reflection lines and rotational symmetry order.", "Intermediate", "[flip + turn]", href("c6nz-geometry")),
                                new SkillCard("Y6-G-04", "Transformations and tessellations", "Use translation, reflection and rotation in pattern reasoning.", "Advanced", "[slide/flip/turn]", href("c6nz-geometry"))
                        )
                ),
                new StrandGroup(
                        "Statistics and Probability",
                        "Data displays, mean/range and chance-based reasoning",
                        List.of(
                                new SkillCard("Y6-S-01", "Read and create data displays", "Work with tables, bar charts, line plots and simple line graphs.", "Beginner", "[||| ||||||]", href("c6nz-data-chance")),
                                new SkillCard("Y6-S-02", "Mean and range in context", "Compute and interpret average and spread for datasets.", "Intermediate", "[mean + range]", href("c6nz-data-chance")),
                                new SkillCard("Y6-S-03", "Interpret trends and comparisons", "Describe patterns in data and justify conclusions from evidence.", "Intermediate", "[up/down trend]", href("c6nz-data-chance")),
                                new SkillCard("Y6-S-04", "Sample space and probability", "List outcomes and estimate probabilities for simple events.", "Advanced", "[fav/total]", href("c6nz-data-chance")),
                                new SkillCard("Y6-S-05", "Experimental probability checks", "Compare predicted and observed probabilities over trials.", "Advanced", "[expected vs observed]", href("c6nz-data-chance"))
                        )
                )
        );
    }

    private String href(String lessonKey) {
        return "/practice/lesson/" + lessonKey;
    }

    public record StrandGroup(String name, String subtitle, List<SkillCard> skills) {
    }

    public record SkillCard(String code, String title, String description, String level, String pattern, String href) {
    }
}

