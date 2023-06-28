package controller;

import model.Item;
import model.VendingMachine;
import view.MaintenanceView;

public class MaintenanceService {
    private int totalMoney;
    private VendingMachine vendingMachine;

    /**
     * Constructs a MaintenanceService object with the specified vending machine.
     *
     * @param vendingMachine the vending machine to be maintained
     */
    public MaintenanceService(VendingMachine vendingMachine) {
        totalMoney = 0;
        this.vendingMachine = vendingMachine;
    }

    //TODO: DO THIS!!!!!
    public void stock(int amount, int slotNo,
                      String itemName, int calories, int price) {
        boolean isCorrectInputs = true;
        if (slotNo - 1 < 0 || slotNo - 1 >= vendingMachine.getSlots().length) {
            MaintenanceView.displayError("Slot number input outside of range.");
            isCorrectInputs = false;
        }

        if (amount <= 0) {
            MaintenanceView.displayError("Item amount is not a positive integer.");
            isCorrectInputs = false;
        }

        if (itemName.isBlank()) {
            MaintenanceView.displayError("Item name is blank.");
            isCorrectInputs = false;
        }

        if (calories <= 0) {
            MaintenanceView.displayError("Item calories is not a positive integer.");
            isCorrectInputs = false;
        }

        if (price <= 0) {
            MaintenanceView.displayError("Item price is not a positive integer.");
            isCorrectInputs = false;
        }

        if (!isCorrectInputs) {
            return;
        }


        Item newItem = new Item(itemName, calories, price);
        vendingMachine.getSlots()[slotNo - 1].setItem(newItem);
        vendingMachine.getSlots()[slotNo - 1].setAmount(amount);
    }

    //TODO: DO THIS!!!!!
    public void restock(int amount, int slotNo) {
        boolean isCorrectInputs = true;
        if (slotNo - 1 < 0 || slotNo - 1 >= vendingMachine.getSlots().length) {
            MaintenanceView.displayError("Slot number input outside of range.");
            isCorrectInputs = false;
        }

        if (amount <= 0) {
            MaintenanceView.displayError("Item amount is not a positive integer.");
            isCorrectInputs = false;
        }

        if (!isCorrectInputs) {
            return;
        }

        vendingMachine.getSlots()[slotNo - 1].setAmount(amount);

    }

    //TODO: DO THIS!!!!!
    public void changeItemPrice(int slotNo, int price) {
        boolean isCorrectInputs = true;
        if (slotNo - 1 < 0 || slotNo - 1 >= vendingMachine.getSlots().length) {
            MaintenanceView.displayError("Slot number input outside of range.");
            isCorrectInputs = false;
        }

        if (price <= 0) {
            MaintenanceView.displayError("Item price is not a positive integer.");
            isCorrectInputs = false;
        }

        if (!isCorrectInputs) {
            return;
        }

        vendingMachine.getSlots()[slotNo - 1].getItem().setPrice(price);

    }

    //TODO: DO THIS!!!!!
    /**
     * Collects the money from the vending machine and adds it to the total money collected.
     */
    public void collectMoney() {
        totalMoney += vendingMachine.getDenomination().passDenomination();
    }

    //TODO: DO THIS!!!!!
    public boolean replenishDenomination(int amount) {
        if(amount > 0) {
            vendingMachine.getDenomination().getCurrency().replaceAll((k, v) -> v + amount);
            return true;
        }
        return false;
    }

    /**
     * Retrieves the total money collected by the maintenance service.
     *
     * @return the total money collected
     */
    public int getTotalMoney() {
        return totalMoney;
    }

    /**
     * Sets the vending machine for maintenance by the service.
     *
     * @param vendingMachine the vending machine to be maintained
     */
    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
}