package jp.benchmark;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class SearchBenchmark {
    // State classes - somehow inherit from a base?
    @State(Scope.Thread)
    public static class BenchStateA {
        public int size = 50;
        public int[] arr;

        @Setup(Level.Invocation)
        public void RandomisedArray() {
            Random rd = new Random();
            arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = rd.nextInt(size);
            }
        }
    }

    @State(Scope.Thread)
    public static class BenchStateB {
        public int size = 100;
        public int[] arr;

        @Setup(Level.Invocation)
        public void RandomisedArray() {
            Random rd = new Random();
            arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = rd.nextInt(size);
            }
        }
    }

    @State(Scope.Thread)
    public static class BenchStateC {
        public int size = 500;
        public int[] arr;

        @Setup(Level.Invocation)
        public void RandomisedArray() {
            Random rd = new Random();
            arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = rd.nextInt(size);
            }
        }
    }

    @State(Scope.Thread)
    public static class BenchStateD {
        public int size = 1000;
        public int[] arr;

        @Setup(Level.Invocation)
        public void RandomisedArray() {
            Random rd = new Random();
            arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = rd.nextInt(size);
            }
        }
    }

    // Functions
    public boolean StandardSearch(int[] arr, int element) {
        return Arrays.asList(arr).contains(element);
    }

    public boolean LinearSearch(int[] arr, int element) {
        boolean exists = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    // Benchmarks
    @Benchmark
    public void stdSearchA(BenchStateA state) {
        StandardSearch(state.arr, 42);
    }

    @Benchmark
    public void stdSearchB(BenchStateB state) {
        StandardSearch(state.arr, 42);
    }

    @Benchmark
    public void stdSearchC(BenchStateC state) {
        StandardSearch(state.arr, 42);
    }

    @Benchmark
    public void stdSearchD(BenchStateD state) {
        StandardSearch(state.arr, 42);
    }

    @Benchmark
    public void linSearchA(BenchStateA state) {
        LinearSearch(state.arr, 42);
    }

    @Benchmark
    public void linSearchB(BenchStateB state) {
        LinearSearch(state.arr, 42);
    }

    @Benchmark
    public void linSearchC(BenchStateC state) {
        LinearSearch(state.arr, 42);
    }

    @Benchmark
    public void linSearchD(BenchStateD state) {
        LinearSearch(state.arr, 42);
    }

    // Run
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SearchBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
