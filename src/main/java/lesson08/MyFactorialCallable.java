package lesson08;

import java.math.BigInteger;
import java.util.concurrent.Callable;

import static lesson08.Main.cache;

public class MyFactorialCallable implements Callable<BigInteger> {

    int n;

    public MyFactorialCallable(int n) {
        this.n = n;
    }

    /**
     * В методе call реализуем нерекурсивный агоритм для вычисления факториала передаваемого числа.
     * В методе рализовано кэширование ранее найденных значений, для увеличения скорости вычисления.
     */

    @Override
    public BigInteger call() throws Exception {
        BigInteger result;

        cache.put(0, BigInteger.ONE);
        cache.put(1, BigInteger.ONE);

        if (n == 0) return BigInteger.ONE;
        if (null != (result = cache.get(n))) return result;
        result = cache.lowerEntry(n).getValue();
        for (int i = cache.lowerEntry(n).getKey() + 1; i <= n; ++i) {
            result = result.multiply(BigInteger.valueOf(i));
            cache.put(i, result);
        }
        return result;
    }
}