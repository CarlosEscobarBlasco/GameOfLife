package gameoflife.ui;

import gameoflife.model.Matrix;
import gameoflife.persistance.MatrixLoader;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingOtions extends JFrame {

    public void execute(Matrix matrix) {
        this.setTitle("Options");
        this.createComponents(matrix);
        this.setBounds(820, 100, 200, 150);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void createComponents(Matrix matrix) {
        this.add(createButtonPanel(matrix));

    }

    private JPanel createButtonPanel(Matrix matrix) {
        JPanel panel = new JPanel();
        panel.add(createReloadButton(matrix));
        panel.add(createBlankButton(matrix));
        panel.add(createGliderButton(matrix));
        panel.add(createExitButton());
        panel.add(createColorComboBox());
        return panel;
    }

    private JButton createReloadButton(final Matrix matrix) {
        final JButton button = new JButton("Reload");
        button.setPreferredSize(new Dimension(75, 26));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                SwingMatrixViewer.setTimeDelay(120);
                MatrixLoader.loadRandom(matrix);
            }
        });
        return button;
    }

    private JButton createBlankButton(final Matrix matrix) {
        final JButton button = new JButton("Blank");
        button.setPreferredSize(new Dimension(75, 26));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MatrixLoader.loadBlank(matrix);
            }
        });
        return button;
    }

    private JButton createGliderButton(final Matrix matrix) {
        final JButton button = new JButton("Glider");
        button.setPreferredSize(new Dimension(75, 26));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MatrixLoader.loadGlider(matrix);
            }
        });
        return button;
    }

    private JButton createExitButton() {
        final JButton button = new JButton("Exit");
        button.setPreferredSize(new Dimension(75, 26));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        return button;
    }
    
    private JComboBox createColorComboBox() {
        final String[] colors = {"Select a Colour","Green", "Red", "Blue","Black"};
        final JComboBox comboBox = new JComboBox(colors);
        comboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String selected = comboBox.getSelectedItem().toString();
                if (selected.equals(colors[1])) SwingMatrixViewer.setColor(new Color(0, 255, 0));
                if (selected.equals(colors[2])) SwingMatrixViewer.setColor(new Color(255, 0, 0));
                if (selected.equals(colors[3])) SwingMatrixViewer.setColor(new Color(0, 0, 255));
                if (selected.equals(colors[4])) SwingMatrixViewer.setColor(new Color(0, 0, 0));
            }
        });
        return comboBox;
    }
}
