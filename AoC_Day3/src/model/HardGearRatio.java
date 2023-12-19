
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem: Conundrum, sum all possible GameIDs given sets of games.
 * 
 * @author Jeremiah
 * 
 * @version 1.0
 * 
 */
public class HardGearRatio {

	/**
	 * prevents external instantiation.
	 */
	private HardGearRatio() {
		throw new IllegalStateException();
	}

	/**
	 * Runs solution.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		String file = "files\\input2.txt";

		int result = solve(file);

		System.out.print(result);
	}

	private static int solve(String theFile) throws FileNotFoundException {
		
		int sum = 0;

		File file = new File(theFile);

		Scanner scan = new Scanner(file);

		int gameID = 1;

		while (scan.hasNextLine()) {

			String line = scan.nextLine();

			Scanner lineScanner = new Scanner(line);
			
			final Map<String, Integer> currentMap = new HashMap<>();
			
			currentMap.put("red", 0);
			currentMap.put("green", 0);
			currentMap.put("blue", 0);
			
			lineScanner.next().replaceAll("[,;:]", "");
			
			lineScanner.next(); // skip "Game"

			System.err.println("GameID: " + gameID);

			while (lineScanner.hasNext()) {
				
				int count = lineScanner.nextInt();
				
				System.err.println(count);
				
				String str = lineScanner.next();
				
				String currentStr = "";
				
				if (str.charAt(str.length() - 1) == ',' || str.charAt(str.length() - 1) == ';') {
					currentStr = str.substring(0, str.length() - 1);
					currentMap.put(currentStr, Math.max(currentMap.get(currentStr), count));
				}
				
				System.err.println(currentStr);
				
				if (str.charAt(str.length() - 1) == ';' || !lineScanner.hasNext()) {
					System.err.println(">>>");
					if (str.charAt(str.length() - 1) == ';') {
						currentStr = str.substring(0, str.length() - 1);
					} else {
						currentStr = str;
					}
					currentMap.put(currentStr, Math.max(currentMap.get(currentStr), count));
				}

			}
			
			System.err.println(currentMap.toString());
			
			int tempSum = (int) currentMap.values().stream()
	                .mapToLong(Integer::intValue)
	                .reduce(1, (a, b) -> a * b);
			
			System.err.println("Power Sum: " + tempSum);
			
			sum += tempSum;
			
			System.out.println("Running Sum: " + sum);
			
			gameID++;

			lineScanner.close();
		}

		scan.close();

		return sum;
	}

}
