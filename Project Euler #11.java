// Project Euler Problem #11 Solution
// by: Corbo
// Will most likely be a brute force or innefficient AF, sorry lol

package com.company;
import java.util.ArrayList;
import java.util.Arrays;

public final class Main {

    public static void main(String[] args) {
    long startTime = System.nanoTime();
    String longString = "08022297381500400075040507785212507791084949994017811857608717409843694804566200814931735579142993714067538830034913366552709523046011426924685601325671370236912231167151676389419236542240402866331380244732609903450244753353783684203517125032988128642367102638406759547066183864706726206802621220956394396308409166499421245558056673992697177878968314883489637221362309750076442045351400613397343133957817532822753167159403800462161409535692163905429635314755588824001754243629855786560048357189070544443744602158515417581980816805944769287392138652177704895540045208839735991607975732162626793327986688366887576220720346336746551232639353690442167338253911249472180846293240627636206936417230238834629969826759857404361620733529783190017431497148868116235705540170547183515469169233486143520189196748";
    int pieceLength = (int) Math.sqrt(longString.length()/2);
    int[][] stringGrid = new int[pieceLength][pieceLength];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                int startIndex = 2 * (i * 20 + j);
                String substr = longString.substring(startIndex, startIndex + 2);
                stringGrid[i][j] = Integer.parseInt(substr);
            }
        }
    // Ok we have a 2d array now lets do math
    int mult = 0;
    int largestMult = 0;

    // Check horizontally
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 17; j++){
                mult = stringGrid[i][j] * stringGrid[i][j + 1] * stringGrid[i][j + 2] * stringGrid[i][j + 3];
                if(mult > largestMult){
                    largestMult = mult;
                }
            }
        }

    // Check vertically
        for(int i = 0; i < 17; i++){
            for(int j = 0; j < 20; j++){
                mult = stringGrid[i][j] * stringGrid[i + 1][j] * stringGrid[i + 2][j] * stringGrid[i + 3][j];
                if(mult > largestMult){
                    largestMult = mult;
                }
            }
        }

    // Check diagonally foward right
        for(int i = 0; i < 17; i++){
            for(int j = 0; j < 17; j++){
                mult = stringGrid[i][j] * stringGrid[i + 1][j + 1] * stringGrid[i + 2][j + 2] * stringGrid[i + 3][j + 3];
                if(mult > largestMult){
                    largestMult = mult;
                }
            }
        }

    // Check diagonally backwards left
        for(int i = 0; i < 17; i++){
            for(int j = 3; j < 20; j++){
                mult = stringGrid[i][j] * stringGrid[i + 1][j - 1] * stringGrid[i + 2][j - 2] * stringGrid[i + 3][j - 3];
                if(mult > largestMult){
                    largestMult = mult;
                }
            }
        }
        System.out.println(largestMult);
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;
        System.out.println(totalTime + "ms");
    }
}
