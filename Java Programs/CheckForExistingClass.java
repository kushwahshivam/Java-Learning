public class CheckForExistingClass {
    class HelloWorld {
        public static void main(String[] args) {
            
            try {
                // Correct method and class name usage
                Class<?> clazz = Class.forName("CheckForExistingClass");
                System.out.println(clazz.getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
