package com.pluralsight;


import LoadingBar.ProgressBar;
import com.pluralsight.userInterface.UserInterface;
    public class WholeLottaSub {
    OrderFileManager orderFileManager = new OrderFileManager();
    public static void main(String[] args) {
        ProgressBar.bar();
        UserInterface userInterface = new UserInterface();
        userInterface.HomeMenu();

    }
}
