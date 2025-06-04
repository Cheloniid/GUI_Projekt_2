package view;

import utils.DataFetcher;
import utils.TopScoreEntry;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TopScoresModel extends AbstractTableModel {

    private List<TopScoreEntry> scores;
    private String[] columnNames = {"#", "Player", "Score"};

    public TopScoresModel() {
        this.scores = DataFetcher.fetchData();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }


    @Override
    public int getRowCount() {
        return scores.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TopScoreEntry scoreEntry = scores.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> scoreEntry.getNo();
            case 1 -> scoreEntry.getName();
            case 2 -> scoreEntry.getScore();
            default -> null;
        };
    }
}
