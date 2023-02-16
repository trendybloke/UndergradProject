using BenchmarkSuite;
using BenchmarkDotNet.Configs;
using BenchmarkDotNet.Running;
using BenchmarkDotNet.Loggers;

var config = new ManualConfig()
    .WithOptions(ConfigOptions.DisableOptimizationsValidator)
    .AddLogger(ConsoleLogger.Default);

// Run factorial tests
var factSummary = BenchmarkRunner
                .Run<Factorial>(config);

// Run sieve tests
var sieveSummary = BenchmarkRunner.Run<Eratosthenes>(config);

// Run algo tests
var algoSummary = BenchmarkRunner.Run<Algo>(config);

Console.ReadKey();