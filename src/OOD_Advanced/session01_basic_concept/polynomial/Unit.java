package OOD_Advanced.session01_basic_concept.polynomial;

public class Unit {
	
	double coefficient;
	double exponent;
	
	public double eval(int x) {
		// return (long) (coefficient) * Math.pow(x, exponent);
		return coefficient * Math.pow(x, exponent);
	}
}
