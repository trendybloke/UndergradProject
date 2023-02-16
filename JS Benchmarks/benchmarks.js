// Setup
const Benchmark = require('benchmark')

// Functions
function iterative_factorial(number){
    let result = 1;
    for(let i = 0; i < number + 1; i++){
        result = result * i;
    }
    return result;
}

function recursive_factorial(number){
    return number <= 1 ? 1 : number * recursive_factorial(number - 1)
}

function iterative_sieve(limit){
    let isPrime = [], output = []

    for(let i = 0; i < limit; i++)
        isPrime.push(true);

    for(let i = 2; i <= Math.sqrt(limit) - 1; i++)
        if (isPrime[i])
            for(let j = i * i; j < limit; j += i)
                isPrime[j] = false;
    
    for(let i = 2; i < limit; i++)
        if(isPrime[i] === true)
            output.push[i]
    
    return output;
}

function segmented_sieve(limit){
    var isPrime = [], output = []
    const step = limit / 4

    for(var i = 0; i < limit; i++)
        isPrime.push(true);

    for(var lowerBound = 0; lowerBound < limit; lowerBound += step)
        var upperBound = lowerBound + step;
        for(var i = lowerBound; i <= Math.sqrt(upperBound) - 1; i++)
            if(isPrime[i] && i > 1)
                for(var j = i * i; j < limit; j += i)
                    isPrime[j] = false;
          
    for(var i = 2; i < limit; i++)
    if(isPrime[i] === true)
        output.push[i]

    return output;
}

function array_sort(list){
    return list.sort()
}

function bubble_sort(list){
    for(var i = 0; i < list.length; i++){
        for(var j = 0; j < (list.length - i - 1); j++){
            if (list[j] > list[j + 1]){
                var temp = list[j]
                list[j] = list[j + 1]
                list[j + 1] = temp
            }
        }
    }
    return list
}

function array_search(list, item){
    return list.find(element => element == item);
}

function linear_search(list, item) {
    let exists = false;
    for(const element of list){
        exists = element == item;
        if(exists){
            break;
        }
    }
    return exists;
}

// Benchmarks

function random_array(size){
    return Array.from(Array(size)).map(x=>Math.floor(Math.random() * size))
}

const suite = new Benchmark.Suite('JS benchmarks');

suite
    .add('Iterative 5!', () => iterative_factorial(5))
    .add('Iterative 10!', () => iterative_factorial(10))
    .add('Iterative 15!', () => iterative_factorial(10))
    .add('Iterative 20!', () => iterative_factorial(20))
    .add('Recursive 5!', () => recursive_factorial(5))
    .add('Recursive 10!', () => recursive_factorial(10))
    .add('Recursive 15!', () => recursive_factorial(15))
    .add('Recursive 20!', () => recursive_factorial(20))
    .add('Iterative Sieve (Limit 100)', () => iterative_sieve(100))
    .add('Iterative Sieve (Limit 200)', () => iterative_sieve(200))
    .add('Iterative Sieve (Limit 500)', () => iterative_sieve(500))
    .add('Iterative Sieve (Limit 1000)', () => iterative_sieve(1000))
    .add('Segmented Sieve (Limit 100)', () => segmented_sieve(100))
    .add('Segmented Sieve (Limit 200)', () => segmented_sieve(200))
    .add('Segmented Sieve (Limit 500', () => segmented_sieve(500))
    .add('Segmented Sieve (Limit 1000)', () => segmented_sieve(1000))
    .add('Standard Sort (50 items)', () => array_sort(random_array(50)))
    .add('Standard Sort (100 items)', () => array_sort(random_array(100)))
    .add('Standard Sort (500 items)', () => array_sort(random_array(500)))
    .add('Standard Sort (1000 items)', () => array_sort(random_array(1000)))
    .add('Bubble Sort (50 items)', () => bubble_sort(random_array(50)))
    .add('Bubble Sort (100 items)', () => bubble_sort(random_array(100)))
    .add('Bubble Sort (500 items)', () => bubble_sort(random_array(500)))
    .add('Bubble Sort (1000 items)', () => bubble_sort(random_array(1000)))
    .add('Standard Search (50 items)', () => array_search(random_array(50), 42))
    .add('Standard Search (100 items)', () => array_search(random_array(100), 42))
    .add('Standard Search (500 items)', () => array_search(random_array(500), 42))
    .add('Standard Search (1000 items)', () => array_search(random_array(1000), 42))
    .add('Linear Search (50 items)', () => linear_search(random_array(50), 42))
    .add('Linear Search (100 items)', () => linear_search(random_array(100), 42))
    .add('Linear Search (500 items)', () => linear_search(random_array(500), 42))
    .add('Linear Search (1000 items)', () => linear_search(random_array(1000), 42))
    .on('cycle', event => {
        const benchmark = event.target;
        console.log(benchmark.toString());
    })
    .run();