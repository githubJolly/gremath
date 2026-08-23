package com.gremath.controller;

import com.gremath.curriculum.NzCurriculumMap;
import com.gremath.dto.ParentProgressSnapshot;
import com.gremath.model.Student;
import com.gremath.service.ParentProgressService;
import com.gremath.service.PracticeService;
import com.gremath.service.SheetPracticeService;
import com.gremath.config.LoginFailureHandler;
import com.gremath.service.StudentDetailsService;
import com.gremath.service.StudentService;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = DashboardController.class)
@AutoConfigureMockMvc
class DashboardPageTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;
    @MockBean
    private PracticeService practiceService;
    @MockBean
    private SheetPracticeService sheetPracticeService;
    @MockBean
    private ParentProgressService parentProgressService;
    @MockBean
    private StudentDetailsService studentDetailsService;
    @MockBean
    private LoginFailureHandler loginFailureHandler;

    @Test
    @WithMockUser(username = "family")
    void dashboardRendersAfterLogin() throws Exception {
        Student student = new Student();
        student.setUsername("family");
        student.setFullName("Aria");
        student.setEmail("aria@example.com");
        student.setParentEmail("parent@example.com");
        student.setParentNotifyEnabled(true);
        student.setNzTrialUsed(true);
        student.setNzTrialUntil(LocalDate.now().plusDays(2));

        when(this.studentService.getByUsername("family")).thenReturn(student);
        when(this.studentService.hasTrackAccess(eq(student), eq("class6-nz"))).thenReturn(true);
        when(this.practiceService.getHistory(student)).thenReturn(List.of());
        when(this.sheetPracticeService.getHistory(student)).thenReturn(List.of());
        when(this.parentProgressService.build(any())).thenReturn(new ParentProgressSnapshot(
                0, 0, 0, 0, "No practice yet.", List.of(), List.of(), List.of()));

        this.mockMvc.perform(get("/dashboard"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Progress by subject")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Hi Aria")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("year-pill")))
                .andExpect(content().string(org.hamcrest.Matchers.not(
                        org.hamcrest.Matchers.containsString("Year 6 maths standards"))));

        org.junit.jupiter.api.Assertions.assertFalse(NzCurriculumMap.cardsForYear(6).isEmpty());
    }
}
