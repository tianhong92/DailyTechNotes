package com.tianhong.demo.thread.interviewQuestions;

/**
 * @author TianhongWang
 * @since 2019/1/17
 */
public class TestThread {
    public static void main(String[] args) {
        RunnableDemo R1 = new RunnableDemo("Thread-1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo("Thread-2");
        R2.start();

//        ThreadDemo T1 = new ThreadDemo("Thread-1");
//        T1.start();
//        ThreadDemo T2 = new ThreadDemo("Thread-2");
//        T2.start();
    }
}
