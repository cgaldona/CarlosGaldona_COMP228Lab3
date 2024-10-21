package exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameTesterMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<GameTester> gameTesterList = new ArrayList<>();

        while (true) {
            GameTester gameTester = null;

            String name;
            while (true) {
                System.out.println("Enter the name of the game tester:");
                name = scanner.nextLine();

                if (!name.trim().isEmpty()) {
                    if (name.matches(".*\\d.*")) {
                        System.out.println("Name should be a string, not numeric. Please enter a valid name.");
                    } else {
                        break; // Exit the loop if a valid name is entered
                    }
                } else {
                    System.out.println("No input entered. Please enter a name.");
                }
            }

            String type;
            while (true) {
                System.out.println("Enter type of game tester (full-time/part-time):");
                type = scanner.nextLine();

                if (!type.trim().isEmpty() && (type.equalsIgnoreCase("full-time") || type.equalsIgnoreCase("part-time"))) {
                    break; // Exit the loop if a valid type is entered
                } else if (type.trim().isEmpty()) {
                    System.out.println("No input entered. Please enter a type.");
                } else {
                    System.out.println("Invalid type. Please enter either 'full-time' or 'part-time': ");
                }
            }

            if (type.equalsIgnoreCase("full-time")) {
                gameTester = new FullTimeGameTester(name);
            } else if (type.equalsIgnoreCase("part-time")) {
                int hoursWorked = 0;
                while (true) {
                    System.out.println("Enter the number of hours worked:");
                    String hoursInput = scanner.nextLine();

                    if (!hoursInput.trim().isEmpty()) {
                        try {
                            hoursWorked = Integer.parseInt(hoursInput);
                            break; // Exit the loop if a valid number is entered
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a numeric value.");
                        }
                    } else {
                        System.out.println("No input entered. Please enter the number of hours worked.");
                    }
                }
                gameTester = new PartTimeGameTester(name, hoursWorked);
            }

            gameTesterList.add(gameTester);

            System.out.println("Game Tester Name: " + gameTester.getName());
            System.out.println("Full-Time: " + gameTester.isFullTime());
            System.out.println("Salary: $" + gameTester.determineSalary());

            String response;
            while (true) {
                System.out.println("Do you want to enter another game tester object? (yes/no):");
                response = scanner.nextLine();

                if (!response.trim().isEmpty()) {
                    if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("no")) {
                        break; // Exit the loop if a valid response is entered
                    } else {
                        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    }
                } else {
                    System.out.println("No input entered. Please enter 'yes' or 'no'.");
                }
            }

            if (response.equalsIgnoreCase("no")) {
                System.out.println("Details of all entered game testers:");
                for (GameTester tester : gameTesterList) {
                    System.out.println("Name: " + tester.getName());
                    System.out.println("Full-Time: " + tester.isFullTime());
                    System.out.println("Salary: $" + tester.determineSalary());
                    System.out.println("--------------------------");
                }
                break; // Exit the outer while loop
            }
        }

        scanner.close();
    }
}
