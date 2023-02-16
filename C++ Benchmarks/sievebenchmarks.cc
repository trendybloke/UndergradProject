#include <benchmark/benchmark.h>
#include <vector>

// functions
static std::vector<int> IterativeSieve(int limit){
    std::vector<bool> isPrime;

    for(int i = 0; i < limit; i++){
        isPrime.push_back(true);
    }

    for(int i = 2; i * i < limit; i++){
        if(isPrime[i]){
            for(int j = i * i; j < limit; j+= i){
                isPrime[j] = false;
            }
        }
    }

    std::vector<int> primes;
    
    for(int i = 0; i < limit - 2; i++){
        if(isPrime[i]){
            primes.push_back(i);
        }
    }

    return primes;
}

static std::vector<int> SegmentedSieve(int limit){
        std::vector<bool> isPrime;

    for(int i = 0; i < limit; i++){
        isPrime.push_back(true);
    }

    for(int lowerBound = 2; lowerBound < limit; lowerBound += (limit / 4) - 2){
        int upperBound = lowerBound + (limit / 4);
        for(int i = lowerBound; i * i < upperBound; i++){
            if(isPrime[i]){
                for(int j = i * i; j < upperBound; j+= i){
                    isPrime[j] = false;
                }
            }
        }
    }

    std::vector<int> primes;
    
    for(int i = 0; i < limit - 2; i++){
        if(isPrime[i]){
            primes.push_back(i);
        }
    }

    return primes;
}

// benchmarks
static void BM_IterSieveHundred(benchmark::State& state){
    for(auto _ : state){
        std::vector<int> primes = IterativeSieve(100);
    }
}
BENCHMARK(BM_IterSieveHundred);

static void BM_IterSieveTwoHundred(benchmark::State& state){
    for(auto _ : state){
        std::vector<int> primes = IterativeSieve(200);
    }
}
BENCHMARK(BM_IterSieveTwoHundred);

static void BM_IterSieveFiveHundred(benchmark::State& state){
    for(auto _ : state){
        std::vector<int> primes = IterativeSieve(500);
    }
}
BENCHMARK(BM_IterSieveFiveHundred);

static void BM_IterSieveThousand(benchmark::State& state){
    for(auto _ : state){
        std::vector<int> primes = IterativeSieve(1000);
    }
}
BENCHMARK(BM_IterSieveThousand);

static void BM_SegSieveHundred(benchmark::State& state){
    for(auto _ : state){
        std::vector<int> primes = SegmentedSieve(100);
    }
}
BENCHMARK(BM_SegSieveHundred);

static void BM_SegSieveTwoHundred(benchmark::State& state){
    for(auto _ : state){
        std::vector<int> primes = SegmentedSieve(200);
    }
}
BENCHMARK(BM_SegSieveTwoHundred);

static void BM_SegSieveFiveHundred(benchmark::State& state){
    for(auto _ : state){
        std::vector<int> primes = SegmentedSieve(500);
    }
}
BENCHMARK(BM_SegSieveFiveHundred);

static void BM_SegSieveThousand(benchmark::State& state){
    for(auto _ : state){
        std::vector<int> primes = SegmentedSieve(1000);
    }
}
BENCHMARK(BM_SegSieveThousand);