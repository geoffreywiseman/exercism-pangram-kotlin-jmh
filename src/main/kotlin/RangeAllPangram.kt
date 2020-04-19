object RangeAllPangram {
	private val alphabet = 'a'..'z'

	fun isPangram(input: String): Boolean {
		return alphabet.all { input.contains(it, ignoreCase = true) }
	}
}
