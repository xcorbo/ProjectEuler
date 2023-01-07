// Project Euler Problem #21 Solution
// by: Corbo
// Will most likely be a brute force or innefficient AF, sorry lol

package com.company;
public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long answer = sumOfAmicable(10000);
        System.out.println("Amicable Sum: " + answer);
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }

    private static int sumOfAmicable(int limit) {
        int answer = 0;
        for (int i = 1; i < limit; i++) {
            int a = sumOfDivisors(i);
            int j = sumOfDivisors(a);
            if (a != j && i == j) {
                answer += a + j;
            }
        }
        return answer / 2;
    }

    public static int sumOfDivisors(int n) {
        int sum = 1;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i + n / i;
                if (i * i == n) sum -= i;
            }
        }
        return sum;
    }
}
