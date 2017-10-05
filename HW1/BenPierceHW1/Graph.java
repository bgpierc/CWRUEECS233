/*
Ben Pierce(bgp12)
So I started doing the assignment without reading the questions; once I finished it,
I realized that it would be easier to use the grapher class if I combined all into one. 
So I have three classes (Problem1, Problem2, Problem3) that I'm now combining into one class
that will accomplish most of their functionality.

 Good thing this isn't a software engineering class.
*/

import java.util.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;
import java.text.*; // For DecimalFormat

public class Graph{
public static final int NUM_ITERATIONS = 7;//number of times ADDEND is added to N
public static final long ADDEND_ALG1 = 10000000000L;//00L;//000L; //number added to N each loop
public static final long ADDEND_ALG2 = 100000L;//0L;
public static final long ADDEND_ALG3 = 100000L;//0L;

 public static void main(String[] args){
 	Grapher grapher = new Grapher();
 	int[] alg1Y = new int[7];
 	int[] alg2Y = new int[7];
 	int[] alg3Y = new int[7];
 	int[] alg1X = {0,1,2,3,4,5,6}; 
 	int[] alg2X = {0,1,2,3,4,5,6};
 	int[] alg3X = {0,1,2,3,4,5,6};
 	long N1 = 0;
 	long N2 = 0;
 	long N3 = 0;

        for(int i = 0; i < NUM_ITERATIONS; i++){  
            alg1Y[i]=alg1(N1);
            N1 += ADDEND_ALG1;        
        }
        prtArr(alg1Y);
        for(int i = 0; i <  NUM_ITERATIONS; i++){
            alg2Y[i] = (int)alg2(N2);
            N2 += ADDEND_ALG2;
        }
        prtArr(alg2Y);
        for(int i = 0; i <  NUM_ITERATIONS; i++){
            alg3Y[i] = (int)alg3(N3);
            N3+= ADDEND_ALG3;
        }
       prtArr(alg3Y);
       grapher.graph(alg1X,alg1Y,Color.BLUE);
       grapher.graph(alg2X,alg2Y, Color.RED);
       grapher.graph(alg3X,alg3Y, Color.GREEN);
       
       grapher.display(); 
 }


 public static int alg3(long N){
        long startTime, stopTime; // For recording start/stop times
        long x = 0;
        startTime = System.currentTimeMillis();
        for (long i = 0; i < N; i++) {
            x = x + 1;
        }
        for (long i = 0; i < N; i++) {
            for (long j = 0; j < N; j++) {
                x = x + 1;
            }
        }
        stopTime = System.currentTimeMillis();
        return (int)(stopTime - startTime);
    }

    public static int alg2(long N){
        long startTime, stopTime; // For recording start/stop times
        long x = 0;
        startTime = System.currentTimeMillis();
        for (long i = 0; i < N; i++) {
            for (long j = 0; j < N; j++) {
                x = x + 1;
            }
        }
        stopTime = System.currentTimeMillis();
        return (int)(stopTime - startTime);
    }

    public static int alg1(long N){
        long startTime, stopTime; // For recording start/stop times
        long x = 0;
        startTime = System.currentTimeMillis();
        for (long i = 0; i < N; i++) {
            x = x + 1;
        }
        stopTime = System.currentTimeMillis();
        return (int)( stopTime - startTime); 
    }

    public static void prtArr(int[]arr){
        for (int i = 0; i< arr.length-1;i++){
            System.out.println(arr[i]);
        }
        System.out.println();
    }
}