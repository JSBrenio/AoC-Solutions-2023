
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem: Trebuchet, sum all first and last digits from input.
 * 
 * @author Jeremiah
 * 
 * @version 1.0
 * 
 */
public class EasyTrebuchet {

	private EasyTrebuchet() {
		throw new IllegalStateException();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String file = "AoC_Solutions\\AoC_Day1\\files\\input.txt";

		int result = solve(file);

		System.out.print(result);
	}

	private static int solve(String theFile) {

		int sum = 0;

		int counter = 0;

		File file = new File(theFile);

		List<Character> list = new ArrayList<>();

		try {
			Scanner scan = new Scanner(file);

			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				for (char c : line.toCharArray()) {
					if (Character.isDigit(c)) {
						System.err.println(c);
						list.add(c);
					}
				}

				System.err.println("First: " + list.getFirst());
				System.err.println("Last: " + list.getLast());

				String calibration = "" + list.getFirst() + list.getLast();
				System.err.println("Line " + counter++ + ": " + calibration);
				sum += Integer.parseInt(calibration);
				list.clear();
			}
			scan.close();

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return sum;
	}

}
