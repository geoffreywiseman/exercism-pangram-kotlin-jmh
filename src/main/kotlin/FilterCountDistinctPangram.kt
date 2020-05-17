object FilterCountDistinctPangram {

	val abc = 'a'..'z'

	fun isPangram(input: String): Boolean {
		return input
				.toLowerCase()
				.toCharArray()
				.filter { it in abc }
				.distinct()
				.count() == abc.count()
	}
}
