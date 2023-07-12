package me.nixuge.freezer.keybinds;

import lombok.Getter;

public class KeyToggleData {
    // Shouldnt be here but making a class for 2 values meh
    private static int DELAY_COUNT = 100;
    @Getter
    private static boolean isGameFrozen = false;
    private static long lastGameFrozenToggle = System.currentTimeMillis();

    public static boolean canChange() {
        return lastGameFrozenToggle + DELAY_COUNT < System.currentTimeMillis();
    }
    private static void setLastFrozenToggle() {
        lastGameFrozenToggle = System.currentTimeMillis();
    }
    public static void toggleFrozen() {
        setLastFrozenToggle();
        isGameFrozen = !isGameFrozen;
    }
}
