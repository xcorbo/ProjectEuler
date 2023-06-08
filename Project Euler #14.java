// Project Euler Problem #14 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol
package com.company;
public final class Main {
    public static void main(String[] args) {
        // Init timer
        long startTime = System.nanoTime();

        // Declarations
        int limit = 1000000;
        int currMax = 0;
        int size = 0;
        int currNum = 0;

        // Code
        for (int i = 1; i <= limit; i++){
            size = getSize(i);
            if (size > currMax){
                currMax = size;
                currNum = i;
            }
        }

        //  Printing the Results
        System.out.println("The number is: " + currNum + " and the chain size is: " + currMax);

        // The end of times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
    public static int getSize(int n){
        int size = 0;
        long num = n;
        while (num != 1){
            if (num % 2 == 0){
                num = num / 2;
                size++;
            } else {
                num = 3 * num + 1;
                size++;
            }
        }
        return size + 1;
    }
}
