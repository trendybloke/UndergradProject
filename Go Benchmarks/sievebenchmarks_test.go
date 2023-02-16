package benchmarks_test

import "testing"

// functions
func IterativeSieve(limit int) [] int {
	prime := make([]bool, limit + 1)

	for i:= 0; i < limit + 1; i++ {
		prime[i] = true
	}

	for i:= 2; i*i <= limit; i++{
		if prime[i] == true {
			for j := i * i; j < limit; j += i{
				prime[j] = false;
			} 
		}
	}

	result := make([]int, limit)

	for i:=0; i <= limit; i++ {
		if prime[i] == true {
			result = append(result, i)
		}
	}

	return result
}

func SegmentedSieve(limit int) [] int {
	prime := make([]bool, limit + 1)

	step := limit / 4

	for i:= 0; i < limit + 1; i++ {
		prime[i] = true
	}

	for lowerBound := 0; lowerBound < limit; lowerBound += step{
		upperBound := lowerBound + step
		for i:= lowerBound; i*i <= upperBound - 1; i++{
			if prime[i] == true && i > 1 {
				for j := i * i; j < limit; j += i{
					prime[j] = false;
				} 
			}
		}
	}

	result := make([]int, limit)

	for i:=0; i <= limit; i++ {
		if prime[i] == true {
			result = append(result, i)
		}
	}

	return result
}

//benchmarks
func BenchmarkIterSieveHundred(b *testing.B){
	for i:=0; i < b.N; i++ {
		IterativeSieve(100)
	}
}

func BenchmarkIterSieveTwoHundred(b *testing.B){
	for i:=0; i < b.N; i++ {
		IterativeSieve(200)
	}
}

func BenchmarkIterSieveFiveHundred(b *testing.B){
	for i:=0; i < b.N; i++ {
		IterativeSieve(500)
	}
}

func BenchmarkIterSieveThousand(b *testing.B){
	for i:=0; i < b.N; i++ {
		IterativeSieve(1000)
	}
}

func BenchmarkSegSieveHundred(b *testing.B){
	for i:=0; i < b.N; i++ {
		SegmentedSieve(100)
	}
}

func BenchmarkSegSieveTwoHundred(b *testing.B){
	for i:=0; i < b.N; i++ {
		SegmentedSieve(200)
	}
}

func BenchmarkSegSieveFiveHundred(b *testing.B){
	for i:=0; i < b.N; i++ {
		SegmentedSieve(500)
	}
}

func BenchmarkSegSieveThousand(b *testing.B){
	for i:=0; i < b.N; i++ {
		SegmentedSieve(1000)
	}
}