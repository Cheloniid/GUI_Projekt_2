package utils;

public class DifficultySettings {
    public int enemiesDescentRate;
    public float fireChance;
    public int enemyColumns;
    public boolean towerDefenseMode;

    private DifficultySettings(int enemiesDescentRate, float fireChance, int enemyColumns, boolean towerDefenseMode) {
        this.enemiesDescentRate = enemiesDescentRate;
        this.fireChance = fireChance;
        this.enemyColumns = enemyColumns;
        this.towerDefenseMode = towerDefenseMode;
    }

    public static DifficultySettings easySettings() {
        return new DifficultySettings(
                1, 0.0005f, 6, false);
    }

    public static DifficultySettings normalSettings() {
        return new DifficultySettings(
                1, 0.0005f, 8,false);
    }

    public void increaseDifficulty() {
        this.fireChance += 0.0005f;
    }
}
