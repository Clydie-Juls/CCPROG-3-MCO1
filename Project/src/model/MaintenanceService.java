package model;


public class MaintenanceService {
    private int totalMoney;

    public MaintenanceService() {
        totalMoney = 0;
    }

    //TODO: DO THIS!!!!!
    public void stock(VendingMachine vendingMachine, Item item, int amount, int slotNo,
                      String itemName, int calories, int price) {
        if (slotNo - 1 >= 0  && slotNo - 1 < vendingMachine.getSlots().length) {
            Item newItem = new Item(itemName, calories, price);
            vendingMachine.getSlots()[slotNo - 1].setItem(item);
            vendingMachine.getSlots()[slotNo - 1].setAmount(amount);
        }
    }

    //TODO: DO THIS!!!!!
    public void restock(VendingMachine vendingMachine, int amount, int slotNo) {
        if (slotNo - 1 >= 0  && slotNo - 1 < vendingMachine.getSlots().length) {
            vendingMachine.getSlots()[slotNo - 1].setAmount(amount);
        }
    }

    //TODO: DO THIS!!!!!
    public void changeItemPrice(VendingMachine vendingMachine, int slotNo, int price) {
        if (slotNo - 1 >= 0  && slotNo - 1 < vendingMachine.getSlots().length) {
            vendingMachine.getSlots()[slotNo - 1].getItem().setPrice(price);
        }
    }

    //TODO: DO THIS!!!!!
    public void collectMoney(VendingMachine vendingMachine) {
        totalMoney += vendingMachine.getDenomination().passDenomination();
    }

    //TODO: DO THIS!!!!!
    public void replenishDenomination(VendingMachine vendingMachine, int amount) {
        vendingMachine.getDenomination().getCurrency().replaceAll((k, v) -> v + amount);
    }

    public int getTotalMoney() {
        return totalMoney;
    }
}
