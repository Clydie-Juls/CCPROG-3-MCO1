package controller;

import model.Item;
import model.Slot;
import model.VendingMachine;
import view.VendingMachineView;

import java.util.LinkedHashMap;

/**
 * Teh VendingMachineController class represents the vending machine's controller.
 */
public class VendingMachineController {
    private final VendingMachine VENDING_MACHINE;
    private final VendingMachineView VENDING_MACHINE_VIEW;

    /**
     * Initializes a vending machine controller with its model and view.
     * @param vendingMachine  model of the vending machine controller
     * @param vendingMachineView view of the vending machine controller
     */
    public VendingMachineController(VendingMachine vendingMachine, VendingMachineView vendingMachineView) {
        this.VENDING_MACHINE = vendingMachine;
        this.VENDING_MACHINE_VIEW = vendingMachineView;
    }

    /**
     * Buys an existing item of the vending machine. If the transaction process failed(i.e. not enough denomination) or
     * there is not enough item, the buy process will fail. Else, it will pass the items the user bought.
     * @param payment  Users payment.
     * @param slotNo  Slot number of the vending machine.
     * @param amount  amount of items the user wants to buy.
     * @return  array of items the user bought if successful, returns null otherwise.
     */
    public Item[] buy(LinkedHashMap<Integer, Integer> payment, int slotNo, int amount) {
        if (slotNo - 1 < 0 || slotNo - 1 >= VENDING_MACHINE.getSlots().length) {
            VENDING_MACHINE_VIEW.displayError("Slot number input outside of range.");
        } else {
            Slot selectedSlot = VENDING_MACHINE.getSlots()[slotNo - 1];

            if (!VENDING_MACHINE.getDenomination().processPayment(payment,
                    selectedSlot.getItem().getPrice() * amount)) {

                VENDING_MACHINE_VIEW.displayError("Currency Transactions has failed.");
            } else {
                Item[] dispensedItem = VENDING_MACHINE.dispenseItem(slotNo, amount);

                if(dispensedItem != null) {
                    VENDING_MACHINE.getTransactions().addTransaction(dispensedItem[0], amount);
                    return dispensedItem;
                }
                VENDING_MACHINE_VIEW.displayError("Not enough item to dispense.");
            }
        }
        return null;
    }

    /**
     * Display all existing(not null and has amount greater to 0) items in the vending machine.
     */
    public void displayStock() {
        VENDING_MACHINE_VIEW.displayStock(VENDING_MACHINE.getSlots());
    }

    /**
     * Displays the transaction history from the vending machine.
     */
    public void displayTransactions() {
        VENDING_MACHINE_VIEW.displayTransactions(VENDING_MACHINE.getTransactions().getItemLogs());
    }

    /**
     *  Checks if the vending machine has at least one stock of item.
     * @return  true if there is at least one stock of item, false otherwise.
     */
    public boolean hasStock() {
        boolean hasItem = false;
        for (int i = 0; i < VENDING_MACHINE.getSlots().length; ++i) {
            if (VENDING_MACHINE.getSlots()[i].getAmount() > 0) {
                hasItem = true;
            }
        }
        return hasItem;
    }

    /**
     * A getter for the vending machine.
     * @return  The controller's vending machine.
     */
    public VendingMachine getVendingMachine() {
        return VENDING_MACHINE;
    }

    /**
     * Retrieves the price of an existing item.
     * @param slotNo  Slot number of the vending machine.
     * @return  The price of the existing item.
     */
    public int getItemPrice(int slotNo) {
        if (slotNo - 1 < 0 || slotNo - 1 >= VENDING_MACHINE.getSlots().length) {
            VENDING_MACHINE_VIEW.displayError("Slot number input outside of range.");
            return -1;
        } else if(VENDING_MACHINE.getSlots()[slotNo - 1].getItem() == null) {
            VENDING_MACHINE_VIEW.displayError("Item doesn't exist in that slot number.");
            return -1;
        }
        return VENDING_MACHINE.getSlots()[slotNo - 1].getItem().getPrice();
    }


}
