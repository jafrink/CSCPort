public class ConcurrencyProject {

    // Thread that counts up
    static class CountUp extends Thread {

        public void run() {
            for (int i = 1; i <= 20; i++) {
                System.out.println("Thread 1 Count: " + i);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Thread that counts down
    static class CountDown extends Thread {

        public void run() {
            for (int i = 20; i >= 0; i--) {
                System.out.println("Thread 2 Count: " + i);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Starting Thread 1...");

        CountUp thread1 = new CountUp();
        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Starting Thread 2...");

        CountDown thread2 = new CountDown();
        thread2.start();

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Program Complete.");
    }
}