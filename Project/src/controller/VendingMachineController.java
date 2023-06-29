package controller;

import model.Item;
import model.VendingMachine;
import view.VendingMachinePrinter;

import java.util.LinkedHashMap;

public class VendingMachineController {
    private final VendingMachine VENDING_MACHINE;

    public VendingMachineController(VendingMachine vendingMachine) {
        this.VENDING_MACHINE = vendingMachine;
    }

    //TODO: DO THIS!!!!!
    public Item[] buy(LinkedHashMap<Integer, Integer> payment, int slotNumber, int amount) {
        return VENDING_MACHINE.dispenseItem(payment, slotNumber, amount);
    }



    //TODO: DO THIS!!!!!
    public void displayStock() {
        VendingMachinePrinter.displayStock(VENDING_MACHINE);
    }

    //TODO: DO THIS!!!!!
    public void displayTransactions() {

    }

    public VendingMachine getvendingMachine() {
        return VENDING_MACHINE;
    }
}
