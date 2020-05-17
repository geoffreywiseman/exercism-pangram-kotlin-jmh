package bench

import DoubleSetPangram
import MutableSetPangram
import RangeAllPangram
import RegexCountPangram
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State

@State(Scope.Benchmark)
open class PangramBenchmark {

	val testCases = listOf(
			"the quick brown fox jumped over the lazy dog",
			"abcdefghijklmnopqrstuvwxyz",
			"this is not a pangram",
			"short",
			"""
				An extremely long string which would probably be a pangram if it weren't for the fact that certain
				characters, like q and z aren't terribly likely to appear in a typical sentence. Of course, I've
				just included them, but there are other similar letters that I haven't included.
			""".trimIndent()
	)

	@Benchmark
	fun benchmarkMutableSetPangram() {
		testCases.forEach { MutableSetPangram.isPangram(it) }
	}

	@Benchmark
	fun benchmarkDoubleSetPangram() {
		testCases.forEach { DoubleSetPangram.isPangram(it) }
	}

	@Benchmark
	fun benchmarkRangeAllPangram() {
		testCases.forEach { RangeAllPangram.isPangram(it) }
	}

	@Benchmark
	fun benchmarkRegexCountPangram() {
		testCases.forEach { RegexCountPangram.isPangram(it) }
	}

	@Benchmark
	fun benchmarkFilterCountDistinctPangram() {
		testCases.forEach { FilterCountDistinctPangram.isPangram(it) }
	}
}
