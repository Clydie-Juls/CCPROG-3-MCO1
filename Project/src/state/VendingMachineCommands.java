package state;

public enum VendingMachineCommands {
    BUY,
    STOCK,
    RESTOCK,
    CHANGE_ITEM_PRICE,
    COLLECT_MONEY,
    REPLENISH_MONEY;

    //TODO: DO THIS!!!!!
    public static VendingMachineCommands inputCommand() {
        return BUY;
    }
}
