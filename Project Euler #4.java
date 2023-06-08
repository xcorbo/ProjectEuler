// Project Euler Problem #4 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol
package com.company;
public final class Main {
    public static void main(String[] args) {
        // Init timer
        long startTime = System.nanoTime();

        // Declarations
        int maxNum = 999;
        int initPal = 0;

        // Code
        for (int i = 0; i <= maxNum; i++){
            for (int j = 0; j <= maxNum; j++){
                if (i*j > initPal && isPalindrome(i*j)){
                        initPal = i*j;
                }
            }
        }

        //  Printing the Results
        System.out.println("The highest palindrome is: " + initPal);

        // The end of times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
    public static boolean isPalindrome(int n){
        String strPal = "";
        String strRevPal = "";
        strPal = String.valueOf(n);
        for (int k = strPal.length()-1; k >= 0; k--){
            strRevPal = strRevPal + strPal.charAt(k);
        }
        return strPal.equals(strRevPal);
    }
}
