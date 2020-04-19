class RegexCountPangramTest: PangramTest() {
	override fun isPangram(input: String): Boolean = RegexCountPangram.isPangram(input)
}
