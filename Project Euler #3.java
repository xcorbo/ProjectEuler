// Project Euler Problem #3 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol

package com.company;

public final class Main {
    public static void main(String[] args) {
        // Init timer
        long startTime = System.nanoTime();

        // Declarations
        long limit = 600851475143L;
        long currPrime = 1;
        long currNum = 2L;

        while (currNum * currNum < limit){
            if (limit % currNum == 0){
                if (isPrime(currNum)){
                    currPrime = currNum;
                }
            }
            currNum++;
        }

        //  Printing the Results
        System.out.println(currPrime);

        // The end of times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
  
  private static boolean isPrime(long n){
        if (n <= 1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        if (n % 2 == 0){
            return false;
        }
        return true;
    }
}
