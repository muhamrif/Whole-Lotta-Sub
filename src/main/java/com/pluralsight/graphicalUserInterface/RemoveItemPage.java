package com.pluralsight.graphicalUserInterface;

import com.pluralsight.order.Chips;
import com.pluralsight.order.Drink;
import com.pluralsight.order.Sandwich;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.pluralsight.graphicalUserInterface.AddOrderGui.order;

public class RemoveItemPage {
    private JFrame frame;

    public RemoveItemPage(JFrame mainFrame) {
        this.frame = mainFrame;
    }

    public void showRemoveItemScreen() {
        frame.getContentPane().removeAll();

        // Assuming you have a list of items to remove
        String[] items = new String[order.size()];
        for (int i = 0; i < order.size(); i++) {
            if(order.get(i) instanceof Sandwich){
                items[i] = "Item #" + (i+1)  + ": "+((Sandwich) order.get(i)).getSize()+" "+ ((Sandwich) order.get(i)).getName();
            }
            else if(order.get(i) instanceof Drink){
                items[i] = "Item #" + (i+1)  + ": "+((Drink) order.get(i)).getSize() +" "+((Drink) order.get(i)).getType();
            }
            else if(order.get(i) instanceof Chips){
                items[i] = "Item #" + (i+1)  + ": "+ ((Chips) order.get(i)).getType() + " Chips";
            }

        }

        JLabel selectItemLabel = new JLabel("Select Item to Remove:");
        JComboBox<String> itemComboBox = new JComboBox<>(items);


        JButton removeButton = new JButton("Remove");
        JButton backToMenuButton = new JButton("Back to Menu");

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (order.size() == 0) {
                    JOptionPane.showMessageDialog(frame, "No items to remove!");
                    frame.setVisible(false);
                    frame.dispose();
                    AddOrderGui.run();
                }else {
                    int index = itemComboBox.getSelectedIndex();
                    JOptionPane.showMessageDialog(frame, "Removed: "+ "\n" + order.get(index).toString());
                    Object removeItem = order.get(index);
                    order.remove(index);
                    if (removeItem instanceof Sandwich) {
                        AddOrderGui.sandwich.remove(removeItem);
                    } else if (removeItem instanceof Chips) {
                        AddOrderGui.chips.remove(removeItem);
                    } else if (removeItem instanceof Drink) {
                        AddOrderGui.drinks.remove(removeItem);
                    }
                    frame.setVisible(false);
                    frame.dispose();
                    AddOrderGui.run();

                }

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
        panel.add(selectItemLabel);
        panel.add(itemComboBox);
        panel.add(removeButton);
        panel.add(backToMenuButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }
}

