package com.pluralsight.graphicalUserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeMenuGUI {
    public static void run() {
        SwingUtilities.invokeLater(HomeMenuGUI::HomeMenuGUIFrame);
    }

    private static void HomeMenuGUIFrame() {
        JFrame frame = new JFrame("WHOLE LOTTA SUB");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        JLabel helloLabel = new JLabel("Welcome to WHOLE LOTTA SUB!");
        helloLabel.setHorizontalAlignment(JLabel.CENTER);
        helloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        helloLabel.setForeground(Color.BLUE);
        frame.add(helloLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        JButton newOrderButton = new JButton("Start a New Order");
        newOrderButton.setBackground(Color.GREEN);
        newOrderButton.setFocusPainted(true);
        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.RED);
        exitButton.setFocusPainted(false);

        newOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                AddOrderGui.run();

            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(newOrderButton);
        buttonPanel.add(exitButton);
        buttonPanel.setLayout(new GridLayout(2, 1));

        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}