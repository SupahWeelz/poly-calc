/*
 * Class that houses the main function
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		//while (true) {
		System.out.println("Polynomial calculator");
		System.out.println("	Polynomial 	format:	(coef_n, coef_n-1, ..., coef_1, coef_0)");
		System.out.println("	Unary  operator format: d Polynomial");
		System.out.println("	Binary operator format: Polynomial op Polynomial");
		
		String query = scan.nextLine();
		String trimmed = query.replaceAll(" ", "");
		String poly1 = "";
		String poly2 = "";
		
		if(trimmed.contains("d")) {
			poly1 = trimmed.substring(1,trimmed.length());
			Polynomial p = new Polynomial(Parser.convert(poly1));
			Calculator.differentiate(p).print();
		}
		else {
			if(query.contains(" - ")) {
				String op = " - ";
				poly1 = query.substring(0,query.indexOf(op));
				poly2 = query.substring(query.indexOf(op)+op.length(),query.length());
				Calculator.subtract(new Polynomial(Parser.convert(poly1)), new Polynomial(Parser.convert(poly2))).print();
			}
			else if(trimmed.contains("+")) {
				String op = "+";
				poly1 = trimmed.substring(0,trimmed.indexOf(op));
				poly2 = trimmed.substring(trimmed.indexOf(op)+op.length(),trimmed.length());
				Calculator.add(new Polynomial(Parser.convert(poly1)), new Polynomial(Parser.convert(poly2))).print();
			}
			else if(trimmed.contains("*")) {
				String op = "*";
				poly1 = trimmed.substring(0,trimmed.indexOf(op));
				poly2 = trimmed.substring(trimmed.indexOf(op)+op.length(),trimmed.length());
				Calculator.multiply(new Polynomial(Parser.convert(poly1)), new Polynomial(Parser.convert(poly2))).print();
			}
			else {
				System.out.println("Incorrect format!");
			}
		}
		
		
		System.out.println();
		//}
	}
}