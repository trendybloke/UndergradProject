using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BenchmarkDotNet.Attributes;

namespace BenchmarkSuite
{
    public class Algo
    {
        Random rng = new Random(DateTime.Today.Day + DateTime.Today.Month + DateTime.Today.Year);

        [Params (50, 100, 500, 1000)]
        public int ArraySize { get; set; }

        public int[] Arr { get; set; }

        [IterationSetup]
        public void BuildArr()
        {
            Arr = new int[ArraySize];

            Array.Fill<int>(Arr, rng.Next(0, ArraySize));
        }

        [Benchmark]
        public void ArrayClassSort()
        {
            // BuildArr();
            Array.Sort(Arr);
        }

        [Benchmark]
        public void BubbleSort()
        {
            // BuildArr();
            int temp = 0;
            for(int i = 0; i < Arr.Length; i++)
            {
                for(int j = 0; j < Arr.Length - 1; j++)
                {
                    if(Arr[j] > Arr[j + 1])
                    {
                        temp = Arr[j + 1];
                        Arr[j + 1] = Arr[j];
                        Arr[j] = temp;
                    }
                }
            }
        }

        [Benchmark]
        public void ArrayClassSearch()
        {
            Array.BinarySearch(Arr, 42);
        }

        [Benchmark]
        public void LinearSearch()
        {
            bool exists = false;
            for(var i = 0; i < Arr.Length; i++)
            {
                exists = Arr[i] == 42;
                if (exists)
                {
                    break;
                }
            }
        }
    }
}
