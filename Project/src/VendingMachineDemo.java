import controller.VendingMachineController;
import model.MaintenanceService;
import model.VendingMachine;
import state.VendingMachineCommands;

import java.util.Scanner;

public class VendingMachineDemo {
    //TODO: DO THIS!!!!!
    private static Scanner scanner;
    private static VendingMachineController vendingMachineController;
    private static MaintenanceService maintenanceService;
    public static void main(String[] args) {
        vendingMachineController = new VendingMachineController(new VendingMachine());
        maintenanceService = new MaintenanceService(vendingMachineController.getvendingMachine());
        scanner = new Scanner(System.in);
        executeOptionFeatures();
    }

    private static void executeOptionFeatures() {
        VendingMachineCommands commands;
        VendingMachineCommands[] availableCommands = {
                VendingMachineCommands.VENDING_MACHINE_FEATURES,
        VendingMachineCommands.MAINTENANCE_FEATURES,
        VendingMachineCommands.EXIT};
        displayCommands(availableCommands);
        do {
            commands = inputCommand(scanner);
            switch (commands) {
                case VENDING_MACHINE_FEATURES -> executeVendingMachineFeatures();
                case MAINTENANCE_FEATURES -> executeMaintenanceFeatures();
                case EXIT -> System.out.println("Program Terminated");
                default -> System.out.println("Invalid Command");
            }
        } while (commands != VendingMachineCommands.EXIT);
    }

    private static void executeVendingMachineFeatures() {
        VendingMachineCommands commands;

        VendingMachineCommands[] availableCommands = {
                VendingMachineCommands.BUY,
                VendingMachineCommands.EXIT};
        displayCommands(availableCommands);
        do {
            vendingMachineController.displayStock();
            commands = inputCommand(scanner);
            switch (commands) {
                case BUY -> vendingMachineController.buy();
                case EXIT -> System.out.println("Program Terminated");
                default -> System.out.println("Invalid Command");
            }
        } while (commands != VendingMachineCommands.EXIT);
    }

    private static void executeMaintenanceFeatures() {
        VendingMachineCommands commands;
        VendingMachineCommands[] availableCommands = {
                VendingMachineCommands.STOCK,
                VendingMachineCommands.RESTOCK,
                VendingMachineCommands.COLLECT_MONEY,
                VendingMachineCommands.REPLENISH_MONEY,
                VendingMachineCommands.CHANGE_ITEM_PRICE,
                VendingMachineCommands.EXIT};
        displayCommands(availableCommands);
        do {
            vendingMachineController.displayStock();
            commands = inputCommand(scanner);
            switch (commands) {
                case STOCK -> maintenanceService.stock();
                case RESTOCK -> maintenanceService.restock();
                case COLLECT_MONEY -> maintenanceService.collectMoney();
                case REPLENISH_MONEY -> maintenanceService.replenishDenomination();
                case CHANGE_ITEM_PRICE -> maintenanceService.changeItemPrice();
                case EXIT -> System.out.println("Program Terminated");
                default -> System.out.println("Invalid Command");
            }
        } while (commands != VendingMachineCommands.EXIT);
    }

    private static VendingMachineCommands inputCommand(Scanner scanner) {
        VendingMachineCommands command;
        do {
            command = VendingMachineCommands.inputCommand(scanner.next());
        } while (command == null);

        return command;
    }

    private static void displayCommands(VendingMachineCommands[] commands) {
        for (int i = 0; i < commands.length; i++) {
            System.out.printf("[%d] -", i + 1);
            System.out.println(commands[i].toString().toLowerCase().replaceAll("_", " "));
        }
    }
}
