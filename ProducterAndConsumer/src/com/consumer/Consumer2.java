package com.consumer;

import com.PCData2;

import java.util.List;

/**
 * 消费者
 */
public class Consumer2 implements Runnable {
    private List<PCData2> queue;

    public Consumer2(List<PCData2> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (Thread.currentThread().isInterrupted())
                    break;
                PCData2 data = null;
                synchronized (queue) {
                    if (queue.size() == 0) {
                        queue.wait();
                        queue.notifyAll();
                    }
                    data = queue.remove(0);
                }
                System.out.println(Thread.currentThread().getId() + " 消费了" + data.getValue() + " result: " + (data.getValue() * data.getValue()));
                Thread.sleep(1000);
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
