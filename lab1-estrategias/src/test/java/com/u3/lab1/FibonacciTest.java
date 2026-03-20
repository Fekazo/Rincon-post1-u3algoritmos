package com.u3.lab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    @Test
    void testFibonacciValoresPequenos() {
        int[] casos = {0, 1, 2, 5, 10, 20};

        for (int n : casos) {
            long rec = Fibonacci.fibRecursivo(n);
            long memo = Fibonacci.fibMemo(n);
            long tabla = Fibonacci.fibTabla(n);

            assertEquals(rec, memo, "Diferencia entre recursivo y memo en n=" + n);
            assertEquals(rec, tabla, "Diferencia entre recursivo y tabla en n=" + n);
        }
    }

    @Test
    void testFibonacciHasta30() {
        for (int n = 0; n <= 30; n++) {
            long rec = Fibonacci.fibRecursivo(n);
            long memo = Fibonacci.fibMemo(n);
            long tabla = Fibonacci.fibTabla(n);

            assertEquals(rec, memo, "Diferencia entre recursivo y memo en n=" + n);
            assertEquals(rec, tabla, "Diferencia entre recursivo y tabla en n=" + n);
        }
    }
}