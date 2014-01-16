package gameoflife.ui.Swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SwingStartOptions extends JFrame{
//NON FUNCTIONAL YET
    
    static Dimension dimension;    
          
    void execute() {
        this.setTitle("Options");
        this.createComponents();
        this.setBounds(820, 100, 200, 170);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void createComponents() {
        this.add(createButtonPanel());
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.add(createColorComboBox());
        return panel;
    }

    private JComboBox createColorComboBox() {
        final String[] colors = {"Select Size","Big", "Medium", "Small"};
        final JComboBox comboBox = new JComboBox(colors);
        dimension = new Dimension(35, 40);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String selected = comboBox.getSelectedItem().toString();
                if (selected.equals(colors[1])) dimension = new Dimension(15, 20); //this.setSize(320, 300);
                if (selected.equals(colors[2])) dimension = new Dimension(25, 30); //this.setSize(460, 500);
                if (selected.equals(colors[3])) dimension = new Dimension(35, 40); //this.setSize(620, 600);
                // AnchuraAprox(izq) = 15*NºdeCeldas(der) + 20
            }
        });
        return comboBox;
    }

    public static Dimension getDimension() {
        return dimension;
    }
    
    
}
