
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem: Trebuchet, sum all first and last worded numbers from input.
 * 
 * @author Jeremiah
 * 
 * @version 1.0
 * 
 */
public class HardTrebuchet {

	/**
	 * prevents external instantiation.
	 */
	private HardTrebuchet() {
		throw new IllegalStateException();
	}

	/**
	 * Runs solution.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		String file = "AoC_Solutions\\AoC_Day1\\files\\input4.txt";

		int result = solve(file);

		System.out.print(result);
	}

	/**
	 * Iterates through file and sums up digits and worded numbers.
	 * 
	 * @param theFile
	 * @return int - sum of all digits and worded numbers.
	 * @throws FileNotFoundException
	 */
	private static int solve(String theFile) throws FileNotFoundException {

		Map<String, Character> map = createMap();

		int sum = 0;

		File file = new File(theFile);

		// Keep track of digits.
		List<Character> list = new ArrayList<>();

		Scanner scan = new Scanner(file);

		while (scan.hasNextLine()) {

			String line = scan.nextLine();

			// Find string powerset of each line and convert to digits.
			for (int i = 0; i < line.length(); i++) {

				for (int j = i + 1; j <= line.length(); j++) {

					String subline = line.substring(i, j);

					if (Character.isDigit(subline.charAt(0))) {
						list.add(subline.charAt(0));
					}
					else if (map.containsKey(subline)) {
						list.add(map.get(subline));
					}

				}

			}

			// Concatenate the two digits.
			String calibration = "" + list.getFirst() + list.getLast();
			sum += Integer.parseInt(calibration);
			list.clear();
		}

		scan.close();
		return sum;
	}

	/**
	 * Creates a HashMap dictionary.
	 * 
	 * @return HashMap<String, Character>
	 */
	private static HashMap<String, Character> createMap() {

		Map<String, Character> wordedDigitsMap = new HashMap<>();

		wordedDigitsMap.put("one", '1');
		wordedDigitsMap.put("two", '2');
		wordedDigitsMap.put("three", '3');
		wordedDigitsMap.put("four", '4');
		wordedDigitsMap.put("five", '5');
		wordedDigitsMap.put("six", '6');
		wordedDigitsMap.put("seven", '7');
		wordedDigitsMap.put("eight", '8');
		wordedDigitsMap.put("nine", '9');

		return (HashMap<String, Character>) wordedDigitsMap;
	}

}
