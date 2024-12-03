import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Monday extends Weekday{
    // Create a public class named Monday. This class shall contain the main method

    static boolean isValidTime(String time) {
        
        try {
            // Allow parsing with or without leading zeros
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
            LocalTime.parse(time, formatter);
            return true;
        } catch (DateTimeParseException e) {
            
        }
        return false;
    }
    public static void main(String[] args) throws Exception {

        String time;

        Monday monday = new Monday();
        
        try{
            
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("\u001B[0mEnter the time for the alarm (Military Time/HH:MM): ");
                time = scanner.nextLine();

                if (isValidTime(time)) {
                    monday.setAlarm(time);
                    break; // Exit loop if input is valid
                } else {
                    System.out.println("\u001B[31mInvalid time format! Please use HH:MM (e.g., 8:00 or 14:30).");
                }
            }

        } catch(InputMismatchException e) {
            System.out.println("\u001B[31mInvalid time format! Please use HH:MM (e.g., 8:00 or 14:30).");
        }
        
        monday.showAlarm();

    
    }
}