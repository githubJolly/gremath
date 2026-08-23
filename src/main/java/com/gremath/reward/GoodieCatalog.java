package com.gremath.reward;

import java.util.List;
import java.util.Optional;

/**
 * In-app collectibles. Names are original LetusLearn items inspired by playground
 * game-style rewards — not official Roblox items, and not real Robux.
 */
public final class GoodieCatalog {

    private static final List<Goodie> ALL = List.of(
            new Goodie("spark-kiwi", "Spark Kiwi", "pet", "🥝", 0, 5, "A glowing kiwi that hatches at 5 stars."),
            new Goodie("neon-cap", "Neon Builder Cap", "hat", "🧢", 0, 15, "Unlocks at 15 stars. Looks like a studio drop."),
            new Goodie("galaxy-trail", "Galaxy Trail", "hat", "🌌", 0, 30, "A star-trail aura at 30 stars."),
            new Goodie("title-rookie", "Rookie Builder", "title", "⭐", 0, 0, "Everyone starts here. Equip it from the shop."),
            new Goodie("title-pro", "Pro Learner", "title", "🏆", 0, 20, "Twenty stars. You are in the club."),
            new Goodie("title-legend", "Sheet Legend", "title", "👑", 0, 50, "Fifty stars. The lobby knows your name."),
            new Goodie("pet-pukeko", "Pixel Pūkeko", "pet", "🐦", 40, 0, "Spend 40 Rbx. Follows you on the rewards page."),
            new Goodie("hat-coil", "Speed Coil Cap", "hat", "🌀", 60, 0, "Game-night energy. 60 Rbx in the shop."),
            new Goodie("pet-weta", "Chrome Wētā", "pet", "🪲", 80, 0, "Rare crawl companion. 80 Rbx."),
            new Goodie("hat-crown", "Studio Crown", "hat", "👑", 160, 0, "Big lobby energy. 160 Rbx."),
            new Goodie("title-noobhero", "Noob-to-Hero", "title", "🚀", 50, 0, "The comeback title. 50 Rbx."),
            new Goodie("title-kaitiaki", "Kaitiaki of Sheets", "title", "🌿", 90, 8, "Look after your streak. 90 Rbx.")
    );

    private GoodieCatalog() {
    }

    public static List<Goodie> all() {
        return ALL;
    }

    public static Optional<Goodie> find(String id) {
        return ALL.stream().filter(g -> g.id().equals(id)).findFirst();
    }

    public static List<Goodie> milestoneUnlocks(int previousStars, int newStars) {
        return ALL.stream()
                .filter(g -> g.rbxCost() == 0 && g.starsNeeded() > 0)
                .filter(g -> previousStars < g.starsNeeded() && newStars >= g.starsNeeded())
                .toList();
    }
}
