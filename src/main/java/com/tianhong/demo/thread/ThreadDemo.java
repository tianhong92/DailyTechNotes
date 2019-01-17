package com.tianhong.demo.thread;

/**
 * @author TianhongWang
 * @since 2019/1/17
 */
public class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;

    ThreadDemo(String name){
        this.threadName = name;
        System.out.println("Creating "+threadName);
    }

    public void run() {
        System.out.println("Running "+threadName);
        for(int i = 4; i > 0; i--){
            System.out.println("Thread "+threadName+", "+i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Thread "+ threadName + " interrupted");
            }
        }
        System.out.println("Thread "+threadName+" exiting.");
    }

    public void start(){
        System.out.println("Starting " + threadName);
        if(t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
