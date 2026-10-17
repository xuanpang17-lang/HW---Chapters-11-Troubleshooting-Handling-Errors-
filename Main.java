import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        System.out.println("=== Terminal Input Reader with Exception Handling ===");

        while (continueProgram) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Read an Integer");
            System.out.println("2. Read a Double (Decimal Number)");
            System.out.println("3. Read a Line of Text");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            try {
                int choice = scanner.nextInt();
                // Consume the remaining newline character
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        readInteger(scanner);
                        break;
                    case 2:
                        readDouble(scanner);
                        break;
                    case 3:
                        readText(scanner);
                        break;
                    case 4:
                        System.out.println("Exiting the program. Goodbye!");
                        continueProgram = false;
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid choice input! Please enter an integer menu option.");
                // Clear the invalid token from scanner buffer
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    /**
     * Reads an integer from the user safely using try...catch
     */
    private static void readInteger(Scanner scanner) {
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Please enter an integer (e.g., 42): ");
                int number = scanner.nextInt();
                scanner.nextLine(); // Clear newline
                System.out.println("--> Success! You entered integer: " + number);
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: That was not a valid integer. Please try again.");
                scanner.nextLine(); // Clear invalid input from buffer
            }
        }
    }

    /**
     * Reads a double from the user safely using try...catch
     */
    private static void readDouble(Scanner scanner) {
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Please enter a decimal number (e.g., 3.14): ");
                double number = scanner.nextDouble();
                scanner.nextLine(); // Clear newline
                System.out.println("--> Success! You entered decimal: " + number);
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: That was not a valid decimal number. Please try again.");
                scanner.nextLine(); // Clear invalid input from buffer
            }
        }
    }

    /**
     * Reads a line of text from the user safely using try...catch
     */
    private static void readText(Scanner scanner) {
        try {
            System.out.print("Please enter any text/sentence: ");
            String text = scanner.nextLine();
            System.out.println("--> Success! You entered text: \"" + text + "\"");
        } catch (Exception e) {
            System.out.println("Error reading text input: " + e.getMessage());
        }
    }
}