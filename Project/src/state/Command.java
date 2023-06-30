package state;

/**
 * The Command enum represents the available commands in the vending machine system.
 */
public enum Command {
    BUY,
    STOCK,
    RESTOCK,
    CHANGE_ITEM_PRICE,
    COLLECT_MONEY,
    REPLENISH_MONEY,
    EXIT,
    VENDING_MACHINE_FEATURES,
    DISPLAY_TRANSACTIONS,
    MAINTENANCE_FEATURES;

    /**
     * Parses the input string and returns the corresponding Command enum value.
     *
     * @param input the input string representing a command
     * @return the Command enum value corresponding to the input string, or null if no match is found
     */
    public static Command inputCommand(String input) {
        for (Command command : Command.values()) {
            if (command.toString().equalsIgnoreCase(input.trim().replaceAll("\\s+", "_"))) {
                return command;
            }
        }
        return null;
    }
}
