package view;

import utils.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class SplashScreen extends JWindow {

    private final JProgressBar progressBar;

    public SplashScreen() {
        setLayout(new BorderLayout());

        try {
            BufferedImage image = ImageIO.read(
                    Objects.requireNonNull(getClass().getResource(Constants.SPLASH_SCREEN_PICTURE)));
            setSize(image.getWidth(), image.getHeight());
            JLabel imageLabel = new JLabel(new ImageIcon(image));
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imageLabel.setOpaque(true);
            add(imageLabel, BorderLayout.CENTER);
        } catch (IOException e){
            System.out.println("IOexception loading splash screen image");
            JLabel label = new JLabel("Could not load splash screen image");
            add(label, BorderLayout.CENTER);
            setSize(200, 50);
        } catch (NullPointerException e){
            System.out.println("Null pointer exception loading splash screen image");
            JLabel label = new JLabel("Could not load splash screen image");
            add(label, BorderLayout.CENTER);
            setSize(200, 50);
        }

        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setString("Loading...");
        progressBar.setStringPainted(true);
        progressBar.setForeground(Constants.UFO_COLOR);
        progressBar.setBackground(Constants.UFO_WINDOW_COLOR);
        add(progressBar, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
}
