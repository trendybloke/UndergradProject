#include <benchmark/benchmark.h>
#include <vector>

using namespace std;

// functions
static void StandardSort(std::vector<int> arr){
    std::sort(arr.begin(), arr.end());
}

static void BubbleSort(std::vector<int> arr){
    for(int i = 0; i < arr.size() - 1; i++){
        for(int j = 0; j < arr.size() - i - 1; j++){
            if(arr[j] > arr[j + 1])
                swap(arr[j], arr[j + 1]);
        }
    }
}

static bool StandardSearch(std::vector<int> arr, int elem){
    std::vector<int>::iterator it;
    it = std::find(arr.begin(), arr.end(), elem);
    return it != arr.end();
}

static bool LinearSearch(std::vector<int> arr, int elem){
    for(int i = 0; i < arr.size(); i++){
        if(arr[i] == elem){
            return true;
        }
    }
    return false;
}

// setup
static std::vector<int> RandomArray(int size){
    std::vector<int> arr;
    for(int i=0; i < size; i++){
        arr.push_back(rand()%size);
    }
    return arr;
}

// benchmarks
static void BM_StdSortA(benchmark::State& state){
    for(auto _ : state){
        StandardSort(RandomArray(50));
    }
}
BENCHMARK(BM_StdSortA);

static void BM_StdSortB(benchmark::State& state){
    for(auto _ : state){
        StandardSort(RandomArray(100));
    }
}
BENCHMARK(BM_StdSortB);

static void BM_StdSortC(benchmark::State& state){
    for(auto _ : state){
        StandardSort(RandomArray(500));
    }
}
BENCHMARK(BM_StdSortC);

static void BM_StdSortD(benchmark::State& state){
    for(auto _ : state){
        StandardSort(RandomArray(1000));
    }
}
BENCHMARK(BM_StdSortD);

static void BM_BubbleSortA(benchmark::State& state){
    for(auto _ : state){
        BubbleSort(RandomArray(50));
    }
}
BENCHMARK(BM_BubbleSortA);

static void BM_BubbleSortB(benchmark::State& state){
    for(auto _ : state){
        BubbleSort(RandomArray(100));
    }
}
BENCHMARK(BM_BubbleSortB);

static void BM_BubbleSortC(benchmark::State& state){
    for(auto _ : state){
        BubbleSort(RandomArray(500));
    }
}
BENCHMARK(BM_BubbleSortC);

static void BM_BubbleSortD(benchmark::State& state){
    for(auto _ : state){
        BubbleSort(RandomArray(1000));
    }
}
BENCHMARK(BM_BubbleSortD);

static void BM_StdSearchA(benchmark::State& state){
    for(auto _ : state){
        StandardSearch(RandomArray(50), 42);
    }
}
BENCHMARK(BM_StdSearchA);

static void BM_StdSearchB(benchmark::State& state){
    for(auto _ : state){
        StandardSearch(RandomArray(100), 42);
    }
}
BENCHMARK(BM_StdSearchB);

static void BM_StdSearchC(benchmark::State& state){
    for(auto _ : state){
        StandardSearch(RandomArray(500), 42);
    }
}
BENCHMARK(BM_StdSearchC);

static void BM_StdSearchD(benchmark::State& state){
    for(auto _ : state){
        StandardSearch(RandomArray(1000), 42);
    }
}
BENCHMARK(BM_StdSearchD);

static void BM_LinearSearchA(benchmark::State& state){
    for(auto _ : state){
        LinearSearch(RandomArray(50), 42);
    }
}
BENCHMARK(BM_LinearSearchA);

static void BM_LinearSearchB(benchmark::State& state){
    for(auto _ : state){
        LinearSearch(RandomArray(100), 42);
    }
}
BENCHMARK(BM_LinearSearchB);

static void BM_LinearSearchC(benchmark::State& state){
    for(auto _ : state){
        LinearSearch(RandomArray(500), 42);
    }
}
BENCHMARK(BM_LinearSearchC);

static void BM_LinearSearchD(benchmark::State& state){
    for(auto _ : state){
        LinearSearch(RandomArray(1000), 42);
    }
}
BENCHMARK(BM_LinearSearchD);