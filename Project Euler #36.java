// Project Euler Problem #36 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol
package com.company;

public final class Main {
    public static void main(String[] args) {
        // Init timer
        long startTime = System.nanoTime();

        // Declarations
        int limit = 1000000;
        int sum = 0;

        // Code
        for (int i = 1; i < limit; i++){
            if(isPalindromeString(String.valueOf(i)) && isPalindromeString(Integer.toBinaryString(i))){
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
    public static boolean isPalindromeString(String m){
        String strPal = "";
        String strRevPal = "";
        strPal = String.valueOf(m);
        for (int k = strPal.length()-1; k >= 0; k--){
            strRevPal = strRevPal + strPal.charAt(k);
        }
        return strPal.equals(strRevPal);
    }
}
