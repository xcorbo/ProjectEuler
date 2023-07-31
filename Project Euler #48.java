// Project Euler Problem #48 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol

import java.math.BigInteger;

public final class Main {
    public static void main(String[] args) {
        // Init timer
        long startTime = System.nanoTime();

        // Declarations
        BigInteger sum = BigInteger.ZERO;
        int limit = 1000;
        String result;

        // Code
        for (int i = 1; i < limit; i++){
            sum = sum.add(BigInteger.valueOf(i).pow(i));
        }
        result = String.valueOf(sum);
        result = result.substring(result.length()-10, result.length());
        
        // Printing the results
        System.out.println(result);

        // The end of times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
}
