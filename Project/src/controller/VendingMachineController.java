package controller;

import model.VendingMachine;
import view.VendingMachinePrinter;

public class VendingMachineController {
    private final VendingMachine VENDING_MACHINE;

    public VendingMachineController(VendingMachine vendingMachine) {
        this.VENDING_MACHINE = vendingMachine;
    }

    //TODO: DO THIS!!!!!
    public boolean buy() {
        return false;
    }

    //TODO: DO THIS!!!!!
    public void stock() {

    }

    //TODO: DO THIS!!!!!
    public void restock() {

    }

    //TODO: DO THIS!!!!!
    public void changeItemPrice() {

    }

    //TODO: DO THIS!!!!!
    public void collectMoney() {

    }

    //TODO: DO THIS!!!!!
    public void replenishDenomination() {

    }

    //TODO: DO THIS!!!!!
    public void displayStock() {
        VendingMachinePrinter.displayStock(VENDING_MACHINE);
    }

    //TODO: DO THIS!!!!!
    public void displayTransactions() {

    }

    //TODO: DO THIS!!!!!
    public void displayStockComparison() {

    }

    public VendingMachine getvendingMachine() {
        return VENDING_MACHINE;
    }
}
