package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControlPanel extends JPanel{
        private ArrayList<JButton> buttons;

        public ControlPanel(){
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            buttons = new ArrayList<>();

            JButton upButton = new JButton("Up");
            buttons.add(upButton);
            JButton downButton = new JButton("Down");
            buttons.add(downButton);
            JButton rightButton = new JButton ("Right");
            buttons.add(rightButton);
            JButton leftButton = new JButton("Left");
            buttons.add(leftButton);

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

            gbc.gridwidth = 2;
            gbc.gridx = 0;
            add(upButton, gbc);

            /// Second row
            gbc.gridy++;
            gbc.gridwidth = 1;
            gbc.gridx=0;
            add(leftButton, gbc);

            gbc.gridx=1;
            add(rightButton, gbc);

            /// Third row
            gbc.gridy++;
            gbc.gridx = 0;
            gbc.gridwidth = 2;

            add(downButton, gbc);
        }
}
