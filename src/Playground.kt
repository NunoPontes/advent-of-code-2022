import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.abs


fun main() {
    fun runningSum(nums: IntArray): IntArray {
        val returnArray = IntArray(nums.size)

        for (i in 0..nums.size) {
            if (i == 0) {
                returnArray[i] = nums[i]
            } else {
                returnArray[i] = nums[i] + nums[i - 1]
            }
        }
        return returnArray
    }

    fun maximumWealth(accounts: Array<IntArray>): Int {
        /*val listOfWealth = mutableListOf<Int>()

        accounts.forEach { it->
            var sumClient = 0
            it.forEach { singleAccount->
                sumClient+=singleAccount
            }
            listOfWealth.add(sumClient)
        }

        return listOfWealth.max()*/

        return accounts.maxOfOrNull { it.sum() } ?: 0
    }

    fun numberOfSteps(num: Int): Int {
        var auxNumber = num
        var numOperations = 0

        while (auxNumber != 0) {
            if (auxNumber % 2 == 0) {
                auxNumber /= 2
            } else {
                auxNumber--
            }
            numOperations++
        }
        return numOperations
    }

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val magazineHashmap = HashMap<Char, Int>()

        magazine.map { char ->
            val amount = magazineHashmap.getOrPut(char) { 0 }
            magazineHashmap[char] = amount + 1
        }

        ransomNote.map { char ->
            if (magazineHashmap[char] == null || magazineHashmap[char] == 0) {
                return false
            } else {
                val amount = magazineHashmap[char]
                if (amount != null) {
                    magazineHashmap[char] = amount - 1
                }
            }
        }
        return true
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun middleNode(head: ListNode?): ListNode? {
        var slow = head
        var fast = head

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }

    fun removeDuplicates(nums: IntArray): Int {
        val list = nums.distinct()
        for (i in list.indices) {
            nums[i] = list[i]
        }
        return list.size
    }

    fun containsDuplicate(nums: IntArray): Boolean {
        val size = nums.size
        return nums.distinct().size != size
    }

    fun isAnagram(s: String, t: String): Boolean {
        val sArray = s.toCharArray()
        val tArray = t.toCharArray()
        sArray.sort()
        tArray.sort()
        return sArray.contentEquals(tArray)
    }


//    fun twoSum(nums: IntArray, target: Int): IntArray {
//        for (i in nums.indices){
//            for (j in nums.indices){
//                if(i!=j && nums[i] + nums[j] == target){
//                    return intArrayOf(i, j)
//                }
//            }
//        }
//        return intArrayOf()
//    }

    fun reverseArray(a: Array<Int>): Array<Int> {
        // Write your code here
        return a.reversedArray()
    }

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val hashMap = hashMapOf<Int, Int>() //Key: number, Value: counter

        nums.map {
            var counter = hashMap[it] ?: 0
            counter++
            hashMap.put(it, counter)
        }
        val sortedMap = hashMap.toList().sortedByDescending { (_, value) -> value }.toMap()

        return sortedMap.keys.take(k).toIntArray()
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val hashmapCharacters = hashMapOf<String, List<String>>()

        strs.map {
            val sortedString = it.toCharArray()
            sortedString.sort()
            val currentList = hashmapCharacters.getOrDefault(String(sortedString), emptyList())
            val mutableList = mutableListOf<String>()
            mutableList.addAll(currentList)
            mutableList.add(it)
            hashmapCharacters.put(String(sortedString), mutableList)
        }

        return hashmapCharacters.values.toList()
    }

    fun productExceptSelf(nums: IntArray): IntArray {
        val resultList = mutableListOf<Int>()
        val prefix = mutableListOf<Int>()
        val postFix: MutableList<Int> = MutableList(nums.size) { index: Int -> 1 }
        var multiply = nums[0]
        for (i in nums.indices) {
            if (i == 0) {
                prefix.add(nums[i])
            } else {
                multiply *= nums[i]
                prefix.add(multiply)
            }
        } //-1,1,0,0,0

        for (i in nums.indices.reversed()) {
            if (i == nums.size - 1) {
                postFix.removeAt(i)
                postFix.add(i, nums[i])
                multiply = nums[i]
            } else {
                multiply *= nums[i]
                postFix.removeAt(i)
                postFix.add(i, multiply)
            }
        }

        for (i in nums.indices) {
            if (i == 0) {
                resultList.add(postFix[1])
            } else if (i == nums.size - 1) {
                resultList.add(prefix[i - 1])
            } else {
                resultList.add(prefix[i - 1] * postFix[i + 1])
            }
        }

        return resultList.toIntArray()
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {


        for (i in board.indices) {
            val rowSet = hashSetOf<Char>()
            val columnSet = hashSetOf<Char>()
            val boxSet = hashSetOf<Char>()
            for (j in board[i].indices) {
                if (board[i][j] != '.' && rowSet.contains(board[i][j])) {
                    return false
                } else if (board[i][j] != '.') {
                    rowSet.add(board[i][j])
                }

                if (board[j][i] != '.' && columnSet.contains(board[j][i])) {
                    return false
                } else if (board[j][i] != '.') {
                    columnSet.add(board[j][i])
                }

                val boxRow = 3 * (i / 3) + j / 3
                val boxCol = 3 * (i % 3) + j % 3

                if (board[boxRow][boxCol] != '.' && boxSet.contains(board[boxRow][boxCol])) {
                    return false
                } else if (board[boxRow][boxCol] != '.') {
                    boxSet.add(board[boxRow][boxCol])
                }
            }
        }
        return true
    }

    val matrix: Array<CharArray> = arrayOf(
        charArrayOf('5', '3', '6', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

//    println(isValidSudoku(matrix))

    fun longestConsecutive(nums: IntArray): Int {
        val hashSet = nums.toHashSet()
        var count = 1
        val mutableListCounts = mutableListOf<Int>()
        nums.map {
            if (!hashSet.contains(it - 1)) {
                //Start sequence
                var aux = it
                while (hashSet.contains(aux + 1)) {
                    count++
                    aux++
                }
                mutableListCounts.add(count)
                count = 1
            }
        }


//        var count = 1
////        val mutableListCounts = mutableListOf<Int>()
//        nums.sort()
//        for (i in nums.indices) {
//            if (i < nums.size - 1 && nums[i] + 1 == nums[i + 1]) {
//                count++
//            } else {
//                mutableListCounts.add(count)
//                count = 1
//            }
//        }
        return mutableListCounts.maxOrNull() ?: 0
    }

    //println(longestConsecutive(intArrayOf(0,3,7,2,5,8,4,6,0,1)))
    //println(longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
    //println(longestConsecutive(intArrayOf()))


    fun encode(listCharacters: List<String>): String {
        var encodedString = ""
        val delimiter = "#"
        listCharacters.map {
            encodedString = encodedString.plus(it.length).plus(delimiter).plus(it)
        }
        return encodedString
    }

    fun decode(encodedList: String): List<String> {
        val delimiter = "#"
        val decodedList = mutableListOf<String>()
        val listChar = encodedList.toList()
        var number = ""
        for (i in listChar.indices) {
            if (listChar[i].digitToIntOrNull() is Number) {
                number = number.plus(listChar[i])
                continue
            } else if (listChar[i].toString() == delimiter) {
                decodedList.add(String(listChar.subList(i + 1, i + 1 + number.toInt()).toCharArray()))
                number = ""
            }
        }
        return decodedList
    }

    val encodedString = encode(listOf("apple", "orange", "pear", "banana"))
    //println(encodedString)
    //println(decode(encodedString))


    fun isValidParenthesis(s: String): Boolean {
        val arrayDeque = ArrayDeque<Char>()
        val hashMapCharacters = hashMapOf<Char, Char>()
        hashMapCharacters[')'] = '('
        hashMapCharacters['}'] = '{'
        hashMapCharacters[']'] = '['

        s.toCharArray().map {

            if (it in hashMapCharacters) {
                if (hashMapCharacters[it] == arrayDeque.firstOrNull()) { //Check if it's a closed parenthesis
                    arrayDeque.removeFirst()
                } else {
                    return false
                }
            } else {
                arrayDeque.addFirst(it)
            }
        }
        return arrayDeque.size == 0
    }

    /*println(isValidParenthesis("()"))
    println(isValidParenthesis("()[]{}"))
    println(isValidParenthesis("([{}])"))
    println(isValidParenthesis("(]"))
    println(isValidParenthesis("("))
    println(isValidParenthesis(")"))
    println(isValidParenthesis("(("))*/



    class MinStack() {
        val arrayDeque = ArrayDeque<Int>()
        val minArrayDeque = ArrayDeque<Int>()
        fun push(`val`: Int) {
            if (minArrayDeque.firstOrNull() == null || `val` < minArrayDeque.first()) {
                minArrayDeque.addFirst(`val`)
            } else {
                minArrayDeque.addFirst(minArrayDeque.first())
            }
            arrayDeque.addFirst(`val`)

        }

        fun pop() {
            arrayDeque.removeFirst()
            minArrayDeque.removeFirst()
        }

        fun top(): Int {
            return arrayDeque.first()
        }

        fun getMin(): Int {
            return minArrayDeque.first()
        }

    }


    fun isPalindrome(s: String): Boolean {
        val nonAlphaNum = "[^a-zA-Z0-9]".toRegex()
        val formattedString = s.lowercase(Locale.getDefault()).trim().replace(nonAlphaNum, "")
        val charArray = formattedString.toCharArray()

        for (i in charArray.indices) {
            if (i < charArray.size - 1 - i) {
                if (charArray[i] == charArray[charArray.size - 1 - i]) {
                    continue
                } else {
                    return false
                }
            }
        }
        return true
    }

    //println(isPalindrome("A man, a plan, a canal: Panama"))
    //println(isPalindrome("race a car"))
    //println(isPalindrome(" "))


    fun twoSum2(numbers: IntArray, target: Int): IntArray {
        var leftPointer = 0
        var rightPointer = numbers.size - 1
        while (leftPointer < rightPointer) {
            if (numbers[leftPointer] + numbers[rightPointer] > target) {
                rightPointer--
            } else if (numbers[leftPointer] + numbers[rightPointer] < target) {
                leftPointer++
            } else {
                return intArrayOf(leftPointer + 1, rightPointer + 1)
            }
        }
        return intArrayOf()
    }

    //println(twoSum2(intArrayOf(2,7,11,15), 9))


    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val arrayDeque = ArrayDeque<Int>()
        arrayDeque.addFirst(0)

        for (i in arrayDeque.indices) {
            temperatures[i]
        }

        return arrayDeque.toIntArray()
    }

    //println(dailyTemperatures(intArrayOf(73,74,75,71,69,72,76,73)))


    fun evalRPN(tokens: Array<String>): Int {
        val arrayDeque = ArrayDeque<String>()

        tokens.map {
            if (it.toIntOrNull() != null) {
                arrayDeque.addFirst(it)
            } else {
                when (it) {
                    "+" -> {
                        val first = arrayDeque.first().toInt()
                        arrayDeque.removeFirst()
                        val second = arrayDeque.first().toInt()
                        arrayDeque.removeFirst()
                        arrayDeque.addFirst((first + second).toString())
                    }

                    "-" -> {
                        val first = arrayDeque.first().toInt()
                        arrayDeque.removeFirst()
                        val second = arrayDeque.first().toInt()
                        arrayDeque.removeFirst()
                        arrayDeque.addFirst((second - first).toString())
                    }

                    "*" -> {
                        val first = arrayDeque.first().toInt()
                        arrayDeque.removeFirst()
                        val second = arrayDeque.first().toInt()
                        arrayDeque.removeFirst()
                        arrayDeque.addFirst((first * second).toString())
                    }

                    "/" -> {
                        val first = arrayDeque.first().toInt()
                        arrayDeque.removeFirst()
                        val second = arrayDeque.first().toInt()
                        arrayDeque.removeFirst()
                        arrayDeque.addFirst((second / first).toString())
                    }
                }
            }
        }
        return arrayDeque.first().toInt()
    }

    //println(evalRPN(arrayOf("2", "1", "+", "3", "*")))
    //println(evalRPN(arrayOf("4", "13", "5", "/", "+")))
    //println(evalRPN(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")))


    fun getConcatenation(nums: IntArray): IntArray {
        val clone = nums.clone()
        return nums + clone
    }


    fun twoSum(nums: IntArray, target: Int): IntArray {
        val mutableHashMap = HashMap<Int, Int>() //Key: number; Value: index
        for (i in nums.indices) {
            val difference = target - nums[i]
            if (mutableHashMap[difference] != null) {
                return intArrayOf(i, mutableHashMap[difference]!!)
            } else {
                mutableHashMap[nums[i]] = i
            }
        }
        return intArrayOf()
    }

    //println(twoSum(intArrayOf(3, 2, 4), 6))

    //Input: s = "()"
    //Output: true
    //Example 2:
    //
    //Input: s = "()[]{}"
    //Output: true
    //Example 3:
    //
    //Input: s = "(]"
    //Output: false


//    println(productExceptSelf(intArrayOf(1, 2, 3, 4)))
//    println(productExceptSelf(intArrayOf(-1, 1, 0, -3, 3)))
//    println(topKFrequent(intArrayOf(1,2,3,4,5,6), 2))
//    println(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))


//
//    println(twoSum(intArrayOf(3,2,4), 6))
//    println(isAnagram("car", "rat"))

//    fun maxProfit(prices: IntArray): Int {
//        prices.map { price-> }
//
//        return 0
//    }

    //var array = intArrayOf(1, 2, 2, 3)
    //println(array)
    //println(removeDuplicates(array))
    //println(array)
    //println(canConstruct(ransomNote = "aabbcc", magazine = "aabbccc"))
    //println(numberOfSteps(14))


    fun threeSum(nums: IntArray): List<List<Int>> {

        val result = mutableListOf<List<Int>>()
        nums.sort()
        for (i in nums.indices) {
            var leftPointer = i + 1
            var rightPointer = nums.size - 1
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            } else {
                while (leftPointer < rightPointer) {
                    if (nums[i] + nums[leftPointer] + nums[rightPointer] < 0) {
                        leftPointer++
                    } else if (nums[i] + nums[leftPointer] + nums[rightPointer] > 0) {
                        rightPointer--
                    } else {
                        result.add(listOf(nums[i], nums[leftPointer], nums[rightPointer]))
                        leftPointer++
                        while (nums[leftPointer] == nums[leftPointer - 1] && leftPointer < rightPointer) {
                            leftPointer++
                        }
                    }
                }
            }
        }
        return result
    }

    //println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))

    fun backTracking(openP: Int, closedP: Int, stack: ArrayDeque<String>, n: Int): List<String> {
        if (openP == closedP && openP == n) {
            return stack.toList()
        }
        if (openP < n) {
            stack.addFirst("(")
            backTracking(openP + 1, closedP, stack, n)
        }
        if (closedP < openP) {
            stack.addFirst(")")
            backTracking(openP, closedP + 1, stack, n)
        }
        return stack.toList()
    }

    fun generateParenthesis(n: Int): List<String> {
        //n parenteses = 3 cada
        // n parenteses ( > )
        val arrayDeque = ArrayDeque<String>()

        return backTracking(0, 0, arrayDeque, n)
    }

    println(generateParenthesis(3))




    fun containsDuplicates(nums: IntArray): Boolean {
        val hashSet = hashSetOf<Int>()
        nums.map {
            if (hashSet.contains(it)){
                return true
            } else{
                hashSet.add(it)
            }
        }
        return false


        val size = nums.size
        return nums.distinct().size != size
    }


    fun twoSumss(nums: IntArray, target: Int): IntArray {
        var leftPointer = 0
        var rightPointer = nums.size-1
        while (leftPointer<rightPointer){
            if(nums[leftPointer] + nums[rightPointer] > target){
                rightPointer--
            } else if (nums[leftPointer] + nums[rightPointer] < target){
                leftPointer++
            } else {
                return intArrayOf(leftPointer, rightPointer)
            }
        }
        return intArrayOf()
    }

}



