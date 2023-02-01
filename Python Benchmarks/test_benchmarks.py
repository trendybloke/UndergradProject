""" 
Benchmarks in Python.
"""
import math
import random #use random.sample(range(lower, upper), limit)

# Benchmarks
def iterative_factorial(num):
    """
    Returns the factorial of a number iteratively, using for
    """
    result = 1
    for i in range(1, num + 1):
        result = result * i
    return result

def recursive_factorial(number):
    """
    Returns the factorial of a number recursively
    """
    if number <= 1: 
        return 1
    else: 
        return number * recursive_factorial(number - 1)

def iterative_sieve(limit):
    """
    Generates prime numbers up to a given limit
    """
    prime = [True for i in range(limit)]
    
    for i in range(2, int(math.sqrt(limit) - 1)):
        if prime[i] == True:
            for j in range(i*i, limit, i):
                prime[j] = False
    
    results = []
    for i in range(0, limit):
        if prime[i] == True:
            results.append(i)
            
    return results

def segmented_sieve(limit):
    """ 
    Generates prime numbers up to a given limit. work is segmented
    so less memory is used overall.
    """
    prime = [True for i in range(limit)]

    step = limit // 4

    for lowerBound in range(0, limit, step):
        upperBound = lowerBound + step
        for i in range(lowerBound, int(math.sqrt(upperBound) - 1)):
            if prime[i] == True and i > 1:
                for j in range(i*i, limit, i):
                    prime[j] = False
    results = []
    for i in range(0, limit):
        if prime[i] == True:
            results.append(i)
            
    return results

def standard_sort(list):
    """ 
    Uses standard list sort to sort a random list
    """
    return list.sort()

def bubble_sort(list):
    """
    Performs a bubble sort on the list
    """
    for i in range(len(list)):
        for j in range(0, len(list) - i - 1):
            if list[j] > list[j + 1]:
                temp = list[j]
                list[j] = list[i]
                list[i] = temp
    return list

def standard_search(list, item):
    """
    Uses the 'in' operator to find an item in a list
    """
    return item in list

# Tests
def test_iter_fact_five(benchmark):
    result = benchmark(iterative_factorial, 5)
    assert result == 120
    
def test_iter_fact_ten(benchmark):
    result = benchmark(iterative_factorial, 10)
    assert result == 3628800
    
def test_iter_fact_fifteen(benchmark):
    result = benchmark(iterative_factorial, 15)
    assert result == 15 * 14 * 13 * 12 * 11 * 3628800
    
def test_iter_fact_twenty(benchmark):
    result = benchmark(iterative_factorial, 20)
    assert result == 20 * 19 * 18 * 17 * 16 * 15 * 14 * 13 * 12 * 11 * 3628800

def test_recter_fact_five(benchmark):
    result = benchmark(recursive_factorial, 5)
    assert result == 120
    
def test_reciter_fact_ten(benchmark):
    result = benchmark(recursive_factorial, 10)
    assert result == 3628800
    
def test_rec_fact_fifteen(benchmark):
    result = benchmark(recursive_factorial, 15)
    assert result == 15 * 14 * 13 * 12 * 11 * 3628800
    
def test_recr_fact_twenty(benchmark):
    result = benchmark(recursive_factorial, 20)
    assert result == 20 * 19 * 18 * 17 * 16 * 15 * 14 * 13 * 12 * 11 * 3628800

def test_iter_sieve_hundred(benchmark):
    benchmark(iterative_sieve, 100)
    
def test_iter_sieve_two_hundred(benchmark):
    benchmark(iterative_sieve, 200)

def test_iter_sieve_five_hundred(benchmark):
    benchmark(iterative_sieve, 500)
    
def test_iter_sieve_thousand(benchmark):
    benchmark(iterative_sieve, 1000)
    
def test_seg_sieve_hundred(benchmark):
    benchmark(segmented_sieve, 100)
    
def test_seg_sieve_two_hundred(benchmark):
    benchmark(segmented_sieve, 200)
    
def test_seg_sieve_five_hundred(benchmark):
    benchmark(segmented_sieve, 500)
    
def test_seg_sieve_thousand(benchmark):
    benchmark(segmented_sieve, 1000)

def test_std_sort_fifty(benchmark):
    benchmark(standard_sort, random.sample(range(50), 50))

def test_std_sort_hundred(benchmark):
    benchmark(standard_sort, random.sample(range(100), 100))

def test_std_sort_five_hundred(benchmark):
    benchmark(standard_sort, random.sample(range(500), 500))

def test_std_sort_thousand(benchmark):
    benchmark(standard_sort, random.sample(range(1000), 1000))

def test_bubble_sort_fifty(benchmark):
    benchmark(bubble_sort, random.sample(range(50), 50))

def test_bubble_sort_hundred(benchmark):
    benchmark(bubble_sort, random.sample(range(100), 100))

def test_bubble_sort_five_hundred(benchmark):
    benchmark(bubble_sort, random.sample(range(500), 500))

def test_bubble_sort_thousand(benchmark):
    benchmark(bubble_sort, random.sample(range(1000), 1000))

def test_std_search_fifty(benchmark):
    benchmark(standard_search, random.sample(range(50), 50), random.randint(1, 50))

def test_std_search_hundred(benchmark):
    benchmark(standard_search, random.sample(range(100), 100), random.randint(1, 100))

def test_std_search_five_hundred(benchmark):
    benchmark(standard_search, random.sample(range(500), 500), random.randint(1, 500))

def test_std_search_thousand(benchmark):
    benchmark(standard_search, random.sample(range(1000), 1000), random.randint(1, 1000))