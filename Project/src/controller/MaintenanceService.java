package controller;

import model.Item;
import model.MaintenanceData;
import model.VendingMachine;
import view.MaintenanceView;

/**
 * The MaintenanceService class maintains the vending machine's condition.
 */
public class MaintenanceService {
    private final MaintenanceData MAINTENANCE_DATA;
    private VendingMachine vendingMachine;
    private final MaintenanceView MAINTENANCE_VIEW;

    /**
     * Constructs a MaintenanceService object with the specified vending machine and the maintenance's model and view.
     * @param maintenanceData  Model of the maintenanceService.
     * @param vendingMachine  Vending machine to maintain.
     * @param maintenanceView  View of the maintenanceService.
     */
    public MaintenanceService(MaintenanceData maintenanceData, VendingMachine vendingMachine,
                              MaintenanceView maintenanceView) {
        this.MAINTENANCE_DATA = maintenanceData;
        this.vendingMachine = vendingMachine;
        this.MAINTENANCE_VIEW = maintenanceView;
    }

    /**
     * Stocks a new item to the vending machine.
     * @param amount  Amount of items to stock.
     * @param slotNo  Slot Number of the vending machine.
     * @param itemName  Name of the item.
     * @param calories  Amount of calories the item has.
     * @param price  How much the item is.
     */
    public void stock(int amount, int slotNo,
                      String itemName, int calories, int price) {
        boolean isCorrectInputs = true;
        if (slotNo - 1 < 0 || slotNo - 1 >= vendingMachine.getSlots().length) {
            MAINTENANCE_VIEW.displayError("Slot number input outside of range.");
            isCorrectInputs = false;
        }

        if (amount <= 0) {
            MAINTENANCE_VIEW.displayError("Item amount is not a positive integer.");
            isCorrectInputs = false;
        }

        if( amount > vendingMachine.getSlots()[slotNo - 1].getCapacity()) {
            MAINTENANCE_VIEW.displayError("Amount exceeded slot capacity.");
            isCorrectInputs = false;
        }

        if (itemName.isBlank()) {
            MAINTENANCE_VIEW.displayError("Item name is blank.");
            isCorrectInputs = false;
        }

        if (calories <= 0) {
            MAINTENANCE_VIEW.displayError("Item calories is not a positive integer.");
            isCorrectInputs = false;
        }

        if (price <= 0) {
            MAINTENANCE_VIEW.displayError("Item price is not a positive integer.");
            isCorrectInputs = false;
        }

        if (!isCorrectInputs) {
            return;
        }


        Item newItem = new Item(itemName, calories, price);
        vendingMachine.getSlots()[slotNo - 1].setItem(newItem);
        vendingMachine.getSlots()[slotNo - 1].setAmount(amount);
        vendingMachine.getTransactions().resetTransactions();
    }

    /**
     * Restocks an existing item of the vending machine.
     * @param amount  Amount of items to stock.
     * @param slotNo  Slot Number of the vending machine.
     */
    public void restock(int amount, int slotNo) {
        boolean isCorrectInputs = true;
        if (slotNo - 1 < 0 || slotNo - 1 >= vendingMachine.getSlots().length) {
            MAINTENANCE_VIEW.displayError("Slot number input outside of range.");
            isCorrectInputs = false;
        } else {
            if(vendingMachine.getSlots()[slotNo - 1].getItem() == null) {
                MAINTENANCE_VIEW.displayError("Cannot restock because there is no existing item there.");
                isCorrectInputs = false;
            }
            if(vendingMachine.getSlots()[slotNo - 1].getAmount() + amount >
                    vendingMachine.getSlots()[slotNo -1].getCapacity()) {
                MAINTENANCE_VIEW.displayError("Amount exceeded slot capacity.");
                isCorrectInputs = false;
            }
        }

        if (amount <= 0) {
            MAINTENANCE_VIEW.displayError("Item amount is not a positive integer.");
            isCorrectInputs = false;
        }

        if (!isCorrectInputs) {
            return;
        }

        vendingMachine.getSlots()[slotNo - 1].setAmount(vendingMachine.getSlots()[slotNo - 1].getAmount() + amount);
        vendingMachine.getTransactions().resetTransactions();

    }

    /**
     * Change the price of an existing item in the vending machine.
     * @param slotNo  Slot Number of the vending machine.
     * @param price  How much the item is.
     */
    public void changeItemPrice(int slotNo, int price) {
        boolean isCorrectInputs = true;
        if (slotNo - 1 < 0 || slotNo - 1 >= vendingMachine.getSlots().length) {
            MAINTENANCE_VIEW.displayError("Slot number input outside of range.");
            isCorrectInputs = false;
        }

        if (price <= 0) {
            MAINTENANCE_VIEW.displayError("Item price is not a positive integer.");
            isCorrectInputs = false;
        }

        if (!isCorrectInputs) {
            return;
        }

        vendingMachine.getSlots()[slotNo - 1].getItem().setPrice(price);

    }

    /**
     * Collects the money saved in the vending machine
     */
    public void collectMoney() {
        MAINTENANCE_DATA.setTotalMoney(MAINTENANCE_DATA.getTotalMoney() +
                vendingMachine.getDenomination().passDenomination());
    }

    /**
     * Refills the vending machine's denomination by a given amount.
     * @param amount  Amount to refill per vending machine's denomination.
     */
    public void replenishDenomination(int amount) {
        if (amount <= 0) {
            MAINTENANCE_VIEW.displayError("Item amount is not a positive integer.");
            return;
        }

        vendingMachine.getDenomination().getCurrency().replaceAll((k, v) -> v + amount);
    }

    /**
     * Displays the stock of the vending machine regardless if it has an item or not.
     */
    public void displayUnfilteredStock() {
        MAINTENANCE_VIEW.displayUnfilteredStock(vendingMachine.getSlots());
    }

    /**
     * Displays the total amount of money the maintenance service has collected.
     */
    public void displayTotalMoneyCollected() {
        MAINTENANCE_VIEW.displayTotalMoneyCollected(MAINTENANCE_DATA.getTotalMoney());
    }

    /**
     * Displays the vending machine's denomination.
     */
    public void displayDenomination() {
        MAINTENANCE_VIEW.displayDenomination(vendingMachine.getDenomination().getCurrency());
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