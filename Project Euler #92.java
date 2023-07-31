// Project Euler Problem #92 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol

public final class Main {
    public static void main(String[] args) {
        // Init timer
        long startTime = System.nanoTime();

        // Declarations
        int limit = 10000000;
        int currSum = 0;

        // Code
        for (int i = 1; i < limit; i++){
            if(is89(i)){
                currSum++;
            }
        }

        // Printing the results
        System.out.println(currSum);

        // The end of times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }

    public static boolean is89(int x){
        while (true){
            switch (x) {
                case  1:  return false;
                case 89:  return true;
                default:  x = nextNumber(x);
            }
        }
    }

    private static int nextNumber(int x) {
        String testNum = String.valueOf(x);
        int sum = 0;
        for (int i = 0; i < testNum.length(); i++){
            sum += Character.getNumericValue(testNum.charAt(i)) * Character.getNumericValue(testNum.charAt(i));
        }
        return sum;
    }
}
