package com.pluralsight.graphicalUserInterface;
import com.pluralsight.order.*;
import com.pluralsight.utils.Size;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddCustomSandwichTwoPage {
    private JFrame frame;

    public AddCustomSandwichTwoPage(JFrame mainFrame) {
        this.frame = mainFrame;
    }

    public void showAddCustomSandwichTwoScreen() {
        frame.getContentPane().removeAll();
        frame.setSize(935,500);

        // Sandwich size options

        JLabel selectSizeLabel = new JLabel("Select Sandwich Size:");
        JComboBox<Size> sizeComboBox = new JComboBox<>();
        sizeComboBox.addItem(Size.SMALL);
        sizeComboBox.addItem(Size.MEDIUM);
        sizeComboBox.addItem(Size.LARGE);


        // Bread options
        String[] breadOptions = {"White", "Whole Wheat", "Rye", "Wrap"};
        JLabel selectBreadLabel = new JLabel("Select Bread:");
        JComboBox<String> breadComboBox = new JComboBox<>(breadOptions);
        breadComboBox.setSelectedIndex(2);

        // Meat checkboxes
        JLabel selectMeatLabel = new JLabel("Select Meat:");
        JCheckBox steakCheckBox = new JCheckBox("Steak");
        JCheckBox hamCheckBox = new JCheckBox("Ham");
        JCheckBox salamiCheckBox = new JCheckBox("Salami",true);
        JCheckBox roastBeefCheckBox = new JCheckBox("Roast Beef");
        JCheckBox chickenCheckBox = new JCheckBox("Chicken",true);
        JCheckBox baconCheckBox = new JCheckBox("Bacon");

        ArrayList<JCheckBox> meatCheckBoxes = new ArrayList<>();
        meatCheckBoxes.add(steakCheckBox);
        meatCheckBoxes.add(hamCheckBox);
        meatCheckBoxes.add(salamiCheckBox);
        meatCheckBoxes.add(roastBeefCheckBox);
        meatCheckBoxes.add(chickenCheckBox);
        meatCheckBoxes.add(baconCheckBox);


        // Cheese checkboxes
        JLabel selectCheeseLabel = new JLabel("Select Cheese:");
        JCheckBox swissCheckBox = new JCheckBox("Swiss");
        JCheckBox cheddarCheckBox = new JCheckBox("Cheddar");
        JCheckBox provoloneCheckBox = new JCheckBox("Provolone");
        JCheckBox americanCheckBox = new JCheckBox("American",true);

        ArrayList<JCheckBox> cheeseCheckBoxes = new ArrayList<>();
        cheeseCheckBoxes.add(swissCheckBox);
        cheeseCheckBoxes.add(cheddarCheckBox);
        cheeseCheckBoxes.add(provoloneCheckBox);
        cheeseCheckBoxes.add(americanCheckBox);

        // Sauce checkboxes
        JLabel selectSauceLabel = new JLabel("Select Sauce:");
        JCheckBox mayonnaiseCheckBox = new JCheckBox("Mayonnaise");
        JCheckBox mustardCheckBox = new JCheckBox("Mustard",true);
        JCheckBox ketchupCheckBox = new JCheckBox("Ketchup",true);
        JCheckBox ranchCheckBox = new JCheckBox("Ranch");
        JCheckBox thousandIslandCheckBox = new JCheckBox("Thousand Island");
        JCheckBox vinaigretteCheckBox = new JCheckBox("Vinaigrette");

        ArrayList<JCheckBox> sauceCheckBoxes = new ArrayList<>();
        sauceCheckBoxes.add(mayonnaiseCheckBox);
        sauceCheckBoxes.add(mustardCheckBox);
        sauceCheckBoxes.add(ketchupCheckBox);
        sauceCheckBoxes.add(ranchCheckBox);
        sauceCheckBoxes.add(thousandIslandCheckBox);
        sauceCheckBoxes.add(vinaigretteCheckBox);

        // Regular topping checkboxes
        JLabel selectToppingLabel = new JLabel("Select Regular Toppings:");
        JCheckBox lettuceCheckBox = new JCheckBox("Lettuce");
        JCheckBox tomatoCheckBox = new JCheckBox("Tomato");
        JCheckBox onionCheckBox = new JCheckBox("Onion");
        JCheckBox picklesCheckBox = new JCheckBox("Pickles");
        JCheckBox jalapenosCheckBox = new JCheckBox("Jalapenos",true);
        JCheckBox bananaPeppersCheckBox = new JCheckBox("Peppers",true);
        JCheckBox olivesCheckBox = new JCheckBox("Olives");
        JCheckBox cucumbersCheckBox = new JCheckBox("Cucumbers");
        JCheckBox mushroomsCheckBox = new JCheckBox("Mushrooms");
        JCheckBox spinachCheckBox = new JCheckBox("Spinach");
        JCheckBox guacamoleCheckBox = new JCheckBox("Guacamole");

        ArrayList<JCheckBox> toppingCheckBoxes = new ArrayList<>();
        toppingCheckBoxes.add(lettuceCheckBox);
        toppingCheckBoxes.add(tomatoCheckBox);
        toppingCheckBoxes.add(onionCheckBox);
        toppingCheckBoxes.add(picklesCheckBox);
        toppingCheckBoxes.add(jalapenosCheckBox);
        toppingCheckBoxes.add(bananaPeppersCheckBox);
        toppingCheckBoxes.add(olivesCheckBox);
        toppingCheckBoxes.add(cucumbersCheckBox);
        toppingCheckBoxes.add(mushroomsCheckBox);
        toppingCheckBoxes.add(spinachCheckBox);
        toppingCheckBoxes.add(guacamoleCheckBox);

        // Checkboxes for extra meat and extra cheese
        JCheckBox extraMeatCheckBox = new JCheckBox("Extra Meat");
        JCheckBox extraCheeseCheckBox = new JCheckBox("Extra Cheese",true);

        JLabel toastedLabel = new JLabel("Do You Want Your Sandwich Toasted:");
        JCheckBox toasted = new JCheckBox("Toasted",true);

        JButton addToOrderButton = new JButton("Add to Order");
        addToOrderButton.setFont(new Font("Arial", Font.BOLD, 20));
        addToOrderButton.setBackground(Color.GREEN);
        addToOrderButton.setFocusPainted(true);
        JButton backToMenuButton = new JButton("Back to Menu");
        backToMenuButton.setFont(new Font("Arial", Font.BOLD, 20));
        backToMenuButton.setBackground(Color.RED);
        backToMenuButton.setFocusPainted(false);

        addToOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Size selectedSize = (Size) sizeComboBox.getSelectedItem();
                Bread selectedBread = new Bread((String) breadComboBox.getSelectedItem());
                ArrayList<Topping> toppings = new ArrayList<>();
                Boolean toastedSandwich = toasted.isSelected();

                for (JCheckBox meatCheckBox : meatCheckBoxes) {
                    if (meatCheckBox.isSelected() && extraMeatCheckBox.isSelected()) {
                        toppings.add(new Meat(meatCheckBox.getText(), true));
                    }else if (meatCheckBox.isSelected() && !extraMeatCheckBox.isSelected()){
                        toppings.add(new Meat(meatCheckBox.getText(), false));
                    }
                }

                for (JCheckBox cheeseCheckBox : cheeseCheckBoxes) {
                    if (cheeseCheckBox.isSelected() && extraCheeseCheckBox.isSelected()) {
                        toppings.add(new Cheese(cheeseCheckBox.getText(), true));
                    }else if (cheeseCheckBox.isSelected() && !extraCheeseCheckBox.isSelected()){
                        toppings.add(new Cheese(cheeseCheckBox.getText(), false));
                    }
                }

                for (JCheckBox sauceCheckBox : sauceCheckBoxes) {
                    if (sauceCheckBox.isSelected()) {
                        toppings.add(new FreeTopping(sauceCheckBox.getText()));
                    }
                }

                for (JCheckBox toppingCheckBox : toppingCheckBoxes) {
                    if (toppingCheckBox.isSelected()) {
                        toppings.add(new FreeTopping(toppingCheckBox.getText()));
                    }
                }

                Sandwich sandwich = new Sandwich(selectedBread, toppings, selectedSize, toastedSandwich);

                AddOrderGui.sandwich.add(sandwich);
                AddOrderGui.order.add(sandwich);
                sandwich.setName("Akhil Special");
                JOptionPane.showMessageDialog(frame, "Added Akhil Special to the order:\n" + sandwich);
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
        panel.setLayout(new GridLayout(7, 2));

        JPanel dropDown = new JPanel();
        dropDown.setLayout(new GridLayout(1, 1));
        dropDown.add(selectSizeLabel);
        dropDown.add(sizeComboBox);
        dropDown.add(selectBreadLabel);
        dropDown.add(breadComboBox);
        dropDown.setBackground(Color.WHITE);
        dropDown.setForeground(Color.BLACK);
        dropDown.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel toastPanel = new JPanel();
        toastPanel.setLayout(new GridLayout(1, 1));
        toastPanel.add(toastedLabel);
        toastPanel.add(toasted);
        toastPanel.setBackground(Color.WHITE);
        toastPanel.setForeground(Color.BLACK);
        toastPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));



        JPanel meatPanel = new JPanel();
        meatPanel.setLayout(new GridLayout(2, 1));
        meatPanel.add(selectMeatLabel);
        meatPanel.add(extraMeatCheckBox);
        meatPanel.add(steakCheckBox);
        meatPanel.add(hamCheckBox);
        meatPanel.add(salamiCheckBox);
        meatPanel.add(roastBeefCheckBox);
        meatPanel.add(chickenCheckBox);
        meatPanel.add(baconCheckBox);
        meatPanel.setBackground(Color.WHITE);
        meatPanel.setForeground(Color.BLACK);
        meatPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel cheesePanel = new JPanel();
        cheesePanel.setLayout(new GridLayout(2, 1));
        cheesePanel.add(selectCheeseLabel);
        cheesePanel.add(extraCheeseCheckBox);
        cheesePanel.add(swissCheckBox);
        cheesePanel.add(cheddarCheckBox);
        cheesePanel.add(provoloneCheckBox);
        cheesePanel.add(americanCheckBox);
        cheesePanel.setBackground(Color.WHITE);
        cheesePanel.setForeground(Color.BLACK);
        cheesePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel saucePanel = new JPanel();
        saucePanel.setLayout(new GridLayout(2, 1));
        saucePanel.add(selectSauceLabel);
        saucePanel.add(mayonnaiseCheckBox);
        saucePanel.add(mustardCheckBox);
        saucePanel.add(ketchupCheckBox);
        saucePanel.add(ranchCheckBox);
        saucePanel.add(thousandIslandCheckBox);
        saucePanel.add(vinaigretteCheckBox);
        saucePanel.setBackground(Color.WHITE);
        saucePanel.setForeground(Color.BLACK);
        saucePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel toppingPanel = new JPanel();
        toppingPanel.setLayout(new GridLayout(2, 1));
        toppingPanel.add(selectToppingLabel);
        toppingPanel.add(lettuceCheckBox);
        toppingPanel.add(tomatoCheckBox);
        toppingPanel.add(onionCheckBox);
        toppingPanel.add(picklesCheckBox);
        toppingPanel.add(jalapenosCheckBox);
        toppingPanel.add(bananaPeppersCheckBox);
        toppingPanel.add(olivesCheckBox);
        toppingPanel.add(cucumbersCheckBox);
        toppingPanel.add(mushroomsCheckBox);
        toppingPanel.add(spinachCheckBox);
        toppingPanel.add(guacamoleCheckBox);
        toppingPanel.setBackground(Color.WHITE);
        toppingPanel.setForeground(Color.BLACK);
        toppingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 1));
        buttonPanel.add(addToOrderButton);
        buttonPanel.add(backToMenuButton);
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setForeground(Color.BLACK);
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        buttonPanel.getFont().deriveFont(Font.BOLD);



        panel.add(dropDown);
        panel.add(toastPanel);
        panel.add(meatPanel);
        panel.add(cheesePanel);
        panel.add(saucePanel);
        panel.add(toppingPanel);
        panel.add(buttonPanel);
        frame.add(panel, BorderLayout.WEST);
        frame.revalidate();
        frame.repaint();
    }
}
