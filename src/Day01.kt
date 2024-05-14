
import java.util.*
import kotlin.math.abs


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

    fun FoodDistribution(arr: IntArray): Int {
        val n = arr[0] // Number of sandwiches
        val hungerLevels = arr.copyOfRange(1, arr.size) // Hunger levels of people

        hungerLevels.sortDescending() // Sort hunger levels in descending order

        // Distribute sandwiches to minimize hunger difference
        for (i in 0 until n) {
            if (i < hungerLevels.size) {
                hungerLevels[i] -= 1
            }
        }

        // Calculate the total minimized difference
        var totalDifference = 0
        for (i in 0 until hungerLevels.size - 1) {
            totalDifference += Math.abs(hungerLevels[i] - hungerLevels[i + 1])
        }

        return totalDifference
    }

    fun calculate(a: IntArray, togive: Int): Int {
        var togive = togive
        var sum = 0
        for (i in a) sum += i
        val mean = sum / a.size
        val first = togive
        for (i in a.indices) {
            val x = a[i]
            if (x > mean) {
                val rem = togive.coerceAtMost(x - mean)
                a[i] -= rem
                togive -= rem
                if (togive == 0) break
            }
        }
        return if (first == togive) 0 else togive
    }
    fun foodDistribution(arr: IntArray): String {
        var togive = arr[0]
        val a = arr.copyOfRange(1, arr.size)
        while (togive > 0) togive = calculate(a, togive)
        var sum = 0
        for (i in 0 until a.size - 1) {
            sum += abs(a[i + 1] - a[i])
        }
        return "" + sum
        // return Arrays.toString(a);
    }




// Test cases
    val arr1 = intArrayOf(5, 3, 1, 2, 1)
    val arr2 = intArrayOf(4, 5, 2, 3, 1, 0)
    val arr3 = intArrayOf(3, 2, 1, 0, 4, 1,0)

    println(foodDistribution(arr1)) // Output: 0
    println(foodDistribution(arr2)) // Output: 2
    println(foodDistribution(arr3)) // Output: 4

}


object FoodDistribution {
    fun foodDistribution(arr: IntArray): String {
        var togive = arr[0]
        val a = arr.copyOfRange(1, arr.size)
        while (togive > 0) togive = apply(a, togive)
        var sum = 0
        for (i in 0 until a.size - 1) {
            sum += abs(a[i + 1] - a[i])
        }
        return "" + sum
        // return Arrays.toString(a);
    }

    private fun apply(a: IntArray, togive: Int): Int {
        var togive = togive
        var sum = 0
        for (i in a) sum += i
        val mean = sum / a.size
        val first = togive
        for (i in a.indices) {
            val x = a[i]
            if (x > mean) {
                val rem = togive.coerceAtMost(x - mean)
                a[i] -= rem
                togive -= rem
                if (togive == 0) break
            }
        }
        return if (first == togive) 0 else togive
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val array = intArrayOf(5, 3, 1, 2, 1)
        val array2 = intArrayOf(4, 5, 2, 3, 1, 0)
        val array3 = intArrayOf(1, 2, 3, 100)
        println(foodDistribution(array))
        println(foodDistribution(array2))
        println(foodDistribution(array3))
    }
}
//@JvmStatic
//fun main(args: Array<String>) {
//    val database = Database(Single.just(Entity("D1")))
//    val apiService = ApiService(Single.just(Entity("A1")))
//    // ApiService apiService = new ApiService(Single.just(new Entity("A1")).delay(500, MILLISECONDS));
//    // ApiService apiService = new ApiService(Single.error(new Exception("Error! Error!")));
//    val subject: BehaviorSubject<Any> = BehaviorSubject.create()
//    Observable.merge(
//        apiService.getEntity()
//            .toObservable()
//            .doOnNext { t -> subject.onNext(STOP) }
//            .doOnError { e -> subject.onNext(STOP) }
//            .onErrorResumeNext { t ->
//                Observable.concatDelayError(
//                    database.getEntity().toObservable(),
//                    Observable.error(t)
//                )
//            },
//        database.getEntity()
//            .delay(300, MILLISECONDS)
//            .toObservable()
//            .takeUntil(subject)
//    )
//        .subscribe(
//            System.out::println,
//            System.err::println
//        )
//    Observable.timer(1, MINUTES) // just for blocking the main thread
//        .toBlocking()
//        .subscribe()
//}