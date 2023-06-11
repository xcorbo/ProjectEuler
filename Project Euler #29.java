// Project Euler Problem #29 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol
package com.company;


import java.util.ArrayList;

public final class Main {
    public static void main(String[] args) {
        // Init timer
        long startTime = System.nanoTime();

        // Declarations
        int startLimit = 2;
        int endLimit = 100;
        ArrayList list = new ArrayList();


        // Code
        for (int i = startLimit; i <= endLimit; i++){
            for (int j = startLimit; j <= endLimit; j++){
                if (!list.contains(Math.pow(i,j))){
                    list.add(Math.pow(i,j));
                }
            }
        }
        
        // Printing the Results
        System.out.println(list.size());

        // The end of times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
}
