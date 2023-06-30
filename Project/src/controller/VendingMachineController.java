package controller;

import model.Item;
import model.Slot;
import model.VendingMachine;
import view.VendingMachineView;

import java.util.LinkedHashMap;

public class VendingMachineController {
    private final VendingMachine VENDING_MACHINE;
    private final VendingMachineView VENDING_MACHINE_VIEW;

    public VendingMachineController(VendingMachine vendingMachine, VendingMachineView vendingMachineView) {
        this.VENDING_MACHINE = vendingMachine;
        this.VENDING_MACHINE_VIEW = vendingMachineView;
    }

    //TODO: DO THIS!!!!!
    public Item[] buy(LinkedHashMap<Integer, Integer> payment, int slotNo, int amount) {
        if (slotNo - 1 < 0 || slotNo - 1 >= VENDING_MACHINE.getSlots().length) {
            VENDING_MACHINE_VIEW.displayError("Slot number input outside of range.");
        } else {
            Slot selectedSlot = VENDING_MACHINE.getSlots()[slotNo - 1];

            if (!VENDING_MACHINE.getDenomination().processPayment(payment,
                    selectedSlot.getItem().getPrice() * amount)) {

                VENDING_MACHINE_VIEW.displayError("Currency Transactions has failed.");
                Item[] dispensedItem = VENDING_MACHINE.dispenseItem(slotNo, amount);

                if(dispensedItem != null) {
                    return dispensedItem;
                }
                VENDING_MACHINE_VIEW.displayError("Not enough item to dispense.");
            }
        }
        return null;
    }



    //TODO: DO THIS!!!!!
    public void displayStock() {
        VENDING_MACHINE_VIEW.displayStock(VENDING_MACHINE);
    }

    //TODO: DO THIS!!!!!
    public void displayTransactions() {
        VENDING_MACHINE_VIEW.displayTransactions(VENDING_MACHINE);
    }

    public boolean hasStock() {
        boolean hasItem = false;
        for (int i = 0; i < VENDING_MACHINE.getSlots().length; ++i) {
            if (VENDING_MACHINE.getSlots()[i].getAmount() > 0) {
                hasItem = true;
            }
        }
        return hasItem;
    }

    public VendingMachine getVendingMachine() {
        return VENDING_MACHINE;
    }


}
