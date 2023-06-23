package model;

public class MaintenanceService {
    private int totalMoney;
    private VendingMachine vendingMachine;

    public MaintenanceService(VendingMachine vendingMachine) {
        totalMoney = 0;
        this.vendingMachine = vendingMachine;
    }

    //TODO: DO THIS!!!!!
    public boolean stock(int amount, int slotNo,
                      String itemName, int calories, int price) {
        if (slotNo - 1 >= 0  && slotNo - 1 < vendingMachine.getSlots().length || amount > 0 || !itemName.isEmpty() ||
        calories > 0 || price > 0) {
            Item newItem = new Item(itemName, calories, price);
            vendingMachine.getSlots()[slotNo - 1].setItem(newItem);
            vendingMachine.getSlots()[slotNo - 1].setAmount(amount);
            return true;
        }
        return false;
    }

    //TODO: DO THIS!!!!!
    public boolean restock(int amount, int slotNo) {
        if (slotNo - 1 >= 0  && slotNo - 1 < vendingMachine.getSlots().length || amount > 0) {
            vendingMachine.getSlots()[slotNo - 1].setAmount(amount);
            return true;
        }
        return false;
    }

    //TODO: DO THIS!!!!!
    public boolean changeItemPrice(int slotNo, int price) {
        if (slotNo - 1 >= 0  && slotNo - 1 < vendingMachine.getSlots().length || price > 0) {
            vendingMachine.getSlots()[slotNo - 1].getItem().setPrice(price);
            return true;
        }
        return false;
    }

    //TODO: DO THIS!!!!!
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

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
}
