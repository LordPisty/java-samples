package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by crespis on 3/31/2015.
 */
public class CondAwaitSignal {

    public static class Drop {
        private String message;
        private boolean empty = true;

        private final Lock lock = new ReentrantLock();
        private final Condition notFull = lock.newCondition();
        private final Condition notEmpty = lock.newCondition();

        private void put(final String s) {
            lock.lock();

            try {
                while (!empty) {
                    notFull.await();
                }

                empty = false;
                message = s;
                notEmpty.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        private String get() {
            lock.lock();
            try {
                while (empty) {
                    notEmpty.await();
                }
                empty = true;
                notFull.signalAll();
                return message;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return null;
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
