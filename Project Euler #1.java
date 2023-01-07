// Project Euler Problem #1 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol

package com.company;
public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // Initial defines.
        int sum = 0;
        int limit = 1000;
        // loops through all elements until limit and checks if multiple of 3 or 5 before sum.
        for(int i=0; i<limit; i++){
            if (i%3 == 0 || i%5 == 0){
                sum = sum + i;
            }
        }
        
        System.out.println(sum);
        // End of Times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
}
