package utils;

public class DifficultySettings {
    public float enemiesDescentRate;
    public float fireChance;
    public int enemyColumns;
    public int enemyRows;
    public Difficulty description;
    public boolean targetPractice;

    private DifficultySettings(float enemiesDescentRate, float fireChance, int enemyColumns, int enemyRows,
                               Difficulty description, boolean targetPractice) {
        this.enemiesDescentRate = enemiesDescentRate;
        this.fireChance = fireChance;
        this.enemyColumns = enemyColumns;
        this.enemyRows = enemyRows;
        this.description = description;
        this.targetPractice = targetPractice;
    }

    public static DifficultySettings easySettings() {

        return new DifficultySettings(
                0.1f, 0.0005f, 5, 3, Difficulty.EASY, false);
    }

    public static DifficultySettings normalSettings() {
        return new DifficultySettings(
                0.2f, 0.0005f, 8, 5, Difficulty.NORMAL, false);
    }

    public static DifficultySettings targetPracticeMode() {
        return new DifficultySettings(
                0f, 0f, 8,
                5, Difficulty.TARGET_PRACTICE, true);
    }

    public void increaseDifficulty() {
        this.fireChance += 0.0002f;
        this.enemiesDescentRate += 0.012f;
    }

    public Difficulty getDescription() {
        return description;
    }

    public boolean isNormal(){
        return this.description == Difficulty.NORMAL;
    }
}


