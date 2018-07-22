package com.producer;
import com.PCData2;

import java.util.List;
import java.util.Random;

/**
 * 生产者
 * 生产者消费者模型
 */
public class Producer2 implements Runnable{
    private List<PCData2> queue;

    private int length;

    public Producer2(List<PCData2> queue, int length) {
        this.queue = queue;
        this.length = length;
    }

    @Override
    public void run() {
        try{
            while (true){
                if(Thread.currentThread().isInterrupted())
                    break;
                Random random = new Random();
                long temp = random.nextInt(100);
                System.out.println(Thread.currentThread().getId()+" 生产了:"+temp);
                PCData2 data = new PCData2();
                data.setValue(temp);
                synchronized (queue){
                    if(queue.size()>=length){
                        queue.notifyAll();
                        queue.wait();
                    }else {
                        queue.add(data);
                    }
                }
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
