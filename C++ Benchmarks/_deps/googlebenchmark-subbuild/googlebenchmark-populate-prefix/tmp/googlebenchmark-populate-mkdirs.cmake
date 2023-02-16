# Distributed under the OSI-approved BSD 3-Clause License.  See accompanying
# file Copyright.txt or https://cmake.org/licensing for details.

cmake_minimum_required(VERSION 3.5)

file(MAKE_DIRECTORY
  "C:/Users/joshp/Desktop/uni work/Year 3/Project/C++ Benchmarks/_deps/googlebenchmark-src"
  "C:/Users/joshp/Desktop/uni work/Year 3/Project/C++ Benchmarks/_deps/googlebenchmark-build"
  "C:/Users/joshp/Desktop/uni work/Year 3/Project/C++ Benchmarks/_deps/googlebenchmark-subbuild/googlebenchmark-populate-prefix"
  "C:/Users/joshp/Desktop/uni work/Year 3/Project/C++ Benchmarks/_deps/googlebenchmark-subbuild/googlebenchmark-populate-prefix/tmp"
  "C:/Users/joshp/Desktop/uni work/Year 3/Project/C++ Benchmarks/_deps/googlebenchmark-subbuild/googlebenchmark-populate-prefix/src/googlebenchmark-populate-stamp"
  "C:/Users/joshp/Desktop/uni work/Year 3/Project/C++ Benchmarks/_deps/googlebenchmark-subbuild/googlebenchmark-populate-prefix/src"
  "C:/Users/joshp/Desktop/uni work/Year 3/Project/C++ Benchmarks/_deps/googlebenchmark-subbuild/googlebenchmark-populate-prefix/src/googlebenchmark-populate-stamp"
)

set(configSubDirs Debug)
foreach(subDir IN LISTS configSubDirs)
    file(MAKE_DIRECTORY "C:/Users/joshp/Desktop/uni work/Year 3/Project/C++ Benchmarks/_deps/googlebenchmark-subbuild/googlebenchmark-populate-prefix/src/googlebenchmark-populate-stamp/${subDir}")
endforeach()
if(cfgdir)
  file(MAKE_DIRECTORY "C:/Users/joshp/Desktop/uni work/Year 3/Project/C++ Benchmarks/_deps/googlebenchmark-subbuild/googlebenchmark-populate-prefix/src/googlebenchmark-populate-stamp${cfgdir}") # cfgdir has leading slash
endif()
