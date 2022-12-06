fun main() {

    fun findMarkerPosition(input:List<String>, size: Int): Int{
        input.first().windowed(size).forEachIndexed { index, s -> if (s.toSet().size == size) return index+ size }
        return -1
    }

    fun part1(input: List<String>): Int {
        return findMarkerPosition(input,4)
    }

    fun part2(input: List<String>): Int {
        return findMarkerPosition(input,14)
    }

    val inputPart1 = readInput("Day06_part1")
    val inputPart2 = readInput("Day06_part2")
    println(part1(inputPart1))
    println(part2(inputPart2))


}


