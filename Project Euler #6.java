// Project Euler Problem # Solution
// by: Corbo
// Will most likely be a brute force or innefficient AF, sorry lol

package com.company;
public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // Initial defines
        int max = 100 ;
        int sumOfSquares = 0;
        int sumOfNaturals = 0;
            for (int i = 0; i <= max; i++){
                    sumOfSquares += i * i;
                }
                for (int j = 0; j <= max; j++){
                    sumOfNaturals += j;
                }
        // We're printing the answer now
        System.out.println((sumOfNaturals * sumOfNaturals) - sumOfSquares);
        // End of Times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
}
