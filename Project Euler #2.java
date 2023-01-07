// Project Euler Problem #2 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol

package com.company;
public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // Initial defines.
        int sum = 0;
        int firstTerm = 1;
        int secondTerm = 2;
        int limit = 4000000;
        // Loops through all terms and while it's than 4000000 do the math to sum, checks for is a pair and sums. 
        for(int i=1; i<limit; i++){
            while (firstTerm < 4000000) {
                int nextTerm = firstTerm + secondTerm;
                firstTerm = secondTerm;
                secondTerm = nextTerm;
                if (firstTerm % 2 == 0) {
                    sum = sum + firstTerm;
                }
            }
        }
        System.out.println(sum);
        // End of Times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
}
