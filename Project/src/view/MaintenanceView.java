package view;

public class MaintenanceView {

    public static void displayError(String ...errors) {
        for (String error : errors) {
            System.out.printf("Error: {%s}\n", error);
        }
    }
}