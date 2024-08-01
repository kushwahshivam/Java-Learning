class Fraction {
    int numerator, denominator;
		
    // Constructor
    Fraction(int n, int d) {
        this.numerator = n;
        this.denominator = d;
    }	
		
    // Method to add fractions
    Fraction add(Fraction a) {
        int den = a.denominator * this.denominator;
        int num = (this.numerator * a.denominator) + (a.numerator * this.denominator);
        Fraction sum = new Fraction(num, den);
        return sum;
    }
		
    // Method to subtract fractions
    Fraction subtract(Fraction a) {
        int den = a.denominator * this.denominator;
        int num = (this.numerator * a.denominator) - (a.numerator * this.denominator);
        Fraction diff = new Fraction(num, den);
        return diff;
    }
		
    // Method to multiply fractions
    Fraction multiply(Fraction a) {
        int num = this.numerator * a.numerator;
        int den = this.denominator * a.denominator;
        Fraction prod = new Fraction(num, den);
        return prod;
    }
    
    // Method to simplify the fraction (not implemented here for brevity)
    // You may want to add a method to simplify fractions if needed
    
    // Method to display the fraction
    public String toString() {
        return numerator + "/" + denominator;
    }
}

public class FractionOperations {
    public static void main(String[] args) {
        Fraction x = new Fraction(2, 3);
        Fraction y = new Fraction(4, 5);
        
        Fraction z1 = x.add(y);
        Fraction z2 = x.subtract(y);
        Fraction z3 = x.multiply(y);
        
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("x + y = " + z1);
        System.out.println("x - y = " + z2);
        System.out.println("x * y = " + z3);
    }
}
