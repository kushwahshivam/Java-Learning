public class Thread_01 {

    // Shared counter
    private static int counter = 0;

    // Synchronize access to the counter
    private static synchronized void incrementCounter() {
        counter++;
    }

    // Worker class that extends Thread
    static class CounterWorker extends Thread {
        private final int numIncrements;

        public CounterWorker(int numIncrements) {
            this.numIncrements = numIncrements;
        }

        @Override
        public void run() {
            for (int i = 0; i < numIncrements; i++) {
                incrementCounter();
            }
            System.out.println("Thread " + Thread.currentThread().getId() + " finished.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Number of threads and increments per thread
        int numThreads = 5;
        int incrementsPerThread = 1000;

        // Create and start threads
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new CounterWorker(incrementsPerThread);
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        // Print the final counter value
        System.out.println("Final counter value: " + counter);
    }
}
