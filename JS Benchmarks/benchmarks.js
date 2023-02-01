// Setup
const Benchmark = require('benchmark')

// Functions
function iterative_factorial(number){
    result = 1;
    for(let i = 0; i < number + 1; i++){
        result = result * i;
    }
    return result;
}

function recursive_factorial(number){
    return number <= 1 ? 1 : number * recursive_factorial(number - 1)
}

function iterative_sieve(limit){
    var isPrime = [], output = []

    for(var i = 0; i < limit; i++)
        isPrime.push(true);

    for(var i = 2; i <= Math.sqrt(limit) - 1; i++)
        if (isPrime[i])
            for(var j = i * i; j < limit; j += i)
                isPrime[j] = false;
    
    for(var i = 2; i < limit; i++)
        if(isPrime[i] === true)
            output.push[i]
    
    return output;
}

function segmented_sieve(limit){
    var isPrime = [], output = []
    const step = limit / 4

    for(var i = 0; i < limit; i++)
        isPrime.push(true);

    for(var lowerBound = 0; i < limit; lowerBound += step)
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
    return list.find(element => element = item);
}

// Benchmarks

// Array.from(Array(1000)).map(x=>Math.floor(Math.random() * 1000))

var bmark= new Benchmark("Array search (1000 items)", () => {
    array_search(Array.from(Array(1000)).map(x=>Math.floor(Math.random() * 1000)), Math.floor(Math.random() * 1000))
})

bmark.on("complete", () => {
    console.log("Average time: " + String(bmark.stats.mean) + " seconds")
})

console.log(`Running ${bmark.name}...`)

bmark.run();