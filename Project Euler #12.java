// Project Euler Problem #12 Solution
// by: Corbo
// Will most likely be a brute force or innefficient AF, sorry lol
// Highly unrecommended solution, took 853124ms to run, absolutely not optimized algo

package com.company;
import java.util.ArrayList;

public final class Main {

    public static void main(String[] args) {
    long startTime = System.nanoTime();

        int limit = 10000000; //Ridiculously large number for the loop.
        int sumTriangular = 0;
        int sumCount = 0;
        ArrayList<Integer> triangularDivisors = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        for(int i = 1; i < limit; i++){
            sumTriangular = sumTriangular + i;
            sumCount = 0;
            for(int j = 1; j <= sumTriangular; j++){
                if (sumTriangular%j == 0){
                    triangularDivisors.add(j);
                    sumCount++;
                }
            }
            count.add(sumCount);
            int lastItem = count.size() - 1;
            System.out.println("Counting..." + count.get(lastItem));
            if (count.get(lastItem) > 500){
                System.out.println("This number has: " + count.get(lastItem) + " divisors");
                System.out.println("Triangular number is:" + sumTriangular);
                break;
            }
        }

    long endTime = System.nanoTime();
    long totalTime = (endTime - startTime) / 1000000;
    System.out.println(totalTime + "ms");
    }
}
