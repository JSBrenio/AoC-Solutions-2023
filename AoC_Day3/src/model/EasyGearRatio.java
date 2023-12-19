
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Problem: Conundrum, sum all possible GameIDs given sets of games.
 * 
 * @author Jeremiah
 * 
 * @version 1.0
 * 
 */
public class EasyGearRatio {

	/**
	 * prevents external instantiation.
	 */
	private EasyGearRatio() {
		throw new IllegalStateException();
	}

	/**
	 * Runs solution.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		String file = "AoC_Solutions\\AoC_Day3\\files\\input2.txt";

		int result = solve(file);

		System.out.print(result);
	}

	private static int solve(String theFile) throws FileNotFoundException {

		int sum = 0;

		File file = new File(theFile);

		Scanner scan = new Scanner(file);

		// symbol checker
		Set<Character> symbols = new HashSet<>();
		symbols.add('*');
		symbols.add('+');
		symbols.add('#');
		symbols.add('$');
		symbols.add('/');
		symbols.add('@');
		symbols.add('!');
		symbols.add('%');
		symbols.add('=');
		symbols.add('-');
		symbols.add('&');

		// To go backwards and forwards in case of vertical adjacency.
		List<String> lines = new ArrayList<>();

		int current = 1;

		// Read file from list instead.
		while (scan.hasNextLine()) {
			lines.add(scan.nextLine());
		}

		while (current < lines.size()) {

			System.out.println(">>>>>>>>>>> " + (current + 1));

			System.err.println(lines.get(current - 1).toString());
			System.err.println(lines.get(current).toString());
			if (current + 1 < lines.size()) {
				System.err.println(lines.get(current + 1).toString());

			}

			for (int i = 0; i < lines.getFirst().length(); i++) {

				if (symbols.contains(lines.get(current).charAt(i))) {

					System.err.println("Found: " + lines.get(current).charAt(i));

					// Number to the left.
					if (Character.isDigit(lines.get(current).charAt(i - 1))) {
						String number = lines.get(current).substring(i - 3, i);

						number = number.replaceAll("\\D", "");

						sum += Integer.parseInt(number);

						System.err.println("Found Left: " + number);
					}

					// Number to the right.
					if (Character.isDigit(lines.get(current).charAt(i + 1))) {
						String number = lines.get(current).substring(i, i + 4);

						number = number.replaceAll("\\D", "");

						sum += Integer.parseInt(number);

						System.err.println("Found Right: " + number);
					}

					// Number Directly above.
					if (Character.isDigit(lines.get(current - 1).charAt(i))) {
						String number = "";

						if (lines.get(current - 1).charAt(i + 1) == '.' &&
								lines.get(current - 1).charAt(i - 1) == '.') {
							number = lines.get(current - 1).substring(i - 1, i + 1);
						} else if (lines.get(current - 1).charAt(i + 1) == '.') {
							number = lines.get(current - 1).substring(i - 3, i + 1);

						} else if (lines.get(current - 1).charAt(i - 1) == '.') {
							number = lines.get(current - 1).substring(i, i + 3);

						} else {
							number = lines.get(current - 1).substring(i - 1, i + 2);
						}

						number = number.replaceAll("\\D", "");

						sum += Integer.parseInt(number);

						System.err.println("Found Top: " + number);
					}

					// Number Top Diagonal left.
					if (Character.isDigit(lines.get(current - 1).charAt(i - 1))
							&& lines.get(current - 1).charAt(i) == '.') {
						String number = lines.get(current - 1).substring(i - 3, i);

						number = number.replaceAll("\\D", "");

						sum += Integer.parseInt(number);

						System.err.println("Found Diagonal Top Left: " + number);
					}

					// Number Top Diagonal right.
					if (Character.isDigit(lines.get(current - 1).charAt(i + 1))
							&& lines.get(current - 1).charAt(i) == '.') {
						String number = lines.get(current - 1).substring(i, i + 4);

						number = number.replaceAll("\\D", "");

						sum += Integer.parseInt(number);

						System.err.println("Found Diagonal Top Right: " + number);
					}

					// Number Directly below.
					if (Character.isDigit(lines.get(current + 1).charAt(i))) {

						String number = "";

						if (lines.get(current + 1).charAt(i + 1) == '.' &&
								lines.get(current + 1).charAt(i - 1) == '.') {
							number = lines.get(current + 1).substring(i - 1, i + 1);
						} else if (lines.get(current + 1).charAt(i + 1) == '.') {
							number = lines.get(current + 1).substring(i - 3, i + 1);
						} else if (lines.get(current + 1).charAt(i - 1) == '.') {
							number = lines.get(current + 1).substring(i, i + 3);
						} else {
							number = lines.get(current + 1).substring(i - 1, i + 2);
						}

						number = number.replaceAll("\\D", "");

						sum += Integer.parseInt(number);

						System.err.println("Found Bottom: " + number);
					}

					// Number Bottom Diagonal left.
					if (Character.isDigit(lines.get(current + 1).charAt(i - 1))
							&& lines.get(current + 1).charAt(i) == '.') {
						String number = lines.get(current + 1).substring(i - 3, i);

						number = number.replaceAll("\\D", "");

						sum += Integer.parseInt(number);

						System.err.println("Found Diagonal Bottom Left: " + number);
					}

					// Number Bottom Diagonal right.
					if (Character.isDigit(lines.get(current + 1).charAt(i + 1))
							&& lines.get(current + 1).charAt(i) == '.') {
						String number = lines.get(current + 1).substring(i, i + 4);

						number = number.replaceAll("\\D", "");

						sum += Integer.parseInt(number);

						System.err.println("Found Diagonal Bottom Right: " + number);
					}
				}
			}

			System.out.println("Current Sum: " + sum);

			current++;
		}

		scan.close();

		return sum;
	}

}
