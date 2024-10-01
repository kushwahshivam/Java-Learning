/**
 * Varargs - Variable Number of Arguments
 */
public class Varargs {

    // Method to sum a variable number of integers
    private static int Sum(int ...args) {
        int total = 0; // Variable to hold the sum
        for (int num : args) { // Iterate through each argument
            total += num; // Add each number to the total
        }
        return total; // Return the total sum
    }

    public static void main(String[] args) {
        // Example usage of the Sum method
        int sum1 = Sum(1, 2, 3);
        int sum2 = Sum(10, 20, 30, 40, 50);
        int sum3 = Sum(); // No arguments, should return 0

        // Print the results
        System.out.println("Sum 1: " + sum1); // Output: Sum 1: 6
        System.out.println("Sum 2: " + sum2); // Output: Sum 2: 150
        System.out.println("Sum 3: " + sum3); // Output: Sum 3: 0
    }
}
