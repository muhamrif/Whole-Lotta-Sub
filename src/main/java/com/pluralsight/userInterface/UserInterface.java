package com.pluralsight.userInterface;

import com.pluralsight.graphicalUserInterface.AddDrinksPage;
import com.pluralsight.order.Chips;
import com.pluralsight.order.Drink;
import com.pluralsight.order.Order;
import com.pluralsight.order.Sandwich;
import com.pluralsight.utils.Size;

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
        System.out.println("4. Go back to home menu");
        Size drinkSize = Size.SMALL;
        while (true) {
            System.out.println("Your Selection: ");
            String DrinkInput = scanner.next().trim();

            switch (DrinkInput) {
                case "1":
                    drinkSize = Size.SMALL;
                    System.out.println("Added small size");
                    break;
                case "2":
                    drinkSize = Size.MEDIUM;
                    System.out.println("Added medium size");
                    break;
                case "3":
                    drinkSize = Size.LARGE;
                    System.out.println("Added Large size");
                    break;
                case "4":
                    System.out.println("Go back to home menu");
                    break; 
                default:
                    System.out.println("Invalid size, please try again");
                    break;
            }
                System.out.println("Choose your brand:");
                System.out.println("1. Coco-Cola");
                System.out.println("2. Mountain Dew");
                System.out.println("3. Sprite");
                System.out.println("4 Sparkling Dew");
                System.out.println("5 Go back to home menu");

                String SelectBrand;

                while (true){
                    System.out.println("Your Brand Selection: ");
                    String BrandInput = scanner.next().trim();

                    switch (BrandInput) {
                        case "1":
                            Drink CocaCola = new Drink(drinkSize,"Coca-cola");
                            drinks.add(CocaCola);
                            System.out.println("Coca-cola was added to your order");
                            break;
                        case "2":
                            Drink MountainDew = new Drink(drinkSize, "Mountain Dew");
                            drinks.add(MountainDew);
                            System.out.println("Mountain Dew was added to your order");
                            break;
                        case "3":
                            Drink Sprite = new Drink(drinkSize,"Sprite");
                            drinks.add(Sprite);
                            System.out.println("Sprite was added to your order");
                            break;
                        case "4":
                            Drink SparklingDew = new Drink(drinkSize,"Sparkling Dew");
                            drinks.add(SparklingDew);
                            System.out.println("Sparkling Dew was added to your order");
                        case "5":
                            System.out.println("Go back to home menu");
                            break;
                        default:
                            System.out.println("Invalid option. Please try again");
                            break;

                    }

                }


        }

    }

    public void addChipsMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("What Flavor of Chips would you Like to Add to your order?:");
        System.out.println("1. plain");
        System.out.println("2. BBQ");
        System.out.println("3. salt and vinegar");
        System.out.println("4. salt");
        System.out.println("5. go back to menu");
        boolean flag = true;

        while (flag){

            System.out.print("Your Selection: ");
            String ChipsInput = input.next().trim();

            switch (ChipsInput) {
                case "1":
                    Chips plain = new Chips("plain");
                    chips.add(plain);
                    System.out.println("Plain Chips added to order!");
                    break;
                case "2":
                    Chips bbqChips = new Chips("BBQ");
                    chips.add(bbqChips);
                    System.out.println("BBQ Chips added to order!");
                    break;
                case "3":
                    Chips saltAndVinegar = new Chips("salt and vinegar");
                    chips.add(saltAndVinegar);
                    System.out.println("salt and vinegar Chips added to order!");
                    break;
                case "4":
                    Chips salt = new Chips("salt");
                    chips.add(salt);
                    System.out.println("Salt Chips added to order!");
                    break;
                case "5":
                    System.out.println("Going back to menu");
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }

        }




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
