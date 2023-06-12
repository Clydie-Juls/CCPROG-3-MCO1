package controller;

import model.MaintenanceService;
import model.VendingMachine;

public class VendingMachineController {
    private final VendingMachine VENDING_MACHINE;
    private MaintenanceService maintenanceService;

    public VendingMachineController(VendingMachine vendingMachine, MaintenanceService maintenanceService) {
        this.VENDING_MACHINE = vendingMachine;
        this.maintenanceService = maintenanceService;
    }

    //TODO: DO THIS!!!!!
    public boolean pickItem() {
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

    }

    //TODO: DO THIS!!!!!
    public void displayTransactions() {

    }

    //TODO: DO THIS!!!!!
    public void displayStockComparison() {

    }
}
