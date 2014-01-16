package gameoflife.ui.Swing;

import gameoflife.model.Sound;
import gameoflife.ui.MatrixDialog;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingMatrixDialog implements MatrixDialog {

    private static Sound sound = new Sound("Sound\\pkm-Pokemon_Center.wav");

    public static Sound getSound() {
        return sound;
    }

    @Override
    public void show() {
        JFrame frame = new JFrame();
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);
        frame.add(createPanel(frame));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        sound.loop();
        frame.setVisible(true);
    }

    private JPanel createPanel(JFrame frame) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(Box.createRigidArea(new Dimension(0, 70)));
        panel.add(createLabel());
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(createPlayButton(frame));
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(createOptionButton());
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(createExitButton());
        return panel;
    }

    private JButton createPlayButton(final JFrame frame) {
        JButton button = new JButton("Play");
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Sound buttonSound = new Sound("Sound\\lockinchampion.wav");
                buttonSound.play();
                SwingMatrixViewer.setStart(true);
                SwingMatrixViewer.setRefresh(true);
                frame.dispose();
            }
        });
        return button;
    }

    private JButton createOptionButton() {
        JButton button = new JButton("Option");
        button.setAlignmentX(CENTER_ALIGNMENT);
        final SwingStartOptions options = new SwingStartOptions();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Sound buttonSound = new Sound("Sound\\lockinchampion.wav");
                buttonSound.play();
                options.execute();
            }
        });
        return button;
    }

    private JButton createExitButton() {
        JButton button = new JButton("Exit");
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Sound buttonSound = new Sound("Sound\\lockinchampion.wav");
                buttonSound.play();
                System.exit(0);
            }
        });
        return button;
    }

    private JLabel createLabel() {
        JLabel label = new JLabel("GAME OF LIFE");
        label.setFont(new Font(label.getName(), 8, 40));
        label.setAlignmentX(CENTER_ALIGNMENT);
        return label;
    }
}
