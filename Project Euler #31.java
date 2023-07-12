// Project Euler Problem #31 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol
package com.company;

public final class Main {

    public static void main(String[] args) {
        // Init timer
        long startTime = System.nanoTime();

        // Declarations
        int[] count = new int[201];
        count[0] = 1;
        int[] coins ={1, 2, 5, 10, 20, 50, 100, 200};

        // Code
        for (int i : coins){
            for (int j = i; j <= 200; j++){
             count[j] += count[j - i];
            }
        }

        // Printing the result
        System.out.println(count[200]);

        // The end of times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
}


