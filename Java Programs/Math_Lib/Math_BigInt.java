import java.math.BigInteger;

public class Math_BigInt {
    public static void main(String[] args) {
        // // BigInteger class is used to store and work wih large integers
        // long x  =(long)Math.pow(10,20);
        // System.out.println(x);


        BigInteger a = new BigInteger("523456789098765432345676543");
        BigInteger b = new BigInteger("10567894356765432345678765432456");

        System.out.println(a);
        System.out.println(b);


        // BigInteger c = a.add(b);
        BigInteger c = a.subtract(b);
        System.out.println(c);



        BigInteger x = new BigInteger("123");
        BigInteger y = new BigInteger("2");


        System.out.println(x.multiply(y));
        System.out.println(x.divide(y));


        BigInteger z = x.pow(20);
        System.out.println(z);


        System.out.println(x.mod(y));
    }
}
