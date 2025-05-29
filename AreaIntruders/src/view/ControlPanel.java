package view;

import utils.Constants;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControlPanel extends JPanel{
        private ArrayList<JButton> buttons;

        public ControlPanel(){
            setBackground(Constants.GAME_PANEL_BACKGROUND);
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            buttons = new ArrayList<>();

            JButton upButton = new JButton("UP");
            buttons.add(upButton);
            JButton downButton = new JButton("DOWN");
            buttons.add(downButton);
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
                //button.setBorderPainted(false);
                //button.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));

            }

            for (JButton button : buttons) {
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton button = (JButton) e.getSource();
                    }
                });
            }

            /// /////First row
            gbc.gridy = 0;

            gbc.gridwidth = 3;
            gbc.gridx = 0;
            add(upButton, gbc);

            /// Second row
            gbc.gridy++;
            gbc.gridwidth = 1;
            gbc.gridx=0;
            add(leftButton, gbc);

            gbc.gridx=1;
            add(fireButton, gbc);

            gbc.gridx=2;
            add(rightButton, gbc);

            /// Third row
            gbc.gridy++;
            gbc.gridx = 0;
            gbc.gridwidth = 3;

            add(downButton, gbc);
        }
}
