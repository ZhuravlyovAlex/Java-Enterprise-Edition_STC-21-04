package lesson08;

import java.math.BigInteger;
import java.util.TreeMap;
import java.util.concurrent.Callable;

public class MyFactorialCallable implements Callable<BigInteger> {

    int n;

    public MyFactorialCallable(int n) {
        this.n = n;
    }
    /*
    В методе call реализуем нерекурсивный агоритм для вычисления факториала передоваемого числа.
    В методе рализовано кэширование ранее найденных значений, для увеличения скорости вычисления.
     */
    @Override
    public BigInteger call() throws Exception {
        BigInteger result;

        TreeMap<Integer, BigInteger> cache = new TreeMap<>();
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