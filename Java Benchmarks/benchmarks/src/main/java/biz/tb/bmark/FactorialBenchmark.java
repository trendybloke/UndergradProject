package biz.tb.bmark;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class FactorialBenchmark {

    // Functions
    public int iterativeFactorial(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public int recursiveFactorial(int num) {
        if (num <= 1)
            return 1;
        else
            return num * recursiveFactorial(num - 1);
    }

    // Benchmarks
    @Benchmark
    public void iterFactA() {
        iterativeFactorial(5);
    }

    @Benchmark
    public void iterFactB() {
        iterativeFactorial(10);
    }

    @Benchmark
    public void iterFactC() {
        iterativeFactorial(15);
    }

    @Benchmark
    public void iterFactD() {
        iterativeFactorial(20);
    }

    @Benchmark
    public void recFactA() {
        recursiveFactorial(5);
    }

    @Benchmark
    public void recFactB() {
        recursiveFactorial(10);
    }

    @Benchmark
    public void recFactC() {
        recursiveFactorial(15);
    }

    @Benchmark
    public void recFactD() {
        recursiveFactorial(20);
    }

    // Run
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(FactorialBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
