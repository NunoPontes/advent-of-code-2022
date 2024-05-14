fun main() {
    fun calculateList(input: List<String>): MutableList<Int> {
        val mutableListCalories = mutableListOf<Int>()
        mutableListCalories.add(0)
        input.forEach { calorie ->
            if (calorie.isNotBlank()) {
                mutableListCalories[mutableListCalories.lastIndex] =
                    mutableListCalories[mutableListCalories.lastIndex] + calorie.toInt()
            } else {
                mutableListCalories.add(0)
            }
        }
        return mutableListCalories
    }

    fun part1(input: List<String>): Int {
        val mutableListCalories = calculateList(input)
        return mutableListCalories.max()
    }

    fun part2(input: List<String>): Int {
        val mutableListCalories = calculateList(input)
        return mutableListCalories.sorted().takeLast(3).sum()
    }

    val inputPart1 = readInput("Day01_part1")
    val inputPart2 = readInput("Day01_part2")
    println(part1(inputPart1))
    println(part2(inputPart2))


    fun restoreString(s: String, indices: IntArray): String {
        val chars = s.toCharArray()
        val hashMap: HashMap<Int, Char> = HashMap()

        for (i in chars.indices) {
            hashMap[indices[i]] = chars[i]
        }

        return hashMap.values.joinToString(separator = "")
    }

    val ints = intArrayOf(4, 5, 6, 7, 0, 2, 1, 3)
    restoreString(s = "codeleet", indices = ints)

}
