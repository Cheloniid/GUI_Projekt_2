package view;

import utils.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ControlPanel extends JPanel{
        private Set<JButton> buttons;

        public ControlPanel(){
            setBackground(Constants.GAME_PANEL_BACKGROUND);
            setLayout(new GridBagLayout());
            setBorder(new EmptyBorder(20, 20, 20, 20));
            GridBagConstraints gbc = new GridBagConstraints();

            buttons = new HashSet<>();

            JButton rightButton = new JButton ("RIGHT");
            buttons.add(rightButton);
            JButton leftButton = new JButton("LEFT");
            buttons.add(leftButton);
            JButton fireButton = new JButton ("FIRE!");
            buttons.add(fireButton);

            for (JButton button : buttons){
                button.setBackground(Constants.GAME_PANEL_BACKGROUND);
                button.setForeground(Color.GREEN);
                button.setPreferredSize(new Dimension(80, 30));
                button.setFocusable(false);

                button.setBorder(BorderFactory.createEmptyBorder(15,0,15,0));

            }

            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridx = 0;
            add(leftButton, gbc);

            gbc.gridx = 1;
            add(fireButton, gbc);

            gbc.gridx = 2;
            add(rightButton, gbc);
        }

    public Set<JButton> getButtons() {
        return buttons;
    }
}
