package benchmarks_test

import (
	"testing"
	"sort"
	"math/rand"
)

// functions

func StandardSort(arr []int) []int {
	sort.Ints(arr)
	return arr
}	

func BubbleSort(arr []int) []int {
	for i:= 0; i < len(arr) - 1; i++ {
		for j:=0; j < len(arr) - i - 1; j++ {
			if(arr[j] > arr[j + 1]){
				arr[j], arr[j + 1] = arr[j + 1], arr[j]
			}
		}
	}
	return arr
}

func LinearSearch(arr []int, elem int) bool {
	found := false
	for i:=0; i < len(arr); i++ {
		if(arr[i] == elem){
			found = true
			break
		}
	}
	return found
}

// benchmarks
func BenchmarkStdSortA(b *testing.B){
	arr := rand.Perm(50)
	b.ResetTimer()
	for i:=0; i < b.N; i++ {
		StandardSort(arr)
	}
}

func BenchmarkStdSortB(b *testing.B){
	arr := rand.Perm(100)
	b.ResetTimer()
	for i:=0; i < b.N; i++ {
		StandardSort(arr)
	}
}

func BenchmarkStdSortC(b *testing.B){
	arr := rand.Perm(500)
	b.ResetTimer()
	for i:=0; i < b.N; i++ {
		StandardSort(arr)
	}
}

func BenchmarkStdSortD(b *testing.B){
	arr := rand.Perm(1000)
	b.ResetTimer()
	for i:=0; i < b.N; i++ {
		StandardSort(arr)
	}
}

func BenchmarkBubbleSortA(b *testing.B){
	arr := rand.Perm(50)
	b.ResetTimer()
	for i:=0; i < b.N; i++ {
		BubbleSort(arr)
	}
}

func BenchmarkBubbleSortB(b *testing.B){
	arr := rand.Perm(100)
	b.ResetTimer()
	for i:=0; i < b.N; i++ {
		BubbleSort(arr)
	}
}

func BenchmarkBubbleSortC(b *testing.B){
	arr := rand.Perm(500)
	b.ResetTimer()
	for i:=0; i < b.N; i++ {
		BubbleSort(arr)
	}
}

func BenchmarkBubbleSortD(b *testing.B){
	arr := rand.Perm(1000)
	b.ResetTimer()
	for i:=0; i < b.N; i++ {
		BubbleSort(arr)
	}
}

func BenchmarkLinearSearchA(b *testing.B){
	arr := rand.Perm(50)
	b.ResetTimer()
	for i:=0; i < b.N; i++ {
		LinearSearch(arr, 42)
	}
}

func BenchmarkLinearSearchB(b *testing.B){
	arr := rand.Perm(100)
	b.ResetTimer()
	for i:=0; i < b.N; i++ {
		LinearSearch(arr, 42)
	}
}

func BenchmarkLinearSearchC(b *testing.B){
	arr := rand.Perm(500)
	b.ResetTimer()
	for i:=0; i < b.N; i++ {
		LinearSearch(arr, 42)
	}
}

func BenchmarkLinearSearchD(b *testing.B){
	arr := rand.Perm(1000)
	b.ResetTimer()
	for i:=0; i < b.N; i++ {
		LinearSearch(arr, 42)
	}
}