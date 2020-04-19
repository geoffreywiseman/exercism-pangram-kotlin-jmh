# Benchmarks for the Exercism Pangram exercise in Kotlin

After seeing a few different pangram implementations in Kotlin while mentoring the exercise on Exercism, I became curious about how the different approaches performed, so I threw a few implementations together with JMH to compare them.

## See Also

* [Exercism](http://exercism.io)
* [Kotlin Track](https://exercism.io/tracks/kotlin)

## Implementations

There are lots of ways of solving the Pangram exercise, including:

- [Comparing two sets](src/main/kotlin/DoubleSetPangram.kt) 
- [Removing Letters from an Alphabet Set](src/main/kotlin/MutableSetPangram.kt)
- [Using a Char range and `all`](src/main/kotlin/RangeAllPangram.kt)
- [Using a Regex and a count](src/main/kotlin/RegexCountPangram.kt) 

There are lots more, these are just a few that I benchmarked.

## Results

```
Result "bench.PangramBenchmark.benchmarkRegexCountPangram":
  109766.631 ±(99.9%) 4874.461 ops/s [Average]
  (min, avg, max) = (94112.081, 109766.631, 114927.307), stdev = 6507.265
  CI (99.9%): [104892.170, 114641.092] (assumes normal distribution)


# Run complete. Total time: 00:33:30

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                                     Mode  Cnt       Score       Error  Units
PangramBenchmark.benchmarkDoubleSetPangram   thrpt   25  265161.312 ± 33405.826  ops/s
PangramBenchmark.benchmarkMutableSetPangram  thrpt   25  480363.900 ± 55898.405  ops/s
PangramBenchmark.benchmarkRangeAllPangram    thrpt   25  175971.288 ± 10583.247  ops/s
PangramBenchmark.benchmarkRegexCountPangram  thrpt   25  109766.631 ±  4874.461  ops/s
```

Basically:

- The `MutableSet` approach is far and away the fastest.
    - It was my first implementation for Pangram
    - I do prefer the legibility of the RangeAll approach
- Then comes `DoubleSet`
    - Feels a bit cleaner, mostly because it's less reliant on mutation
    - barely faster than half the speed of the mutable set
- Then comes `RangeAll`
    - A bit faster than a third of the speed of `MutableSet`
    - Probably my favorite in terms of legibility
- `RegexCount` is dead last
    - I ported this from a community solution
    - about 20% of `MutableSet`'s speed

Of course, there are lots of other approaches, and also ways to lightly tweak these approaches to make them more performant. This isn't meant to be exhaustive, it was just an exploration of the viarous options.
