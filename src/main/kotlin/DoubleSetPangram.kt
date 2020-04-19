object DoubleSetPangram {

	private val alphabet = 'a'..'z'

	fun isPangram(input: String): Boolean {
		val alphaSet = alphabet.toSet()
		val inputSet = input.toLowerCase().toSet()
		return inputSet.containsAll(alphaSet)
	}
}
