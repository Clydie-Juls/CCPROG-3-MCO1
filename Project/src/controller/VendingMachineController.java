package controller;

import model.Item;
import model.Slot;
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
    public Item[] buy(LinkedHashMap<Integer, Integer> payment, int slotNo, int amount) {
        if (slotNo - 1 < 0 || slotNo - 1 >= VENDING_MACHINE.getSlots().length) {
            System.out.println("Slot number input outside of range.");
        } else {
            Slot selectedSlot = VENDING_MACHINE.getSlots()[slotNo];

            if (!VENDING_MACHINE.getDenomination().processPayment(payment,
                    selectedSlot.getItem().getPrice() * amount)) {

                System.out.println("Currency Transactions has failed.");
                Item[] dispensedItem = VENDING_MACHINE.dispenseItem(slotNo, amount);

                if(dispensedItem != null) {
                    return dispensedItem;
                }
                System.out.println("Not enough item to dispense.");
            }
        }
        return null;
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
