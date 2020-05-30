/*
 * Class that represents a polynomial term
 */

public class Term {
	private int coef, exp;
	
	public Term(int c, int e) {
		coef=c;
		exp=e;
	}
	
	// Gets sign of Term coefficient
	public String getSign() {
		if(coef < 0)
			return "-";
		else
			return "+";
	}
	
	// Gets Term coefficient
	public int getCoef() {
		return coef;
	}
	
	// Gets Term exponent
	public int getExp() {
		return exp;
	}
	
	// Returns true if Term's exponent is equal to the given int
	public boolean hasExp(int e) {
		return exp == e;
	}

	// Displays String representation of Term object
	public void Print() {
		int temp = Math.abs(coef);
		if(temp == 0) {}
		else if(exp == 0)
			System.out.printf("%d ", temp);
		else if(exp == 1)
			if(temp == 1)
				System.out.print("x ");
			else
				System.out.printf("%dx ", temp);
		else
			if(temp == 1)
				System.out.printf("x^%d ", exp);
			else
				System.out.printf("%dx^%d ", temp, exp);
	}

	// Returns String representation of Term object
	public String toString() {
		int temp = Math.abs(coef);
		if(temp == 0)
			return "";
		else if(exp == 0)
			return temp+" ";
		else if(exp == 1)
			if(temp == 1)
				return "x ";
			else
				return temp+"x ";
		else
			if(temp == 1)
				return "x^"+exp+" ";
			else
				return temp+"x^"+exp+" ";
	}
}
