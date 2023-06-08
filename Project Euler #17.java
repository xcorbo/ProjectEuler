// Project Euler Problem #17 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol
package com.company;
public final class Main {
    public static void main(String[] args) {
      
        // Init timer
        long startTime = System.nanoTime();

        // Declarations
        int limit = 1000;
        int count = 0;

        // Code
        for (int i = 1; i <= limit; i++){
            count += toWords(i).length();
        }

        //  Printing the Results
        System.out.println(count);

        // The end of times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
  
    final private  static String[] units = {"zero","one","two","three","four",
            "five","six","seven","eight","nine","ten",
            "eleven","twelve","thirteen","fourteen","fifteen",
            "sixteen","seventeen","eighteen","nineteen"};

    final private static String[] tens = {"","","twenty","thirty","forty","fifty",
            "sixty","seventy","eighty","ninety"};

    public static String toWords(int i) {
        if( i < 20)  return units[i];
        if( i < 100) return tens[i/10] + ((i % 10 > 0)? "" + toWords(i % 10):"");
        if( i < 1000) return units[i/100] + "hundred" + ((i % 100 > 0)?"and" + toWords(i % 100):"");
        if( i < 1000000) return toWords(i / 1000) + "thousand" + ((i % 1000 > 0)? " " + toWords(i % 1000):"");
        return toWords(i / 1000000) + "million" + ((i % 1000000 > 0)? "" + toWords(i % 1000000):"");
    }
}
