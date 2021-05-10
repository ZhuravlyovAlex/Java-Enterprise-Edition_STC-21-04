package lesson08;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Программа для вычисления факториалов всех элементов массива случайных чисел.
 * Для вычесления используется пул потоков.
 *
 * При чем вычислив факториал для одного числа, можно запомнить эти данные и использовать их для вычисления другого,
 * что будет гораздо быстрее
 * <p>
 * * <p>
 * version 2.0
 * Copyright Журавлёв Алексей
 */

public class Main {

    public static ConcurrentNavigableMap<Integer,BigInteger> cache;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        cache = new ConcurrentSkipListMap<>();
        int[] nums = new int[]{26, 7, 45, 12, 8, 21, 5, 67, 19, 98, 34, 3, 2, 5, 260, 7, 450, 12, 8, 21};

        final ExecutorService executor = Executors.newFixedThreadPool(4);

        List<Callable<BigInteger>> factorialResult = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            Callable<BigInteger> result = new MyFactorialCallable(nums[i]);
            factorialResult.add(result);
        }
        for (Future<BigInteger> fResult : executor.invokeAll(factorialResult)) {
            System.out.println(fResult.get());
        }
        executor.shutdown();
    }
}