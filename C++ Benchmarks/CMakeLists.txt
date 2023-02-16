cmake_minimum_required(VERSION 3.14)
project(benchmarks)
enable_testing()

# File courtesy of https://stackoverflow.com/a/64853449

include(FetchContent)

## Project-wide setup
set(CMAKE_CXX_STANDARD 14)
set(CMAKE_CXX_STANDARD_REQUIRED YES)
set(CMAKE_CXX_EXTENSIONS NO)

# Externally provided libraries
FetchContent_Declare(googletest
        GIT_REPOSITORY https://github.com/google/googletest.git
        GIT_TAG v1.10.x)
    
FetchContent_Declare(googlebenchmark
        GIT_REPOSITORY https://github.com/google/benchmark.git
        GIT_TAG main)

FetchContent_MakeAvailable(
    googletest
    googlebenchmark)

add_executable(benchmarks main.cc)
target_link_libraries(benchmarks benchmark::benchmark)