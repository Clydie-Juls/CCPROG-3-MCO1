import controller.VendingMachineController;
import model.MaintenanceService;
import model.VendingMachine;
import state.VendingMachineCommands;

import java.util.Map;
import java.util.Scanner;

public class VendingMachineDemo {
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
        Map<VendingMachineCommands, Runnable> commandsRunnableMap = Map.of(
                VendingMachineCommands.VENDING_MACHINE_FEATURES, VendingMachineDemo::executeVendingMachineFeatures,
                VendingMachineCommands.MAINTENANCE_FEATURES, VendingMachineDemo::executeMaintenanceFeatures,
                VendingMachineCommands.EXIT, () -> System.out.println("Program Terminated")
        );

        displayCommands(commandsRunnableMap.keySet().toArray(new VendingMachineCommands[0]));
        executeCommand(commandsRunnableMap, false);
    }

    private static void executeVendingMachineFeatures() {
        Map<VendingMachineCommands, Runnable> commandsRunnableMap = Map.of(
                VendingMachineCommands.BUY, () -> {if(vendingMachineController.buy()) {System.out.println("Unable to purchase");}},
                VendingMachineCommands.EXIT, () -> System.out.println("Vnd Features exit.")
        );

        displayCommands(commandsRunnableMap.keySet().toArray(new VendingMachineCommands[0]));
        executeCommand(commandsRunnableMap, true);
    }

    private static void executeMaintenanceFeatures() {
        Map<VendingMachineCommands, Runnable> commandsRunnableMap = Map.of(
                VendingMachineCommands.STOCK, maintenanceService.stock(),
                VendingMachineCommands.RESTOCK, maintenanceService.restock(),
                VendingMachineCommands.COLLECT_MONEY, maintenanceService.collectMoney(),
                VendingMachineCommands.REPLENISH_MONEY, maintenanceService.replenishDenomination(),
                VendingMachineCommands.CHANGE_ITEM_PRICE, maintenanceService.changeItemPrice(),
                VendingMachineCommands.EXIT, () -> System.out.println("Exit Maintenance features.")
        );

        displayCommands(commandsRunnableMap.keySet().toArray(new VendingMachineCommands[0]));
        executeCommand(commandsRunnableMap, false);
    }

    private static void executeCommand(Map<VendingMachineCommands, Runnable> commandsRunnableMap,
                                       boolean isVndFeatures) {
        displayCommands(commandsRunnableMap.keySet().toArray(new VendingMachineCommands[0]));
        VendingMachineCommands command;
        do {
            if(isVndFeatures) {
                vendingMachineController.displayStock();
            }
            command = inputCommand(scanner);
            if(commandsRunnableMap.containsKey(command)) {
                commandsRunnableMap.get(command).run();
            } else {
                System.out.println("Invalid Command");
            }
        } while (command != VendingMachineCommands.EXIT);
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
