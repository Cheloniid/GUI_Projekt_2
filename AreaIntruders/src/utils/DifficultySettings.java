package utils;

public class DifficultySettings {
    public int enemiesDescentRate;
    public int fireChance;
    public int playersFireInterval;
    public boolean towerDefenseMode;

    private DifficultySettings(int enemiesDescentRate, int fireChance,
                               int playersFireInterval, boolean towerDefenseMode) {
        this.enemiesDescentRate = enemiesDescentRate;
        this.fireChance = fireChance;
        this.playersFireInterval = playersFireInterval;
        this.towerDefenseMode = towerDefenseMode;
    }

    public static DifficultySettings easySettings() {
        return new DifficultySettings(
                5, 5, 300,false);
    }
}
