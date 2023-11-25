package com.pluralsight.fileManager;

import com.pluralsight.order.Chips;
import com.pluralsight.order.Drink;
import com.pluralsight.order.Order;
import com.pluralsight.order.Sandwich;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderFileManager {

    public ArrayList<Order> getSavedOrders(){
        return null;
    }

    public void saveOrder(Order order){
        order.setCheckoutTime(LocalDateTime.now());
        List<Sandwich> sandwiches = order.getSandwiches();
        List<Drink> drinks = order.getDrinks();
        List<Chips> chips = order.getChips();
        String FILE_NAME = "reciepts/"+order.getCheckoutTime().getYear() + (order.getCheckoutTime().getMonthValue()) + order.getCheckoutTime().getDayOfMonth() + "-" + order.getCheckoutTime().getHour() + order.getCheckoutTime().getMinute() + order.getCheckoutTime().getSecond() + ".txt";
        try {
            File myFile = new File(FILE_NAME);
            if (myFile.createNewFile()) {
                System.out.println("Order Placed!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));

            writer.write(
                    "                    WholeLottaSub\n" +
                    "                    "+ order.getCheckoutTime().getMonthValue()+"/"+order.getCheckoutTime().getDayOfMonth()+"/"+order.getCheckoutTime().getYear()+ "\n"+
                    "                    "+"123 Potato St, NY, USA" + "\n"+
                    "                    "+"123-456-7890" + "\n"+
                    "Order#: " + order.getOrderNumber() + "\n"+ "\n");
            writer.close();
        }catch(Exception e) {
            System.out.println(e);
        }



        try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
                for (Sandwich sandwich : sandwiches) {
                 writer.write(sandwich.toString() + "\n");
                }
                for (Drink drink : drinks) {
                 writer.write(drink.toString() + "\n");
                }
                for (Chips chip : chips) {
                 writer.write(chip.toString() + "\n");
                }
                writer.write("Order Total: $" + order.getOrderTotalPrice()+ "\n");

                writer.write("                      Thank you for your order, Hope to see you soon!");
                writer.close();
          } catch (IOException e) {
                System.out.println(e);
          }

    }
}
