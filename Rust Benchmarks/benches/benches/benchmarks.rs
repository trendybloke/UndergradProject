use criterion::{black_box, criterion_group, criterion_main, Criterion};
use rand::Rng;

// Functions
fn iter_factorial(n:u64) -> u64 {
    let mut f:u64 = 1;
    for i in 2..n {
        f = f * i;
    }
    return f;
}

fn rec_factorial(n:u64) -> u64 {
    match n {
        0 | 1 => 1,
        _ => rec_factorial(n - 1) * n,
    }
}

fn iter_sieve(limit:i32) -> Vec<i32> {
    let mut primes: Vec<bool> = Vec::new();

    for _i in 0..=limit {
        primes.push(true);
    }

    for i in 2..(((limit as f64).sqrt() - 1.0) as i32) {
        if primes[i as usize] == true {
            for j in (i*i..limit).step_by(i as usize) {
                primes[j as usize] = false;
            }
        }
    }

    let mut results: Vec<i32> = Vec::new();
    for i in 0..limit {
        if primes[i as usize] == true {
            results.push(i)
        }
    }

    return results;
}

fn seg_sieve(limit:i32) -> Vec<i32> {
    let mut primes: Vec<bool> = Vec::new();

    for _i in 0..=limit {
        primes.push(true);
    }

    let step: usize = (limit / 4) as usize;

    for lower_bound in (0..=limit).step_by(step){
        let upper_bound:i32 = lower_bound + (step) as i32;

        for i in lower_bound ..(((upper_bound as f64).sqrt() - 1.0) as i32) {
            if primes[i as usize] == true && i > 1 {
                for j in (i*i..limit).step_by(i as usize) {
                    primes[j as usize] = false;
                }
            }
        }
    }
    
    let mut results: Vec<i32> = Vec::new();
    for i in 0..limit {
        if primes[i as usize] == true {
            results.push(i)
        }
    }

    return results;
}

fn std_sort(mut arr:Vec<i32>) {
    arr.sort();
}

fn bubble_sort(mut arr:Vec<i32>){
    for i in 0..arr.len(){
        for j in 0..arr.len() - 1 - i {
            if arr[j] > arr[j + 1]{
                arr.swap(j, j + 1);
            }
        }
    }
}

fn std_search(arr:Vec<i32>, element: i32){
    arr.iter().position(|&x| x == element);
}

// Benchmarks
fn iter_fact_a(c: &mut Criterion) {
    c.bench_function("iter 5!", |b| b.iter(|| iter_factorial(black_box(5))));
}

fn iter_fact_b(c: &mut Criterion) {
    c.bench_function("iter 10!", |b| b.iter(|| iter_factorial(black_box(10))));
}

fn iter_fact_c(c: &mut Criterion) {
    c.bench_function("iter 15!", |b| b.iter(|| iter_factorial(black_box(15))));
}

fn iter_fact_d(c: &mut Criterion) {
    c.bench_function("iter 20!", |b| b.iter(|| iter_factorial(black_box(20))));
}

fn rec_fact_a(c: &mut Criterion) {
    c.bench_function("rec 5!", |b| b.iter(|| rec_factorial(black_box(5))));
}

fn rec_fact_b(c: &mut Criterion) {
    c.bench_function("rec 10!", |b| b.iter(|| rec_factorial(black_box(10))));
}

fn rec_fact_c(c: &mut Criterion) {
    c.bench_function("rec 15!", |b| b.iter(|| rec_factorial(black_box(15))));
}

fn rec_fact_d(c: &mut Criterion) {
    c.bench_function("rec 20!", |b| b.iter(|| rec_factorial(black_box(20))));
}

fn iter_sieve_a(c: &mut Criterion){
    c.bench_function("iter sieve (limit 100)", |b| b.iter(|| iter_sieve(black_box(100))));
}

fn iter_sieve_b(c: &mut Criterion){
    c.bench_function("iter sieve (limit 200)", |b| b.iter(|| iter_sieve(black_box(200))));
}

fn iter_sieve_c(c: &mut Criterion){
    c.bench_function("iter sieve (limit 500)", |b| b.iter(|| iter_sieve(black_box(500))));
}

fn iter_sieve_d(c: &mut Criterion){
    c.bench_function("iter sieve (limit 1000)", |b| b.iter(|| iter_sieve(black_box(1000))));
}

fn seg_sieve_a(c: &mut Criterion){
    c.bench_function("segmented sieve (limit 100)", |b| b.iter(|| seg_sieve(black_box(100))));
}

fn seg_sieve_b(c: &mut Criterion){
    c.bench_function("segmented sieve (limit 200)", |b| b.iter(|| seg_sieve(black_box(200))));
}

fn seg_sieve_c(c: &mut Criterion){
    c.bench_function("segmented sieve (limit 500)", |b| b.iter(|| seg_sieve(black_box(500))));
}

fn seg_sieve_d(c: &mut Criterion){
    c.bench_function("segmented sieve (limit 1000)", |b| b.iter(|| seg_sieve(black_box(1000))));
}

fn std_sort_a(c: &mut Criterion){
    c.bench_function("std sort (50 items)", |b| b.iter(|| std_sort(black_box((0..50).map(|v| v + 1000).collect()))));
}

fn std_sort_b(c: &mut Criterion){
    c.bench_function("std sort (100 items)", |b| b.iter(|| std_sort(black_box((0..100).map(|v| v + 1000).collect()))));
}

fn std_sort_c(c: &mut Criterion){
    c.bench_function("std sort (500 items)", |b| b.iter(|| std_sort(black_box((0..500).map(|v| v + 1000).collect()))));
}

fn std_sort_d(c: &mut Criterion){
    c.bench_function("std sort (1000 items)", |b| b.iter(|| std_sort(black_box((0..1000).map(|v| v + 1000).collect()))));
}

fn bubble_sort_a(c: &mut Criterion){
    c.bench_function("bubble sort (50 items)", |b| b.iter(|| bubble_sort(black_box((0..50).map(|v| v + 1000).collect()))));
}

fn bubble_sort_b(c: &mut Criterion){
    c.bench_function("bubble sort (100 items)", |b| b.iter(|| bubble_sort(black_box((0..100).map(|v| v + 1000).collect()))));
}

fn bubble_sort_c(c: &mut Criterion){
    c.bench_function("bubble sort (500 items)", |b| b.iter(|| bubble_sort(black_box((0..500).map(|v| v + 1000).collect()))));
}

fn bubble_sort_d(c: &mut Criterion){
    c.bench_function("bubble sort (1000 items)", |b| b.iter(|| bubble_sort(black_box((0..1000).map(|v| v + 1000).collect()))));
}

fn std_search_a(c: &mut Criterion){
    let mut rng = rand::thread_rng();
    c.bench_function("std search (50 items)", |b| b.iter(||std_search(black_box((0..50).map(|v| v + 1000).collect()), black_box(rng.gen_range(0..50)))));
}

fn std_search_b(c: &mut Criterion){
    let mut rng = rand::thread_rng();
    c.bench_function("std search (100 items)", |b| b.iter(||std_search(black_box((0..100).map(|v| v + 1000).collect()), black_box(rng.gen_range(0..100)))));
}

fn std_search_c(c: &mut Criterion){
    let mut rng = rand::thread_rng();
    c.bench_function("std search (500 items)", |b| b.iter(||std_search(black_box((0..500).map(|v| v + 1000).collect()), black_box(rng.gen_range(0..500)))));
}

fn std_search_d(c: &mut Criterion){
    let mut rng = rand::thread_rng();
    c.bench_function("std search (1000 items)", |b| b.iter(||std_search(black_box((0..1000).map(|v| v + 1000).collect()), black_box(rng.gen_range(0..1000)))));
}

// Config
criterion_group!(benches, 
    iter_fact_a,
    iter_fact_b,
    iter_fact_c,
    iter_fact_d,
    rec_fact_a,
    rec_fact_b,
    rec_fact_c,
    rec_fact_d,
    iter_sieve_a,
    iter_sieve_b,
    iter_sieve_c,
    iter_sieve_d,
    seg_sieve_a,
    seg_sieve_b,
    seg_sieve_c,
    seg_sieve_d,
    std_sort_a,
    std_sort_b,
    std_sort_c,
    std_sort_d,
    bubble_sort_a,
    bubble_sort_b,
    bubble_sort_c,
    bubble_sort_d, 
    std_search_a, 
    std_search_b, 
    std_search_c, 
    std_search_d);
criterion_main!(benches);