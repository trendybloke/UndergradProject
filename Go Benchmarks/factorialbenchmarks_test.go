package benchmarks_test

import "fmt"
import "testing"

func main()	{
	fmt.Println("Run benchmarks using 'go test -bench .'")
}

// functions
func IterativeFactorial(num int) int {
	var result = 1
	for i := 1; i <= num; i++ {
		result = result * i
	}
	return result
}

func RecursiveFactorial(num int) int {
	if num <= 1 {
		return 1
	}
	return num * RecursiveFactorial(num - 1)
}

// benchmarks
func BenchmarkIterFactFive(b *testing.B){
	for i:= 0; i < b.N; i++ {
		IterativeFactorial(5)
	}
}

func BenchmarkIterFactTen(b *testing.B){
	for i:= 0; i < b.N; i++ {
		IterativeFactorial(10)
	}
}

func BenchmarkIterFactFifteen(b *testing.B){
	for i:= 0; i < b.N; i++ {
		IterativeFactorial(15)
	}
}

func BenchmarkIterFactTwenty(b *testing.B){
	for i:= 0; i < b.N; i++ {
		IterativeFactorial(20)
	}
}

func BenchmarkRecFactFive(b *testing.B){
	for i:= 0; i < b.N; i++ {
		RecursiveFactorial(5)
	}
}

func BenchmarkRecFactTen(b *testing.B){
	for i:= 0; i < b.N; i++ {
		RecursiveFactorial(10)
	}
}

func BenchmarkRecFactFifteen(b *testing.B){
	for i:= 0; i < b.N; i++ {
		RecursiveFactorial(15)
	}
}

func BenchmarkRecFactTwenty(b *testing.B){
	for i:= 0; i < b.N; i++ {
		RecursiveFactorial(20)
	}
}