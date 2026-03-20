package com.u3.lab1;

import java.util.Arrays;

/** Tres implementaciones de Fibonacci para comparación empírica. */
public class Fibonacci {
    // VARIANTE 1: Recursivo ingenuo — O(2^n)
    public static long fibRecursivo(int n) {
        if (n <= 1)
            return n;
        return fibRecursivo(n - 1) + fibRecursivo(n - 2);
    }

    // VARIANTE 2: Memoización top-down — O(n) tiempo, O(n) espacio
    public static long fibMemo(int n) {
        long[] memo = new long[n + 2];
        Arrays.fill(memo, -1L);
        return fibMemoHelper(n, memo);
    }

    private static long fibMemoHelper(int n, long[] memo) {
        if (n <= 1)
            return n;
        if (memo[n] != -1)
            return memo[n];
        memo[n] = fibMemoHelper(n - 1, memo) + fibMemoHelper(n - 2,
                memo);
        return memo[n];
    }

    // VARIANTE 3: Tabulación bottom-up — O(n) tiempo, O(1) espacio
    public static long fibTabla(int n) {
        if (n <= 1)
            return n;
        long prev2 = 0, prev1 = 1;
        for (int i = 2; i <= n; i++) {
            long curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
