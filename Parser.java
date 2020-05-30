/*
 * Class that handles parsing of polynomials
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Parser {
	
	// Converts polynomial of the form (c1, c2, c3, ..., cn), where c is a coefficient,
	// to an ArrayList of Integers where each Integer is a coefficient
	public static ArrayList<Integer> convert(String s) throws Exception{
		
		// Removes parentheses from input string
		s = s.substring(1, s.length() - 1);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(s);
		
		// Sets comma "," as the delimiter
		scan.useDelimiter("\\s*,\\s*");
		
		// Stores coefficients into an ArrayList
		while(scan.hasNext())
			temp.add(scan.nextInt());
		return temp;
	}
}