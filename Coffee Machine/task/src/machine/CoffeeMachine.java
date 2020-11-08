package machine;

import java.util.Scanner;

enum Actions {
    RUNNING("running"),
    BUY("buy"),
    FILL_WATER("fill_water"),
    FILL_MILK("fill_milk"),
    FILL_COFFEE_BEANS("fill_coffee_beans"),
    FILL_CUPS("fill_cups"),
    OFF("exit");
    public final String label;
    
    Actions(String label) {
        this.label = label;
    }
}

class CoffeeMaker {
    
    private static int mlOfWaterAvailable = 400;
    private static int mlOfMilkAvailable = 540;
    private static int gOfBeansAvailable = 120;
    private static int noOfDisposableCups = 9;
    private static int amountOfMoneyAvailable = 550;
    private static String state = Actions.RUNNING.label;
    
    public static String stateMessage() {
        return state;
    }
    
    public static boolean pushCommand(String command) {
        switch (command) {
            case "buy":
                state = Actions.BUY.label;
                break;
            case "1":
            case "2":
            case "3":
            case "4": {
                if (checkIfCanMakeCoffee()) {
                    makeCoffee(command);
                }
                state = Actions.RUNNING.label;
                break;
            }
            case "back":
                state = Actions.RUNNING.label;
                break;
            case "fill":
                state = Actions.FILL_WATER.label;
                break;
            case "take":
                System.out.println("I gave you $" + amountOfMoneyAvailable + "\n");
                amountOfMoneyAvailable = 0;
                state = Actions.RUNNING.label;
                break;
            case "remaining":
                coffeeMachineReport();
                state = Actions.RUNNING.label;
                break;
            case "exit":
                state = Actions.OFF.label;
                System.exit(0);
            default:
                if (state.equals(Actions.FILL_WATER.label)) {
                    mlOfWaterAvailable += Integer.parseInt(command);
                    state = Actions.FILL_MILK.label;
                } else if (state.equals(Actions.FILL_MILK.label)) {
                    mlOfMilkAvailable += Integer.parseInt(command);
                    state = Actions.FILL_COFFEE_BEANS.label;
                } else if (state.equals(Actions.FILL_COFFEE_BEANS.label)) {
                    gOfBeansAvailable += Integer.parseInt(command);
                    state = Actions.FILL_CUPS.label;
                } else if (state.equals(Actions.FILL_CUPS.label)) {
                    noOfDisposableCups += Integer.parseInt(command);
                    state = Actions.RUNNING.label;
                }
        }
        return !state.equals(Actions.OFF.label);
    }
    
    private static boolean checkIfCanMakeCoffee() {
        boolean canMakeCoffee = false;
        if (mlOfWaterAvailable < 200 ) {
            System.out.println("Sorry, not enough water!\n");
        } else if (mlOfMilkAvailable < 50 ) {
            System.out.println("Sorry, not enough milk!\n");
        } else if (gOfBeansAvailable < 15 ) {
            System.out.println("Sorry, not enough coffee beans!\n");
        } else if (noOfDisposableCups == 0 ) {
            System.out.println("Sorry, not enough disposable cups!\n");
        } else {
            int portionsOfWater = mlOfWaterAvailable / 200;
            int portionsOfMilk = mlOfMilkAvailable / 50;
            int portionsOfCoffeeBeans = gOfBeansAvailable / 15;
            int numberOfCupsPossbile =
                    Math.min(Math.min(portionsOfWater, portionsOfMilk), portionsOfCoffeeBeans);
            System.out.println("I have enough resources, making you a coffee!\n Max "
                    + numberOfCupsPossbile + " !");
            canMakeCoffee = true;
        }
        return canMakeCoffee;
    }
    
    private static void makeCoffee(String option) {
        switch (option) {
            case "1":
                mlOfWaterAvailable -= 250;
                gOfBeansAvailable -= 16;
                amountOfMoneyAvailable += 4;
                noOfDisposableCups--;
                break;
            case "2":
                mlOfWaterAvailable -= 350;
                mlOfMilkAvailable -= 75;
                gOfBeansAvailable -= 20;
                amountOfMoneyAvailable += 7;
                noOfDisposableCups--;
                break;
            case "3":
                mlOfWaterAvailable -= 200;
                mlOfMilkAvailable -= 100;
                gOfBeansAvailable -= 12;
                amountOfMoneyAvailable += 6;
                noOfDisposableCups--;
                break;
            default:
                System.out.println("No such option");
                break;
        }
    }
    
    private static void coffeeMachineReport() {
        System.out.println("The coffee machine has:\n" +
                mlOfWaterAvailable + " of water\n" +
                mlOfMilkAvailable + " of milk\n" +
                gOfBeansAvailable + " of coffee beans\n" +
                noOfDisposableCups + " of disposable cups\n" +
                "$" + amountOfMoneyAvailable + " of money\n");
    }
}

public class CoffeeMachine {
    
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(CoffeeMaker.stateMessage());
            if (CoffeeMaker.stateMessage().equals(Actions.RUNNING.label)) {
                System.out.println("Write action (buy, fill, take, remaining, exit):");
            } else if (CoffeeMaker.stateMessage().equals(Actions.BUY.label)) {
                System.out.println(
                        "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            } else if (CoffeeMaker.stateMessage().equals(Actions.FILL_WATER.label)) {
                System.out.println("Write how many ml of water do you want to add:");
            } else if (CoffeeMaker.stateMessage().equals(Actions.FILL_MILK.label)) {
                System.out.println("Write how many ml of milk do you want to add:");
            } else if (CoffeeMaker.stateMessage().equals(Actions.FILL_COFFEE_BEANS.label)) {
                System.out.println("Write how many grams of coffee beans do you want to add:");
            } else if (CoffeeMaker.stateMessage().equals(Actions.FILL_CUPS.label)) {
                System.out.println("Write how many disposable cups of coffee do you want to add:");
            } else {
                System.out.println("No such option!");
            }
        } while (CoffeeMaker.pushCommand(sc.nextLine()));
        
    }
    
}
