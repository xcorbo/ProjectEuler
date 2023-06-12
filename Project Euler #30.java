// Project Euler Problem #30 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol
package com.company;



public final class Main {
    public static void main(String[] args) {
        // Init timer
        long startTime = System.nanoTime();

        // Declarations
        int sum = 0;

        // Code
        for (int i = 2; i <= 1000000; i++){
             if (i == sumOfFifthsPowers(i)){
                 sum += i;
             }
        }

        // Printing the Results
        System.out.println(sum);

        // The end of times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
    public static int sumOfFifthsPowers(int x){
        int sum = 0;
        int digits = 5;
        String temp = Integer.toString(x);
        for (int i = 0; i < temp.length(); i++){
             sum += Character.getNumericValue(temp.charAt(i))  * Character.getNumericValue(temp.charAt(i)) * Character.getNumericValue(temp.charAt(i)) * Character.getNumericValue(temp.charAt(i)) * Character.getNumericValue(temp.charAt(i));
        }
        return sum;
    }
}
