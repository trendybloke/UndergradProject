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
public class SortBenchmark {

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
    public void StandardSort(int[] arr) {
        Arrays.sort(arr);
    }

    public void BubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Benchmarks
    @Benchmark
    public void stdSortA(BenchStateA state) {
        StandardSort(state.arr);
    }

    @Benchmark
    public void stdSortB(BenchStateB state) {
        StandardSort(state.arr);
    }

    @Benchmark
    public void stdSortC(BenchStateC state) {
        StandardSort(state.arr);
    }

    @Benchmark
    public void stdSortD(BenchStateD state) {
        StandardSort(state.arr);
    }

    @Benchmark
    public void bblSortaA(BenchStateA state) {
        BubbleSort(state.arr);
    }

    @Benchmark
    public void bblSortaB(BenchStateB state) {
        BubbleSort(state.arr);
    }

    @Benchmark
    public void bblSortaC(BenchStateC state) {
        BubbleSort(state.arr);
    }

    @Benchmark
    public void bblSortaD(BenchStateD state) {
        BubbleSort(state.arr);
    }

    // Run
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SortBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
