#include <benchmark/benchmark.h>

// functions
static int IterativeFactorial(int num){
    int result = 1;
    for(int i = 1; i <= num; i++){
        result = result * i;
    }
    return result;
}

static int RecursiveFactorial(int num){
    if(num <= 1){
        return 1;
    }
    else{
        return num * RecursiveFactorial(num - 1);
    }
}

// benchmarks
static void BM_IterFactFive(benchmark::State& state){
    for(auto _ : state){
        int FactFive = IterativeFactorial(5);
    }
}
BENCHMARK(BM_IterFactFive);

static void BM_IterFactTen(benchmark::State& state){
    for(auto _ : state){
        int FactTen = IterativeFactorial(10);
    }
}
BENCHMARK(BM_IterFactTen);

static void BM_IterFactFifteen(benchmark::State& state){
    for(auto _ : state){
        int FactFive = IterativeFactorial(15);
    }
}
BENCHMARK(BM_IterFactFifteen);

static void BM_IterFactTwenty(benchmark::State& state){
    for(auto _ : state){
        int FactFive = IterativeFactorial(20);
    }
}
BENCHMARK(BM_IterFactTwenty);

static void BM_RecFactFive(benchmark::State& state){
    for(auto _ : state){
        int FactFive = RecursiveFactorial(5);
    }
}
BENCHMARK(BM_RecFactFive);

static void BM_RecFactTen(benchmark::State& state){
    for(auto _ : state){
        int FactTen = RecursiveFactorial(10);
    }
}
BENCHMARK(BM_RecFactTen);

static void BM_RecFactFifteen(benchmark::State& state){
    for(auto _ : state){
        int FactFive = RecursiveFactorial(15);
    }
}
BENCHMARK(BM_RecFactFifteen);

static void BM_RecFactTwenty(benchmark::State& state){
    for(auto _ : state){
        int FactFive = RecursiveFactorial(20);
    }
}
BENCHMARK(BM_RecFactTwenty);