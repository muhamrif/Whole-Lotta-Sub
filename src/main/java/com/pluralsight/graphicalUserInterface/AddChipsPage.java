package com.pluralsight.graphicalUserInterface;

import com.pluralsight.order.Chips;
import com.pluralsight.order.Drink;
import com.pluralsight.utils.Size;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddChipsPage {
    private final JFrame frame;

    public AddChipsPage(JFrame mainFrame) {
        this.frame = mainFrame;
    }

    public void showAddChipsScreen() {
        frame.getContentPane().removeAll();

        JLabel flavorLabel = new JLabel("Select Drink Flavor:");
        JComboBox<String> flavorComboBox = new JComboBox<>(new String[]{"Plain", "BBQ", "Salt & Vinegar", "Sour Cream & Onion", "Jalapeno", "Cheddar & Sour Cream"});

        JButton addToOrderButton = new JButton("Add to Order");
        JButton backToMenuButton = new JButton("Back to Menu");

        addToOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFlavor = (String) flavorComboBox.getSelectedItem();
                Chips chips = new Chips( selectedFlavor);
                AddOrderGui.order.add(chips);
                AddOrderGui.chips.add(chips);
                JOptionPane.showMessageDialog(frame, "Added " + selectedFlavor + " Chips to the order!");
                frame.setVisible(false);
                frame.dispose();
                AddOrderGui.run();
            }
        });

        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                AddOrderGui.run();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(flavorLabel);
        panel.add(flavorComboBox);
        panel.add(addToOrderButton);
        panel.add(backToMenuButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }
}

