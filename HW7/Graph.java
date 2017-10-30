import java.util.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;
import java.text.*; // For DecimalFormat

public class Graph{
	public static void main(String[] args){
		int N = 0;
		long numIter = 10000000;
		Graph obj = new Graph();
		Grapher2 graph = new Grapher2();
		IntArrayBag bag = new IntArrayBag();
		Heap heap = new Heap();
		double[] heapTimes = new double[5];
		double[] bagTimes = new double[5];
		double[] x = {0,1,2,3,4};
		for(int i = 0; i < 5;i++){
			obj.createStructures(N,heap,bag,numIter);
			bagTimes[i] = obj.bagTime(bag,numIter,N);
			heapTimes[i] = obj.heapTime(heap,numIter,N);
			N+=200;
		}
		graph.graph(x,heapTimes,Color.RED);
	 	graph.graph(x,bagTimes,Color.BLUE);
	 	graph.display();
	}

	public void createStructures(int N, Heap h, IntArrayBag b, long numIter){
		h = new Heap();
		b = new IntArrayBag();
		for(int i = 0; i < numIter; i++){
			h.add(N-1);
			b.add(N);
		}
	}
	public int bagTime(IntArrayBag b, long numIter, int N){
		long startTime, stopTime;
	 	startTime = System.currentTimeMillis();
		for(long i = 0; i < numIter; i++){
			b.add(N);
			b.remove(N);
		}
		stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
	}
	public int heapTime(Heap h, long numIter, int N){
		long startTime, stopTime;
	 	startTime = System.currentTimeMillis();
	 	for(long i = 0; i < numIter;i++){
	 		h.add(N);
	 		h.removeMax();
	 	}
	 	stopTime = System.currentTimeMillis();
		return (int)(stopTime-startTime);
	}
	// public int N = 1000;
	// public long ADDED_BAG = 1000000L; 
	// public long ADDED_HEAP = 1000000L; 

	// public static void main(String[] args){
	// 	Graph obj = new Graph();
	// 	Grapher2 graph = new Grapher2();
	// 	IntArrayBag bag = new IntArrayBag();
	// 	Heap heap = new Heap();
	// 	double[] heapTimes = new double[5];
	// 	double[] bagTimes = new double[5];
	// 	double[] x = {0,1,2,3,4};
	// 	for(int i = 0; i < 5; i++){
	// 		obj.createStructures(bag,heap);
	// 		obj.ADDED_BAG+=obj.ADDED_BAG;
	// 		obj.ADDED_HEAP+=obj.ADDED_HEAP;
	// 		heapTimes[i] = obj.heapTime(obj.ADDED_HEAP,heap);
	// 		bagTimes[i] = obj.bagTime(obj.ADDED_BAG,bag);
	// 	}
	// 	graph.graph(x,heapTimes,Color.RED);
	// 	graph.graph(x,bagTimes,Color.BLUE);
	// 	graph.display();
	// }
	// public int bagTime(long numTimes, IntArrayBag bag){
	// 	long startTime, stopTime;
	// 	startTime = System.currentTimeMillis();
	// 	for(long i = 0; i < numTimes; i++){
	// 		bag.add(N);
	// 		bag.remove(N);
	// 	}
	// 	stopTime = System.currentTimeMillis();
	// 	return (int)(stopTime-startTime);
	// }
	// public int heapTime(long numTimes, Heap heap){
	// 	long startTime, stopTime;
	// 	startTime = System.currentTimeMillis();
	// 	for(long i = 0; i < numTimes; i++){
	// 		heap.add(N);
	// 		heap.removeMax();
	// 	}
	// 	stopTime = System.currentTimeMillis();
	// 	return (int)(stopTime-startTime);
	// }
	// public void createStructures(IntArrayBag bag, Heap heap){
	// 	bag = new IntArrayBag();
	// 	heap =  new Heap();
	// 	for(long i = ADDED_BAG; i < this.ADDED_BAG; i++){
	// 		bag.add(N);
	// 	}
	// 	for(long i = ADDED_HEAP; i < this.ADDED_HEAP; i++){
	// 		heap.add(N-1);
	// 	}
	// }
}