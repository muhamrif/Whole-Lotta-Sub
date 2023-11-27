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
        Scanner input = new Scanner(System.in);
        int bread = -1;
        int meat = -1;
        int cheese = -1;
        int otherToppings = -1;
        int sauces = -1;
        int sandwichSize = -1;
        boolean toasted = false;
        while (bread == -1) {
            System.out.print("Enter type of bread (1 for white and 2 for wheat 3 for rye 4 for wrap): ");
            try {
                bread = Integer.parseInt(input.next());
                if (bread != 1 && bread != 2) {
                    System.out.println("Invalid input. Please enter 1 for white or 2 for wheat 3 for rye 4 for wrap.");
                    bread = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        while (meat == -1) {
            System.out.print("Enter type of meat (1 for turkey, 2 for ham, 3 for salami 4 for roast beef 5 for chicken 6 for bacon ): ");
            try {
                meat = Integer.parseInt(input.next());
                if (meat < 1 || meat > 3) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    meat = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        while (cheese == -1) {
            System.out.print("Do you want cheese (1 for yes, 2 for no): ");
            try {
                cheese = Integer.parseInt(input.next());
                if (cheese != 1 && cheese != 2) {
                    System.out.println("Invalid input. Please enter 1 for yes or 2 for no.");
                    cheese = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        while (otherToppings == -1) {
            System.out.print("Do you want other toppings (1 for yes, 2 for no): ");
            try {
                otherToppings = Integer.parseInt(input.next());
                if (otherToppings != 1 && otherToppings != 2) {
                    System.out.println("Invalid input. Please enter 1 for yes or 2 for no.");
                    otherToppings = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        while (sauces == -1) {
            System.out.print("Select sauces (1 for mayonnaise, 2 for mustard, 3 for ketchup, 4 for ranch 5 for thousand island 6 for vinaigrette): ");
            try {
                sauces = Integer.parseInt(input.next());
                if (sauces < 1 || sauces > 4) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    sauces = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        while (toasted == false) {
            System.out.print("Do you want your sandwich toasted (yes or no): ");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                toasted = true;
            } else if (answer.equalsIgnoreCase("no")) {
                toasted = false;
            } else {
                System.out.println("Invalid input. Please enter yes or no.");
            }
        }
        while (sandwichSize == -1) {
            System.out.print("Enter your sandwich size (1 for small, 2 for medium, 3 for large): ");
            try {
                sandwichSize = Integer.parseInt(input.next());
                if (sandwichSize < 1 || sandwichSize > 3) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    sandwichSize = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

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
