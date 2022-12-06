import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt")
    .readLines()

fun readInputAsInt(name: String) = File("src", "$name.txt")
    .readLines().map { it.toInt() }

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

private const val LOWERCASE_OFFSET = 96
private const val UPPERCASE_OFFSET = 38
fun Char.toItemCode(): Int = when {
    isLowerCase() -> code - LOWERCASE_OFFSET
    isUpperCase() -> code - UPPERCASE_OFFSET
    else -> throw IllegalArgumentException()
}

fun List<String>.filterStackLines() = this.takeWhile { !it.startsWith(" 1") }

fun List<String>.filterOperationLines() = this.filter { it.startsWith("move") }

fun List<String>.parseToStack(): MutableMap<Int, String> {
    val stacks = mutableMapOf<Int, String>()

    this.forEach {
        it.chunked(4).forEachIndexed { index, s ->
            if (s.isNotBlank()) {
                val existing = stacks[index + 1] ?: ""
                stacks[index + 1] = existing + s[1]
            }
        }
    }

    return stacks
}

fun List<String>.parseOperations(): List<List<Int>> =
    this.map { it.split(" ").mapNotNull { op -> op.toIntOrNull() } }

fun List<List<Int>>.runOperations(stacks: MutableMap<Int, String>, oneByOne: Boolean = true) = this.forEach {
    val (amount, from, to) = it

    val str = stacks[from]?.take(amount) ?: throw Exception("Stack $from does not exist!")
    stacks[from] = stacks[from]?.drop(amount) ?: throw Exception("Stack $from does not exist!")
    stacks[to] = if (oneByOne) str.reversed() + stacks[to] else str + stacks[to]
}

fun Map<Int, String>.getTopValues() = this.toSortedMap().map { it.value.first() }.joinToString("")