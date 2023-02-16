using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BenchmarkDotNet.Attributes;

namespace BenchmarkSuite
{
    public class Eratosthenes
    {
        [Params(100, 200, 500, 1000)]
        public int PrimeLimit { get; set; }

        [Benchmark]
        public List<int> IterativeEratosthenes()
        {
            bool[] isPrime = new bool[PrimeLimit + 1];
            Array.Fill(isPrime, true);

            for (int i = 2; i * i <= PrimeLimit; i++)
            {
                if (isPrime[i])
                {
                    for (int j = i * i; j <= PrimeLimit; j += i)
                    {
                        isPrime[j] = false;
                    }
                }
            }

            List<int> Primes = new List<int>();

            for (int i = 0; i < PrimeLimit - 2; i++)
            {
                if (isPrime[i])
                    Primes.Add(i);
            }

            return Primes;

        }

        [Benchmark]
        public List<int> SegmentedEratosthenes()
        {
            bool[] isPrime = new bool[PrimeLimit + 1];
            Array.Fill(isPrime, true);

            for(int lowerBound = 0; lowerBound < PrimeLimit; lowerBound += PrimeLimit / 4)
            {
                int upperBound = lowerBound + PrimeLimit / 4;
                for (int i = lowerBound; i * i <= upperBound; i++)
                {
                    if (isPrime[i])
                    {
                        for (int j = i * i; j <= upperBound; j += i)
                        {
                            isPrime[j] = false;
                        }
                    }
                }
            }

            List<int> Primes = new List<int>();

            for (int i = 0; i < PrimeLimit - 2; i++)
            {
                if (isPrime[i])
                    Primes.Add(i);
            }

            return Primes;
        }
    }
}
