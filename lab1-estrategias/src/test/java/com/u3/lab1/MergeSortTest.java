package com.u3.lab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {

    @Test
    void testArregloVacio() {
        int[] arr = {};
        int[] esperado = {};
        
        MergeSort.sort(arr);
        
        assertArrayEquals(esperado, arr);
    }

    @Test
    void testArregloUnElemento() {
        int[] arr = {42};
        int[] esperado = {42};
        
        MergeSort.sort(arr);
        
        assertArrayEquals(esperado, arr);
    }

    @Test
    void testArregloYaOrdenado() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] esperado = {1, 2, 3, 4, 5};
        
        MergeSort.sort(arr);
        
        assertArrayEquals(esperado, arr);
    }

    @Test
    void testArregloOrdenInverso() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] esperado = {1, 2, 3, 4, 5};
        
        MergeSort.sort(arr);
        
        assertArrayEquals(esperado, arr);
    }

    @Test
    void testArregloConDuplicados() {
        int[] arr = {4, 1, 3, 1, 2, 4, 2};
        int[] esperado = {1, 1, 2, 2, 3, 4, 4};
        
        MergeSort.sort(arr);
        
        assertArrayEquals(esperado, arr);
    }
}