// Project Euler Problem #45 Solution
// by: Corbo
// Will most likely be a brute force or inefficient AF, sorry lol

public final class Main {
    public static void main(String[] args) {
        // Init timer
        long startTime = System.nanoTime();

        // Declarations
        long limit = 500000;
        int findNextNumFrom = 40755;
        long nextNum = 0;

        // Code
        for (long i = 285; i <= limit; i++){
            long tempTriangle = i * (i + 1) / 2;
            for (long j = 165; j <= limit; j++){
                long tempPentagon = j * ((3 * j) - 1) / 2;

                if (tempPentagon == tempTriangle){
                    for (long k = 143; k <= limit; k++){
                        long tempHexagon = k * ((2 * k) - 1);

                        if (tempHexagon == tempPentagon && tempHexagon > findNextNumFrom){
                            nextNum = tempHexagon;
                            break;
                        }

                    }
                }
            }
            if (nextNum > 0)
                break;
        }

        // Printing the results
        System.out.println(nextNum);

        // The end of times
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
}
