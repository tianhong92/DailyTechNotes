package com.tianhong.demo.thread.interviewQuestions;

class RunnableDemo implements Runnable {
    private String threadName;
    private Thread t;

    RunnableDemo(String name){
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println("Running "+threadName);
        for(int i = 4; i > 0; i--){
            System.out.println(threadName + ", "+ i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Thread "+threadName+" interrupted.");
            }
        }
        System.out.println(threadName+" exiting.");
    }

    public void start(){
        System.out.println("Starting "+threadName);
        if(t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}