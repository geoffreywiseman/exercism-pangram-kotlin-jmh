object MutableSetPangram {

	private val alphabet = 'a'..'z'

	fun isPangram(input: String): Boolean {
		val unused = alphabet.toMutableSet()
		input.forEach { unused.remove(it.toLowerCase()) }
		return unused.isEmpty()
	}
}
