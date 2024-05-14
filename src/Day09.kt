import kotlin.math.absoluteValue
import kotlin.math.sign

fun main() {

    fun Sequence<IntPair>.follow(): Sequence<IntPair> = sequence {
        var tailX = 0
        var tailY = 0
        yield(IntPair(tailX, tailY))
        for ((headX, headY) in this@follow) {
            val deltaX = headX - tailX
            val deltaY = headY - tailY
            if (deltaX.absoluteValue <= 1 && deltaY.absoluteValue <= 1) continue
            tailX = if (deltaX.absoluteValue >= deltaY.absoluteValue) headX - deltaX.sign else headX
            tailY = if (deltaX.absoluteValue <= deltaY.absoluteValue) headY - deltaY.sign else headY
            yield(IntPair(tailX, tailY))
        }
    }

    fun part1(input: List<String>): Int {
        val moves = sequence {
            var x = 0
            var y = 0
            yield(IntPair(x, y))
            for (line in input) {
                when (line[0]) {
                    'L' -> repeat(line.drop(2).toInt()) { yield(IntPair(--x, y)) }
                    'R' -> repeat(line.drop(2).toInt()) { yield(IntPair(++x, y)) }
                    'U' -> repeat(line.drop(2).toInt()) { yield(IntPair(x, --y)) }
                    'D' -> repeat(line.drop(2).toInt()) { yield(IntPair(x, ++y)) }
                }
            }
        }

        return moves.follow().toSet().size
    }

    fun part2(input: List<String>): Int {
        val moves = sequence {
            var x = 0
            var y = 0
            yield(IntPair(x, y))
            for (line in input) {
                when (line[0]) {
                    'L' -> repeat(line.drop(2).toInt()) { yield(IntPair(--x, y)) }
                    'R' -> repeat(line.drop(2).toInt()) { yield(IntPair(++x, y)) }
                    'U' -> repeat(line.drop(2).toInt()) { yield(IntPair(x, --y)) }
                    'D' -> repeat(line.drop(2).toInt()) { yield(IntPair(x, ++y)) }
                }
            }
        }

        return moves
            .follow() // 1
            .follow() // 2
            .follow() // 3
            .follow() // 4
            .follow() // 5
            .follow() // 6
            .follow() // 7
            .follow() // 8
            .follow() // 9
            .toSet()
            .size
    }

    val inputPart1 = readInput("Day09_part1")
    val inputPart2 = readInput("Day09_part2")
    println(part1(inputPart1))
    println(part2(inputPart2))

}

data class IntPair(val first: Int, val second: Int)