// Ben Pierce (bgp12)
public class Example1 {

    public static final int NUM_ITERATIONS = 7;//number of times ADDEND is added to N
    public static final long ADDEND = 10000000000L; //number added to N each loo
    public static final long START = 100000L; // starting value of N

    public static void main(String[] args) {
        long N = START;
        System.out.println("------ Algorithim 1 ------");
        for(int i = 0; i < NUM_ITERATIONS; i++){
            System.out.println("N = " + N + " Time Elapsed: " + alg1(N) + "ms"); //I could've just slapped the other 2 algs into this program, but I just made 3 programs b/c it was easier
            N += ADDEND;
        }
        
    }
    public static long alg1(long N){
        long startTime, stopTime; // For recording start/stop times
        long x = 0;
        startTime = System.currentTimeMillis();
        for (long i = 0; i < N; i++) {
            x = x + 1;
        }
        stopTime = System.currentTimeMillis();
        return stopTime - startTime; 
    }
}
