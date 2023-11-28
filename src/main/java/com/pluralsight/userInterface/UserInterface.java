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
            System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT+"Choose an option:"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"1 New Order"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"2 Exit - exit the application"+ConsoleColors.RESET);

            System.out.print(ConsoleColors.WHITE_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
            String input = scanner.next().trim();

            switch (input) {
                case "1":
                    orderMenu();
                    break;
                case "2":
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Exiting the application"+ConsoleColors.RESET);
                    running = false;
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                    break;
            }
        }
    }

    public void orderMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT+"Choose an option:"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"1 Add Sandwich"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"2 Add Drink"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"3 Add Chips"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"4 Checkout"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"0 Cancel Order"+ConsoleColors.RESET);

            System.out.print(ConsoleColors.WHITE_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
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
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Canceling order"+ConsoleColors.RESET);
                    running = false;
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                    break;
            }
        }
    }


    public void addSandwichMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"What Size of sandwich would you like to add to your order?:"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"1. 4 inch (small)"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"2. 8 inch (medium)"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"3. 12 inch (large)"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"4. go back to menu"+ConsoleColors.RESET);
        Size sandwichSize = Size.SMALL;
        boolean sizeFlag = true;
        while (sizeFlag) {

            System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
            String SandwichInput = input.next().trim();

            switch (SandwichInput) {
                case "1":
                    sandwichSize = Size.SMALL;
                    System.out.println(ConsoleColors.WHITE+"small size Selected for sandwich"+ConsoleColors.RESET);
                    sizeFlag = false;
                    break;
                case "2":
                    sandwichSize = Size.MEDIUM;
                    System.out.println(ConsoleColors.WHITE+"medium size Selected for sandwich"+ConsoleColors.RESET);
                    sizeFlag = false;
                    break;
                case "3":
                    sandwichSize = Size.LARGE;
                    System.out.println(ConsoleColors.WHITE+"large size Selected for sandwich"+ConsoleColors.RESET);
                    sizeFlag = false;
                    break;
                case "4":
                    System.out.println(ConsoleColors.WHITE+"Going back to menu"+ConsoleColors.RESET);
                    sizeFlag = false;
                    break;
                default:
                    System.out.println(ConsoleColors.WHITE+"Invalid option, please try again."+ConsoleColors.RESET);
                    break;
            }
        }

        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"What type of bread would you like to add to your sandwich?:"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"1. White"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"2. Whole Wheat"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"3. Rye"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"4. Wrap"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"5. Go back to menu"+ConsoleColors.RESET);
        Bread sandwichBread = new Bread("no bread");
        boolean breadFlag = true;
        while (breadFlag) {

            System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
            String BreadInput = input.next().trim();

            switch (BreadInput) {
                case "1":
                    sandwichBread.setType("White");
                    System.out.println(ConsoleColors.WHITE+"White Bread Selected for sandwich"+ConsoleColors.RESET);
                    breadFlag = false;
                    break;
                case "2":
                    sandwichBread.setType("Whole Wheat");
                    System.out.println(ConsoleColors.WHITE+"Whole Wheat Bread Selected for sandwich"+ConsoleColors.RESET);
                    breadFlag = false;
                    break;
                case "3":
                    sandwichBread.setType("Rye");
                    System.out.println(ConsoleColors.WHITE+"Rye Bread Selected for sandwich"+ConsoleColors.RESET);
                    breadFlag = false;
                    break;
                case "4":
                    sandwichBread.setType("Wrap");
                    System.out.println(ConsoleColors.WHITE+"Wrap Selected for sandwich"+ConsoleColors.RESET);
                    breadFlag = false;
                    break;
                case "5":
                    System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Going back to menu"+ConsoleColors.RESET);
                    breadFlag = false;
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                    break;
            }
        }

        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like your sandwich toasted?"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"1. Yes"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"2. No"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go back to menu"+ConsoleColors.RESET);
        boolean toastedFlag = true;
        boolean sandwichToasted = false;
        while (toastedFlag) {

            System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
            String ToastedInput = input.next().trim();

            switch (ToastedInput) {
                case "1":
                    sandwichToasted = true;
                    System.out.println(ConsoleColors.WHITE+"Sandwich will be toasted"+ConsoleColors.RESET);
                    toastedFlag = false;
                    break;
                case "2":
                    sandwichToasted = false;
                    System.out.println(ConsoleColors.WHITE+"Sandwich will not be toasted"+ConsoleColors.RESET);
                    toastedFlag = false;
                    break;
                case "3":
                    System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Going back to menu"+ConsoleColors.RESET);
                    toastedFlag = false;
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                    break;
            }
        }

        ArrayList<Topping> toppings = new ArrayList<>();

        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add toppings to your sandwich?"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"1. Yes"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"2. No"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go back to menu"+ConsoleColors.RESET);
        boolean toppingFlag = true;

        while (toppingFlag) {
            System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
            String ToppingInput = input.next().trim();

            switch (ToppingInput) {
                case "1":
                    System.out.println(ConsoleColors.WHITE+"Adding toppings to sandwich"+ConsoleColors.RESET);
                    toppings = addTopping();
                    toppingFlag = false;
                    break;
                case "2":
                    System.out.println(ConsoleColors.WHITE+"No toppings added to sandwich"+ConsoleColors.RESET);
                    toppingFlag = false;
                    break;
                case "3":
                    System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Going back to menu"+ConsoleColors.RESET);
                    toppingFlag = false;
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                    break;
            }
        }

        Sandwich sandwich = new Sandwich(sandwichBread, toppings, sandwichSize, sandwichToasted);
        sandwiches.add(sandwich);

        System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT+"Sandwich added to order!"+ConsoleColors.RESET);
    }

    public ArrayList<Topping> addTopping() {
        Scanner input = new Scanner(System.in);
        ArrayList<Topping> toppings = new ArrayList<>();


        boolean toppingFlag = true;

        while (toppingFlag) {
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"What Toppings would you like to add to your sandwich?:"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"1. Meats"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"2. Cheeses"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"3. Sauces"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"4. Veggies"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"5. No more toppings to add"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
            String ToppingInput = input.next().trim();

            switch (ToppingInput) {
                case "1":
                    System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Adding Meats to sandwich"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"1. Ham"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"2. Turkey"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"3. Roast Beef"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"4. Chicken"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"5. Salami"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"6. bacon"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"7. Go back to menu"+ConsoleColors.RESET);
                    boolean meatFlag = true;
                    while (meatFlag) {
                        System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
                        String MeatInput = input.next().trim();

                        switch (MeatInput) {
                            case "1":
                                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra Ham to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.RED+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go back to menu"+ConsoleColors.RESET);
                                boolean extraMeatFlag = true;
                                while (extraMeatFlag) {
                                    System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
                                    String ExtraMeatInput = input.next().trim();

                                    switch (ExtraMeatInput) {
                                        case "1":
                                            Topping ham = new Meat("Ham", true);
                                            toppings.add(ham);
                                            System.out.println(ConsoleColors.WHITE+"Extra Ham added to sandwich"+ConsoleColors.RESET);
                                            extraMeatFlag = false;
                                            break;
                                        case "2":
                                            Topping ham2 = new Meat("Ham", false);
                                            toppings.add(ham2);
                                            System.out.println(ConsoleColors.WHITE+"Ham added to sandwich"+ConsoleColors.RESET);
                                            extraMeatFlag = false;
                                            break;
                                        case "3":
                                            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Going back to menu"+ConsoleColors.RESET);
                                            extraMeatFlag = false;
                                            break;
                                        default:
                                            System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                                            break;
                                    }
                                }
                                meatFlag = false;
                                break;
                            case "2":
                                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra Turkey to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go back to menu"+ConsoleColors.RESET);
                                boolean extraTurkeyFlag = true;
                                while (extraTurkeyFlag) {
                                    System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
                                    String ExtraTurkeyInput = input.next().trim();

                                    switch (ExtraTurkeyInput) {
                                        case "1":
                                            Topping turkey = new Meat("Turkey", true);
                                            toppings.add(turkey);
                                            System.out.println(ConsoleColors.WHITE+"Extra Turkey added to sandwich"+ConsoleColors.RESET);
                                            extraTurkeyFlag = false;
                                            break;
                                        case "2":
                                            Topping turkey2 = new Meat("Turkey", false);
                                            toppings.add(turkey2);
                                            System.out.println(ConsoleColors.WHITE+"Turkey added to sandwich"+ConsoleColors.RESET);
                                            extraTurkeyFlag = false;
                                            break;
                                        case "3":
                                            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Going back to menu"+ConsoleColors.RESET);
                                            extraTurkeyFlag = false;
                                            break;
                                        default:
                                            System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                                            break;
                                    }
                                }
                                meatFlag = false;
                                break;
                            case "3":
                                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra Roast Beef to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.RED+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go back to menu"+ConsoleColors.RESET);
                                boolean extraRoastBeefFlag = true;
                                while (extraRoastBeefFlag) {
                                    System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
                                    String ExtraRoastBeefInput = input.next().trim();

                                    switch (ExtraRoastBeefInput) {
                                        case "1":
                                            Topping roastBeef = new Meat("Roast Beef", true);
                                            toppings.add(roastBeef);
                                            System.out.println(ConsoleColors.WHITE+"Extra Roast Beef added to sandwich"+ConsoleColors.RESET);
                                            extraRoastBeefFlag = false;
                                            break;
                                        case "2":
                                            Topping roastBeef2 = new Meat("Roast Beef", false);
                                            toppings.add(roastBeef2);
                                            System.out.println(ConsoleColors.WHITE+"Roast Beef added to sandwich"+ConsoleColors.RESET);
                                            extraRoastBeefFlag = false;
                                            break;
                                        case "3":
                                            System.out.println(ConsoleColors.BLUE+"Going back to menu"+ConsoleColors.RESET);
                                            extraRoastBeefFlag = false;
                                            break;
                                        default:
                                            System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                                            break;
                                    }
                                }
                                meatFlag = false;
                                break;
                            case "4":
                                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra Chicken to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.RED+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go back to menu"+ConsoleColors.RESET);
                                boolean extraChickenFlag = true;
                                while (extraChickenFlag) {
                                    System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
                                    String ExtraChickenInput = input.next().trim();

                                    switch (ExtraChickenInput) {
                                        case "1":
                                            Topping chicken = new Meat("Chicken", true);
                                            toppings.add(chicken);
                                            System.out.println(ConsoleColors.WHITE+"Extra Chicken added to sandwich"+ConsoleColors.RESET);
                                            extraChickenFlag = false;
                                            break;
                                        case "2":
                                            Topping chicken2 = new Meat("Chicken", false);
                                            toppings.add(chicken2);
                                            System.out.println(ConsoleColors.WHITE+"Chicken added to sandwich"+ConsoleColors.RESET);
                                            extraChickenFlag = false;
                                            break;
                                        case "3":
                                            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Going back to menu"+ConsoleColors.RESET);
                                            extraChickenFlag = false;
                                            break;
                                        default:
                                            System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                                            break;
                                    }
                                }
                                meatFlag = false;
                                break;
                            case "5":
                                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra Salami to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.RED+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go back to menu"+ConsoleColors.RESET);
                                boolean extraSalamiFlag = true;
                                while (extraSalamiFlag) {
                                    System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
                                    String ExtraSalamiInput = input.next().trim();

                                    switch (ExtraSalamiInput) {
                                        case "1":
                                            Topping salami = new Meat("Salami", true);
                                            toppings.add(salami);
                                            System.out.println(ConsoleColors.WHITE+"Extra Salami added to sandwich"+ConsoleColors.RESET);
                                            extraSalamiFlag = false;
                                            break;
                                        case "2":
                                            Topping salami2 = new Meat("Salami", false);
                                            toppings.add(salami2);
                                            System.out.println(ConsoleColors.WHITE+"Salami added to sandwich"+ConsoleColors.RESET);
                                            extraSalamiFlag = false;
                                            break;
                                        case "3":
                                            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Going back to menu"+ConsoleColors.RESET);
                                            extraSalamiFlag = false;
                                            break;
                                        default:
                                            System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                                            break;
                                    }
                                }
                                meatFlag = false;
                                break;
                            case "6":
                                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra Bacon to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.RED+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go back to menu"+ConsoleColors.RESET);
                                boolean extraBaconFlag = true;
                                while (extraBaconFlag) {
                                    System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
                                    String ExtraBaconInput = input.next().trim();

                                    switch (ExtraBaconInput) {
                                        case "1":
                                            Topping bacon = new Meat("Bacon", true);
                                            toppings.add(bacon);
                                            System.out.println(ConsoleColors.WHITE+"Extra Bacon added to sandwich"+ConsoleColors.RESET);
                                            extraBaconFlag = false;
                                            break;
                                        case "2":
                                            Topping bacon2 = new Meat("Bacon", false);
                                            toppings.add(bacon2);
                                            System.out.println(ConsoleColors.WHITE+"Bacon added to sandwich"+ConsoleColors.RESET);
                                            extraBaconFlag = false;
                                            break;
                                        case "3":
                                            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Going back to menu"+ConsoleColors.RESET);
                                            extraBaconFlag = false;
                                            break;
                                        default:
                                            System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                                            break;
                                    }
                                }
                                meatFlag = false;
                                break;
                            case "7":
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Going back to menu"+ConsoleColors.RESET);
                                meatFlag = false;
                                break;
                            default:
                                System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                                break;
                        }
                    }
//                    toppingFlag = false;
                    break;
                case "2":
                    System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Adding Cheeses to sandwich"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"1. American"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"2. Swiss"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"3. Cheddar"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"4. Provolone"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"5. Go back to menu"+ConsoleColors.RESET);
                    boolean cheeseFlag = true;
                    while (cheeseFlag) {
                        System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
                        String CheeseInput = input.next().trim();

                        switch (CheeseInput) {
                            case "1":
                                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra American Cheese to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.RED+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go back to menu"+ConsoleColors.RESET);
                                boolean extraAmericanCheese = true;
                                while (extraAmericanCheese) {
                                    System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
                                    String extraAmericanCheeseInput = input.next().trim();

                                    switch (extraAmericanCheeseInput) {
                                        case "1":
                                            Topping americanCheese = new Cheese("American Cheese", true);
                                            toppings.add(americanCheese);
                                            System.out.println(ConsoleColors.WHITE+"Extra American Cheese added to sandwich"+ConsoleColors.RESET);
                                            extraAmericanCheese = false;
                                            break;
                                        case "2":
                                            Topping americanCheese1 = new Cheese("American Cheese", false);
                                            toppings.add(americanCheese1);
                                            System.out.println(ConsoleColors.WHITE+"American Cheese added to sandwich"+ConsoleColors.RESET);
                                            extraAmericanCheese = false;
                                            break;
                                        case "3":
                                            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Going back to menu"+ConsoleColors.RESET);
                                            extraAmericanCheese = false;
                                            break;
                                        default:
                                            System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                                            break;
                                    }
                                }
                                cheeseFlag = false;
                                break;
                            case "2":
                                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra Swiss Cheese to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go back to menu"+ConsoleColors.RESET);
                                boolean extraSwissCheese = true;
                                while (extraSwissCheese) {
                                    System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
                                    String extraSwissCheeseInput = input.next().trim();

                                    switch (extraSwissCheeseInput) {
                                        case "1":
                                            Topping swissCheese = new Cheese("Swiss Cheese", true);
                                            toppings.add(swissCheese);
                                            System.out.println(ConsoleColors.WHITE+"Extra Swiss Cheese added to sandwich"+ConsoleColors.RESET);
                                            extraSwissCheese = false;
                                            break;
                                        case "2":
                                            Topping swissCheese1 = new Cheese("Swiss Cheese", false);
                                            toppings.add(swissCheese1);
                                            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Swiss Cheese added to sandwich"+ConsoleColors.RESET);
                                            extraSwissCheese = false;
                                            break;
                                        case "3":
                                            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Going back to menu"+ConsoleColors.RESET);
                                            extraSwissCheese = false;
                                            break;
                                        default:
                                            System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                                            break;
                                    }
                                }
                                cheeseFlag = false;
                                break;
                            case "3":
                                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra Cheddar Cheese to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.RED+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go back to menu"+ConsoleColors.RESET);
                                boolean extraCheddarCheese = true;
                                while (extraCheddarCheese) {
                                    System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
                                    String extraCheddarCheeseInput = input.next().trim();

                                    switch (extraCheddarCheeseInput) {
                                        case "1":
                                            Topping cheddarCheese = new Cheese("Cheddar Cheese", true);
                                            toppings.add(cheddarCheese);
                                            System.out.println(ConsoleColors.WHITE+"Extra Cheddar Cheese added to sandwich"+ConsoleColors.RESET);
                                            extraCheddarCheese = false;
                                            break;
                                        case "2":
                                            Topping cheddarCheese1 = new Cheese("Cheddar Cheese", false);
                                            toppings.add(cheddarCheese1);
                                            System.out.println(ConsoleColors.WHITE+"Cheddar Cheese added to sandwich"+ConsoleColors.RESET);
                                            extraCheddarCheese = false;
                                            break;
                                        case "3":
                                            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Going back to menu"+ConsoleColors.RESET);
                                            extraCheddarCheese = false;
                                            break;
                                        default:
                                            System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                                            break;
                                    }
                                }
                                cheeseFlag = false;
                                break;
                            case "4":
                                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra Provolone Cheese to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.RED+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go back to menu"+ConsoleColors.RESET);
                                boolean extraProvoloneCheese = true;
                                while (extraProvoloneCheese) {
                                    System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
                                    String extraProvoloneCheeseInput = input.next().trim();

                                    switch (extraProvoloneCheeseInput) {
                                        case "1":
                                            Topping provoloneCheese = new Cheese("Provolone Cheese", true);
                                            toppings.add(provoloneCheese);
                                            System.out.println(ConsoleColors.WHITE+"Extra Provolone Cheese added to sandwich"+ConsoleColors.RESET);
                                            extraProvoloneCheese = false;
                                            break;
                                        case "2":
                                            Topping provoloneCheese1 = new Cheese("Provolone Cheese", false);
                                            toppings.add(provoloneCheese1);
                                            System.out.println(ConsoleColors.WHITE+"Provolone Cheese added to sandwich"+ConsoleColors.RESET);
                                            extraProvoloneCheese = false;
                                            break;
                                        case "3":
                                            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Going back to menu"+ConsoleColors.RESET);
                                            extraProvoloneCheese = false;
                                            break;
                                        default:
                                            System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                                            break;
                                    }
                                }
                                cheeseFlag = false;
                                break;
                            case "5":
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Going back to menu"+ConsoleColors.RESET);
                                cheeseFlag = false;
                                break;
                            default:
                                System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                                break;
                        }
                    }
//                    toppingFlag = false;
                    break;
                case "3":
                    System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Adding Sauces to sandwich"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"1. Mayo"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"2. Mustard"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"3. Ranch"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"4. Ketchup"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"5. Thousand Island"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"6. Vinaigrette"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"7. Go back to menu"+ConsoleColors.RESET);
                    boolean sauceFlag = true;
                    while (sauceFlag) {
                        System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
                        String SauceInput = input.next().trim();

                        switch (SauceInput) {
                            case "1":
                                Topping mayo = new FreeTopping("Mayo");
                                toppings.add(mayo);
                                System.out.println(ConsoleColors.WHITE+"Mayo added to sandwich"+ConsoleColors.RESET);
                                sauceFlag = false;
                                break;
                            case "2":
                                Topping mustard = new FreeTopping("Mustard");
                                toppings.add(mustard);
                                System.out.println(ConsoleColors.WHITE+"Mustard added to sandwich"+ConsoleColors.RESET);
                                sauceFlag = false;
                                break;
                            case "3":
                                Topping ranch = new FreeTopping("Ranch");
                                toppings.add(ranch);
                                System.out.println(ConsoleColors.WHITE+"Ranch added to sandwich"+ConsoleColors.RESET);
                                sauceFlag = false;
                                break;
                            case "4":
                                Topping ketchup = new FreeTopping("Ketchup");
                                toppings.add(ketchup);
                                System.out.println(ConsoleColors.WHITE+"Ketchup added to sandwich"+ConsoleColors.RESET);
                                sauceFlag = false;
                                break;

                            case "5":
                                Topping thousandIsland = new FreeTopping("Thousand Island");
                                toppings.add(thousandIsland);
                                System.out.println(ConsoleColors.WHITE+"Thousand Island added to sandwich"+ConsoleColors.RESET);
                                sauceFlag = false;
                                break;
                            case "6":
                                Topping vinaigrette = new FreeTopping("Vinaigrette");
                                toppings.add(vinaigrette);
                                System.out.println(ConsoleColors.WHITE+"Vinaigrette added to sandwich"+ConsoleColors.RESET);
                                sauceFlag = false;
                                break;
                            case "7":
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Going back to menu"+ConsoleColors.RESET);
                                sauceFlag = false;
                                break;
                            default:
                                System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                                break;
                        }
                    }
//                    toppingFlag = false;
                    break;
                case "4":
                    System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Adding Veggies to sandwich"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"1. Lettuce"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"2. Tomato"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"3. Onion"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"4. Pickles"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"5. Peppers"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"6. Jalapenos"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"7. Cucumbers"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"8. Mushrooms"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"9. Guacamole"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"X. Go back to menu"+ConsoleColors.RESET);
                    boolean veggieFlag = true;
                    while (veggieFlag) {
                        System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
                        String VeggieInput = input.next().trim();

                        switch (VeggieInput.toLowerCase()) {
                            case "1":
                                Topping lettuce = new FreeTopping("Lettuce");
                                toppings.add(lettuce);
                                System.out.println(ConsoleColors.WHITE+"Lettuce added to sandwich"+ConsoleColors.RESET);
                                veggieFlag = false;
                                break;
                            case "2":
                                Topping tomato = new FreeTopping("Tomato");
                                toppings.add(tomato);
                                System.out.println(ConsoleColors.WHITE+"Tomato added to sandwich"+ConsoleColors.RESET);
                                veggieFlag = false;
                                break;
                            case "3":
                                Topping onion = new FreeTopping("Onion");
                                toppings.add(onion);
                                System.out.println(ConsoleColors.WHITE+"Onion added to sandwich"+ConsoleColors.RESET);
                                veggieFlag = false;
                                break;
                            case "4":
                                Topping pickles = new FreeTopping("Pickles");
                                toppings.add(pickles);
                                System.out.println(ConsoleColors.WHITE+"Pickles added to sandwich"+ConsoleColors.RESET);
                                veggieFlag = false;
                                break;
                            case "5":
                                Topping peppers = new FreeTopping("Peppers");
                                toppings.add(peppers);
                                System.out.println(ConsoleColors.WHITE+"Peppers added to sandwich"+ConsoleColors.RESET);
                                veggieFlag = false;
                                break;
                            case "6":
                                Topping jalapenos = new FreeTopping("Jalapenos");
                                toppings.add(jalapenos);
                                System.out.println(ConsoleColors.WHITE+"Jalapenos added to sandwich"+ConsoleColors.RESET);
                                veggieFlag = false;
                                break;
                            case "7":
                                Topping cucumbers = new FreeTopping("Cucumbers");
                                toppings.add(cucumbers);
                                System.out.println(ConsoleColors.WHITE+"Cucumbers added to sandwich"+ConsoleColors.RESET);
                                veggieFlag = false;
                                break;
                            case "8":
                                Topping mushrooms = new FreeTopping("Mushrooms");
                                toppings.add(mushrooms);
                                System.out.println(ConsoleColors.WHITE+"Mushrooms added to sandwich"+ConsoleColors.RESET);
                                veggieFlag = false;
                                break;
                            case "9":
                                Topping guacamole = new FreeTopping("Guacamole");
                                toppings.add(guacamole);
                                System.out.println(ConsoleColors.WHITE+"Guacamole added to sandwich"+ConsoleColors.RESET);
                                veggieFlag = false;
                                break;
                            case "x":
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Going back to menu"+ConsoleColors.RESET);
                                veggieFlag = false;
                                break;
                            default:
                                System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                                break;
                        }
                    }
//                    toppingFlag = false;
                    break;
                case "5":
                    System.out.println(ConsoleColors.WHITE+"All of the toppings have been added to your sandwich"+ConsoleColors.RESET);
                    toppingFlag = false;
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                    break;
            }
        }


        return toppings;

    }


    public void addDrinkMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Choose drink size:"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"1. Small"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"2. Medium"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"3. Large"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"4. Go back to home menu"+ConsoleColors.RESET);
        Size drinkSize = Size.SMALL;
        boolean sizeFlag = true;
        while (sizeFlag) {
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
            String DrinkInput = scanner.next().trim();

            switch (DrinkInput) {
                case "1":
                    drinkSize = Size.SMALL;
                    System.out.println(ConsoleColors.WHITE+"Added small size"+ConsoleColors.RESET);
                    sizeFlag = false;
                    break;
                case "2":
                    drinkSize = Size.MEDIUM;
                    System.out.println(ConsoleColors.WHITE+"Added medium size"+ConsoleColors.RESET);
                    sizeFlag = false;
                    break;
                case "3":
                    drinkSize = Size.LARGE;
                    System.out.println(ConsoleColors.WHITE+"Added Large size"+ConsoleColors.RESET);
                    sizeFlag = false;
                    break;
                case "4":
                    System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Go back to home menu"+ConsoleColors.RESET);
                    sizeFlag = false;
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid size, please try again"+ConsoleColors.RESET);
                    sizeFlag = false;
                    break;
            }
        }
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Choose your brand:"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"1. Coco-Cola"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"2. Mountain Dew"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"3. Sprite"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"4. Pepsi"+ConsoleColors.RESET);
            System.out.println("5. Go back to home menu");
            boolean brandFlag = true;
            while (brandFlag) {
                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Your Brand Selection: "+ConsoleColors.RESET);
                String BrandInput = scanner.next().trim();

                switch (BrandInput) {
                    case "1":
                        Drink CocaCola = new Drink(drinkSize, "Coca-cola");
                        drinks.add(CocaCola);
                        System.out.println(ConsoleColors.WHITE+"Coca-cola was added to your order"+ConsoleColors.RESET);
                        brandFlag = false;
                        break;
                    case "2":
                        Drink MountainDew = new Drink(drinkSize, "Mountain Dew");
                        drinks.add(MountainDew);
                        System.out.println(ConsoleColors.WHITE+"Mountain Dew was added to your order"+ConsoleColors.RESET);
                        brandFlag = false;
                        break;
                    case "3":
                        Drink Sprite = new Drink(drinkSize, "Sprite");
                        drinks.add(Sprite);
                        System.out.println(ConsoleColors.WHITE+"Sprite was added to your order"+ConsoleColors.RESET);
                        brandFlag = false;
                        break;
                    case "4":
                        Drink pepsi = new Drink(drinkSize, "Pepsi");
                        drinks.add(pepsi);
                        System.out.println(ConsoleColors.WHITE+"Sparkling Dew was added to your order"+ConsoleColors.RESET);
                        brandFlag = false;
                        break;
                    case "5":
                        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Go back to home menu"+ConsoleColors.RESET);
                        brandFlag = false;
                        break;
                    default:
                        System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option. Please try again"+ConsoleColors.RESET);
                        break;

                }

            }




    }

    public void addChipsMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"What Flavor of Chips would you Like to Add to your order?:"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"1. plain"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"2. BBQ"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"3. salt and vinegar"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"4. salt"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"5. go back to menu"+ConsoleColors.RESET);
        boolean flag = true;

        while (flag) {

            System.out.print(ConsoleColors.BLUE_BOLD_BRIGHT+"Your Selection: "+ConsoleColors.RESET);
            String ChipsInput = input.next().trim();

            switch (ChipsInput) {
                case "1":
                    Chips plain = new Chips("plain");
                    chips.add(plain);
                    System.out.println(ConsoleColors.WHITE+"Plain Chips added to order!"+ConsoleColors.RESET);
                    flag = false;
                    break;
                case "2":
                    Chips bbqChips = new Chips("BBQ");
                    chips.add(bbqChips);
                    System.out.println(ConsoleColors.WHITE+"BBQ Chips added to order!"+ConsoleColors.RESET);
                    flag = false;
                    break;
                case "3":
                    Chips saltAndVinegar = new Chips("salt and vinegar");
                    chips.add(saltAndVinegar);
                    System.out.println(ConsoleColors.WHITE+"salt and vinegar Chips added to order!"+ConsoleColors.RESET);
                    flag = false;
                    break;
                case "4":
                    Chips salt = new Chips("salt");
                    chips.add(salt);
                    System.out.println(ConsoleColors.WHITE+"Salt Chips added to order!"+ConsoleColors.RESET);
                    flag = false;
                    break;
                case "5":
                    System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Going back to menu"+ConsoleColors.RESET);
                    flag = false;
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
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
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Your order is: "+ConsoleColors.RESET);
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
