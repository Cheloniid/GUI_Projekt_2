package utils;

public class DifficultySettings {
    public int enemiesDescentRate;
    public int fireChance;
    public boolean towerDefenseMode;

    private DifficultySettings(int enemiesDescentRate, int fireChance, boolean towerDefenseMode) {
        this.enemiesDescentRate = enemiesDescentRate;
        this.fireChance = fireChance;
        this.towerDefenseMode = towerDefenseMode;
    }

    public static DifficultySettings easySettings() {
        return new DifficultySettings(
                5, 5, false);
    }
}
