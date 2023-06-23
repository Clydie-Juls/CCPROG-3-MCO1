package controller;


import model.Item;
import model.VendingMachine;

public class MaintenanceService {
    private int totalMoney;
    private VendingMachine vendingMachine;

    public MaintenanceService(VendingMachine vendingMachine) {
        totalMoney = 0;
        this.vendingMachine = vendingMachine;
    }

    //TODO: DO THIS!!!!!
    public void stock(Item item, int amount, int slotNo,
                      String itemName, int calories, int price) {
        if (slotNo - 1 >= 0  && slotNo - 1 < vendingMachine.getSlots().length) {
            Item newItem = new Item(itemName, calories, price);
            vendingMachine.getSlots()[slotNo - 1].setItem(item);
            vendingMachine.getSlots()[slotNo - 1].setAmount(amount);
        }
    }

    //TODO: DO THIS!!!!!
    public void restock(int amount, int slotNo) {
        if (slotNo - 1 >= 0  && slotNo - 1 < vendingMachine.getSlots().length) {
            vendingMachine.getSlots()[slotNo - 1].setAmount(amount);
        }
    }

    //TODO: DO THIS!!!!!
    public void changeItemPrice(int slotNo, int price) {
        if (slotNo - 1 >= 0  && slotNo - 1 < vendingMachine.getSlots().length) {
            vendingMachine.getSlots()[slotNo - 1].getItem().setPrice(price);
        }
    }

    //TODO: DO THIS!!!!!
    public void collectMoney() {
        totalMoney += vendingMachine.getDenomination().passDenomination();
    }

    //TODO: DO THIS!!!!!
    public void replenishDenomination(int amount) {
        vendingMachine.getDenomination().getCurrency().replaceAll((k, v) -> v + amount);
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
}
