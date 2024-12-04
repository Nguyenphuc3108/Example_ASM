package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Example array for QuickSort
        int[] quickSortArray = {10, 7, 8, 9, 1, 5};
        int[] mergeSortArray = {12, 11, 13, 5, 6, 7};
        int[] bubbleSortArray = {64, 34, 25, 12, 22, 11, 90};

        // QuickSort demonstration
        System.out.println("Original Array for QuickSort:");
        Sorting.printArray(quickSortArray);

        Sorting.quickSort(quickSortArray, 0, quickSortArray.length - 1);

        System.out.println("Sorted Array using QuickSort:");
        Sorting.printArray(quickSortArray);

        // MergeSort demonstration
        System.out.println("\nOriginal Array for MergeSort:");
        Sorting.printArray(mergeSortArray);

        Sorting.mergeSort(mergeSortArray);

        System.out.println("Sorted Array using MergeSort:");
        Sorting.printArray(mergeSortArray);

        // BubbleSort demonstration
        System.out.println("\nOriginal Array for BubbleSort:");
        Sorting.printArray(bubbleSortArray);

        Sorting.bubbleSort(bubbleSortArray);

        System.out.println("Sorted Array using BubbleSort:");
        Sorting.printArray(bubbleSortArray);

        // Performance testing
        int size = 100000;
        int[] randomArrayBubble = new Random().ints(size, 0, 10000000).toArray();
        int[] randomArrayQuick = randomArrayBubble.clone();
        int[] randomArrayMerge = randomArrayBubble.clone();

        // Bubble Sort timing
        long time1 = System.nanoTime();
        Sorting.bubbleSort(randomArrayBubble);
        long time2 = System.nanoTime();
        System.out.println("Run time BubbleSort: " + (time2 - time1) + " nanoseconds");

        // Quick Sort timing
        long time3 = System.nanoTime();
        Sorting.quickSort(randomArrayQuick, 0, randomArrayQuick.length - 1);
        long time4 = System.nanoTime();
        System.out.println("Run time QuickSort: " + (time4 - time3) + " nanoseconds");

        // Merge Sort timing
        long time5 = System.nanoTime();
        Sorting.mergeSort(randomArrayMerge);
        long time6 = System.nanoTime();
        System.out.println("Run time MergeSort: " + (time6 - time5) + " nanoseconds");
    }
}
