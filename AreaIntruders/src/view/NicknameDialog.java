package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NicknameDialog {

    public static String show(Component parent, String message, String title) {
        JTextField textField = new JTextField(20);
        textField.setText(System.getProperty("user.name"));

        JOptionPane optionPane = new JOptionPane(
                new Object[]{message, textField},
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION,
                null,
                new Object[]{"OK"},
                "OK"
        );

        final JDialog dialog = optionPane.createDialog(parent, title);
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        textField.addActionListener(e -> dialog.dispose());
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {}

            @Override
            public void windowOpened(WindowEvent e) {
                textField.requestFocus();
            }
        });

        dialog.setVisible(true);
        return textField.getText();
    }
}
