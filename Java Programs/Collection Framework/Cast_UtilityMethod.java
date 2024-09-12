// Example Usage
// Here’s an example of how you might use this method:

public class Cast_UtilityMethod {
    public static void main(String[] args) {
        Object obj = "Hello, world!";
        
        // Using the cast method to cast the Object to String
        String str = cast(obj);
        
        System.out.println(str);  // Output: Hello, world!
        System.out.println(str.hashCode());
        System.out.println(obj.hashCode());
    }

    public static <V> V cast(Object object) {
        return (V) object;
    }
}

// In this example, cast is used to cast an Object of type String to a String.

// Important Considerations
// Unchecked Warning: Since this is an unchecked cast, the Java compiler will likely generate an unchecked cast warning. This is because the compiler cannot verify that the cast is safe at runtime.
// ClassCastException: If you use this method and the actual type of object is not compatible with V, a ClassCastException will be thrown at runtime. For example, casting an Integer to a String will result in a ClassCastException.
// Conclusion
// The cast method is a generic utility that performs unchecked type casting. It allows for flexible type casting, but you should use it with caution due to the potential for runtime exceptions if the cast is not valid.