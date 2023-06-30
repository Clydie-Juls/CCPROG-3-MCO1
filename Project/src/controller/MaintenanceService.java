package controller;

import model.Item;
import model.MaintenanceData;
import model.VendingMachine;
import view.MaintenanceView;

public class MaintenanceService {
    private final MaintenanceData MAINTENANCE_DATA;
    private VendingMachine vendingMachine;
    private final MaintenanceView MAINTENANCE_VIEW;

    /**
     * Constructs a MaintenanceService object with the specified vending machine.
     *
     * @param vendingMachine the vending machine to be maintained
     */
    public MaintenanceService(MaintenanceData maintenanceData, VendingMachine vendingMachine,
                              MaintenanceView maintenanceView) {
        this.MAINTENANCE_DATA = maintenanceData;
        this.vendingMachine = vendingMachine;
        this.MAINTENANCE_VIEW = maintenanceView;
    }

    //TODO: DO THIS!!!!!
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

    //TODO: DO THIS!!!!!
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

    //TODO: DO THIS!!!!!
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

    //TODO: DO THIS!!!!!
    /**
     * Collects the money from the vending machine and adds it to the total money collected.
     */
    public void collectMoney() {
        MAINTENANCE_DATA.setTotalMoney(MAINTENANCE_DATA.getTotalMoney() +
                vendingMachine.getDenomination().passDenomination());
    }

    //TODO: DO THIS!!!!!
    public void replenishDenomination(int amount) {
        if (amount <= 0) {
            MAINTENANCE_VIEW.displayError("Item amount is not a positive integer.");
            return;
        }

        vendingMachine.getDenomination().getCurrency().replaceAll((k, v) -> v + amount);
    }

    public void displayUnfilteredStock() {
        MAINTENANCE_VIEW.displayUnfilteredStock(vendingMachine.getSlots());
    }

    public void displayTotalMoneyCollected() {
        MAINTENANCE_VIEW.displayTotalMoneyCollected(MAINTENANCE_DATA.getTotalMoney());
    }

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