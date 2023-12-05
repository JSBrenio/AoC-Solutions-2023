
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
public class EasyConundrum {

	private EasyConundrum() {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String file = "AoC_Solutions\\AoC_Day2\\files\\input.txt";

		int result = solve(file);

		System.out.print(result);
	}

	private static int solve(String theFile) {

		int sum = 0;

		File file = new File(theFile);

		try {
			Scanner scan = new Scanner(file);

			while (scan.hasNextLine()) {
				String line = scan.nextLine();

			}
			scan.close();

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return sum;
	}

}
