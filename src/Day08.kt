fun main() {

    fun <T> traverse(grid: List<List<Int>>,score: (Int, List<Int>) -> T, combine: (List<T>) -> Int): List<Int> {
        return (grid.indices).flatMap { r ->
            (grid.indices).map { c ->
                val current = grid[r][c]
                val up = score(current, grid.slice(r - 1 downTo 0).map { it[c] })
                val down = score(current, grid.slice(r + 1 until grid.size).map { it[c] })
                val left = score(current, grid[r].slice(c - 1 downTo 0))
                val right = score(current, grid[r].slice(c + 1 until grid.size))
                combine(listOf(up, down, left, right))
            }
        }
    }

    fun part1(input: List<String>): Int {
        val grid = input.map { it.toList().map(Char::digitToInt) }

        return traverse(
            grid = grid,
            score = { current, slice -> slice.all { it < current } },
            combine = { directions -> if (directions.any { it }) 1 else 0 }
        ).sum()
    }

    fun part2(input: List<String>): Int {
        val grid = input.map { it.toList().map(Char::digitToInt) }

        return traverse(
            grid = grid,
            score = { current, slice -> (slice.indexOfFirst { it >= current } + 1).takeIf { it != 0 } ?: slice.size },
            combine = { it.reduce(Int::times) }
        ).max()
    }

    val inputPart1 = readInput("Day08_part1")
    val inputPart2 = readInput("Day08_part2")
    println(part1(inputPart1))
    println(part2(inputPart2))

}
