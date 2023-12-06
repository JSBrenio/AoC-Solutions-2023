
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
public class HardConundrum {

	/**
	 * prevents external instantiation.
	 */
	private HardConundrum() {
		throw new IllegalStateException();
	}

	/**
	 * Runs solution.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		String file = "AoC_Solutions\\AoC_Day2\\files\\input.txt";

		int result = solve(file);

		System.out.print(result);
	}

	private static int solve(String theFile) throws FileNotFoundException {

		int sum = 0;

		File file = new File(theFile);

		Scanner scan = new Scanner(file);

		while (scan.hasNextLine()) {
			String line = scan.nextLine();
		}

		scan.close();

		return sum;
	}

}
