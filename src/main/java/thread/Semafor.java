package thread;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by crespis on 3/31/2015.
 */
public class Semafor {

    private static final int SIZE = 10;

    private static class SemaDrop {

        AtomicInteger count = new AtomicInteger(0);
        Semaphore semaphore = new Semaphore(SIZE);

        private Random random = new Random();

        public void put() {
            try {
                semaphore.acquire();

                System.out.println(Thread.currentThread().getName() + " is playing with the semaphore...");
                System.out.println(count.incrementAndGet());
                Thread.sleep(random.nextInt(5));

                System.out.println(Thread.currentThread().getName() + " is done playing with the semaphore.");
                System.out.println(count.decrementAndGet());
                semaphore.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void get() {
            try {
                semaphore.acquire();

                System.out.println(Thread.currentThread().getName() + " is playing with the semaphore...");
                System.out.println(count.incrementAndGet());
                Thread.sleep(random.nextInt(5));

                System.out.println(Thread.currentThread().getName() + " is done playing with the semaphore.");
                System.out.println(count.decrementAndGet());
                semaphore.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Producer implements Runnable {

        private final SemaDrop drop;
        private Random random = new Random();

        private Producer(SemaDrop d) {
            drop = d;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " producing " + i + "...");
                drop.put();
                try {
                    Thread.sleep(random.nextInt(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Consumer implements Runnable {

        private final SemaDrop drop;
        private Random random = new Random();

        private Consumer(SemaDrop d) {
            drop = d;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " consuming...");
                drop.get();
                try {
                    Thread.sleep(random.nextInt(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String... args) {
        SemaDrop drop = new SemaDrop();

        for (int j = 0; j < SIZE * 2; j++) {
            new Thread(new Producer(drop)).start();
            new Thread(new Consumer(drop)).start();
        }
    }

}
