package thread;

/**
 * Created by crespis on 3/31/2015.
 */
public class WaitNotify {

    public static class Drop {
        private String message;
        private boolean empty = true;

        private synchronized void put(final String s) {
            while (!empty) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            empty = false;
            message = s;
            notifyAll();
        }

        private synchronized String get() {
            while (empty) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            empty = true;
            notifyAll();
            return message;
        }
    }

    public static class Producer implements Runnable {

        private final Drop drop;

        private Producer(Drop d) {
            drop = d;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " producing " + i + "...");
                drop.put(String.valueOf(i));
                try {
                    Thread.sleep(i * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Consumer implements Runnable {

        private final Drop drop;

        private Consumer(Drop d) {
            drop = d;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " consuming...");
                String result = drop.get();
                System.out.println(Thread.currentThread().getName() + " consumed " + result);
                try {
                    Thread.sleep(i * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String... args) {
        Drop drop = new Drop();

        Producer p1 = new Producer(drop);
        Producer p2 = new Producer(drop);

        Consumer c1 = new Consumer(drop);
        Consumer c2 = new Consumer(drop);

        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(p1).start();
        new Thread(p2).start();
    }
}
