package com.ning.interview.view;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test2 {
//    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executor = Executors.newFixedThreadPool(1);
//        executor.submit(new Runnable() {
//
//            @Override
//            public void run() {
//                while (true) {
//                    if (Thread.currentThread().isInterrupted()) {
//                        System.out.println("interrupted");
//                        break;
//                    }
//                }
//            }
//        });
//
//        executor.shutdown();
//        if (!executor.awaitTermination(100, TimeUnit.MICROSECONDS)) {
//            System.out.println("Still waiting after 100ms: calling System.exit(0)...");
//            System.exit(0);
//        }
//        System.out.println("Exiting normally...");
//    }
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("interrupted");
                        break;
                    }
                }
            }
        });

        executor.shutdown();
        try {
            if (!executor.awaitTermination(100, TimeUnit.MICROSECONDS)) {
                System.out.println("Still waiting after 100ms: calling System.exit(0)...");
                System.exit(0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting normally...");
    }
}
