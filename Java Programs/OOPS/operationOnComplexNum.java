package OOPS;

class ComplexNumber {
    
    float real, imaginary;
    
    ComplexNumber(float r, float i) {
        this.real = r;
        this.imaginary = i;
    }
    
    public ComplexNumber add(ComplexNumber x) {
        float r = this.real + x.real;
        float i = this.imaginary + x.imaginary;
        ComplexNumber sum = new ComplexNumber(r, i);
        return sum;
    }
    
    public ComplexNumber subtract(ComplexNumber x) {
        float r = this.real - x.real;
        float i = this.imaginary - x.imaginary;
        ComplexNumber diff = new ComplexNumber(r, i);
        return diff;
    }
    
    public ComplexNumber multiply(ComplexNumber x) {
        // (a + bi)(c + di) = (ac - bd) + (ad + bc)i
        float r = this.real * x.real - this.imaginary * x.imaginary;
        float i = this.real * x.imaginary + this.imaginary * x.real;
        ComplexNumber prod = new ComplexNumber(r, i);
        return prod;
    }
    
    public ComplexNumber divide(ComplexNumber x) {
        // To divide two complex numbers, multiply by the conjugate of the denominator
        // (a + bi) / (c + di) = [(ac + bd) + (bc - ad)i] / (c^2 + d^2)
        float denominator = x.real * x.real + x.imaginary * x.imaginary;
        float r = (this.real * x.real + this.imaginary * x.imaginary) / denominator;
        float i = (this.imaginary * x.real - this.real * x.imaginary) / denominator;
        ComplexNumber res = new ComplexNumber(r, i);
        return res;
    }
    
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}

public class operationOnComplexNum {
    
    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(10, 5);
        ComplexNumber b = new ComplexNumber(2, 3);
        
        ComplexNumber c1 = a.add(b);
        ComplexNumber c2 = a.subtract(b);
        ComplexNumber c3 = a.multiply(b);
        ComplexNumber c4 = a.divide(b);
        
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a + b = " + c1);
        System.out.println("a - b = " + c2);
        System.out.println("a * b = " + c3);
        System.out.println("a / b = " + c4);
    }
}
