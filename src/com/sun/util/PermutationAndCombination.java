package com.sun.util;

public class PermutationAndCombination {

    public static long permutation(int n, int m) {
        long result = 1L;
        for (int i = n; i > n - m; i--) {
            result *= i;
        }
        return result;
    }

    public static long combination(int n, int m) {
        m = Math.min(m, n - m);
        return permutation(n, m) / factorial(m);
    }

    public static long factorial(int n) {
        long result = 1L;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(permutation(7, 5));
        System.out.println(combination(7, 5));
    }
}
