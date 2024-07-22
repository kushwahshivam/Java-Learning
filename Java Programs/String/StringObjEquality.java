package String;

public class StringObjEquality {
    public static void checkStringObjEquality(String s1, String s2) {
        if (s1 == s2) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
    
    public static void checkStringContentEquality(String s1, String s2) {
        if (s1.equals(s2)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
    
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = "cba";
        
        checkStringObjEquality(s1, s2); // Outputs: Equal
        checkStringObjEquality(s1, s3); // Outputs: Not Equal (since s1 and s3 are different objects)
        
        checkStringContentEquality(s1, s2); // Outputs: Equal
        checkStringContentEquality(s1, s3); // Outputs: Equal (since s1 and s3 have the same content)
        checkStringContentEquality(s1, s4); // Outputs: Not Equal
    }
}
