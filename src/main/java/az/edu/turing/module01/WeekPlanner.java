package az.edu.turing.module01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WeekPlanner {

    private static final String[] DAYS_OF_WEEK = {
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    };

    private static final Map<String, String> schedule = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeSchedule();

        while (true) {
            System.out.println("\n--- Week Planner ---");
            System.out.println("1. View Schedule");
            System.out.println("2. Add Activity");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewSchedule();
                    break;
                case 2:
                    addActivity(scanner);
                    break;
                case 3:
                    System.out.println("Exiting... Have a great day!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        }
    }

    private static void initializeSchedule() {
        for (String day : DAYS_OF_WEEK) {
            schedule.put(day, "");
        }
    }

    private static void viewSchedule() {
        System.out.println("\n--- Schedule ---");
        for (String day : DAYS_OF_WEEK) {
            String activity = schedule.get(day);
            if (activity.isEmpty()) {
                System.out.println(day + ": No activity scheduled.");
            } else {
                System.out.println(day + ": " + activity);
            }
        }
    }

    private static void addActivity(Scanner scanner) {
        System.out.println("\nWhich day would you like to add an activity to?");
        for (int i = 0; i < DAYS_OF_WEEK.length; i++) {
            System.out.println((i + 1) + ". " + DAYS_OF_WEEK[i]);
        }
        System.out.print("Choose a day: ");

        int dayIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (dayIndex < 0 || dayIndex >= DAYS_OF_WEEK.length) {
            System.out.println("Invalid day selected.");
            return;
        }

        String day = DAYS_OF_WEEK[dayIndex];
        System.out.print("Enter the activity for " + day + ": ");
        String activity = scanner.nextLine();

        schedule.put(day, activity);
        System.out.println("Activity added for " + day + ".");
    }
}

