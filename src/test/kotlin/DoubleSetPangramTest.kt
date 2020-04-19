class DoubleSetPangramTest: PangramTest() {
	override fun isPangram(input: String): Boolean = DoubleSetPangram.isPangram(input)
}
