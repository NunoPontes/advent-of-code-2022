fun main() {

    val rock = 1
    val paper = 2
    val scissors = 3
    val win = 6
    val draw = 3
    val lost = 0

    fun part1(input: List<String>): Int {
        return input.sumOf {
            when (it) {
                "A X" -> rock + draw
                "A Y" -> paper + win
                "A Z" -> scissors + lost
                "B X" -> rock + lost
                "B Y" -> paper + draw
                "B Z" -> scissors + win
                "C X" -> rock + win
                "C Y" -> paper + lost
                "C Z" -> scissors + draw
                else -> lost.toInt()
            }
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf {
            when (it) {
                "A X" -> scissors + lost
                "A Y" -> rock + draw
                "A Z" -> paper + win
                "B X" -> rock + lost
                "B Y" -> paper + draw
                "B Z" -> scissors + win
                "C X" -> paper + lost
                "C Y" -> scissors + draw
                "C Z" -> rock + win
                else -> lost.toInt()
            }
        }
    }

    val inputPart1 = readInput("Day02_part1")
    val inputPart2 = readInput("Day02_part2")
    println(part1(inputPart1))
    println(part2(inputPart2))
}
