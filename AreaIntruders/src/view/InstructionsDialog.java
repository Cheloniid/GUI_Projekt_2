package view;

import controller.GameController;
import utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InstructionsDialog extends JDialog {

    private GameController controller;

    public InstructionsDialog(JFrame parent, GameController controller, String buttonText) {

        super(parent, "Instructions", true);
        this.controller = controller;

        JTextArea textArea = new JTextArea(
                "Welcome to Area Intruders!\n\n" +
                        "Press ARROWS to move and dodge enemy missiles.\n" +
                        "Press SPACE to shoot and eliminate invaders.\n" +
                        "Don't let them reach you!\n\n" +
                        "Good luck, Captain!"
        );

        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setBackground(Constants.UFO_WINDOW_COLOR);

        JPanel panel = new JPanel(new BorderLayout());

        JButton closeButton = new JButton(buttonText);
        closeButton.addActionListener(e -> {
            controller.pauseResumeGame();
            dispose();
        });

        getRootPane().setDefaultButton(closeButton);

        panel.add(closeButton, BorderLayout.SOUTH);
        panel.add(textArea, BorderLayout.CENTER);
        add(panel, BorderLayout.CENTER);

        setSize(300, 300);
        setLocationRelativeTo(parent);

    }
}
