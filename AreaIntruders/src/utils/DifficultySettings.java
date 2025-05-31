package utils;

public class DifficultySettings {
    public int enemiesDescentRate;
    public float fireChance;
    public int playersFireInterval;
    public boolean towerDefenseMode;

    private DifficultySettings(int enemiesDescentRate, float fireChance,
                               int playersFireInterval, boolean towerDefenseMode) {
        this.enemiesDescentRate = enemiesDescentRate;
        this.fireChance = fireChance;
        this.playersFireInterval = playersFireInterval;
        this.towerDefenseMode = towerDefenseMode;
    }

    public static DifficultySettings easySettings() {
        return new DifficultySettings(
                5, 0.002f, 150,false);
    }
}
