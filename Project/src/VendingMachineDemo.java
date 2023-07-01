import controller.VendingMachineController;
import controller.MaintenanceService;
import model.Item;
import model.MaintenanceData;
import model.VendingMachine;
import state.Command;
import view.MaintenanceView;
import view.VendingMachineView;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The VendingMachineDemo class represents a demo program for a vending machine.
 */
public class VendingMachineDemo {
    private static Scanner scanner;
    private static VendingMachineController vendingMachineController;
    private static MaintenanceService maintenanceService;

    public static void main(String[] args) {
        //Initialization
        VendingMachine vendingMachine = new VendingMachine();
        VendingMachineView vendingMachineView = new VendingMachineView();
        MaintenanceData maintenanceData = new MaintenanceData();
        MaintenanceView maintenanceView = new MaintenanceView();
        vendingMachineController = new VendingMachineController(vendingMachine, vendingMachineView);
        maintenanceService = new MaintenanceService(maintenanceData,
                vendingMachineController.getVendingMachine(), maintenanceView);
        scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------");
        System.out.println("| Welcome to The Vending Machine Demo Program |");
        System.out.println("-----------------------------------------------");
        executeOptionFeatures();
        scanner.close();
    }

    /**
     * Executes the main options/features of the vending machine demo program.
     */
    private static void executeOptionFeatures() {
        // Available commands
        Command[] commands = {
                Command.VENDING_MACHINE_FEATURES,
                Command.MAINTENANCE_FEATURES,
                Command.EXIT
        };
        System.out.println("-------------------");
        System.out.println("| Option Features |");
        System.out.println("-------------------");

        Command currCommand;

        // command options inputs, prompts and actions.
        do {
            displayCommands(commands);
            currCommand = inputCommand(commands);
            switch (currCommand) {
                case VENDING_MACHINE_FEATURES -> executeVendingMachineFeatures();
                case MAINTENANCE_FEATURES -> executeMaintenanceFeatures();
                case EXIT -> System.out.println("Exit inputted.");
                default -> System.out.println("Command Not Recognized");
            }

        } while (currCommand != Command.EXIT);
    }

    /**
     * Executes the vending machine features/options.
     */
    private static void executeVendingMachineFeatures() {
        // Available commands
        Command[] commands = {
                Command.BUY,
                Command.EXIT
        };

        Command currCommand;

        System.out.println("---------------------------");
        System.out.println("| Vending Machine Options |");
        System.out.println("---------------------------");
        // command options inputs, prompts and actions.
        do {
            vendingMachineController.displayStock();
            System.out.println();
            displayCommands(commands);
            currCommand = inputCommand(commands);
            switch (currCommand) {
                case BUY -> {
                    if(!vendingMachineController.hasStock()) {
                        System.out.println("Command denied. The vending machine currently has no stock");
                        continue;
                    }
                    // Input prerequisites before buying
                    System.out.println("Enter slot Number: ");
                    int slotNo = scanner.nextInt();
                    System.out.println("Input amount: ");
                    int amount = scanner.nextInt();
                    LinkedHashMap<Integer, Integer> payment = new LinkedHashMap<>();
                    payment.put(1000, 0);
                    payment.put(500, 0);
                    payment.put(200, 0);
                    payment.put(100, 0);
                    payment.put(50, 0);
                    payment.put(20, 0);
                    payment.put(10, 0);
                    payment.put(5, 0);
                    payment.put(1, 0);

                    int priceLeft = vendingMachineController.getItemPrice(slotNo) * amount;

                    // Proceeds to denomination payment if previous inputs are valid
                    if (priceLeft > 0) {
                        // loops through the payment linked hash map for the frequency
                        for (Map.Entry<Integer, Integer> entry : payment.entrySet()) {
                            /* Prompts for input and shows the price left(Will still
                             continue regardless if price left is 0)*/
                            System.out.println("How may \"" + entry.getKey() + "\" are you going to insert? (₱"
                            + Math.max(0, priceLeft) + " left)");
                            // scans for the money amount and will loop until a positive integer value is inputted.
                            int moneyAmount = scanner.nextInt();
                            while (moneyAmount < 0) {
                                System.out.println("Please input a positive integer value");
                                System.out.println("How may \"" + entry.getKey() + "\" are you going to insert?");
                                moneyAmount = scanner.nextInt();
                            }
                            // decreases after each successful input
                            priceLeft -= entry.getKey() * moneyAmount;
                            // add the money amount
                            payment.put(entry.getKey(), moneyAmount);
                        }
                        // obtains the array of items bought if the buy process is successful
                        Item[] boughtItems = vendingMachineController.buy(payment, slotNo, amount);
                        if (boughtItems != null) {
                            System.out.println("Successfully bought :" + Arrays.toString(boughtItems));
                            System.out.println("Change of the Buyer:");
                            for (Map.Entry<Integer, Integer> entry : payment.entrySet()) {
                                System.out.println("₱" + entry.getKey() + " - " + entry.getValue());
                            }
                        }
                    } else {
                        System.out.println("Error { Invalid Inputs }");
                    }
                }
                case EXIT -> System.out.println("Exit inputted.");
                // Command is unrecognizable.
                default -> System.out.println("Command Not Recognized");
            }

        } while (currCommand != Command.EXIT);
    }

    /**
     * Executes the maintenance features/options.
     */
    private static void executeMaintenanceFeatures() {
        // Available commands
        Command[] commands = {
                Command.STOCK,
                Command.RESTOCK,
                Command.COLLECT_MONEY,
                Command.REPLENISH_DENOMINATION,
                Command.CHANGE_ITEM_PRICE,
                Command.SHOW_TOTAL_MONEY_COLLECTED,
                Command.DISPLAY_TRANSACTIONS,
                Command.EXIT
        };

        Command currCommand;

        System.out.println("-----------------------");
        System.out.println("| Maintenance Options |");
        System.out.println("-----------------------");

        // command options inputs, prompts and actions.
        do {
            // prompts unfiltered stock
            maintenanceService.displayUnfilteredStock();
            System.out.println();
            //prompts vending machine's current denomination
            maintenanceService.displayDenomination();
            System.out.println();
            displayCommands(commands);
            currCommand = inputCommand(commands);
            switch (currCommand) {
                case STOCK -> {
                    // Input prerequisites
                    System.out.println("Input item name:");
                    String itemName = scanner.nextLine();
                    System.out.println("Input amount:");
                    int amount = scanner.nextInt();
                    System.out.println("How much does each item cost?");
                    int price = scanner.nextInt();
                    System.out.println("Input calories:");
                    int calories = scanner.nextInt();
                    System.out.println("Which slot number should the item be placed in?");
                    int slotNo = scanner.nextInt();
                    maintenanceService.stock(amount, slotNo, itemName, calories, price);
                }

                case RESTOCK -> {
                    // Input prerequisites
                    System.out.println("Which slot number should be refilled?");
                    int slotNo = scanner.nextInt();
                    System.out.println("Input amount:");
                    int amount = scanner.nextInt();
                    maintenanceService.restock(amount, slotNo);
                }

                case COLLECT_MONEY -> maintenanceService.collectMoney();

                case REPLENISH_DENOMINATION -> {
                    // Input prerequisites
                    System.out.println("How many of each denomination should be refilled?");
                    int amount = scanner.nextInt();
                    maintenanceService.replenishDenomination(amount);
                }

                case CHANGE_ITEM_PRICE -> {
                    // Input prerequisites
                    System.out.println("Which slot number should the item's price be changed?");
                    int slotNo = scanner.nextInt();
                    System.out.println("Enter the new price:");
                    int price = scanner.nextInt();
                    maintenanceService.changeItemPrice(slotNo, price);
                }
                case SHOW_TOTAL_MONEY_COLLECTED -> maintenanceService.displayTotalMoneyCollected();
                case DISPLAY_TRANSACTIONS -> vendingMachineController.displayTransactions();
                case EXIT -> System.out.println("Exit inputted.");
                // Command is unrecognizable.
                default -> System.out.println("Command Not Recognized");
            }

        } while (currCommand != Command.EXIT);
    }

    /**
     * Reads and validates the user's command input.
     *
     * @param availableCommands The array of available commands.
     * @return The command entered by the user.
     */
    private static Command inputCommand(Command[] availableCommands) {
        Command command;
        // request for input until a valid command is inputted
        do {
            System.out.print("Input: ");
            String input;
            // request inputs until the input has actual words
            do {
                input = scanner.nextLine();
            } while (input.isBlank());
            command = Command.inputCommand(input);
            // if the user either inputed the wrong command or the command number
            if (command == null) {
                Integer commandIndex;
                // catch for the unchecked exception when the integer failed to parse the input
                try {
                    commandIndex = Integer.parseInt(input) - 1;
                } catch (NumberFormatException e) {
                    commandIndex = null;
                }
                // if command number input is valid and in range
                if (commandIndex != null && commandIndex >= 0 && commandIndex < availableCommands.length) {
                    command = availableCommands[commandIndex];
                } else {
                    // If command index is out of bounds
                    if(commandIndex == null) {
                        System.out.println("Error{ Command Index Out of Bounds. }");
                        // If the command index was caught for unchecked exception and wrong command input.
                    } else {
                        System.out.println("Error{ Command not Recognized. }");
                    }
                }
            }
        } while (command == null);

        return command;
    }

    /**
     * Displays the available commands/options to the user.
     *
     * @param commands The array of commands/options to display.
     */
    private static void displayCommands(Command[] commands) {
        for (int i = 0; i < commands.length; i++) {
            // format enum commands by converting them to lower case and removing '_'
            System.out.printf("[%d] - %s%n", i + 1, commands[i].toString().toLowerCase().
                    replace('_', ' '));
        }
    }
}
