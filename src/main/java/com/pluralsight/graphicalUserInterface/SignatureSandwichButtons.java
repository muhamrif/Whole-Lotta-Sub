package com.pluralsight.graphicalUserInterface;

import com.pluralsight.order.Drink;
import com.pluralsight.utils.Size;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignatureSandwichButtons {
    private final JFrame frame;

    public SignatureSandwichButtons(JFrame mainFrame) {
        this.frame = mainFrame;
    }

    public void SignatureSandwich() {
        frame.getContentPane().removeAll();
    frame.setSize(800, 800);
            JLabel helloLabel = new JLabel("Please Select a Signature Sandwich or Build Your Own");
        helloLabel.setHorizontalAlignment(JLabel.CENTER);
                helloLabel.setFont(new Font("Arial", Font.BOLD, 20));
                helloLabel.setForeground(Color.BLUE);
                frame.add(helloLabel, BorderLayout.NORTH);

                JButton newOrderButton = new JButton();
                newOrderButton.setText("<html><div style='text-align: center;'><b>The Big Hamza:</b> <br/>Extra Steak and Extra Bacon,<br/>with Extra Provolone Cheese,<br/>Topped with Lettuce, Tomato, and Mayo,<br/>on a Toasted White Bread.</div></html>");
                newOrderButton.setBackground(Color.GREEN);
                newOrderButton.setFocusPainted(true);

                JButton newOrderButton2 = new JButton();
                newOrderButton2.setText("<html><div style='text-align: center;'><b>The Akhil Special:</b> <br/>Chicken and Salami<br/>with Extra American Cheese,<br/>Topped with Peppers, Jalapenos, Ketchup, and Mustard,<br/>on a Toasted Rye Bread.</div></html>");

                newOrderButton2.setBackground(Color.GREEN);
                newOrderButton2.setFocusPainted(true);

                JButton newOrderButton4 = new JButton();
                newOrderButton4.setText("<html><div style='text-align: center;'><b>Ray's Potato Percussion Panini:</b> <br/>Extra Potato,<br/>with Potato Cheese,<br/>Topped with Potato,<br/>on a Toasted Potato Bread.</div></html>");

                JButton newOrderButton3 = new JButton("Add Custom Sandwich");
                newOrderButton3.setBackground(Color.GREEN);
                newOrderButton3.setFocusPainted(true);

                JButton backToMenuButton = new JButton("Back to Menu");
                backToMenuButton.setBackground(Color.GREEN);
                backToMenuButton.setFocusPainted(true);

                newOrderButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new AddCustomSandwichOnePage(frame).showAddCustomSandwichOneScreen();
                    }
                });

                newOrderButton2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       new AddCustomSandwichTwoPage(frame).showAddCustomSandwichTwoScreen();
                    }
                });

        newOrderButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCustomSandwichThreePage(frame).showAddCustomSandwichThreeScreen();
            }
        });

                newOrderButton3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new AddSandwichPage(frame).showAddSandwichScreen();
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
        panel.setLayout(new GridLayout(5, 1));

        panel.add(newOrderButton);
        panel.add(newOrderButton2);
        panel.add(newOrderButton4);
        panel.add(newOrderButton3);
        panel.add(backToMenuButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }
}



