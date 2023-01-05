// Project Euler Problem #7 Solution
// by: Corbo
// Will most likely be a brute force or innefficient AF, sorry lol

package com.company;
import java.util.ArrayList;
public final class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int limit = 1000000; // doing an insanely large number cause idk lmao
        ArrayList<Integer> primeCount = new ArrayList<>();
        for (int i = 2; i < limit; i++){
            if(isPrime(i)){
                primeCount.add(i);
                if(primeCount.size() == 10001){
                    System.out.println(primeCount.get(primeCount.size()-1));
                    long endTime = System.nanoTime();
                    long totalTime = (endTime - startTime) / 1000000;
                    System.out.println(totalTime + "ms");
                    break;
                }
            }
        }
    }

    private static boolean isPrime(int n){
    
        if (n == 0 || n == 1){
            return false;
        }
        for (int i = 2; i < n; i++){
            if (n % i == 0){
                return false;
            }
        }
        
        return true;
    }
}
