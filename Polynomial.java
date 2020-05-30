/*
 * Class that represents a polynomial
 * 	-Stores polynomial as both an array of integers and a list of Term objects
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class Polynomial {
	ArrayList<Integer> polyArr = new ArrayList<Integer>();
	LinkedList<Term> polyList = new LinkedList<Term>();
	
	public Polynomial(ArrayList<Integer> p) {
		polyArr = p;
		int exp = p.size()-1;
		for(int i = 0; i < p.size(); i++){
			if(p.get(i) != 0)
				polyList.add(new Term(p.get(i),exp));
			exp--;
		}
		if(polyList.size() == 0) {
			polyList.add(new Term(0,0));
		}
	}
	
	public void print() {
		if(polyList.size() == 0) {
			System.out.println(0);
			return;
		}
		for(int i = 0; i < polyList.size(); i++) {
			Term temp = polyList.get(i);
			String sign = temp.getSign();
			if(sign.equals("-") && i == 0)
				System.out.print(sign);
			if(i != 0)
				System.out.print(temp.getSign()+" ");
			temp.Print();
		}
		System.out.println();
	}

	public ArrayList<Integer> getArr(){
		return new ArrayList<Integer>(polyArr);
	}
	
	public LinkedList<Term> getList(){
		return new LinkedList<Term>(polyList);
	}
}