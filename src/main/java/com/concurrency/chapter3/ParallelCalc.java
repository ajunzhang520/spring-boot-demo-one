package com.concurrency.chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ParallelCalc {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> element = Arrays.asList(array);

        calcByThreadPoolCalc(element);

    }

    private static void calcByThreadPoolCalc(List<Integer> element) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Integer sum = 0;
        for (int i = 0; i < 10; i++) {
            Future<Integer> result = executorService.submit(new AddElement(element));
            sum += result.get();
        }
        System.out.println(sum);

    }

    private static void calcByFutureTask(List<Integer> element) throws InterruptedException, ExecutionException {
        Integer sum = 0;
        for (int i = 0; i < 10; i++) {
            AddElement addElement = new AddElement(element);
            FutureTask<Integer> futureTask = new FutureTask<>(addElement);
            Thread thread = new Thread(futureTask);
            thread.start();

            sum += futureTask.get();
        }

        System.out.println("All sum value is " + sum);
    }

    static class AddElement implements Callable<Integer> {
        private final List<Integer> elements;

        private AddElement(List<Integer> elements) {
            this.elements = elements;
        }

        @Override
        public Integer call() {
            int sum = 0;
            for (int i = 0; i < elements.size(); i++) {
                sum += i;
            }
            System.out.println("Thread" + Thread.currentThread().getName() + " cal sum is " + sum);
            return sum;
        }
    }


}
