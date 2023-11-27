package com.pluralsight.userInterface;

import com.pluralsight.fileManager.OrderFileManager;
import com.pluralsight.graphicalUserInterface.AddDrinksPage;
import com.pluralsight.order.*;
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
                    orderMenu();
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

    public void orderMenu() {
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
                    addSandwichMenu();
                    break;
                case "2":
                    addDrinkMenu();
                    break;
                case "3":
                    addChipsMenu();
                    break;
                case "4":
                    processCheckout();
                    running = false;
                    break;
                case "0":
                    System.out.println("Canceling order");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
    }


    public void addSandwichMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("What Size of sandwich would you like to add to your order?:");
        System.out.println("1. 4 inch (small)");
        System.out.println("2. 8 inch (medium)");
        System.out.println("3. 12 inch (large)");
        System.out.println("4. go back to menu");
        Size sandwichSize = Size.SMALL;
        boolean sizeFlag = true;
        while (sizeFlag) {

            System.out.print("Your Selection: ");
            String SandwichInput = input.next().trim();

            switch (SandwichInput) {
                case "1":
                    sandwichSize = Size.SMALL;
                    System.out.println("small size Selected for sandwich");
                    sizeFlag = false;
                    break;
                case "2":
                    sandwichSize = Size.MEDIUM;
                    System.out.println("medium size Selected for sandwich");
                    sizeFlag = false;
                    break;
                case "3":
                    sandwichSize = Size.LARGE;
                    System.out.println("large size Selected for sandwich");
                    sizeFlag = false;
                    break;
                case "4":
                    System.out.println("Going back to menu");
                    sizeFlag = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }

        System.out.println("What type of bread would you like to add to your sandwich?:");
        System.out.println("1. White");
        System.out.println("2. Whole Wheat");
        System.out.println("3. Rye");
        System.out.println("4. Wrap");
        System.out.println("5. Go back to menu");
        Bread sandwichBread = new Bread("no bread");
        boolean breadFlag = true;
        while (breadFlag) {

            System.out.print("Your Selection: ");
            String BreadInput = input.next().trim();

            switch (BreadInput) {
                case "1":
                    sandwichBread.setType("White");
                    System.out.println("White Bread Selected for sandwich");
                    breadFlag = false;
                    break;
                case "2":
                    sandwichBread.setType("Whole Wheat");
                    System.out.println("Whole Wheat Bread Selected for sandwich");
                    breadFlag = false;
                    break;
                case "3":
                    sandwichBread.setType("Rye");
                    System.out.println("Rye Bread Selected for sandwich");
                    breadFlag = false;
                    break;
                case "4":
                    sandwichBread.setType("Wrap");
                    System.out.println("Wrap Selected for sandwich");
                    breadFlag = false;
                    break;
                case "5":
                    System.out.println("Going back to menu");
                    breadFlag = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }

        System.out.println("Would you like your sandwich toasted?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("3. Go back to menu");
        boolean toastedFlag = true;
        boolean sandwichToasted = false;
        while (toastedFlag) {

            System.out.print("Your Selection: ");
            String ToastedInput = input.next().trim();

            switch (ToastedInput) {
                case "1":
                    sandwichToasted = true;
                    System.out.println("Sandwich will be toasted");
                    toastedFlag = false;
                    break;
                case "2":
                    sandwichToasted = false;
                    System.out.println("Sandwich will not be toasted");
                    toastedFlag = false;
                    break;
                case "3":
                    System.out.println("Going back to menu");
                    toastedFlag = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }

        ArrayList<Topping> toppings = new ArrayList<>();

        System.out.println("Would you like to add toppings to your sandwich?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("3. Go back to menu");
        boolean toppingFlag = true;

        while (toppingFlag) {
            System.out.print("Your Selection: ");
            String ToppingInput = input.next().trim();

            switch (ToppingInput) {
                case "1":
                    System.out.println("Adding toppings to sandwich");
                    toppings = addTopping();
                    toppingFlag = false;
                    break;
                case "2":
                    System.out.println("No toppings added to sandwich");
                    toppingFlag = false;
                    break;
                case "3":
                    System.out.println("Going back to menu");
                    toppingFlag = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }

        Sandwich sandwich = new Sandwich(sandwichBread, toppings, sandwichSize, sandwichToasted);
        sandwiches.add(sandwich);

        System.out.println("Sandwich added to order!");
    }

    public ArrayList<Topping> addTopping() {
        Scanner input = new Scanner(System.in);
        ArrayList<Topping> toppings = new ArrayList<>();


        boolean toppingFlag = true;

        while (toppingFlag) {
            System.out.println("What Toppings would you like to add to your sandwich?:");
            System.out.println("1. Meats");
            System.out.println("2. Cheeses");
            System.out.println("3. Sauces");
            System.out.println("4. Veggies");
            System.out.println("5. No more toppings to add");
            System.out.print("Your Selection: ");
            String ToppingInput = input.next().trim();

            switch (ToppingInput) {
                case "1":
                    System.out.println("Adding Meats to sandwich");
                    System.out.println("1. Ham");
                    System.out.println("2. Turkey");
                    System.out.println("3. Roast Beef");
                    System.out.println("4. Chicken");
                    System.out.println("5. Salami");
                    System.out.println("6. bacon");
                    System.out.println("7. Go back to menu");
                    boolean meatFlag = true;
                    while (meatFlag) {
                        System.out.print("Your Selection: ");
                        String MeatInput = input.next().trim();

                        switch (MeatInput) {
                            case "1":
                                System.out.println("Would you like to add extra Ham to your sandwich?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                System.out.println("3. Go back to menu");
                                boolean extraMeatFlag = true;
                                while (extraMeatFlag) {
                                    System.out.print("Your Selection: ");
                                    String ExtraMeatInput = input.next().trim();

                                    switch (ExtraMeatInput) {
                                        case "1":
                                            Topping ham = new Meat("Ham", true);
                                            toppings.add(ham);
                                            System.out.println("Extra Ham added to sandwich");
                                            extraMeatFlag = false;
                                            break;
                                        case "2":
                                            Topping ham2 = new Meat("Ham", false);
                                            toppings.add(ham2);
                                            System.out.println("Ham added to sandwich");
                                            extraMeatFlag = false;
                                            break;
                                        case "3":
                                            System.out.println("Going back to menu");
                                            extraMeatFlag = false;
                                            break;
                                        default:
                                            System.out.println("Invalid option, please try again.");
                                            break;
                                    }
                                }
                                meatFlag = false;
                                break;
                            case "2":
                                System.out.println("Would you like to add extra Turkey to your sandwich?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                System.out.println("3. Go back to menu");
                                boolean extraTurkeyFlag = true;
                                while (extraTurkeyFlag) {
                                    System.out.print("Your Selection: ");
                                    String ExtraTurkeyInput = input.next().trim();

                                    switch (ExtraTurkeyInput) {
                                        case "1":
                                            Topping turkey = new Meat("Turkey", true);
                                            toppings.add(turkey);
                                            System.out.println("Extra Turkey added to sandwich");
                                            extraTurkeyFlag = false;
                                            break;
                                        case "2":
                                            Topping turkey2 = new Meat("Turkey", false);
                                            toppings.add(turkey2);
                                            System.out.println("Turkey added to sandwich");
                                            extraTurkeyFlag = false;
                                            break;
                                        case "3":
                                            System.out.println("Going back to menu");
                                            extraTurkeyFlag = false;
                                            break;
                                        default:
                                            System.out.println("Invalid option, please try again.");
                                            break;
                                    }
                                }
                                meatFlag = false;
                                break;
                            case "3":
                                System.out.println("Would you like to add extra Roast Beef to your sandwich?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                System.out.println("3. Go back to menu");
                                boolean extraRoastBeefFlag = true;
                                while (extraRoastBeefFlag) {
                                    System.out.print("Your Selection: ");
                                    String ExtraRoastBeefInput = input.next().trim();

                                    switch (ExtraRoastBeefInput) {
                                        case "1":
                                            Topping roastBeef = new Meat("Roast Beef", true);
                                            toppings.add(roastBeef);
                                            System.out.println("Extra Roast Beef added to sandwich");
                                            extraRoastBeefFlag = false;
                                            break;
                                        case "2":
                                            Topping roastBeef2 = new Meat("Roast Beef", false);
                                            toppings.add(roastBeef2);
                                            System.out.println("Roast Beef added to sandwich");
                                            extraRoastBeefFlag = false;
                                            break;
                                        case "3":
                                            System.out.println("Going back to menu");
                                            extraRoastBeefFlag = false;
                                            break;
                                        default:
                                            System.out.println("Invalid option, please try again.");
                                            break;
                                    }
                                }
                                meatFlag = false;
                                break;
                            case "4":
                                System.out.println("Would you like to add extra Chicken to your sandwich?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                System.out.println("3. Go back to menu");
                                boolean extraChickenFlag = true;
                                while (extraChickenFlag) {
                                    System.out.print("Your Selection: ");
                                    String ExtraChickenInput = input.next().trim();

                                    switch (ExtraChickenInput) {
                                        case "1":
                                            Topping chicken = new Meat("Chicken", true);
                                            toppings.add(chicken);
                                            System.out.println("Extra Chicken added to sandwich");
                                            extraChickenFlag = false;
                                            break;
                                        case "2":
                                            Topping chicken2 = new Meat("Chicken", false);
                                            toppings.add(chicken2);
                                            System.out.println("Chicken added to sandwich");
                                            extraChickenFlag = false;
                                            break;
                                        case "3":
                                            System.out.println("Going back to menu");
                                            extraChickenFlag = false;
                                            break;
                                        default:
                                            System.out.println("Invalid option, please try again.");
                                            break;
                                    }
                                }
                                meatFlag = false;
                                break;
                            case "5":
                                System.out.println("Would you like to add extra Salami to your sandwich?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                System.out.println("3. Go back to menu");
                                boolean extraSalamiFlag = true;
                                while (extraSalamiFlag) {
                                    System.out.print("Your Selection: ");
                                    String ExtraSalamiInput = input.next().trim();

                                    switch (ExtraSalamiInput) {
                                        case "1":
                                            Topping salami = new Meat("Salami", true);
                                            toppings.add(salami);
                                            System.out.println("Extra Salami added to sandwich");
                                            extraSalamiFlag = false;
                                            break;
                                        case "2":
                                            Topping salami2 = new Meat("Salami", false);
                                            toppings.add(salami2);
                                            System.out.println("Salami added to sandwich");
                                            extraSalamiFlag = false;
                                            break;
                                        case "3":
                                            System.out.println("Going back to menu");
                                            extraSalamiFlag = false;
                                            break;
                                        default:
                                            System.out.println("Invalid option, please try again.");
                                            break;
                                    }
                                }
                                meatFlag = false;
                                break;
                            case "6":
                                System.out.println("Would you like to add extra Bacon to your sandwich?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                System.out.println("3. Go back to menu");
                                boolean extraBaconFlag = true;
                                while (extraBaconFlag) {
                                    System.out.print("Your Selection: ");
                                    String ExtraBaconInput = input.next().trim();

                                    switch (ExtraBaconInput) {
                                        case "1":
                                            Topping bacon = new Meat("Bacon", true);
                                            toppings.add(bacon);
                                            System.out.println("Extra Bacon added to sandwich");
                                            extraBaconFlag = false;
                                            break;
                                        case "2":
                                            Topping bacon2 = new Meat("Bacon", false);
                                            toppings.add(bacon2);
                                            System.out.println("Bacon added to sandwich");
                                            extraBaconFlag = false;
                                            break;
                                        case "3":
                                            System.out.println("Going back to menu");
                                            extraBaconFlag = false;
                                            break;
                                        default:
                                            System.out.println("Invalid option, please try again.");
                                            break;
                                    }
                                }
                                meatFlag = false;
                                break;
                            case "7":
                                System.out.println("Going back to menu");
                                meatFlag = false;
                                break;
                            default:
                                System.out.println("Invalid option, please try again.");
                                break;
                        }
                    }
//                    toppingFlag = false;
                    break;
                case "2":
                    System.out.println("Adding Cheeses to sandwich");
                    System.out.println("1. American");
                    System.out.println("2. Swiss");
                    System.out.println("3. Cheddar");
                    System.out.println("4. Provolone");
                    System.out.println("5. Go back to menu");
                    boolean cheeseFlag = true;
                    while (cheeseFlag) {
                        System.out.print("Your Selection: ");
                        String CheeseInput = input.next().trim();

                        switch (CheeseInput) {
                            case "1":
                                System.out.println("Would you like to add extra American Cheese to your sandwich?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                System.out.println("3. Go back to menu");
                                boolean extraAmericanCheese = true;
                                while (extraAmericanCheese) {
                                    System.out.print("Your Selection: ");
                                    String extraAmericanCheeseInput = input.next().trim();

                                    switch (extraAmericanCheeseInput) {
                                        case "1":
                                            Topping americanCheese = new Cheese("American Cheese", true);
                                            toppings.add(americanCheese);
                                            System.out.println("Extra American Cheese added to sandwich");
                                            extraAmericanCheese = false;
                                            break;
                                        case "2":
                                            Topping americanCheese1 = new Cheese("American Cheese", false);
                                            toppings.add(americanCheese1);
                                            System.out.println("American Cheese added to sandwich");
                                            extraAmericanCheese = false;
                                            break;
                                        case "3":
                                            System.out.println("Going back to menu");
                                            extraAmericanCheese = false;
                                            break;
                                        default:
                                            System.out.println("Invalid option, please try again.");
                                            break;
                                    }
                                }
                                cheeseFlag = false;
                                break;
                            case "2":
                                System.out.println("Would you like to add extra Swiss Cheese to your sandwich?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                System.out.println("3. Go back to menu");
                                boolean extraSwissCheese = true;
                                while (extraSwissCheese) {
                                    System.out.print("Your Selection: ");
                                    String extraSwissCheeseInput = input.next().trim();

                                    switch (extraSwissCheeseInput) {
                                        case "1":
                                            Topping swissCheese = new Cheese("Swiss Cheese", true);
                                            toppings.add(swissCheese);
                                            System.out.println("Extra Swiss Cheese added to sandwich");
                                            extraSwissCheese = false;
                                            break;
                                        case "2":
                                            Topping swissCheese1 = new Cheese("Swiss Cheese", false);
                                            toppings.add(swissCheese1);
                                            System.out.println("Swiss Cheese added to sandwich");
                                            extraSwissCheese = false;
                                            break;
                                        case "3":
                                            System.out.println("Going back to menu");
                                            extraSwissCheese = false;
                                            break;
                                        default:
                                            System.out.println("Invalid option, please try again.");
                                            break;
                                    }
                                }
                                cheeseFlag = false;
                                break;
                            case "3":
                                System.out.println("Would you like to add extra Cheddar Cheese to your sandwich?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                System.out.println("3. Go back to menu");
                                boolean extraCheddarCheese = true;
                                while (extraCheddarCheese) {
                                    System.out.print("Your Selection: ");
                                    String extraCheddarCheeseInput = input.next().trim();

                                    switch (extraCheddarCheeseInput) {
                                        case "1":
                                            Topping cheddarCheese = new Cheese("Cheddar Cheese", true);
                                            toppings.add(cheddarCheese);
                                            System.out.println("Extra Cheddar Cheese added to sandwich");
                                            extraCheddarCheese = false;
                                            break;
                                        case "2":
                                            Topping cheddarCheese1 = new Cheese("Cheddar Cheese", false);
                                            toppings.add(cheddarCheese1);
                                            System.out.println("Cheddar Cheese added to sandwich");
                                            extraCheddarCheese = false;
                                            break;
                                        case "3":
                                            System.out.println("Going back to menu");
                                            extraCheddarCheese = false;
                                            break;
                                        default:
                                            System.out.println("Invalid option, please try again.");
                                            break;
                                    }
                                }
                                cheeseFlag = false;
                                break;
                            case "4":
                                System.out.println("Would you like to add extra Provolone Cheese to your sandwich?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                System.out.println("3. Go back to menu");
                                boolean extraProvoloneCheese = true;
                                while (extraProvoloneCheese) {
                                    System.out.print("Your Selection: ");
                                    String extraProvoloneCheeseInput = input.next().trim();

                                    switch (extraProvoloneCheeseInput) {
                                        case "1":
                                            Topping provoloneCheese = new Cheese("Provolone Cheese", true);
                                            toppings.add(provoloneCheese);
                                            System.out.println("Extra Provolone Cheese added to sandwich");
                                            extraProvoloneCheese = false;
                                            break;
                                        case "2":
                                            Topping provoloneCheese1 = new Cheese("Provolone Cheese", false);
                                            toppings.add(provoloneCheese1);
                                            System.out.println("Provolone Cheese added to sandwich");
                                            extraProvoloneCheese = false;
                                            break;
                                        case "3":
                                            System.out.println("Going back to menu");
                                            extraProvoloneCheese = false;
                                            break;
                                        default:
                                            System.out.println("Invalid option, please try again.");
                                            break;
                                    }
                                }
                                cheeseFlag = false;
                                break;
                            case "5":
                                System.out.println("Going back to menu");
                                cheeseFlag = false;
                                break;
                            default:
                                System.out.println("Invalid option, please try again.");
                                break;
                        }
                    }
//                    toppingFlag = false;
                    break;
                case "3":
                    System.out.println("Adding Sauces to sandwich");
                    System.out.println("1. Mayo");
                    System.out.println("2. Mustard");
                    System.out.println("3. Ranch");
                    System.out.println("4. Ketchup");
                    System.out.println("5. Thousand Island");
                    System.out.println("6. Vinaigrette");
                    System.out.println("7. Go back to menu");
                    boolean sauceFlag = true;
                    while (sauceFlag) {
                        System.out.print("Your Selection: ");
                        String SauceInput = input.next().trim();

                        switch (SauceInput) {
                            case "1":
                                Topping mayo = new FreeTopping("Mayo");
                                toppings.add(mayo);
                                System.out.println("Mayo added to sandwich");
                                sauceFlag = false;
                                break;
                            case "2":
                                Topping mustard = new FreeTopping("Mustard");
                                toppings.add(mustard);
                                System.out.println("Mustard added to sandwich");
                                sauceFlag = false;
                                break;
                            case "3":
                                Topping ranch = new FreeTopping("Ranch");
                                toppings.add(ranch);
                                System.out.println("Ranch added to sandwich");
                                sauceFlag = false;
                                break;
                            case "4":
                                Topping ketchup = new FreeTopping("Ketchup");
                                toppings.add(ketchup);
                                System.out.println("Ketchup added to sandwich");
                                sauceFlag = false;
                                break;

                            case "5":
                                Topping thousandIsland = new FreeTopping("Thousand Island");
                                toppings.add(thousandIsland);
                                System.out.println("Thousand Island added to sandwich");
                                sauceFlag = false;
                                break;
                            case "6":
                                Topping vinaigrette = new FreeTopping("Vinaigrette");
                                toppings.add(vinaigrette);
                                System.out.println("Vinaigrette added to sandwich");
                                sauceFlag = false;
                                break;
                            case "7":
                                System.out.println("Going back to menu");
                                sauceFlag = false;
                                break;
                            default:
                                System.out.println("Invalid option, please try again.");
                                break;
                        }
                    }
//                    toppingFlag = false;
                    break;
                case "4":
                    System.out.println("Adding Veggies to sandwich");
                    System.out.println("1. Lettuce");
                    System.out.println("2. Tomato");
                    System.out.println("3. Onion");
                    System.out.println("4. Pickles");
                    System.out.println("5. Peppers");
                    System.out.println("6. Jalapenos");
                    System.out.println("7. Cucumbers");
                    System.out.println("8. Mushrooms");
                    System.out.println("9. Guacamole");
                    System.out.println("X. Go back to menu");
                    boolean veggieFlag = true;
                    while (veggieFlag) {
                        System.out.print("Your Selection: ");
                        String VeggieInput = input.next().trim();

                        switch (VeggieInput.toLowerCase()) {
                            case "1":
                                Topping lettuce = new FreeTopping("Lettuce");
                                toppings.add(lettuce);
                                System.out.println("Lettuce added to sandwich");
                                veggieFlag = false;
                                break;
                            case "2":
                                Topping tomato = new FreeTopping("Tomato");
                                toppings.add(tomato);
                                System.out.println("Tomato added to sandwich");
                                veggieFlag = false;
                                break;
                            case "3":
                                Topping onion = new FreeTopping("Onion");
                                toppings.add(onion);
                                System.out.println("Onion added to sandwich");
                                veggieFlag = false;
                                break;
                            case "4":
                                Topping pickles = new FreeTopping("Pickles");
                                toppings.add(pickles);
                                System.out.println("Pickles added to sandwich");
                                veggieFlag = false;
                                break;
                            case "5":
                                Topping peppers = new FreeTopping("Peppers");
                                toppings.add(peppers);
                                System.out.println("Peppers added to sandwich");
                                veggieFlag = false;
                                break;
                            case "6":
                                Topping jalapenos = new FreeTopping("Jalapenos");
                                toppings.add(jalapenos);
                                System.out.println("Jalapenos added to sandwich");
                                veggieFlag = false;
                                break;
                            case "7":
                                Topping cucumbers = new FreeTopping("Cucumbers");
                                toppings.add(cucumbers);
                                System.out.println("Cucumbers added to sandwich");
                                veggieFlag = false;
                                break;
                            case "8":
                                Topping mushrooms = new FreeTopping("Mushrooms");
                                toppings.add(mushrooms);
                                System.out.println("Mushrooms added to sandwich");
                                veggieFlag = false;
                                break;
                            case "9":
                                Topping guacamole = new FreeTopping("Guacamole");
                                toppings.add(guacamole);
                                System.out.println("Guacamole added to sandwich");
                                veggieFlag = false;
                                break;
                            case "x":
                                System.out.println("Going back to menu");
                                veggieFlag = false;
                                break;
                            default:
                                System.out.println("Invalid option, please try again.");
                                break;
                        }
                    }
//                    toppingFlag = false;
                    break;
                case "5":
                    System.out.println("All of the toppings have been added to your sandwich");
                    toppingFlag = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }


        return toppings;

    }


    public void addDrinkMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose drink size:");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        System.out.println("4. Go back to home menu");
        Size drinkSize = Size.SMALL;
        boolean sizeFlag = true;
        while (sizeFlag) {
            System.out.println("Your Selection: ");
            String DrinkInput = scanner.next().trim();

            switch (DrinkInput) {
                case "1":
                    drinkSize = Size.SMALL;
                    System.out.println("Added small size");
                    sizeFlag = false;
                    break;
                case "2":
                    drinkSize = Size.MEDIUM;
                    System.out.println("Added medium size");
                    sizeFlag = false;
                    break;
                case "3":
                    drinkSize = Size.LARGE;
                    System.out.println("Added Large size");
                    sizeFlag = false;
                    break;
                case "4":
                    System.out.println("Go back to home menu");
                    sizeFlag = false;
                    break;
                default:
                    System.out.println("Invalid size, please try again");
                    sizeFlag = false;
                    break;
            }
        }
            System.out.println("Choose your brand:");
            System.out.println("1. Coco-Cola");
            System.out.println("2. Mountain Dew");
            System.out.println("3. Sprite");
            System.out.println("4. Pepsi");
            System.out.println("5. Go back to home menu");
            boolean brandFlag = true;
            while (brandFlag) {
                System.out.println("Your Brand Selection: ");
                String BrandInput = scanner.next().trim();

                switch (BrandInput) {
                    case "1":
                        Drink CocaCola = new Drink(drinkSize, "Coca-cola");
                        drinks.add(CocaCola);
                        System.out.println("Coca-cola was added to your order");
                        brandFlag = false;
                        break;
                    case "2":
                        Drink MountainDew = new Drink(drinkSize, "Mountain Dew");
                        drinks.add(MountainDew);
                        System.out.println("Mountain Dew was added to your order");
                        brandFlag = false;
                        break;
                    case "3":
                        Drink Sprite = new Drink(drinkSize, "Sprite");
                        drinks.add(Sprite);
                        System.out.println("Sprite was added to your order");
                        brandFlag = false;
                        break;
                    case "4":
                        Drink pepsi = new Drink(drinkSize, "Pepsi");
                        drinks.add(pepsi);
                        System.out.println("Sparkling Dew was added to your order");
                        brandFlag = false;
                        break;
                    case "5":
                        System.out.println("Go back to home menu");
                        brandFlag = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again");
                        break;

                }

            }




    }

    public void addChipsMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("What Flavor of Chips would you Like to Add to your order?:");
        System.out.println("1. plain");
        System.out.println("2. BBQ");
        System.out.println("3. salt and vinegar");
        System.out.println("4. salt");
        System.out.println("5. go back to menu");
        boolean flag = true;

        while (flag) {

            System.out.print("Your Selection: ");
            String ChipsInput = input.next().trim();

            switch (ChipsInput) {
                case "1":
                    Chips plain = new Chips("plain");
                    chips.add(plain);
                    System.out.println("Plain Chips added to order!");
                    flag = false;
                    break;
                case "2":
                    Chips bbqChips = new Chips("BBQ");
                    chips.add(bbqChips);
                    System.out.println("BBQ Chips added to order!");
                    flag = false;
                    break;
                case "3":
                    Chips saltAndVinegar = new Chips("salt and vinegar");
                    chips.add(saltAndVinegar);
                    System.out.println("salt and vinegar Chips added to order!");
                    flag = false;
                    break;
                case "4":
                    Chips salt = new Chips("salt");
                    chips.add(salt);
                    System.out.println("Salt Chips added to order!");
                    flag = false;
                    break;
                case "5":
                    System.out.println("Going back to menu");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }

        }


    }


    public void processRemoveSandwichFromOrder(Sandwich sandwich) {

    }

    public void processRemoveDrinkFromOrder(Drink drink) {

    }

    public void processRemoveChipsFromOrder(Chips chips) {

    }

    public void processCheckout() {
        Order order = new Order(sandwiches, drinks, chips);
        OrderFileManager orderFileManager1 = new OrderFileManager();
        orderFileManager1.saveOrder(order);
        System.out.println("Your order is: ");
//        System.out.println(order.toString());
        for (Sandwich sandwich : sandwiches) {
            System.out.println(sandwich.toString() + "\n");
        }
        for (Drink drink : drinks) {
            System.out.println(drink.toString() + "\n");
        }
        for (Chips chip : chips) {
            System.out.println(chip.toString() + "\n");
        }
        System.out.println("Order Total: $"+order.getPrice(Size.SMALL));
    }


}
