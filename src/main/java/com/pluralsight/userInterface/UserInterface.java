package com.pluralsight.userInterface;

import com.pluralsight.LoadingBar.ProgressBar;
import com.pluralsight.fileManager.OrderFileManager;
import com.pluralsight.order.*;
import com.pluralsight.utils.ConsoleColors;
import com.pluralsight.utils.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    private List<Object> orderItems = new ArrayList<>();



    public UserInterface() {
    }

    public void HomeMenu() {
        System.out.println("\n");
        System.out.println(ConsoleColors.BLUE+ConsoleColors.BLUE_BACKGROUND+"--------------------------------"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE+ConsoleColors.BLUE_BACKGROUND+"--"+ConsoleColors.RESET+ConsoleColors.WHITE_UNDERLINED+ConsoleColors.WHITE_BOLD_BRIGHT+" WELCOME TO WHOLE-LOTTA-SUB!"+ConsoleColors.BLUE+ConsoleColors.BLUE_BACKGROUND+"--"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE+ConsoleColors.BLUE_BACKGROUND+"--------------------------------"+ConsoleColors.RESET);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n"+ ConsoleColors.WHITE_BOLD_BRIGHT+"Choose an option:"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"1 New Order"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"2 Exit - exit the application"+ConsoleColors.RESET);

            System.out.print(ConsoleColors.WHITE_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
            String input = scanner.next().trim();

            switch (input) {
                case "1":
                    orderMenu();
                    break;
                case "2":
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Exiting the application"+ConsoleColors.RESET);
                    System.out.println("HOPE YOU ENJOY YOUR MEAL!");
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
            System.out.println("\n"+ConsoleColors.BLUE_BOLD_BRIGHT+"Choose an option:"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"1 Add Sandwich"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"2 Add Drink"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"3 Add Chips"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"4 Checkout"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED+"0 Cancel Order"+ConsoleColors.RESET);

            System.out.print("\n"+ConsoleColors.WHITE_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
            String input = scanner.next().trim();

            switch (input) {
                case "1":
                    customSandwiches();
                    ProgressBar.dance();
                    printOrder();
                    break;
                case "2":
                    addDrinkMenu();
                    ProgressBar.dance();
                    printOrder();
                    break;
                case "3":
                    addChipsMenu();
                    ProgressBar.dance();
                    printOrder();
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

    public void customSandwiches(){
        System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT+"Select from the following:"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"1. Create a custom sandwich"+ConsoleColors.RESET + ConsoleColors.WHITE_BOLD_BRIGHT+" (You choose the bread, size, toppings, etc.)"+ConsoleColors.RESET+"\n");
        System.out.println(ConsoleColors.WHITE+"2. The Big Hamza:"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"Meat: Extra Steak and Extra Bacon"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"Cheese: Extra Provolone Cheese"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"Toppings: Lettuce, Tomato, and Mayo"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"Bread: Toasted White Bread"+ConsoleColors.RESET+"\n");
        System.out.println(ConsoleColors.WHITE+"3. The Akhil Special"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"Meat: Chicken and Salami"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"Cheese: Extra American Cheese"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"Toppings: Peppers, Jalapenos, Ketchup, and Mustard"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"Bread: Toasted Rye Bread"+ConsoleColors.RESET+"\n");
        System.out.println(ConsoleColors.WHITE+"4. Ray's Potato Percussion Panini"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"Meat: Extra Potato"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"Cheese: Potato Cheese"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"Toppings: Potato"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"Bread: Toasted Potato Bread"+ConsoleColors.RESET+"\n");
        System.out.println(ConsoleColors.RED+"5. Go back to menu"+ConsoleColors.RESET);


        Scanner input = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.print(ConsoleColors.WHITE_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
            String Userinput = input.next().trim();

            switch (Userinput) {
                case "1":
                    addSandwichMenu();
                    ProgressBar.main();
                    running=false;
                    break;
                case "2":
                    System.out.println("Please Select a Size for your sandwich:");
                    System.out.println("1. 4 inch (small)");
                    System.out.println("2. 8 inch (medium)");
                    System.out.println("3. 12 inch (large)");
                    System.out.println("4. Go Back To Home Menu");
                    Size sandwichSize = Size.SMALL;
                    boolean sizeFlag = true;
                    while (sizeFlag) {

                        System.out.print("Your Selection:\uD83D\uDC49\uD83C\uDFFD ");
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
                                System.out.println("Go Back To Home Menu");
                                sizeFlag = false;
                                break;
                            default:
                                System.out.println("Invalid option, please try again.");
                                break;
                        }
                    }
                    Sandwich TheBigHamza = new Sandwich(new Bread("White"), new ArrayList<Topping>(), sandwichSize, true);
                    TheBigHamza.addTopping(new Meat("Steak", true));
                    TheBigHamza.addTopping(new Meat("Bacon", true));
                    TheBigHamza.addTopping(new Cheese("Provolone", true));
                    TheBigHamza.addTopping(new FreeTopping("Lettuce"));
                    TheBigHamza.addTopping(new FreeTopping("Tomato"));
                    TheBigHamza.addTopping(new FreeTopping("Mayo"));
                    TheBigHamza.setName("The Big Hamza");
                    sandwiches.add(TheBigHamza);
                    orderItems.add(TheBigHamza);
                    System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT+TheBigHamza.getSize()+" "+"The Big Hamza added to order!"+ConsoleColors.RESET+"\n");
                    ProgressBar.main();
                    running=false;
                    break;
                case "3":
                    System.out.println("Please Select a Size for your sandwich:");
                    System.out.println("1. 4 inch (small)");
                    System.out.println("2. 8 inch (medium)");
                    System.out.println("3. 12 inch (large)");
                    System.out.println("4. Go Back To Home Menu");
                    Size sandwichSize2 = Size.SMALL;
                    boolean sizeFlag2 = true;
                    while (sizeFlag2) {

                        System.out.print("Your Selection:\uD83D\uDC49\uD83C\uDFFD ");
                        String SandwichInput = input.next().trim();

                        switch (SandwichInput) {
                            case "1":
                                sandwichSize2 = Size.SMALL;
                                System.out.println("small size Selected for sandwich");
                                sizeFlag2 = false;
                                break;
                            case "2":
                                sandwichSize2 = Size.MEDIUM;
                                System.out.println("medium size Selected for sandwich");
                                sizeFlag2 = false;
                                break;
                            case "3":
                                sandwichSize2 = Size.LARGE;
                                System.out.println("large size Selected for sandwich");
                                sizeFlag2 = false;
                                break;
                            case "4":
                                System.out.println("Go Back To Home Menu");
                                sizeFlag2 = false;
                                break;
                            default:
                                System.out.println("Invalid option, please try again.");
                                break;
                        }
                    }
                    Sandwich TheAkhilSpecial = new Sandwich(new Bread("Rye"), new ArrayList<Topping>(), sandwichSize2, true);
                    TheAkhilSpecial.addTopping(new Meat("Chicken", true));
                    TheAkhilSpecial.addTopping(new Meat("Salami", true));
                    TheAkhilSpecial.addTopping(new Cheese("American", true));
                    TheAkhilSpecial.addTopping(new FreeTopping("Peppers"));
                    TheAkhilSpecial.addTopping(new FreeTopping("Jalapenos"));
                    TheAkhilSpecial.addTopping(new FreeTopping("Ketchup"));
                    TheAkhilSpecial.addTopping(new FreeTopping("Mustard"));
                    TheAkhilSpecial.setName("The Akhil Special");
                    sandwiches.add(TheAkhilSpecial);
                    orderItems.add(TheAkhilSpecial);
                    System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT+TheAkhilSpecial.getSize()+" "+"The Akhil Special added to order!"+ConsoleColors.RESET+"\n");
                    printOrder();
                    ProgressBar.main();
                    running=false;
                    break;
                case "4":
                    System.out.println("Please Select a Size for your sandwich:");
                    System.out.println("1. 4 inch (small)");
                    System.out.println("2. 8 inch (medium)");
                    System.out.println("3. 12 inch (large)");
                    System.out.println("4. Go Back To Home Menu");
                    Size sandwichSize3 = Size.SMALL;
                    boolean sizeFlag3 = true;
                    while (sizeFlag3) {

                        System.out.print("Your Selection:\uD83D\uDC49\uD83C\uDFFD ");
                        String SandwichInput3 = input.next().trim();

                        switch (SandwichInput3) {
                            case "1":
                                sandwichSize3 = Size.SMALL;
                                System.out.println("small size Selected for sandwich");
                                sizeFlag3 = false;
                                break;
                            case "2":
                                sandwichSize3 = Size.MEDIUM;
                                System.out.println("medium size Selected for sandwich");
                                sizeFlag3 = false;
                                break;
                            case "3":
                                sandwichSize3 = Size.LARGE;
                                System.out.println("large size Selected for sandwich");
                                sizeFlag3 = false;
                                break;
                            case "4":
                                System.out.println("Go Back To Home Menu");
                                sizeFlag3 = false;
                                break;
                            default:
                                System.out.println("Invalid option, please try again.");
                                break;
                        }
                    }
                    Sandwich RayPotatoPercussionPanini = new Sandwich(new Bread("Potato"), new ArrayList<Topping>(), sandwichSize3, true);
                    RayPotatoPercussionPanini.addTopping(new Meat("Potato", true));
                    RayPotatoPercussionPanini.addTopping(new Cheese("Potato Cheese", true));
                    RayPotatoPercussionPanini.addTopping(new FreeTopping("Potato"));
                    RayPotatoPercussionPanini.setName("Ray's Potato Percussion Panini");
                    sandwiches.add(RayPotatoPercussionPanini);
                    orderItems.add(RayPotatoPercussionPanini);
                    System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT+RayPotatoPercussionPanini.getSize()+" "+"Ray's Potato Percussion Panini added to order!"+ConsoleColors.RESET+"\n");
                    ProgressBar.main();
                    running = false;
                    break;
                case "5":
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Going back to menu"+ConsoleColors.RESET);
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
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"4. Go Back To Home Menu"+ConsoleColors.RESET);
        Size sandwichSize = Size.SMALL;
        boolean sizeFlag = true;
        while (sizeFlag) {

            System.out.print(ConsoleColors.PURPLE_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
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
                    System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Go Back To Home Menu"+ConsoleColors.RESET);
                    sizeFlag = false;
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                    break;
            }
        }

        System.out.println("\n"+ConsoleColors.YELLOW_BOLD_BRIGHT+"What type of bread would you like to add to your sandwich?:"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"1. White"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"2. Whole Wheat"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"3. Rye"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"4. Wrap"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"5. Go Back To Home Menu"+ConsoleColors.RESET);
        Bread sandwichBread = new Bread("no bread");
        boolean breadFlag = true;
        while (breadFlag) {

            System.out.print("\n"+ConsoleColors.WHITE_BOLD_BRIGHT+"Your Selection: \uD83D\uDC49\uD83C\uDFFD"+ConsoleColors.RESET);
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
                    System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Go Back To Home Menu"+ConsoleColors.RESET);
                    breadFlag = false;
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                    break;
            }
        }

        System.out.println("\n"+ConsoleColors.YELLOW_BOLD_BRIGHT+"Would you like your sandwich toasted?"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"1. Yes"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"2. No"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT+"3. Go Back To Home Menu"+ConsoleColors.RESET);
        boolean toastedFlag = true;
        boolean sandwichToasted = false;
        while (toastedFlag) {

            System.out.print("\n"+ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
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
                    System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Go Back To Home Menu"+ConsoleColors.RESET);
                    toastedFlag = false;
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                    break;
            }
        }

        ArrayList<Topping> toppings = new ArrayList<>();

        System.out.println("\n"+ConsoleColors.PURPLE_BOLD_BRIGHT+"Would you like to add toppings to your sandwich?"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"1. Yes"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"2. No"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go back to menu"+ConsoleColors.RESET);
        boolean toppingFlag = true;

        while (toppingFlag) {
            System.out.print("\n"+ConsoleColors.WHITE_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
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
                    System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Go Back To Home Menu"+ConsoleColors.RESET);
                    toppingFlag = false;
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                    break;
            }
        }

        Sandwich sandwich = new Sandwich(sandwichBread, toppings, sandwichSize, sandwichToasted);
        sandwiches.add(sandwich);
        orderItems.add(sandwich);

        System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT+"Sandwich added to order!"+ConsoleColors.RESET);
    }

    public ArrayList<Topping> addTopping() {
        Scanner input = new Scanner(System.in);
        ArrayList<Topping> toppings = new ArrayList<>();


        boolean toppingFlag = true;

        while (toppingFlag) {
            System.out.println("\n"+ConsoleColors.YELLOW_BOLD_BRIGHT+"What Toppings would you like to add to your sandwich?:"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"1. Meats"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"2. Cheeses"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"3. Sauces"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"4. Veggies"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE+"5. No more toppings to add"+ConsoleColors.RESET);
            System.out.print("\n"+ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
            String ToppingInput = input.next().trim();

            switch (ToppingInput) {
                case "1":
                    System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT+"Adding Meats to sandwich"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"1. Ham"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"2. Turkey"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"3. Roast Beef"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"4. Chicken"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"5. Salami"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE+"6. bacon"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"7. Go Back To Home Menu"+ConsoleColors.RESET);
                    boolean meatFlag = true;
                    while (meatFlag) {
                        System.out.print("\n"+ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
                        String MeatInput = input.next().trim();

                        switch (MeatInput) {
                            case "1":
                                System.out.println("\n"+ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra Ham to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.RED+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go Back To Home Menu"+ConsoleColors.RESET);
                                boolean extraMeatFlag = true;
                                while (extraMeatFlag) {
                                    System.out.print("\n"+ConsoleColors.YELLOW_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
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
                                            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Go Back To Home Menu"+ConsoleColors.RESET);
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
                                System.out.println("\n"+ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra Turkey to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.RED+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go Back To Home Menu"+ConsoleColors.RESET);
                                boolean extraTurkeyFlag = true;
                                while (extraTurkeyFlag) {
                                    System.out.print("\n"+ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
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
                                            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Go Back To Home Menu"+ConsoleColors.RESET);
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
                                System.out.println("\n"+ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra Roast Beef to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.RED+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go Back To Home Menu"+ConsoleColors.RESET);
                                boolean extraRoastBeefFlag = true;
                                while (extraRoastBeefFlag) {
                                    System.out.print("\n"+ConsoleColors.YELLOW_BOLD_BRIGHT+"Your Selection: \uD83D\uDC49\uD83C\uDFFD"+ConsoleColors.RESET);
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
                                            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Go Back To Home Menu"+ConsoleColors.RESET);
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
                                System.out.println("\n"+ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra Chicken to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.RED+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go Back To Home Menu"+ConsoleColors.RESET);
                                boolean extraChickenFlag = true;
                                while (extraChickenFlag) {
                                    System.out.print("\n"+ConsoleColors.WHITE_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
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
                                            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Go Back To Home Menu"+ConsoleColors.RESET);
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
                                System.out.println("\n"+ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra Salami to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.RED+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go Back To Home Menu"+ConsoleColors.RESET);
                                boolean extraSalamiFlag = true;
                                while (extraSalamiFlag) {
                                    System.out.print("\n"+ConsoleColors.WHITE_BOLD_BRIGHT+"Your Selection: \uD83D\uDC49\uD83C\uDFFD"+ConsoleColors.RESET);
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
                                            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Go Back To Home Menu"+ConsoleColors.RESET);
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
                                System.out.println("\n"+ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra Bacon to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.RED+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go Back To Home Menu"+ConsoleColors.RESET);
                                boolean extraBaconFlag = true;
                                while (extraBaconFlag) {
                                    System.out.print("\n"+ConsoleColors.CYAN_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
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
                                System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"Going back to menu"+ConsoleColors.RESET);
                                meatFlag = false;
                                break;
                            default:
                                System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid option, please try again."+ConsoleColors.RESET);
                                break;
                        }
                    }
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
                        System.out.print(ConsoleColors.WHITE_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
                        String CheeseInput = input.next().trim();

                        switch (CheeseInput) {
                            case "1":
                                System.out.println("\n"+ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra American Cheese to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.RED+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go back to menu"+ConsoleColors.RESET);
                                boolean extraAmericanCheese = true;
                                while (extraAmericanCheese) {
                                    System.out.print("\n"+ConsoleColors.PURPLE_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
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
                                System.out.println("\n"+ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra Swiss Cheese to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go back to menu"+ConsoleColors.RESET);
                                boolean extraSwissCheese = true;
                                while (extraSwissCheese) {
                                    System.out.print("\n"+ConsoleColors.WHITE_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
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
                                            System.out.println(ConsoleColors.WHITE+"Swiss Cheese added to sandwich"+ConsoleColors.RESET);
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
                                System.out.println("\n"+ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra Cheddar Cheese to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.RED+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go back to menu"+ConsoleColors.RESET);
                                boolean extraCheddarCheese = true;
                                while (extraCheddarCheese) {
                                    System.out.print("\n"+ConsoleColors.PURPLE_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
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
                                System.out.println("\n"+ConsoleColors.GREEN_BOLD_BRIGHT+"Would you like to add extra Provolone Cheese to your sandwich?"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN+"1. Yes"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.RED+"2. No"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go back to menu"+ConsoleColors.RESET);
                                boolean extraProvoloneCheese = true;
                                while (extraProvoloneCheese) {
                                    System.out.print("\n"+ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection: \uD83D\uDC49\uD83C\uDFFD"+ConsoleColors.RESET);
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
                        System.out.print("\n"+ConsoleColors.PURPLE_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
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
                        System.out.print("\n"+ConsoleColors.CYAN_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
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
            System.out.println("\n"+ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
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
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"5. Go back to home menu"+ConsoleColors.RESET);
            boolean brandFlag = true;
            while (brandFlag) {
                System.out.println("\n"+ConsoleColors.GREEN_BOLD_BRIGHT+"Your Brand Selection: "+ConsoleColors.RESET);
                String BrandInput = scanner.next().trim();

                switch (BrandInput) {
                    case "1":
                        Drink CocaCola = new Drink(drinkSize, "Coca-cola");
                        drinks.add(CocaCola);
                        orderItems.add(CocaCola);
                        System.out.println(ConsoleColors.WHITE+"Coca-cola was added to your order"+ConsoleColors.RESET);
                        brandFlag = false;
                        break;
                    case "2":
                        Drink MountainDew = new Drink(drinkSize, "Mountain Dew");
                        drinks.add(MountainDew);
                        orderItems.add(MountainDew);
                        System.out.println(ConsoleColors.WHITE+"Mountain Dew was added to your order"+ConsoleColors.RESET);
                        brandFlag = false;
                        break;
                    case "3":
                        Drink Sprite = new Drink(drinkSize, "Sprite");
                        drinks.add(Sprite);
                        orderItems.add(Sprite);
                        System.out.println(ConsoleColors.WHITE+"Sprite was added to your order"+ConsoleColors.RESET);
                        brandFlag = false;
                        break;
                    case "4":
                        Drink pepsi = new Drink(drinkSize, "Pepsi");
                        drinks.add(pepsi);
                        orderItems.add(pepsi);
                        System.out.println(ConsoleColors.WHITE+"Sparkling Dew was added to your order"+ConsoleColors.RESET);
                        brandFlag = false;
                        break;
                    case "5":
                        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Go back to home menu"+ConsoleColors.RESET);
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
        System.out.println("\n"+ConsoleColors.GREEN_BOLD_BRIGHT+"What Flavor of Chips would you Like to Add to your order?:"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"1. plain"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"2. BBQ"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"3. salt and vinegar"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE+"4. salt"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"5. go back to menu"+ConsoleColors.RESET);
        boolean flag = true;

        while (flag) {

            System.out.print("\n"+ConsoleColors.GREEN_BOLD_BRIGHT+"Your Selection:\uD83D\uDC49\uD83C\uDFFD "+ConsoleColors.RESET);
            String ChipsInput = input.next().trim();

            switch (ChipsInput) {
                case "1":
                    Chips plain = new Chips("plain");
                    chips.add(plain);
                    orderItems.add(plain);
                    System.out.println(ConsoleColors.WHITE+"Plain Chips added to order!"+ConsoleColors.RESET);
                    flag = false;
                    break;
                case "2":
                    Chips bbqChips = new Chips("BBQ");
                    chips.add(bbqChips);
                    orderItems.add(bbqChips);
                    System.out.println(ConsoleColors.WHITE+"BBQ Chips added to order!"+ConsoleColors.RESET);
                    flag = false;
                    break;
                case "3":
                    Chips saltAndVinegar = new Chips("salt and vinegar");
                    chips.add(saltAndVinegar);
                    orderItems.add(saltAndVinegar);
                    System.out.println(ConsoleColors.WHITE+"salt and vinegar Chips added to order!"+ConsoleColors.RESET);
                    flag = false;
                    break;
                case "4":
                    Chips salt = new Chips("salt");
                    chips.add(salt);
                    orderItems.add(salt);
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

//    public void editOrder(){
//        System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT+"Would you like to remove items from your order?"+ConsoleColors.RESET);
//        System.out.println(ConsoleColors.WHITE+"1. Yes"+ConsoleColors.RESET);
//        System.out.println(ConsoleColors.WHITE+"2. No"+ConsoleColors.RESET);
//        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"3. Go Back To Home Menu"+ConsoleColors.RESET);
//        boolean editFlag = true;
//        Scanner input = new Scanner(System.in);
//        String editInput = input.next().trim();
//        while (editFlag){
//
//            switch (editInput){
//                case "1":
//                    System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT+"What would you like to remove?"+ConsoleColors.RESET);
//                    printOrder();
//
//
//            }
//        }
//
//
//
//
//    }



    public void processCheckout() {
        Order order = new Order(sandwiches, drinks, chips);
        OrderFileManager orderFileManager1 = new OrderFileManager();
        orderFileManager1.saveOrder(order);
        double total = 0;
        int itemNumber = 1;
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                                  WholeLottaSub\n" +
                "                                 " + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getYear() + "\n" +
                "                                 " + "123 Potato St, NY, USA" + "\n" +
                "                                 " + "123-456-7890" + "\n" + "\n");

        System.out.println("Order #" + order.getOrderNumber() + "\n");
        for (Object item : orderItems) {
            System.out.println("Item #" + itemNumber +":"+"\n");
            System.out.println(item.toString() + "\n");
            if(item instanceof Sandwich) {
                total += ((Sandwich) item).getPrice(((Sandwich) item).getSize());
            } else if (item instanceof Chips) {
                total += ((Chips) item).getPrice(Size.SMALL);
            } else if (item instanceof Drink) {
                total += ((Drink) item).getPrice(((Drink) item).getSize());
            }
            itemNumber++;
        }
        System.out.println( "Order Total: $" + String.format("%.2f",total));
        System.out.println("                                  Thankyou For Your Order");
        System.out.println("                                    "+"Hope You Enjoy!");
        System.out.println("------------------------------------------------------------------------");
    }

public void printOrder(){
    double total = 0;
    int itemNumber = 1;
    System.out.println("Your Current Order:");
    if (orderItems.size() == 0) {
        System.out.println("No items in order");
    }
    for (Object item : orderItems) {
        System.out.println("Item #" + itemNumber +":");
        System.out.println(item.toString() + "\n");
        if(item instanceof Sandwich) {
            total += ((Sandwich) item).getPrice(((Sandwich) item).getSize());
        } else if (item instanceof Chips) {
            total += ((Chips) item).getPrice(Size.SMALL);
        } else if (item instanceof Drink) {
            total += ((Drink) item).getPrice(((Drink) item).getSize());
        }
        itemNumber++;
    }
    System.out.println( "Order Total: $" + String.format("%.2f",total));
}
}
