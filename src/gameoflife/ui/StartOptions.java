

package gameoflife.ui;

import java.awt.Color;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class StartOptions extends JFrame{

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
        comboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String selected = comboBox.getSelectedItem().toString();
                if (selected.equals(colors[1])) System.out.println("Big selected");
                if (selected.equals(colors[2])) System.out.println("Medium selected");
                if (selected.equals(colors[3])) System.out.println("Small selected");

            }
        });
        return comboBox;
    }

}
