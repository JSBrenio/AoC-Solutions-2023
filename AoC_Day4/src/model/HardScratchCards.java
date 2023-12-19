
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem: ScratchCards, sum all winning card hands given sets of card games.
 * 
 * @author Jeremiah
 * 
 * @version 1.0
 * 
 */
public class HardScratchCards {

	/**
	 * prevents external instantiation.
	 */
	private HardScratchCards() {
		throw new IllegalStateException();
	}

	/**
	 * Runs solution.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		String file = "AoC_Solutions\\AoC_Day4\\files\\input2.txt";

		int result = solve(file);

		System.out.print(result);
	}

	private static int solve(String theFile) throws FileNotFoundException {

		int sum = 0;

		File file = new File(theFile);

		Scanner scan = new Scanner(file);
		Scanner scan2 = new Scanner(file);

		Map<Integer, Integer> copies = new HashMap<>();

		int count = 1;
		while (scan2.hasNextLine()) {
			scan2.nextLine();
			copies.put(count, 1);
			count++;
		}

		while (scan.hasNextLine()) {

			String line = scan.nextLine();

			line = line.replaceAll("[Card:]", "");

			Scanner lineScanner = new Scanner(line);

			int cardID = lineScanner.nextInt();

			List<Integer> cardNum = createArr(lineScanner);
			// System.err.println(cardNum.toString());
			lineScanner.next(); // skip pipe '|'
			List<Integer> winNum = createArr(lineScanner);
			// System.err.println(winNum.toString());

			System.out.println(cardID + ": " + cardNum.toString() + winNum.toString());

			int points = 0;

			for (int i = 0; i < cardNum.size(); i++) {
				for (int j = 0; j < winNum.size(); j++) {
					if (cardNum.get(i) == winNum.get(j)) {
						System.err.println("Winning Number: " + cardNum.get(i) + " And " + winNum.get(j));
						points++;
					}
				}
			}

			System.out.println(cardID + ": " + points);

			for (int i = 0; i < copies.get(cardID); i++) {

				for (int j = 0; j < points; j++) {

					copies.put(j + cardID + 1, copies.get(j + cardID + 1) + 1);
				}
			}

			sum += copies.get(cardID);

			lineScanner.close();

		}

		scan.close();

		return sum;
	}

	private static ArrayList<Integer> createArr(Scanner scan) {
		List<Integer> list = new ArrayList<Integer>();
		while (scan.hasNextInt()) {
			list.add(scan.nextInt());
		}
		return (ArrayList<Integer>) list;
	}

}
