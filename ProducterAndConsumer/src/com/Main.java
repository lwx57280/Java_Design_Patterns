package com;

import com.consumer.Consumer;
import com.consumer.Consumer2;
import com.producer.Producer;
import com.producer.Producer2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 生产者负责生产一个数字并存入缓冲区，消费者从缓冲区中取出数据并且求出它的平方并输出。
 *
 * 因为BlockingQueue是一个阻塞队列，它的存取可以保证只有一个线程在进行，所以根据逻辑，生产者在内存满的时候进行等待，
 * 并且唤醒消费者队列，反过来消费者在饥饿状态下等待并唤醒生产者进行生产。
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Demo1();

        List<PCData2> queue = new ArrayList<PCData2>();
        int length =10;
        Producer2 p1=new Producer2(queue,length);
        Producer2 p2=new Producer2(queue,length);
        Producer2 p3=new Producer2(queue,length);

        Consumer2 c1=new Consumer2(queue);
        Consumer2 c2=new Consumer2(queue);
        Consumer2 c3=new Consumer2(queue);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(p1);
        service.execute(p2);
        service.execute(p3);

        service.execute(c1);
        service.execute(c2);
        service.execute(c3);

    }

    private static void Demo1() throws InterruptedException {
        BlockingQueue<PCData> queue = new LinkedBlockingDeque<PCData>(10);
        Producer p1 = new Producer(queue);
        Producer p2 = new Producer(queue);
        Producer p3 = new Producer(queue);

        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(p1);
        service.execute(p2);
        service.execute(p3);

        service.execute(c1);
        service.execute(c2);
        service.execute(c3);

        Thread.sleep(10*1000);

        p1.stop();
        p2.stop();
        p3.stop();
        Thread.sleep(3000);
        service.shutdown();
    }
}
