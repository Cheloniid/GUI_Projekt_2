package utils;

public class DifficultySettings {
    public float enemiesDescentRate;
    public float fireChance;
    public int enemyColumns;
    public boolean towerDefenseMode;

    private DifficultySettings(float enemiesDescentRate, float fireChance, int enemyColumns, boolean towerDefenseMode) {
        this.enemiesDescentRate = enemiesDescentRate;
        this.fireChance = fireChance;
        this.enemyColumns = enemyColumns;
        this.towerDefenseMode = towerDefenseMode;
    }

    public static DifficultySettings easySettings() {
        System.out.println("creating easy difficulty settings");
        return new DifficultySettings(
                0.1f, 0.0005f, 5, false);
    }

    public static DifficultySettings normalSettings() {
        return new DifficultySettings(
                0.2f, 0.0005f, 8,false);
    }

    public void increaseDifficulty() {
        this.fireChance += 0.0002f;
        this.enemiesDescentRate += 0.015f;
    }
}
