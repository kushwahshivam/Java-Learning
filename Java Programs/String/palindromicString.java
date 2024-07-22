package String;
import java.util.Scanner;

public class palindromicString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String rev = sb.toString();
        // check palindrome
        if(str.equals(rev)){
            System.out.println("String is palindrome");
        }
        else{
            System.out.println("String is not palindrome");
        }
        sc.close();
    }
}
