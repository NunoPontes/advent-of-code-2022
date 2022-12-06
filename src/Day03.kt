fun main() {

    fun part1(input: List<String>): Int {
        val partOneSum = input.fold(0) { acc, line ->
            val middle = line.length / 2
            val compA = line.slice(0 until middle).toSet()
            val compB = line.slice(middle..line.lastIndex).toSet()
            val commonChar = compA.intersect(compB).first()
            val charValue = commonChar.toItemCode()
            acc + charValue
        }
        return partOneSum
    }

    fun part2(input: List<String>): Int {
        val partTwoSum = input.map { it.toSet() }.windowed(3, 3).sumOf {
            it.fold(emptySet<Char>()) { acc, rucksack ->
                if (acc.isEmpty()) rucksack else acc.intersect(rucksack)
            }.first().toItemCode()
        }
        return partTwoSum
    }

    val inputPart1 = readInput("Day03_part1")
    val inputPart2 = readInput("Day03_part2")
    println(part1(inputPart1))
    println(part2(inputPart2))
}


