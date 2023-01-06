// Project Euler Problem #10 Solution
// by: Corbo
// Will most likely be a brute force or innefficient AF, sorry lol

package com.company;
import java.util.ArrayList;
public final class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long limit = 2000000;
        long primeSum = 0;
        ArrayList<Integer> primeCount = new ArrayList<>();
        for (int i = 2; i < limit; i++){
            if(isPrime(i)){
                primeCount.add(i);
            }
        }
        for (int j = 0; j < primeCount.size(); j++){
            primeSum += primeCount.get(j);
        }
        System.out.println(primeSum);
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }

    private static boolean isPrime(int n){

        if (n <= 1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
