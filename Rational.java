//Andrew Guo
//AP CS Period 9
//2013-11-18
//Period 9

public class Rational {
    
    /*========================
              Phase 1
    ========================*/

    //  Instance Variables  //
    private int numerator;
    private int denominator;
 
    //     Constructors     //
    public Rational() {
	numerator = 0;
	denominator = 1;
    }      
    public Rational (int newN, int newD) {
	this();
	if (newD == 0)
	    System.out.println("Invalid Denominator");
	else {
	    numerator = newN;	    
	    denominator = newD;
	}
    }

    //       toString       //
    public String toString() {
	return numerator + "/" + denominator;
    }

    public double floatValue() {
	return ((double)numerator) / denominator;
    }

    public void multiply(Rational ratio) {
	numerator *= ratio.numerator;
	denominator *= ratio.denominator;
    }

    public void divide(Rational ratio) {
	numerator *= ratio.denominator;
	denominator *= ratio.numerator;
    }

    /*========================
              Phase 2
    ========================*/
    public void add(Rational ratio) {
	numerator =(numerator*ratio.denominator) + (denominator*ratio.numerator);
	denominator = denominator * ratio.denominator;
    }

    public void subtract(Rational ratio) {
	numerator =(numerator*ratio.denominator) - (denominator*ratio.numerator);
	denominator = denominator * ratio.denominator;
    }

    public int gcd() {
	int a = numerator;
	int b = denominator;
	while ( (a % b ) != 0 ) {
	    int mod = a % b;
	    a = b;
	    b = mod;
	}
	return b;
    }

    public void reduce() {
	int gcd = gcd();
	numerator /= gcd;
	denominator /= gcd;
    }

    /*========================
              Phase 3
    ========================*/
    public static int gcd(int num, int dnm) {
	while ( (num % dnm ) != 0 ) {
	    int mod = num % dnm;
	    num = dnm;
	    dnm = mod;
	}
	return dnm;
    }

    /*
      compareTo: Returns a positive value if the calling rational number is greater than the parameter.
                 Returns a negative value if it is less than the parameter. Returns 0 if they are equal.
      Pre: the product of the denominators is positive. All negative fractions must have negative numerators
      and positive denomiators
    */
    public int compareTo (Rational ratio) {

	    return (numerator * ratio.denominator) - (denominator * ratio.numerator);
    }

    public static void main (String[] args) {
	Rational r = new Rational (1, 2);
	Rational s = new Rational (1, 3);
	Rational w = new Rational (2, 5);
	Rational t = new Rational (5, 10);
	Rational p = new Rational (-1, 4);
	Rational f = new Rational (2, 3);
	System.out.print("Attempted instantiation of q, 5/0:");
	Rational q = new Rational (5, 0);

	System.out.print("Value of q:");
	System.out.println(q);

	System.out.print("1/2 as a float:");
	System.out.println(r.floatValue());

	System.out.print("-1/4 as a float:");
	System.out.println(p.floatValue());

	r.multiply(s);
	System.out.print("1/2 times 1/3:");
	System.out.println(r);

	w.multiply(f);
	System.out.print("2/5 times 2/3:");
	System.out.println(w);

	t.add(p);
	System.out.print("5/10 plus -1/4:");
	System.out.println(t);

	t.reduce();
	System.out.print("10/40 reduced:");
	System.out.println(t);

	System.out.print("Greatest common divisor of 32 and 20:");
	System.out.println(gcd(32, 20));
    }
}
