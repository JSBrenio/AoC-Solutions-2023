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
	
	private HardTrebuchet() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String file = "files/input4.txt";
		
		int result = solve(file);
		
		System.out.print(result);
	}
	
	private static int solve(String theFile) {
		
		Map<String, Character> map = createMap();
		
		int sum = 0;
		
		int counter = 0;
		
		File file = new File(theFile);
				
		List<Character> list = new ArrayList<>();
		
		try {
			Scanner scan = new Scanner(file);
			
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				for (int i = 0; i < line.length(); i++) {
					for (int j = i + 1; j <= line.length(); j++) {
		                String subline = line.substring(i, j);
		                if (Character.isDigit(subline.charAt(0))) {
		                	String str = subline.substring(0,1);
		                	char c = str.charAt(0);
		                	list.add(c);
		                }
		                else if (map.containsKey(subline)) {
		                	list.add(map.get(subline));
		                }
					}
				}
				
				System.err.println(list.toString());

				System.err.println("First: " + list.getFirst());
				System.err.println("Last: " + list.getLast());

				String calibration = "" + list.getFirst() + list.getLast();
				System.err.println("Line " + counter++ + ": " + calibration);
				sum += Integer.parseInt(calibration);
				list.clear();
			}
			
			scan.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return sum;
	}
	
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
