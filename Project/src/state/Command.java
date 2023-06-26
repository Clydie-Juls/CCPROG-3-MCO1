package state;

public enum Command {
    BUY,
    STOCK,
    RESTOCK,
    CHANGE_ITEM_PRICE,
    COLLECT_MONEY,
    REPLENISH_MONEY,
    EXIT,
    VENDING_MACHINE_FEATURES,
    MAINTENANCE_FEATURES;

    //TODO: DO THIS!!!!!
    public static Command inputCommand(String input) {
        for (int i = 0; i < Command.values().length; i++) {

            if(Command.values()[i].toString().equalsIgnoreCase(input)) {
                return Command.values()[i];
            }
        }
        return null;
    }
}
