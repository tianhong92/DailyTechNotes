package com.tianhong.demo.thread.interviewQuestions;

/**
 * @author TianhongWang
 * @since 2019/1/17
 */
public class DisplayMessage implements Runnable {
    private String message;

    public DisplayMessage(String message) {
        this.message = message;
    }

    public void run() {
        while(true) {
            System.out.println(message);
        }
    }
}
