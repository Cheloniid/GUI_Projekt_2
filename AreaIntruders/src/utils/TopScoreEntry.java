package utils;

public class TopScoreEntry {
    public int no;
    public String name;
    public int score;

    @Override
    public String toString() {
        return String.format("[%d, %s, %d]", no, name, score);
    }

    public String getName() {
        return name;
    }

    public int getNo() {
        return no;
    }

    public int getScore() {
        return score;
    }
}
