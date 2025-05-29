package utils;

public class DifficultySettings {
    public int enemiesInRow;
    public int numberOfRows;
    public int enemiesDescentRate;
    public int fireChance;
    public boolean towerDefenseMode;

    private DifficultySettings(int enemiesDescentRate, int enemiesInRow,
                               int numberOfRows, int fireChance, boolean towerDefenseMode) {
        this.enemiesDescentRate = enemiesDescentRate;
        this.enemiesInRow = enemiesInRow;
        this.numberOfRows = numberOfRows;
        this.fireChance = fireChance;
        this.towerDefenseMode = towerDefenseMode;
    }

    public static DifficultySettings easySettings() {
        return new DifficultySettings(
                5, 10, 3, 5, false);
    }
}
