fun main() {

    fun part1(input: List<String>): Int {
        return input.map { it -> it.split(",", "-").map { it.toInt() } }.count {
            val (first, second, third, fourth) = it
            (first in third..fourth && second in third..fourth) || (third in first..second && fourth in first..second)
        }
    }

    fun part2(input: List<String>): Int {
        return input.map { it -> it.split(",", "-").map { it.toInt() } }.count {
            val (first, second, third, fourth) = it
            (first in third..fourth || second in third..fourth) || (third in first..second || fourth in first..second)
        }
    }

    val inputPart1 = readInput("Day04_part1")
    val inputPart2 = readInput("Day04_part2")
    println(part1(inputPart1))
    println(part2(inputPart2))
}


