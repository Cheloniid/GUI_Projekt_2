package utils;

public class DifficultySettings {
    public float enemiesDescentRate;
    public float fireChance;
    public int enemyColumns;
    public int enemyRows;
    public Difficulty description;
    public boolean towerDefenseMode;

    private DifficultySettings(float enemiesDescentRate, float fireChance, int enemyColumns, int enemyRows,
                               Difficulty description, boolean towerDefenseMode) {
        this.enemiesDescentRate = enemiesDescentRate;
        this.fireChance = fireChance;
        this.enemyColumns = enemyColumns;
        this.enemyRows = enemyRows;
        this.description = description;
        this.towerDefenseMode = towerDefenseMode;
    }

    public static DifficultySettings easySettings() {

        return new DifficultySettings(
                0.1f, 0.0005f, 5, 3, Difficulty.EASY, false);
    }

    public static DifficultySettings normalSettings() {
        return new DifficultySettings(
                0.2f, 0.0005f, 8, 5, Difficulty.NORMAL, false);
    }

    public void increaseDifficulty() {
        this.fireChance += 0.0002f;
        this.enemiesDescentRate += 0.012f;
    }
}


