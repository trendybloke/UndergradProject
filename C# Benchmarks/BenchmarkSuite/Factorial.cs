using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BenchmarkDotNet.Attributes;

namespace BenchmarkSuite
{
    public class Factorial
    {
        [Params(5, 10, 15, 20)]
        public int FactorialLimit { get; set; }

        [Benchmark]
        public int IterativeFactorial()
        {
            int number = 1;

            for (int i = 1; i <= FactorialLimit; i++)
                number *= i;

            return number;
        }

        [Benchmark]
        public int RecursiveFactorial()
        {
            return RecursiveFactorial(FactorialLimit);
        }


        public int RecursiveFactorial(int number)
        {
            if (number == 0)
                return 1;

            return number * RecursiveFactorial(number - 1);
        }
    }
}
