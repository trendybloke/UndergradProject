package biz.tb.bmark;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class SieveBenchmark {

    // Functions
    public List<Integer> iterativeSieve(int limit) {
        // initialise primes
        boolean[] primes = new boolean[limit];

        for (int i = 0; i < limit; i++) {
            primes[i] = true;
        }

        // perform sieve
        for (int i = 2; i < Math.sqrt(limit) - i; i++) {
            if (primes[i]) {
                for (int j = i * i; j < limit; j += i) {
                    primes[j] = false;
                }
            }
        }

        // generate values
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            if (primes[i]) {
                results.add(i);
            }
        }

        return results;
    }

    static void segmentedSieve(int n) {
        int limit = (int) (Math.floor(Math.sqrt(n)) + 1);
        Vector<Integer> prime = new Vector<>();

        int low = limit;
        int high = 2 * limit;

        // Start segments
        while (low < n) {
            if (high >= n)
                high = n;

            // initialise primes
            boolean mark[] = new boolean[limit + 1];

            for (int i = 0; i < mark.length; i++)
                mark[i] = true;

            // perform sieve
            for (int i = 0; i < prime.size(); i++) {
                int loLim = (int) (Math.floor(low / prime.get(i)) * prime.get(i));
                if (loLim < low)
                    loLim += prime.get(i);

                for (int j = loLim; j < high; j += prime.get(i))
                    mark[j - low] = false;
            }

            // Store results
            ArrayList<Integer> results = new ArrayList<>();
            for (int i = low; i < high; i++)
                if (mark[i - low] == true)
                    results.add(i);

            // Update low and high for next segment
            low = low + limit;
            high = high + limit;
        }
    }

    @Benchmark
    public void iterSieveA() {
        iterativeSieve(100);
    }

    @Benchmark
    public void iterSieveB() {
        iterativeSieve(200);
    }

    @Benchmark
    public void iterSieveC() {
        iterativeSieve(500);
    }

    @Benchmark
    public void iterSieveD() {
        iterativeSieve(1000);
    }

    @Benchmark
    public void segSieveA() {
        segmentedSieve(100);
    }

    @Benchmark
    public void segSieveB() {
        segmentedSieve(200);
    }

    @Benchmark
    public void segSieveC() {
        segmentedSieve(500);
    }

    @Benchmark
    public void segSieveD() {
        segmentedSieve(1000);
    }

    // Run
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SieveBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
