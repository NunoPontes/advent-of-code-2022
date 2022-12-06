fun main() {

    fun part1(input: List<String>): String {
        val stacks = input.filterStackLines().parseToStack()

        input.filterOperationLines().parseOperations().runOperations(stacks, oneByOne = true)

        return stacks.getTopValues()
    }

    fun part2(input: List<String>): String {
        val stacks = input.filterStackLines().parseToStack()

        input.filterOperationLines().parseOperations().runOperations(stacks, oneByOne = false)

        return stacks.getTopValues()
    }

    val inputPart1 = readInput("Day05_part1")
    val inputPart2 = readInput("Day05_part2")
    println(part1(inputPart1))
    println(part2(inputPart2))
}


