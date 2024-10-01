import java.math.BigInteger;

class ComputeFactorial{
    public static void main(String[] args) {
        // Given N, Compute its factorial
        // int x = 5;
        int x = 500;
        // int ans = 1;
        BigInteger ans = new BigInteger("1");
        for(int i=1;i<=x;i++){
            BigInteger temp = new BigInteger(i+"");
            ans = ans.multiply(temp);
        }
        System.out.println(ans);
    }
}