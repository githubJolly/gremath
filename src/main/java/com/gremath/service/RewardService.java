package com.gremath.service;

import com.gremath.model.Student;
import com.gremath.repository.StudentRepository;
import com.gremath.reward.Goodie;
import com.gremath.reward.GoodieCatalog;
import com.gremath.reward.RewardPayout;
import com.gremath.reward.RewardRules;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RewardService {
    private final StudentRepository studentRepository;

    public RewardService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public RewardPayout award(Student student, int score, int totalQuestions) {
        Student live = this.studentRepository.findById(student.getId()).orElse(student);
        int pct = totalQuestions == 0 ? 0 : Math.round(score * 100.0f / totalQuestions);
        LocalDate today = LocalDate.now();
        boolean firstToday = live.getLastPracticeDate() == null || live.getLastPracticeDate().isBefore(today);
        int streak = live.getStreakDays();
        if (firstToday) {
            if (live.getLastPracticeDate() != null && live.getLastPracticeDate().equals(today.minusDays(1))) {
                streak = streak + 1;
            } else {
                streak = 1;
            }
            live.setStreakDays(streak);
            live.setLastPracticeDate(today);
        }
        int stars = RewardRules.stars(pct);
        int rbx = RewardRules.rbx(score, pct, live.getStreakDays(), firstToday);
        int previousStars = live.getStars();
        live.setStars(previousStars + stars);
        live.setRbxPoints(live.getRbxPoints() + rbx);
        if (!live.hasGoodie("title-rookie")) {
            live.addGoodie("title-rookie");
            if (live.getEquippedTitle() == null) {
                live.setEquippedTitle("title-rookie");
            }
        }
        List<String> unlockedNames = new ArrayList<>();
        for (Goodie g : GoodieCatalog.milestoneUnlocks(previousStars, live.getStars())) {
            if (!live.hasGoodie(g.id())) {
                live.addGoodie(g.id());
                unlockedNames.add(g.emoji() + " " + g.name());
            }
        }
        this.studentRepository.save(live);
        student.setStars(live.getStars());
        student.setRbxPoints(live.getRbxPoints());
        student.setStreakDays(live.getStreakDays());
        student.setLastPracticeDate(live.getLastPracticeDate());
        student.setUnlockedGoodies(live.getUnlockedGoodies());
        student.setEquippedTitle(live.getEquippedTitle());
        String drop = unlockedNames.isEmpty() ? null : String.join(" · ", unlockedNames);
        return new RewardPayout(stars, rbx, live.getStreakDays(),
                RewardRules.cheer(pct, live.getStreakDays(), firstToday),
                drop, live.getStars(), live.getRbxPoints(), live.getRewardLevel());
    }

    @Transactional
    public String buy(Student student, String goodieId) {
        Student live = this.studentRepository.findById(student.getId()).orElseThrow();
        Goodie goodie = GoodieCatalog.find(goodieId).orElseThrow(() -> new IllegalArgumentException("Unknown goodie"));
        if (live.hasGoodie(goodie.id())) {
            return "You already own " + goodie.name() + ".";
        }
        if (live.getStars() < goodie.starsNeeded()) {
            return "Need " + goodie.starsNeeded() + " stars first.";
        }
        if (live.getRbxPoints() < goodie.rbxCost()) {
            return "Need " + goodie.rbxCost() + " Rbx points.";
        }
        live.setRbxPoints(live.getRbxPoints() - goodie.rbxCost());
        live.addGoodie(goodie.id());
        this.studentRepository.save(live);
        return "Unlocked " + goodie.emoji() + " " + goodie.name() + "!";
    }

    @Transactional
    public void equip(Student student, String goodieId) {
        Student live = this.studentRepository.findById(student.getId()).orElseThrow();
        Goodie goodie = GoodieCatalog.find(goodieId).orElseThrow(() -> new IllegalArgumentException("Unknown goodie"));
        if (!live.hasGoodie(goodie.id())) {
            throw new IllegalArgumentException("You do not own that goodie yet.");
        }
        if (goodie.isTitle()) {
            live.setEquippedTitle(goodie.id());
        } else if (goodie.isPet()) {
            live.setEquippedPet(goodie.id());
        } else if (goodie.isHat()) {
            live.setEquippedHat(goodie.id());
        }
        this.studentRepository.save(live);
    }

    public Student reload(Student student) {
        return this.studentRepository.findById(student.getId()).orElse(student);
    }
}
