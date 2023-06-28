import controller.VendingMachineController;
import controller.MaintenanceService;
import model.VendingMachine;
import state.Command;

import java.util.Scanner;

public class VendingMachineDemo {
    private static Scanner scanner;
    private static VendingMachineController vendingMachineController;
    private static MaintenanceService maintenanceService;
    public static void main(String[] args) {
        vendingMachineController = new VendingMachineController(new VendingMachine());
        maintenanceService = new MaintenanceService(vendingMachineController.getvendingMachine());
        scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------");
        System.out.println("| Welcome to The Vending Machine Demo Program |");
        System.out.println("-----------------------------------------------");
        executeOptionFeatures();
        scanner.close();
    }

    private static void executeOptionFeatures() {
        Command[] commands = {
                Command.VENDING_MACHINE_FEATURES,
                Command.MAINTENANCE_FEATURES,
                Command.EXIT};

        Command currCommand;

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

    private static void executeVendingMachineFeatures() {
        Command[] commands = {
                Command.BUY,
                Command.EXIT
        };

        Command currCommand;

        do {
            vendingMachineController.displayStock();
            System.out.println();
            displayCommands(commands);
            currCommand = inputCommand(commands);
            switch (currCommand) {
                // buy method will be modified.
                case BUY -> {
                    if(!vendingMachineController.buy()) {
                        System.out.println("Buy process Unsuccessful!!!");
                    }
                }
                case EXIT -> System.out.println("Exit inputted.");
                default -> System.out.println("Command Not Recognized");
            }

        } while (currCommand != Command.EXIT);
    }

    private static void executeMaintenanceFeatures() {
        Command[] commands = {
                Command.STOCK,
                Command.RESTOCK,
                Command.COLLECT_MONEY,
                Command.REPLENISH_MONEY,
                Command.CHANGE_ITEM_PRICE,
                Command.EXIT
        };

        Command currCommand;

        do {
            vendingMachineController.displayStock();
            System.out.println();
            displayCommands(commands);
            currCommand = inputCommand(commands);
            switch (currCommand) {
                case STOCK -> {
                    System.out.println("Input item name:");
                    String itemName = scanner.nextLine();
                    System.out.println("Input amount:");
                    int amount = scanner.nextInt();
                    System.out.println("How much of each item:");
                    int price = scanner.nextInt();
                    System.out.println("Input calories:");
                    int calories = scanner.nextInt();
                    System.out.println("Which slot number should the item be putted?");
                    int slotNo = scanner.nextInt();
                    maintenanceService.stock(amount, slotNo, itemName, calories, price);
                }

                case RESTOCK -> {
                    System.out.println("Which slot number should it refill the item?");
                    int slotNo = scanner.nextInt();
                    System.out.println("Input amount:");
                    int amount = scanner.nextInt();
                    maintenanceService.restock(amount, slotNo);
                }

                case COLLECT_MONEY -> maintenanceService.collectMoney();

                case REPLENISH_MONEY -> {
                    System.out.println("How many should I refill each denomination?");
                    int amount = scanner.nextInt();
                    maintenanceService.replenishDenomination(amount);
                }

                case CHANGE_ITEM_PRICE -> {
                    System.out.println("Which slot number should it change the item's price?");
                    int slotNo = scanner.nextInt();
                    System.out.println("How much?");
                    int price = scanner.nextInt();
                    maintenanceService.changeItemPrice(slotNo, price);
                }

                case EXIT -> System.out.println("Exit inputted.");
                default -> System.out.println("Command Not Recognized");
            }

        } while (currCommand != Command.EXIT);
    }

    private static Command inputCommand(Command[] availableCommands) {
        Command command;
        do {
            String input = scanner.nextLine();
            command = Command.inputCommand(input);
            if(command == null) {
                Integer commandIndex;
                try {
                    commandIndex = Integer.parseInt(input) - 1;
                } catch (NumberFormatException e) {
                    commandIndex = null;
                }
                if(commandIndex >= 0 && commandIndex < availableCommands.length) {
                    command = availableCommands[commandIndex];
                } else {
                    System.out.println("Command Index Out of bounds.");
                }

            }
        } while (command == null);

        return command;
    }

    private static void displayCommands(Command[] commands) {
        for (int i = 0; i < commands.length; i++) {
            System.out.printf("[%d] - ", i + 1);
            System.out.println(commands[i].toString().toLowerCase());
        }
    }
}
