package org.example;

public class LinearSearch {
    // Ex: Consider a function that searches for an element in a list (linear search)
    public boolean linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }
    // Ex: Consider a function that creates a new list of squared numbers:
    public int[] squareNumbers(int[] arr) {
        int[] squaredArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            squaredArr[i] = arr[i] * arr[i];
        }
        return squaredArr;
    }


}
