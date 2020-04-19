import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

abstract class PangramTest {

	abstract fun isPangram(input: String): Boolean

	@Test
	fun emptySentence() {
		assertFalse(isPangram(""))
	}

	@Test
	fun perfectLowerCase() {
		assertTrue(isPangram("abcdefghijklmnopqrstuvwxyz"))
	}

	@Test
	fun onlyLowerCase() {
		assertTrue(isPangram("the quick brown fox jumps over the lazy dog"))
	}

	@Test
	fun missingTheLetterX() {
		assertFalse(isPangram("a quick movement of the enemy will jeopardize five gunboats"))
	}

	@Test
	fun missingTheLetterH() {
		assertFalse(isPangram("five boxing wizards jump quickly at it"))
	}

	@Test
	fun withUnderscores() {
		assertTrue(isPangram("the_quick_brown_fox_jumps_over_the_lazy_dog"))
	}

	@Test
	fun withNumbers() {
		assertTrue(isPangram("the 1 quick brown fox jumps over the 2 lazy dogs"))
	}

	@Test
	fun missingLettersReplacedByNumbers() {
		assertFalse(isPangram("7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog"))
	}

	@Test
	fun mixedCaseAndPunctuation() {
		assertTrue(isPangram("\"Five quacking Zephyrs jolt my wax bed.\""))
	}

	@Test
	fun caseInsensitive() {
		assertFalse(isPangram("the quick brown fox jumps over with lazy FX"))
	}

}
