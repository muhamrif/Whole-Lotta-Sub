package com.pluralsight.graphicalUserInterface;

import com.pluralsight.order.Drink;
import com.pluralsight.utils.Size;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrinksPage {
    private final JFrame frame;

    public AddDrinksPage(JFrame mainFrame) {
        this.frame = mainFrame;
    }

    public void showAddDrinkScreen() {
        frame.getContentPane().removeAll();

        JLabel sizeLabel = new JLabel("Select Drink Size:");
        JComboBox<Size> sizeComboBox = new JComboBox<>();
        sizeComboBox.addItem(Size.SMALL);
        sizeComboBox.addItem(Size.MEDIUM);
        sizeComboBox.addItem(Size.LARGE);
        JLabel flavorLabel = new JLabel("Select Drink Flavor:");
        JComboBox<String> flavorComboBox = new JComboBox<>(new String[]{"Cola", "Orange", "Lemonade", "Iced Tea"});

        JButton addToOrderButton = new JButton("Add to Order");
        JButton backToMenuButton = new JButton("Back to Menu");

        addToOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Size selectedSize = (Size) sizeComboBox.getSelectedItem();
                String selectedFlavor = (String) flavorComboBox.getSelectedItem();
                Drink drink = new Drink(selectedSize, selectedFlavor);
                AddOrderGui.order.add(drink);
                AddOrderGui.drinks.add(drink);
                JOptionPane.showMessageDialog(frame, "Added " + selectedSize.toString().toLowerCase() + " " + selectedFlavor + " to the order!");
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
        panel.setLayout(new GridLayout(3, 2));
        panel.add(sizeLabel);
        panel.add(sizeComboBox);
        panel.add(flavorLabel);
        panel.add(flavorComboBox);
        panel.add(addToOrderButton);
        panel.add(backToMenuButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }
}
