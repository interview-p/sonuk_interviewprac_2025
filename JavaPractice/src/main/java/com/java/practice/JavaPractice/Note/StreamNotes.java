package com.java.practice.JavaPractice.Note;

public class StreamNotes {

	/*
	
	source -> intermediate -> terminal
	
Stream Creation

From Collections: list.stream(), list.parallelStream()
From Arrays: Arrays.stream(arr)
Using static factory: Stream.of(...), Stream.generate(...), Stream.iterate(...)
Using Files, Pattern, Random, etc.


Intermediate Operations (lazy, return Stream)

Filtering: filter(Predicate)
Mapping: map(Function), flatMap(Function)
Sorting: sorted(), sorted(Comparator)
Distinct: distinct()
Limiting: limit(long), skip(long)
Peeking: peek(Consumer)


Terminal Operations (eager, produce result/non-stream)

Iteration: forEach(Consumer), forEachOrdered(Consumer)
Reduction: reduce(BinaryOperator<T>)
Collecting: collect(Collector)
Matching: anyMatch(Predicate), allMatch(Predicate), noneMatch(Predicate)
Finding: findFirst(), findAny()
Counting: count()
Min/Max: min(Comparator), max(Comparator)
To array: toArray()


Collectors

Collectors.toList(), toSet(), toMap()
groupingBy(Function<T,K>) , partitioningBy(Predicate<T>)
joining, counting, summarizingInt, etc.


Parallel Streams
parallelStream(), parallel()
ForkJoinPool, performance considerations.

Advanced

Custom collectors (Collector.of(...))
Primitive Streams: IntStream, LongStream, DoubleStream
Stream vs Optional integration.
	
	*/
	
/*
 
 Collectors.collectingAndThen() in Java Stream API is a wrapper collector — it lets you apply a finishing transformation on the result of another collector.

👉 In simple words:

First, it applies the inner collector to collect elements - downstream → the actual collector (like toList(), toSet(), counting(), etc.).

Then, it applies the finisher function to transform the result into a final form - finisher → a function that transforms the collected result into another form.


long count = Arrays.asList("A", "B", "C", "D").stream()
    .collect(Collectors.collectingAndThen(
        Collectors.counting(),
        c -> "Total elements: " + c
    ));

System.out.println(count); 
// Output: Total elements: 4


 */
}
