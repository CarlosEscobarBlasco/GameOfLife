package gameoflife.ui.Swing;

import gameoflife.model.Sound;
import gameoflife.model.MatrixChanger;
import gameoflife.model.Matrix;
import gameoflife.ui.MatrixViewer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class SwingMatrixViewer extends JFrame implements MatrixViewer {
    private JButton[][] bMatrix;
    private Matrix matrix;
    private static boolean refresh = false;
    private static int timeDelay = 120;
    private static Color color = new Color(0, 250, 0);
    private static boolean start = false;

    public static void setStart(boolean start) {
        SwingMatrixViewer.start = start;
    }
    
    public SwingMatrixViewer(Matrix matrix) {
        this.matrix = matrix;
        this.bMatrix = new JButton[matrix.high()][matrix.width()];
        this.setTitle("Game of Life");
        this.setSize(620, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        createButtonsMatrix();
        createComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void show(Matrix matrix) {
        this.setVisible(start);
        while (refresh) {
            refresh(matrix);
            delay(timeDelay);
            MatrixChanger.change(matrix);
            
        }
    }

    public static void setRefresh(boolean refresh) {
        SwingMatrixViewer.refresh = refresh;
    }

    public static void setColor(Color color) {
        SwingMatrixViewer.color = color;
    }

    public static void setTimeDelay(int timeDelay) {
        SwingMatrixViewer.timeDelay = timeDelay;
    }

    private void createComponents() {
        this.add(createMatrixPanel());
        this.add(createButtonsPanel(matrix), BorderLayout.SOUTH);
    }

    private void refresh(Matrix matrix) {
        for (int i = 0; i < bMatrix.length; i++) {
            for (int j = 0; j < bMatrix[0].length; j++) {
                bMatrix[i][j].setBackground(matrix.getCell(i, j).isAlive() ? color : Color.white);
            }
        }
    }
    
    private void refresh2(Matrix matrix) {
                for (int i = 0; i < bMatrix.length; i++) {
            for (int j = 0; j < bMatrix[0].length; j++) {
                if (matrix.getCell(i, j).isPreviusState()) {
                    bMatrix[i][j].setBackground(new Color(193, 255, 193));
                } else if (matrix.getCell(i, j).isAlive()) {
                    bMatrix[i][j].setBackground(color);
                } else {
                    bMatrix[i][j].setBackground(Color.white);
                }
            }
        }
    }

    private void delay(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException ex) {
        }
    }

    private JButton[][] createButtonsMatrix() {
        for (int i = 0; i < bMatrix.length; i++) {
            for (int j = 0; j < bMatrix[0].length; j++) {
                final int ii = i, jj = j;
                final JButton button = new JButton();
                button.setPreferredSize(new Dimension(10, 10));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        button.setBackground(button.getBackground() != Color.WHITE ? Color.WHITE : color);
                        matrix.setCell(ii, jj, matrix.getCell(ii, jj).isAlive() ? false : true);
                    }
                });
                bMatrix[i][j] = button;
            }
        }
        return bMatrix;
    }

    private JPanel createMatrixPanel() {
        JPanel panel = new JPanel();
        for (int i = 0; i < bMatrix.length; i++) {
            for (int j = 0; j < bMatrix[0].length; j++) {
                panel.add(bMatrix[i][j]);
            }

        }
        panel.setMaximumSize(new Dimension(620, 610));
        return panel;
    }

    private JPanel createButtonsPanel(Matrix matrix) {
        JPanel panel = new JPanel();
        panel.add(createSlowerButton());
        panel.add(createPausePlayButton());
        panel.add(createFasterButton());
        panel.add(createOptionsButton(matrix));
        return panel;
    }

    private JButton createPausePlayButton() {
        final JButton button = new JButton();
        button.setPreferredSize(new Dimension(57, 26));
        ImageIcon imagen = new ImageIcon("Images//pause&play.png");
        button.setIcon(imagen);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Sound buttonSound = new Sound("Sound\\lockinchampion.wav");
                buttonSound.play();
                refresh = refresh ? false : true;
                if(refresh)SwingMatrixDialog.getSound().loop();
                if(!refresh)SwingMatrixDialog.getSound().pause();
            }
        });
        return button;
    }

    private JButton createSlowerButton() {
        final JButton button = new JButton();
        button.setPreferredSize(new Dimension(57, 26));
        ImageIcon imagen = new ImageIcon("Images//slower.png");
        button.setIcon(imagen);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                timeDelay = timeDelay >= 700 ? timeDelay : timeDelay + 30;
            }
        });
        return button;
    }

    private JButton createFasterButton() {
        final JButton button = new JButton();
        button.setPreferredSize(new Dimension(57, 26));
        ImageIcon imagen = new ImageIcon("Images//faster.png");
        button.setIcon(imagen);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                timeDelay = timeDelay <= 0 ? timeDelay : timeDelay - 30;
            }
        });
        return button;
    }

    private JButton createOptionsButton(final Matrix matrix) {
        final JButton button = new JButton("Options");
        final SwingOtions options = new SwingOtions();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                options.execute(matrix);
            }
        });
        return button;
    }
}
