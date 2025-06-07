package view;

import controller.GameController;
import model.DataToUpload;
import model.GameModel;
import utils.Constants;
import utils.DataUploader;
import utils.DifficultySettings;
import utils.JSONConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private final GamePanel gamePanel;
    private final ControlPanel controlPanel;
    private final HealthPanel healthPanel;
    private final ScorePanel scorePanel;
    private GameModel model;
    private GameController controller;

    public MainFrame(GameModel model) {
        UIManager.put("OptionPane.background", Constants.UFO_WINDOW_COLOR);
        UIManager.put("Panel.background", Constants.UFO_WINDOW_COLOR);
        UIManager.put("TextField.background", Color.WHITE);
        UIManager.put("OptionPane.messageFont", new Font("Monospaced", Font.PLAIN, 14));
        UIManager.put("OptionPane.messageForeground", Constants.GAME_PANEL_BACKGROUND);
        UIManager.put("Button.background", Constants.GAME_PANEL_BACKGROUND);
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("TextField.foreground", Color.BLACK);
//        UIManager.put("TextField.caretForeground", Color.GREEN);


        this.model = model;

        gamePanel = new GamePanel(model);
        controlPanel = new ControlPanel();
        healthPanel = new HealthPanel(model.getPlayer());
        scorePanel = new ScorePanel(model.getPlayer());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 3));
        bottomPanel.add(healthPanel);
        bottomPanel.add(controlPanel);
        bottomPanel.add(scorePanel);
        add(gamePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setJMenuBar(createMenuBar());


        for (JButton button : controlPanel.getButtons()) {
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (button.getText().equals("LEFT")) {
                        controller.getPressedKeys().add(KeyEvent.VK_LEFT);
                    } else if (button.getText().equals("RIGHT")) {
                        controller.getPressedKeys().add(KeyEvent.VK_RIGHT);
                    } else if (button.getText().equals("FIRE!")) {
                        controller.fire();
                    }
                }

                public void mouseReleased(MouseEvent e) {
                    if (button.getText().equals("LEFT")) {
                        controller.getPressedKeys().remove(KeyEvent.VK_LEFT);
                    } else if (button.getText().equals("RIGHT")) {
                        controller.getPressedKeys().remove(KeyEvent.VK_RIGHT);
                    } else if (button.getText().equals("FIRE!")) {
                        controller.getPressedKeys().remove(KeyEvent.VK_SPACE);
                    }
                }
            });
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Area Intruders");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                if(Constants.DEBUG_MODE){
                    System.out.println("Scores uploaded in window listener: " + controller.isScoresUploaded());
                }
                if (model.getDifficultySettings().isNormal()){
                    controller.uploadScores();
                }
            }
        });

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setBackground(Constants.UFO_WINDOW_COLOR);

        /// Game Menu
        JMenu gameMenu = new JMenu("Game");
        gameMenu.setBackground(Constants.UFO_WINDOW_COLOR);

        JMenuItem newGameItem = new JMenuItem("New Game");
        newGameItem.setBackground(Constants.UFO_WINDOW_COLOR);
        JMenuItem pauseItem = new JMenuItem("Pause");
        pauseItem.setBackground(Constants.UFO_WINDOW_COLOR);
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setBackground(Constants.UFO_WINDOW_COLOR);

        newGameItem.addActionListener(e -> {
            controller.startNewGame();
        });
        pauseItem.addActionListener(e -> {
            controller.pauseResumeGame();
        });
        exitItem.addActionListener((e) -> {
            System.exit(0);
        });

        gameMenu.setMnemonic(KeyEvent.VK_G);
        newGameItem.setMnemonic(KeyEvent.VK_N);
        newGameItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        pauseItem.setMnemonic(KeyEvent.VK_P);
        pauseItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));

        gameMenu.add(newGameItem);
        gameMenu.add(pauseItem);
        gameMenu.addSeparator();
        gameMenu.add(exitItem);
        menuBar.add(gameMenu);

        ///  Difficulty
        if (Constants.ENABLE_DIFFICULTY_SETTINGS) {
            JMenu difficultyMenu = new JMenu("Difficulty");

            JRadioButtonMenuItem easyItem = new JRadioButtonMenuItem("Easy");
            easyItem.setBackground(Constants.UFO_WINDOW_COLOR);
            easyItem.addActionListener(e -> {
                model.changeDifficulty(DifficultySettings.easySettings());
                controller.startNewGame();
            });
            JRadioButtonMenuItem normalItem = new JRadioButtonMenuItem("Normal");
            normalItem.setBackground(Constants.UFO_WINDOW_COLOR);
            normalItem.addActionListener(e -> {
                model.changeDifficulty(DifficultySettings.normalSettings());
                controller.startNewGame();
            });
            JRadioButtonMenuItem targetPracticeItem = new JRadioButtonMenuItem("Target Practice");
            targetPracticeItem.setBackground(Constants.UFO_WINDOW_COLOR);
            targetPracticeItem.addActionListener(e -> {
                if (Constants.DEBUG_MODE){
                    System.out.println("Inside targetPracticeItem action listener");
                }
                model.changeDifficulty(DifficultySettings.targetPracticeMode());
                controller.startNewGame();
            });


            ButtonGroup diffGroup = new ButtonGroup();
            diffGroup.add(easyItem);
            diffGroup.add(normalItem);
            diffGroup.add(targetPracticeItem);
            normalItem.setSelected(true);

            difficultyMenu.add(easyItem);
            difficultyMenu.add(normalItem);
            difficultyMenu.add(targetPracticeItem);

            menuBar.add(difficultyMenu);
        }

        ///  Top scores
        JMenu topScoresMenu = new JMenu("Top Scores");
        JMenuItem showTopScores = new JMenuItem("Show Top Scores");
        showTopScores.setBackground(Constants.UFO_WINDOW_COLOR);
        topScoresMenu.add(showTopScores);
        menuBar.add(topScoresMenu);

        topScoresMenu.setMnemonic(KeyEvent.VK_O);
        showTopScores.setMnemonic(KeyEvent.VK_S);

        showTopScores.addActionListener(e -> {
            if (controller.isGameStarted() && !controller.isGameOver() && !controller.isGamePaused()) {
                controller.pauseResumeGame();
            }
            new TopScoresFrame(controller);
        });

        ///  Help ///
        JMenu helpMenu = new JMenu("Help");
        JMenuItem instructionsItem = new JMenuItem("Instructions");
        instructionsItem.setBackground(Constants.UFO_WINDOW_COLOR);
        instructionsItem.addActionListener(e -> {
            controller.pauseResumeGame();
            showInstructionsDialog(this, controller, "Close");
        });
        helpMenu.add(instructionsItem);
        menuBar.add(helpMenu);

        return menuBar;
    }

    public void showEndGameMsg(int score) {
        JOptionPane.showMessageDialog(gamePanel,
                "Game Over!\nYou scored " + score + " points.",
                "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

    public void repaintGamePanel() {
        this.gamePanel.repaint();
    }

    public void showInstructionsDialog(JFrame frame, GameController controller, String buttonText) {
        InstructionsDialog instructionsDialog = new InstructionsDialog(frame, controller, buttonText);
        instructionsDialog.setVisible(true);
    }

    public void setController(GameController controller) {
        this.controller = controller;
        this.gamePanel.setController(controller);
    }

    public JPanel getGamePanel() {
        return gamePanel;
    }

    public HealthPanel getHealthPanel() {
        return healthPanel;
    }

    public ScorePanel getScorePanel() {
        return scorePanel;
    }

    public void setModel(GameModel model) {
        this.model = model;
    }

    public void showTargetPracticeEndMessage(int score, int shots) {
        int accuracy = (int) ((double) score / (double) shots * 10);
        JOptionPane.showMessageDialog(gamePanel,
                "Target practice complete!\nYou fired "
                        + shots + " shots with " + accuracy + "% accuracy.",
                "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }
}
