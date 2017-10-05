// Ben Pierce (bgp12)
public class Example2 {
    public static final int NUM_ITERATIONS = 7;
    public static final long ADDEND = 100000L;
    public static final long START = 0L;
    public static void main(String[] args) {
        long N = START;
        System.out.println("------ Algorithim 2 ------");
        for(int i = 0; i < NUM_ITERATIONS; i++){
            System.out.println("N = " + N + " Time Elapsed: " + alg2(N) + "ms");
            N += ADDEND;
        }
    }

    public static long alg2(long N){
        long startTime, stopTime; // For recording start/stop times
        long x = 0;
        startTime = System.currentTimeMillis();
        for (long i = 0; i < N; i++) {
            for (long j = 0; j < N; j++) {
                x = x + 1;
            }
        }
        stopTime = System.currentTimeMillis();
        return(stopTime - startTime);
    }
}

