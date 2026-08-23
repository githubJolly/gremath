package com.gremath.reward;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RewardRulesTest {

    @Test
    void starsScaleWithScore() {
        assertEquals(0, RewardRules.stars(40));
        assertEquals(1, RewardRules.stars(50));
        assertEquals(2, RewardRules.stars(80));
        assertEquals(3, RewardRules.stars(100));
    }

    @Test
    void perfectSheetPaysMoreRbxThanAFail() {
        int perfect = RewardRules.rbx(10, 100, 3, true);
        int fail = RewardRules.rbx(0, 0, 1, false);
        assertTrue(perfect > fail);
        assertTrue(perfect >= 80 + 20 + 40 + 15);
    }

    @Test
    void catalogHasShopAndStarUnlocks() {
        assertTrue(GoodieCatalog.all().size() >= 10);
        assertTrue(GoodieCatalog.find("spark-kiwi").isPresent());
        assertEquals(1, GoodieCatalog.milestoneUnlocks(4, 5).size());
    }
}
