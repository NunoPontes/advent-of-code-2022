fun main() {

    fun parseInput(input: List<String>): Directory {
        val callStack = ArrayDeque<Directory>().apply { add(Directory("/")) }
        input.forEach { item ->
            when {
                item == "$ ls" -> {}// Noop
                item.startsWith("dir") -> {} // Noop
                item == "$ cd /" -> callStack.removeIf { it.name != "/" }
                item == "$ cd .." -> callStack.removeFirst()
                item.startsWith("$ cd") -> {
                    val name = item.substringAfterLast(" ")
                    callStack.addFirst(callStack.first().traverse(name))
                }
                else -> {
                    val size = item.substringBefore(" ").toInt()
                    callStack.first().addFile(size)
                }
            }
        }
        return callStack.last()
    }

    fun part1(input: List<String>): Int {
        val rootDirectory: Directory = parseInput(input)
        return rootDirectory.find { it.size <= 100_000 }.sumOf { it.size }
    }

    fun part2(input: List<String>): Int {
        val rootDirectory: Directory = parseInput(input)
        val unusedSpace = 70_000_000 - rootDirectory.size
        val deficit = 30_000_000 - unusedSpace
        return rootDirectory.find { it.size >= deficit }.minBy { it.size }.size
    }

    val inputPart1 = readInput("Day07_part1")
    val inputPart2 = readInput("Day07_part2")
    println(part1(inputPart1))
    println(part2(inputPart2))
}

class Directory(val name: String) {
    private val subDirs: MutableMap<String, Directory> = mutableMapOf()
    private var sizeOfFiles: Int = 0

    val size: Int
        get() = sizeOfFiles + subDirs.values.sumOf { it.size }

    fun addFile(size: Int) {
        sizeOfFiles += size
    }

    fun traverse(dir: String): Directory =
        subDirs.getOrPut(dir) { Directory(dir) }

    fun find(predicate: (Directory) -> Boolean): List<Directory> =
        subDirs.values.filter(predicate) +
                subDirs.values.flatMap { it.find(predicate) }
}
