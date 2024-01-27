package Helper;

public class Helper {
    public static int convertToInt(String choice) {
        int userInput = -1;
        try {
            userInput = Integer.parseInt(choice);
        } catch (NumberFormatException e) {
            System.out.println(" Please enter a valid number.");
        }
        return userInput;
    }

}
