package com.pluralsight.LoadingBar;


import com.pluralsight.userInterface.ConsoleColors;

public class ProgressBar {
    public static void main() {
        //char[] animationChars = new char[] {'|', '/', '-', '\\'};
        char[] animationChars = new char[] {'⣾', '⣽', '⣻', '⢿', '⣟', '⣯', '⣷'};
        for (int i = 0; i <= 100; i++) {
            System.out.print("Processing: " + i + "% " + animationChars[i % 4] + "\r");


            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Processing: Done!");
    }
    public static void bar() {
        int totalSteps = 100;
        for (int i = 0; i <= totalSteps; i++) {
            int progress = i * 100 / totalSteps;
            String progressBar = "[" + ConsoleColors.GREEN+ConsoleColors.GREEN_BACKGROUND+"=".repeat(progress)+ConsoleColors.RESET +" ".repeat(100 - progress) +  "]";
            System.out.print("\rWELCOME TO WHOLE-LOTTA-SUB: " + progressBar + " " + progress + "%");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}




