package bankapp.cli;

import java.util.Scanner;

/**
 * The class ConsoleHelper provides helper methods for console I/O.
 */
public class ConsoleHelper {

	/**
	 * The scanner to read from the console.
	 */
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Displays a menu of options.
	 *
	 * @param title   the title of the menu
	 * @param options the menu options
	 * @return the number of the chosen option
	 */
	public static int displayMenu(String title, String... options) {
		while (true) {
			if (title != null) {
				System.out.println();
				System.out.println(title);
				System.out.println("----------------------------------------");
			}
			for (int i = 1; i <= options.length; i++)
				System.out.println(i + ": " + options[i - 1]);
			int choice = readInteger("> ");
			if (choice >= 1 && choice <= options.length)
				return choice;
			System.out.println("Invalid choice");
		}
	}

	/**
	 * Reads a string from the console.
	 *
	 * @param prompt the prompt to display
	 * @return the read string
	 */
	public static String readString(String prompt) {
		prompt = prompt.endsWith(" ") ? prompt : prompt + ": ";
		System.out.print(prompt);
		return scanner.nextLine();
	}

	/**
	 * Reads an integer from the console.
	 *
	 * @param prompt the prompt to display
	 * @return the read integer
	 */
	public static int readInteger(String prompt) {
		prompt = prompt.endsWith(" ") ? prompt : prompt + ": ";
		while (true) {
			System.out.print(prompt);
			String line = scanner.nextLine();
			if (line.matches("\\d+"))
				return Integer.parseInt(line);
			System.out.println("Invalid input");
		}
	}

	/**
	 * Reads a decimal from the console.
	 *
	 * @param prompt the prompt to display
	 * @return the read decimal
	 */
	public static double readDecimal(String prompt) {
		prompt = prompt.endsWith(" ") ? prompt : prompt + ": ";
		while (true) {
			System.out.print(prompt);
			String line = scanner.nextLine();
			if (line.matches("\\d+(\\.\\d+)?"))
				return Double.parseDouble(line);
			System.out.println("Invalid input");
		}
	}

	/**
	 * Writes a message to the console.
	 *
	 * @param text the message text
	 */
	public static void writeMessage(String text) {
		System.out.println("*" + text + "*");
	}

	public static void writeData(Object data) {
		System.out.println("-> " + data);
	}
}
