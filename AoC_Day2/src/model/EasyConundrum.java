
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
public class EasyConundrum {

	/**
	 * prevents external instantiation.
	 */
	private EasyConundrum() {
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

		final Map<String, Integer> map = new HashMap<>();

		// 12 red cubes, 13 green cubes, and 14 blue cubes.
		map.put("red", 12);
		map.put("green", 13);
		map.put("blue", 14);
		
		
		final Map<String, Integer> emptyMap = new HashMap<>();
		
		// for each sub game
		emptyMap.put("red", 0);
		emptyMap.put("green", 0);
		emptyMap.put("blue", 0);

		final int maxSum = 39;

		int sum = 0;

		File file = new File(theFile);

		Scanner scan = new Scanner(file);

		int gameID = 1;

		while (scan.hasNextLine()) {

			String line = scan.nextLine();

			Scanner lineScanner = new Scanner(line);

			Map<String, Integer> currentMap = new HashMap<>(emptyMap);
			
			Map<Map<String, Integer>, Boolean> setMaps = new HashMap<>();
			
			lineScanner.next().replaceAll("[,;:]", "");
			
			lineScanner.next(); // skip "Game"

			System.out.println("GameID: " + gameID);

			while (lineScanner.hasNext()) {
				
				int count = lineScanner.nextInt();
				
				System.err.println(count);
				
				String str = lineScanner.next();
				
				String currentStr = "";
				
				if (str.charAt(str.length() - 1) == ',' || str.charAt(str.length() - 1) == ';') {
					currentStr = str.substring(0, str.length() - 1);
					currentMap.put(currentStr, count);
				}
				
				System.err.println(currentStr);
				
				if (str.charAt(str.length() - 1) == ';' || !lineScanner.hasNext()) {
					System.err.println(">>>");
					if (str.charAt(str.length() - 1) == ';') {
						currentStr = str.substring(0, str.length() - 1);
					} else {
						currentStr = str;
					}
					currentMap.put(currentStr, count);

					int tempSum = 0;
					// Sums all integers in map.
					tempSum = currentMap.values().stream().mapToInt(Integer::intValue).sum();
					
					System.err.println("SUM: " + tempSum + " vs. " + maxSum);
					System.err.println("RED: " + map.get("red") + " vs. " + currentMap.get("red"));
					System.err.println("GREEN: " + map.get("green") + " vs. " + currentMap.get("green"));
					System.err.println("BLUE: " + map.get("blue") + " vs. " + currentMap.get("blue"));

					if (tempSum < maxSum) {
						setMaps.put(currentMap, true);
					}
					
					if ((map.get("red") >= currentMap.get("red") &&
							map.get("green") >= currentMap.get("green") &&
							map.get("blue") >= currentMap.get("blue"))) {
						setMaps.put(currentMap, true);
					} else {
						setMaps.put(currentMap, false);
						System.err.println(gameID + " Is not Possible.");
					}
					

					
					currentMap = new HashMap<>(emptyMap);
					
				}


			}
			
			System.err.println(setMaps.toString());
			
			if (setMaps.values().stream().allMatch(Boolean::valueOf)) {

				System.err.println(gameID + " Is Possible.");
				sum += gameID;
				System.err.println("Sum: " + sum);

			}
			
			gameID++;

			lineScanner.close();
		}

		scan.close();

		return sum;
	}

}
