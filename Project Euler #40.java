// Project Euler Problem #40 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol

public final class Main {
    public static void main(String[] args) {
        // Init timer
        long startTime = System.nanoTime();

        // Declarations
        int limit = 1000000;

        // Form the string
        StringBuilder fraction = new StringBuilder();
        for (int i = 1; i < limit; i++)
            fraction.append(i);

        int mult = 1;
        for (int i = 1; i < 7; i++)
            mult *= Character.getNumericValue(fraction.charAt((int) (Math.pow(10,i)-1)));

        // Printing the results
        System.out.println(mult);

        // The end of times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
}
