package com.pluralsight.graphicalUserInterface;

import com.pluralsight.fileManager.OrderFileManager;
import com.pluralsight.order.Chips;
import com.pluralsight.order.Drink;
import com.pluralsight.order.Order;
import com.pluralsight.order.Sandwich;
import com.pluralsight.utils.Size;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class AddOrderGui {
    static ArrayList<Object> order = new ArrayList<>();
    static ArrayList<Drink> drinks = new ArrayList<>();
    static ArrayList<Sandwich> sandwich = new ArrayList<>();
    static ArrayList<Chips> chips = new ArrayList<>();

    static Order finalOrder = new Order(sandwich, drinks, chips);
    private static JFrame frame;
    public static JTextArea orderScreen;

    public static void run() {
        SwingUtilities.invokeLater(AddOrderGui::showOrderScreen);
    }

    private static void showOrderScreen() {
        frame = new JFrame("Add items to your order");
        frame.getContentPane().removeAll();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);


        JButton addSandwichButton = new JButton("Add Sandwich");
        JButton addDrinkButton = new JButton("Add Drink");
        JButton addChipsButton = new JButton("Add Chips");
        JButton checkoutButton = new JButton("Checkout");
        JButton cancelButton = new JButton("Cancel Order");
        JButton removeItemButton = new JButton("Remove Item From Order");

        addSandwichButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddSandwichPage(frame).showAddSandwichScreen();
            }
        });

        addDrinkButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDrinksPage(frame).showAddDrinkScreen();

            }
        });

        addChipsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddChipsPage(frame).showAddChipsScreen();
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (order.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please add items to your order before checking out!");
                }else {
                    JOptionPane.showMessageDialog(frame, "Order checked out!");
                    frame.setVisible(false);
                    frame.dispose();
                    HomeMenuGUI.run();
                    finalOrder.setSandwiches(sandwich);
                    finalOrder.setDrinks(drinks);
                    finalOrder.setChips(chips);
                    finalOrder.setOrderTotalPrice(finalOrder.getPrice(Size.SMALL));
                    OrderFileManager.saveOrder(finalOrder);
                    order.clear();
                    drinks.clear();
                    sandwich.clear();
                    chips.clear();
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Order Cancelled : (");
                frame.setVisible(false);
                frame.dispose();
                HomeMenuGUI.run();
                order.clear();
                drinks.clear();
                sandwich.clear();
                chips.clear();
            }
        });
        removeItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveItemPage(frame).showRemoveItemScreen();
            }
        });

        JPanel LeftButtonPanel = new JPanel();
        LeftButtonPanel.setLayout(new GridLayout(3, 1));
        LeftButtonPanel.add(addSandwichButton);
        LeftButtonPanel.add(addDrinkButton);
        LeftButtonPanel.add(addChipsButton);

        JPanel RightButtonPanel = new JPanel();
        RightButtonPanel.setLayout(new GridLayout(3, 1));
        RightButtonPanel.add(checkoutButton);
        RightButtonPanel.add(removeItemButton);
        RightButtonPanel.add(cancelButton);

        orderScreen = new JTextArea();
        JScrollPane sp = new JScrollPane(orderScreen);
        sp.setFont(new Font("Arial", Font.PLAIN, 15));
        orderScreen.setLineWrap(true);
        orderScreen.setEditable(false);
        orderScreen.setAutoscrolls(true);
        addOrderToDisplay();


        frame.add(RightButtonPanel, BorderLayout.EAST);
        frame.add(LeftButtonPanel, BorderLayout.WEST);
        frame.add(sp, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private static void addOrderToDisplay() {
        double total = 0;
        int itemNumber = 1;
        orderScreen.setText("");
        orderScreen.append("                                            WholeLottaSub\n" +
                "                                           " + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getYear() + "\n" +
                "                                           " + "123 Potato St, NY, USA" + "\n" +
                "                                           " + "123-456-7890" + "\n" + "\n");

        orderScreen.append("Order #" + finalOrder.getOrderNumber() + "\n");
        for (Object item : order) {
            orderScreen.append("Item #" + itemNumber +":"+"\n");
            orderScreen.append(item.toString() + "\n");
            if(item instanceof Sandwich) {
                total += ((Sandwich) item).getPrice(((Sandwich) item).getSize());
            } else if (item instanceof Chips) {
                total += ((Chips) item).getPrice(Size.SMALL);
            } else if (item instanceof Drink) {
                total += ((Drink) item).getPrice(((Drink) item).getSize());
            }
            itemNumber++;
        }

        orderScreen.append("\n" + "Order Total: $" + total);

    }
}
