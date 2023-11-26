package com.pluralsight.userInterface;

import com.pluralsight.order.Chips;
import com.pluralsight.order.Drink;
import com.pluralsight.order.Order;
import com.pluralsight.order.Sandwich;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();


    public UserInterface() {
    }

    public void HomeMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1 New Order");
            System.out.println("2 Exit - exit the application");

            System.out.print("Your Selection: ");
            String input = scanner.next().trim();

            switch (input) {
                case "1":
                    System.out.println("Processing new order");
                    break;
                case "2":
                    System.out.println("Exiting the application");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
    }

    public void orderMenu () {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1 Add Sandwich");
            System.out.println("2 Add Drink");
            System.out.println("3 Add Chips");
            System.out.println("4 Checkout");
            System.out.println("0 Cancel Order");

            System.out.print("Your Selection: ");
            String input = scanner.next().trim();

            switch (input) {
                case "1":
                    System.out.println("Processing Sandwich");
                    break;
                case "2":
                    System.out.println("Processing Drink");
                    break;
                case "3":
                    System.out.println("Processing Chips");
                case "4":
                    System.out.println("Processing Checkout");
                case "0":
                    System.out.println("Canceling order");
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
    }


    public void addSandwichMenu(){


    }

    public void addDrinkMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose drink size:");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");

        int size = scanner.nextInt();

        System.out.println("Choose drink flavor:");
        System.out.println("1. Orange");
        System.out.println("2. Apple");
        System.out.println("3. Grape");

        int flavor = scanner.nextInt();
        System.out.println("You have ordered a " + size + " size " + flavor + " drink.");

    }

    public void addChipsMenu(){

    }

    public void processAddSandwichToOrder(Sandwich sandwich){

    }

    public void processAddDrinkToOrder(Drink drink){

    }

    public void processAddChipsToOrder(Chips chips){

    }

    public void processRemoveSandwichFromOrder(Sandwich sandwich){

    }

    public void processRemoveDrinkFromOrder(Drink drink){

    }

    public void processRemoveChipsFromOrder(Chips chips){

    }

    public void processCheckout(){
        Order order = new Order(sandwiches,drinks,chips);
    }


}
