// Project Euler Problem #56 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol

import java.math.BigInteger;

public final class Main {
    public static void main(String[] args) {
        // Init timer
        long startTime = System.nanoTime();

        // Declarations
        BigInteger sum = BigInteger.ZERO;
        int limit = 100;
        int currMaxSum = 0;
        String result;

        // Code
        for (int i = 0; i < limit; i++){
            for (int j = 0; j < limit; j++){
                sum = BigInteger.valueOf(i).pow(j);
                result = String.valueOf(sum);
                if (digitsSum(result) > currMaxSum){
                    currMaxSum = digitsSum(result);
                }
            }
        }
        
        // Printing the results
        System.out.println(currMaxSum);

        // The end of times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
    
    public static int digitsSum(String sum){
        int sumDigits = 0;
        for (int i = 0; i < sum.length(); i++){
            sumDigits += Character.getNumericValue(sum.charAt(i));
        }
        return sumDigits;
    }
}
