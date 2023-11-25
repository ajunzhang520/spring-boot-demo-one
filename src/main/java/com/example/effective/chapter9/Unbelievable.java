package com.example.effective.chapter9;

import java.util.concurrent.atomic.AtomicLong;

/**
 * zhangshijun
 * 2019/9/28 16:46
 **/
public class Unbelievable {
    private static Integer i;

    private final AtomicLong count = new AtomicLong();

    public long getCount() {
        return count.get();
    }

    public void addCount() {
        count.incrementAndGet();
    }

    public static void main(String[] args) {

        if (i == 41) {
            System.out.println("unbelievable");
        }
    }
}
