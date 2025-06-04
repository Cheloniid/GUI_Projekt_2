package view;

import controller.GameController;
import utils.Constants;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;

public class TopScoresFrame extends JFrame {

    private final GameController controller;
    private JTable table;
    private TopScoresModel model;

    public TopScoresFrame(GameController controller) {
        this.controller = controller;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Area Intruders Top Scores");
        setSize(600, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Constants.UFO_WINDOW_COLOR);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });
        panel.add(closeButton, BorderLayout.SOUTH);

        model = new TopScoresModel();
        table = new JTable(model);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Constants.UFO_COLOR);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Monospaced", Font.PLAIN, 14));
        table.setFont(new Font("Monospaced", Font.PLAIN, 14));
        table.setBackground(Constants.UFO_WINDOW_COLOR);


        setLayout(new BorderLayout());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        add(panel);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void closeWindow(){
        if (controller.isGamePaused()) {
            controller.pauseResumeGame();
        }
        dispose();
    }
}
