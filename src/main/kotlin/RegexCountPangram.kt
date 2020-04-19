object RegexCountPangram {
	fun isPangram(input: String): Boolean =
			Regex("[a-z]")
					.findAll(input.toLowerCase())
					.map { it.value }
					.distinct()
					.count() == 26 // == alphabet length
}
