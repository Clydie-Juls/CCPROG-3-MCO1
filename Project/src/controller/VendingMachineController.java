package controller;

import model.Item;
import model.VendingMachine;
import view.VendingMachinePrinter;

import java.util.LinkedHashMap;

public class VendingMachineController {
    private final VendingMachine VENDING_MACHINE;
    private final VendingMachinePrinter VENDING_MACHINE_PRINTER;

    public VendingMachineController(VendingMachine vendingMachine, VendingMachinePrinter vendingMachinePrinter) {
        this.VENDING_MACHINE = vendingMachine;
        this.VENDING_MACHINE_PRINTER = vendingMachinePrinter;
    }

    //TODO: DO THIS!!!!!
    public Item[] buy(LinkedHashMap<Integer, Integer> payment, int slotNumber, int amount) {
        return VENDING_MACHINE.dispenseItem(payment, slotNumber, amount);
    }



    //TODO: DO THIS!!!!!
    public void displayStock() {
        VENDING_MACHINE_PRINTER.displayStock(VENDING_MACHINE);
    }

    //TODO: DO THIS!!!!!
    public void displayTransactions() {
        VENDING_MACHINE_PRINTER.displayStock(VENDING_MACHINE);
    }

    public VendingMachine getVendingMachine() {
        return VENDING_MACHINE;
    }


}
