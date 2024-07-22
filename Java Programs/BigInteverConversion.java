import java.math.BigInteger;
public class BigInteverConversion {
    public static void main(String[] args) {
        int x = 50;
        BigInteger b = new BigInteger(x+"");
     System.out.println(b);  
     
     
BigInteger b2 = new BigInteger("9823");
int y = b2.intValue();
System.out.println(y);


long z = b2.longValue();
System.out.println(z);

    }
}
