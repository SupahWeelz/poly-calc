/*
 * Class that handles the mathematical operations on polynomials
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class Calculator {
	
	// Returns the results of applying the chain rule to the term parameter
	public static Term chainRule(Term t) {
		int exp = t.getExp();
		int coef = t.getCoef();
		//System.out.printf("Before: Coef: %d Exp: %d\n", coef, exp);
		if(exp == 0)
			coef = 0;
		else {
			coef *= exp;
			exp-=1;
		}
		//System.out.printf("After : Coef: %d Exp: %d\n", coef, exp);
		return new Term(coef,exp);
	}

	// Returns the product of two terms
	public static Term multiply(Term a, Term b) {
		return new Term(a.getCoef()*b.getCoef(),a.getExp()+b.getExp());
	}
	
	// Returns sum of two Polynomial objects
	public static Polynomial add(Polynomial a, Polynomial b) {
		if(a.getArr().size() == 0)
 			return b;
 		if(b.getArr().size() == 0)
 			return a;

		int aSize = a.getArr().size();
		int bSize = b.getArr().size();
		
		// Get smaller list, and add zeros to the front until it's the same length as the longer list
		int diff = Math.abs(a.getArr().size() - b.getArr().size());
		
		if(aSize < bSize)
			for(int i = 0; i < diff; i++) 
				a.getArr().add(0,0);
		else if(aSize > bSize)
			for(int i = 0; i < diff; i++)
				b.getArr().add(0,0);
		
		ArrayList<Integer> ret = new ArrayList<Integer>();
		
		// Adds each term together
		for(int i = 0; i < aSize; i++)
			ret.add(a.getArr().get(i) + b.getArr().get(i));
		
		
		return new Polynomial(ret);
	}

	// Returns difference of two Polynomial objects, a - b
	public static Polynomial subtract(Polynomial a, Polynomial b) {
		if(a.getArr().size() == 0)
 			return b;
 		if(b.getArr().size() == 0)
 			return a;

		int aSize = a.getArr().size();
		int bSize = b.getArr().size();
		
		// Get smaller list, and add zeros to the front until it's the same length as the longer list
		int diff = Math.abs(a.getArr().size() - b.getArr().size());
		
		if(aSize < bSize)
			for(int i = 0; i < diff; i++) 
				a.getArr().add(0,0);
		else if(aSize > bSize)
			for(int i = 0; i < diff; i++)
				b.getArr().add(0,0);
		
		ArrayList<Integer> ret = new ArrayList<Integer>();
		
		// Subtract terms
		for(int i = 0; i < aSize; i++)
			ret.add(a.getArr().get(i) - b.getArr().get(i));
		
		
		return new Polynomial(ret);
	}

	// Returns product of two Polynomial objects
	public static Polynomial multiply(Polynomial a, Polynomial b) {
		
		LinkedList<Term> ret = new LinkedList<Term>();
		
		// Applies distributive property
		for(int i = 0; i < a.getList().size();i++)
			for(int j = 0; j < b.getList().size();j++) {
				Term term = multiply(a.getList().get(i), b.getList().get(j));
				ret.add(term);
			}
		
		// Compiles terms into an ArrayList
		ArrayList<Term> fin = new ArrayList<Term>();
		for(int i = 0; i < ret.size(); i++) {
			Term term = ret.get(i);
			fin.add(term);
		}
		
		int exp = fin.get(0).getExp();
		ArrayList<Integer> coefs = new ArrayList<Integer>();
		
		// Outer loop executes number of times equal to the degree
		// of the polynomial + 1, while inner loop scans the ArrayList
		// for terms of degree i, summing the coefficients of those terms
		for(int i = exp; i >= 0; i--) {
			int sum = 0;
			for(int j = 0; j < fin.size();j++){
				if(fin.get(j).getExp() == i) {
					sum+=fin.get(j).getCoef();
				}
			}
			coefs.add(sum);
		}
		return new Polynomial(coefs);
	}

	// Returns derivative of the given polynomial
	public static Polynomial differentiate(Polynomial a) {
		LinkedList<Term> poly = new LinkedList<Term>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		for(int i = 0; i < a.getList().size(); i++) {
			int exp = a.getList().get(i).getExp();
			int coef = a.getList().get(i).getCoef();
			//System.out.println("Exp: "+exp+" Coef: "+coef);
			Term t = chainRule(new Term(coef, exp));
			poly.add(t);
		}
		
		for(int i = 0; i < poly.size(); i++)
			temp.add(poly.get(i).getCoef());
		
		return new Polynomial(temp);
	}
}