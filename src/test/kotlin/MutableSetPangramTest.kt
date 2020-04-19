class MutableSetPangramTest: PangramTest() {
	override fun isPangram(input: String): Boolean = MutableSetPangram.isPangram(input)
}
