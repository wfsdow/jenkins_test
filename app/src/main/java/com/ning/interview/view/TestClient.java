package com.ning.interview.view;


import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//分析一些没理解的问题
public class TestClient {
    public void test() {
        //引用队列的原理?
        //1. 是谁把对象放到引用队列中的？
        //2. 引用队列持有对象会导致内存泄漏吗？  引用队列中保存的是软引用？
        Object obj = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        WeakReference<Object> ref = new WeakReference<>(obj, queue);


    }

    //测试线程池相关原理
    public void test2() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.shutdown();

        Thread t1 = new Thread();
        t1.interrupt();
    }
}
