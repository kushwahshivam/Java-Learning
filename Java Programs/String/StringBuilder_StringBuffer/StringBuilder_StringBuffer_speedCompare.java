public class StringBuilder_StringBuffer_speedCompare {

    public static void main(String[] args) {
      long startTime = System.currentTimeMillis();
  
      StringBuffer temp1 = new StringBuffer("InterviewBit");
      for (int i = 0; i < 1000000; i++) {
        temp1.append("abcd");
      }
  
      System.out.println(
        "Time taken by StringBuffer Class for updation: " +
        (System.currentTimeMillis() - startTime) +
        "ms"
      );
  
      startTime = System.currentTimeMillis();
      StringBuilder temp2 = new StringBuilder("InterviewBit");
      for (int i = 0; i < 1000000; i++) {
        temp2.append("abcd");
      }
      
      System.out.println(
        "Time taken by StringBuilder Class for updation: " +
        (System.currentTimeMillis() - startTime) +
        "ms"
      );
    }
  }
  