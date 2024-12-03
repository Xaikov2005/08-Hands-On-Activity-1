import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException; // mport Scanner from java.util and LocalTime from java.time. For showAlarm(),

public abstract class Weekday implements Alarm{ //Add two (2) classes without modifiers named Weekday (abstract) and Monday
    // For the Weekday class, implement the Alarm interface. Leave this class empty.
    protected String time;

    @Override
    public void setAlarm(String time) {
        this.time = time;
    }

    @Override
    public void showAlarm() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm"); 

            // add these two (2) statements: LocalTime alarm = LocalTime.parse(time), LocalTime now = LocalTime.now()
            LocalTime alarm = LocalTime.parse(time, formatter); 
            LocalDateTime now = LocalDateTime.now(); 

            // Create today's alarm and tomorrow's alarm
            LocalDateTime todayAlarm = LocalDateTime.of(LocalDate.now(), alarm);
            LocalDateTime tomorrowAlarm = todayAlarm.plusDays(1);

            if (todayAlarm.isBefore(now)) { //Use isAfter() or isBefore() in the showAlarm() 
                System.out.println("\u001B[32mAlarm is set for Tommorow at " + tomorrowAlarm); // If the time entered is past the current time, then display "Alarm is set for tomorrow!";
                System.out.println("\u001B[0m");
                

            } else if (todayAlarm.isAfter(now)) { //Use isAfter() or isBefore() in the showAlarm() 
                System.out.println("\u001B[32mI'll wake you up later at " + todayAlarm); //otherwise, display "I'll wake you up later!"
                System.out.println("\u001B[0m");

            }else {
                System.out.println("\u001B[32mAlarm is set at " + todayAlarm);
                System.out.println("\u001B[0m");
            }
        } catch (DateTimeParseException e) {
            System.out.println("\u001B[31mInvalid time format. Please enter the time in HH:MM format.");
        }
    }

}


