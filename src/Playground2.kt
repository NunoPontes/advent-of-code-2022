fun main() {

//    val list = listOf(1, 2, 3, 4, 5)
//    val result=list.filter { it%2==0 }.reduce { acc, i -> acc+i }
//    println(result)
//
//    val num1="10"
//    val num2=20
//    val result2=num1+num2
//    println(result2)
//    val seq=list.asSequence().map { it*2 }
//    val iter=seq.toList().asIterable()
//    println(iter.first())

//    val obj=MySubClass()
//    obj.print()


//    val result=try{
//        returnNothing()
//    }catch (e: Exception){
//        "Exception caught"
//    }
//    println(result)


//    val obj=MyClass()
//    println(obj.foo())
//    println(MyClass.foo())


//    val list = mutableListOf(1, 2, 3, 4, 5, 5, 4, 3)
//    val result = list.toSet().toMutableList()
//    println(result)

//    val listNode = ListNode(2)
//    listNode.next = ListNode(4)
//
//    val listNode2 = ListNode(5)
//    listNode2.next = ListNode(6)
//    addTwoNumbers(listNode, listNode2)

//
//    val sportStats = listOf(
//        Summary(Sport.HIKE, 92),
//        Summary(Sport.RUN, 77),
//        Summary(Sport.TOURING_BICYCLE, 322),
//        Summary(Sport.E_TOURING_BICYCLE, 656)
//    )
//
//    // Write kotlin code to print the top sport by distance excluding eBikes.
//    val result = sportStats.filter { it.sport != Sport.E_TOURING_BICYCLE }.maxByOrNull { it.distance }
//
//    println(result?.sport)


    /*
    * i = [1, 3, 5];j = [2, 6, 8, 9];k = 4;return = [1,2,3,5]
     */

    fun mergeLists(list1: List<Int>, list2: List<Int>, maxNumbers: Int): List<Int> {
        val mutableList = mutableListOf<Int>()
        var list1Pointer = 0
        var list2Pointer = 0

//        while (mutableList.size < maxNumbers) {
//            if (list1Pointer < list1.size - 1 && list2Pointer < list2.size - 1) {//Bug
//                val list1Value = list1[list1Pointer]
//                val list2Value = list2[list2Pointer]
//                if (list1Value < list2Value){
//                    mutableList.add(list1Value)
//                } else if (list1Value > list2Value){
//                    mutableList.add(list2Value)
//                } else if (list1Value == list2Value){
//                    mutableList.add(list1Value)
//                    mutableList.add(list2Value)
//                }
//                list1Pointer++
//                list2Pointer++
//            }
//        }
        mutableList.addAll(list1)
        mutableList.addAll(list2)
        mutableList.sort() //Time: O(n logn); Space: O(n)

        return mutableList.take(maxNumbers)
    }

    fun commas(aux: String): String {
        val auxArray = aux.toCharArray()
        var final = ""

        auxArray.forEach {
            final += "$it,"
        }
        return final.take(final.length - 1)
    }

    fun commonSubstring(aux: String, number: Int): String {
        val hashMap = hashMapOf<String, Int>()

        for (i in aux.indices) {
//            val substring: String = if (number + i >= aux.length) {
//                aux.substring(i, number + i - 2)
//            } else {
//                aux.substring(i, number + i)
//            }

            val substring = if (number + i + 1 >= aux.length) {
                aux.drop(aux.length-number)
//                continue
            } else{
                aux.slice(i until number + i )
            }
//            val substring = aux.slice(i until number + i + 1)
//            val substring = aux.drop(IntRange(i, number + i))

            if (hashMap[substring] == null) {
                hashMap[substring] = 1
            } else {
                val value = hashMap[substring] ?: 0
                hashMap[substring] = value + 1
            }
        }


        val maxOcurences = hashMap.values.max()
        hashMap.map {
            if (it.value == maxOcurences) {
                return it.key
            } else {
                return ""
            }
        }
        return ""
    }

    fun twoSumAll(nums: IntArray, target: Int): List<IntArray> {
        val hashMap = hashMapOf<Int, Int>()
        val mutableListResults = mutableListOf<IntArray>()
        for (i in nums.indices) {
            val difference = target - nums[i]
            if (hashMap[difference] != null) {
                mutableListResults.add(intArrayOf(i, hashMap[difference]!!))
            } else {
                hashMap[nums[i]] = i
            }
        }
        return mutableListResults
    }


//    println(twoSumAll(intArrayOf(2, 7, 11, 15, 1, 8), 9))

//    val result = mergeLists(listOf(1, 3, 5), listOf(2, 6, 8, 9), 4)
//    println(result)
//
//    println(commas("string"))

    println(commonSubstring("abcdabxe", 2))
}


/*
*Given an array of integers and a number n, return true/false if there is a pair that sums to that number
Write a function that takes a string of characters and an integer n and returns the most frequent n-gram. Example: for ‘abcdabxe’ and 2 returns ‘ab’. If there are more than one with the same frequency, return the first one you encountered. ;Modify this to return the most frequent one.
given an input string S, and an input number X, which X letters were repeating more in S.
Merge Two returns the top n elements of the merged arrays.
Merge k sorted lists; 2 sorted arrays, merge them in a sorted way and return back the result with a limit number of elements.; i = [1, 3, 5];j = [2, 6, 8, 9];k = 4;return = [1,2,3,5]

Merge two sorted lists and truncate to k
given a string as an input, return the most frequently occurring substring of length n;For example,;input: 'inengineering', n = 2;output: 'in'
a variation of Two Sum question. Instead of finding 1 pair, you need to find all of it.
Write a function to merge two ordered lists and returned the first X numbers. (Be prepared to come up with input to test your functions.)
Most occurring substring
Merge 2 sorted lists into a single sorted list up until the merged list reaches a certain length.(A while loop with two pointers for the indexes of the two lists. Loop and increment the pointers until you get your desired list length.)
Find the most frequent substring of a certain length (Use two pointers the length of the desired substring. Start them from position 0 to N-1. Use a while loop and take the substring using those two pointers. Save the substring in a dictionary that maps the substring a count. Keep track of the max count, and the substring that maps to it. Increment your pointers until the end of the string in the while loop that you created.)

*
* Write a function that inserts a comma between each letter of a string.(Split the string into an array, join the array with commas.)
 */


//fun returnNothing(): Nothing{
//    throw IllegalStateException("Nothing")
//}
//
//open class MyClass {
//    private val myPrivateVar="private"
//    protected val myProtectedVar="protected"
//    internal val myInternalVar="internal"
//    val myPublicVar="public"
//}
// 
//class MySubClass: MyClass(){
//    fun print(){
////        println(this@MySubClass.myPrivateVar)
//        println(myProtectedVar)
//        println(myInternalVar)
//        println(myPublicVar)
//    }
//}

class MyClass {
    companion object {
        fun foo(): String {
            return "Companion object foo"
        }
    }

    fun foo(): String {
        return "Class foo"
    }
}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val mutableListIntL1 = mutableListOf<Int>()
    val mutableListIntL2 = mutableListOf<Int>()

    l1?.`val`?.let { mutableListIntL1.add(it) }
    var nextNodeL1 = l1?.next
    while (nextNodeL1 != null) {
        mutableListIntL1.add(nextNodeL1.`val`)
        nextNodeL1 = nextNodeL1.next
    }
    mutableListIntL1.reverse()
    var auxStringL1 = ""
    mutableListIntL1.forEach {
        auxStringL1 += it.toString()
    }
    val resultL1 = auxStringL1.toInt()
    println("resultL1: $resultL1")

    l2?.`val`?.let { mutableListIntL2.add(it) }
    var nextNodeL2 = l2?.next
    while (nextNodeL2 != null) {
        mutableListIntL2.add(nextNodeL2.`val`)
        nextNodeL2 = nextNodeL2.next
    }
    mutableListIntL2.reverse()
    var auxStringL2 = ""
    mutableListIntL2.forEach {
        auxStringL2 += it.toString()
    }
    val resultL2 = auxStringL2.toInt()
    println("resultL2: $resultL2")

    val finalResult = resultL1 + resultL2
    println("finalResult: $finalResult")

    val finalResultString = finalResult.toString()
    val finalResultStringReversed = finalResultString.reversed()
    println("finalResultStringReversed: $finalResultStringReversed")

    val finalResultStringReversedList = finalResultStringReversed.toList()

    val toInt = finalResultStringReversedList[0].toString().toInt()
    val listValues = finalResultStringReversedList.toMutableList()
    listValues.removeAt(0)
    val finalNode = addToNext(
        ListNode(toInt),
        listValues
    )

    println("finalNode: $finalNode")



    return null
}

fun addToNext(currentListNode: ListNode, listValues: MutableList<Char>): ListNode {

    currentListNode.next = ListNode(listValues[0].toString().toInt())
    listValues.removeAt(0)
    if (listValues.isNotEmpty()) {
        addToNext(currentListNode.next!!, listValues)
    }
    return currentListNode
}

enum class Sport { HIKE, RUN, TOURING_BICYCLE, E_TOURING_BICYCLE }

data class Summary(val sport: Sport, val distance: Int)


//fun longestCommonPrefix(strs: Array<String>): String {
//
//
//}
//import java.util.*
//
//fun main() {
////    val ints = intArrayOf(4, 5, 6, 7, 0, 2, 1, 3)
////    println(restoreString(s = "codeleet", indices = ints))
////
////    println( mostWordsFound(sentences = arrayOf("alice and bob love leetcode", "i think so too", "this is great thanks very much")))
////
////    println(pangrams("abc"))
////    println(pangrams("A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V W X Y and Z"))
//
////    println(gradingStudents(arrayOf(84,94,21,0,18,100,18,62,30,61,53,0,43,2,29,53,61,40,14,4,29,98,37,23,46,9,79,62,20,38,51,99,59,47,4,86,61,68,17,45,6,1,95,95)))
//
////    println(sumEpigram("Dealing with failure is easy: Work hard to improve. Success is also easy to handle: You’ve solved the wrong problem. Work hard to improve."))
//    println(fibonacciSumOdd(10000))
////    println(calculateOccurrencesOfX(2660))
////    println(isPalindrome(121))
////    println(isPalindrome(1211))
////    println(sumPalindromes(10000))
////    println(countApplesAndOranges(s = 7, t = 11, a = 5, b = 15, apples = arrayOf(-2, 2, 1), oranges = arrayOf(5, -6)))
////    println(maximumWealth(accounts = arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1))))
//    val linkedList = LinkedList<Int>()
//}
//
//fun restoreString(s: String, indices: IntArray): String {
//    val chars = s.toCharArray()
//    val hashMap: HashMap<Int, Char> = HashMap()
//
//    for (i in chars.indices) {
//        hashMap[indices[i]] = chars[i]
//    }
//
//    return hashMap.values.joinToString(separator = "")
//}
//
//fun mostWordsFound(sentences: Array<String>): Int {
//    var maxWords = 0
//    sentences.forEach { sentence ->
//        val words = sentence.split(" ")
//        if (words.size > maxWords) {
//            maxWords = words.size
//        }
//    }
//    return maxWords
//}
//
//fun pangrams(s: String): String {
//    // Write your code here
//    val chars = s.replace(" ", "").lowercase(Locale.getDefault()).toCharArray()
//    val map = hashMapOf<Char, Int>()
//    chars.forEach { character ->
//        map[character] = 1
//    }
//    return if (map.size == 26) {
//        "pangram"
//    } else {
//        "not pangram"
//    }
//}
//
//fun gradingStudents(grades: Array<Int>): Array<Int> {
//    // Write your code here
//    val finalGrades: Array<Int> = Array(grades.size) { 0 }
//    for (i in grades.indices) {
//        if (grades[i] < 38) {
//            finalGrades[i] = grades[i]
//        } else if ((grades[i] + 1) % 5 == 0 || (grades[i] + 2) % 5 == 0) {
//            if ((grades[i] + 1) % 5 == 0) {
//                finalGrades[i] = grades[i] + 1
//            } else {
//                finalGrades[i] = grades[i] + 2
//            }
//
//        } else {
//            finalGrades[i] = grades[i]
//        }
//    }
//    return finalGrades
//}
//
//
////Considering only the alphabetical characters, consonants having the value of their ASCII codes, and vowels having the inverse value of their ASCII codes, what is the sum of the sentence?
////
////Example: Taking the word “iffy”, the ASCII code of “i” is 105, it’s inverse is -105. The ASCII value of ‘f’ is 102. The ASCII y of “y” is 121. The sum of “iffy” = 220
//fun Char.isVowel(): Boolean {
//    return this.lowercaseChar() in "aeiou"
//}
//
//fun sumEpigram(sentence: String): Int {
//    var sum = 0
//    sentence.forEach { character ->
//        if (character.isLetter()) {
//            if (character.isVowel()) {
//                sum -= character.code
//            } else {
//                sum += character.code
//            }
//        }
//    }
//    return sum
//}
//
//
////Fibonacci
////The Fibonacci sequence begins like this: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 (each number is the sum of the previous two)
////
////What is the sum of all odd numbers in the Fibonacci sequence that are less than 10,000?
//
//fun fibonacciSumOdd(n: Int): Int {
//    if (n <= 0) return 0
//
//    val fibonacci = IntArray(n + 1)
//    fibonacci[0] = 0
//    fibonacci[1] = 1
//
//    var sum = fibonacci[0] + fibonacci[1]
//
//    for (i in 2..n) {
//        fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2]
//        if (fibonacci[i] % 2 != 0 && fibonacci[i] < n) {
//            sum += fibonacci[i]
//        } else if (fibonacci[i] >= n) {
//            break
//        }
//    }
//    return sum
//}
//
////Legionaries
////In the range 1 - 13 (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13) the digit 1 occurs 6 times.
////
////In the range, 1 - 2,660 (half the number of Romans in a legion), expressed in Roman numerals, how many times does the numeral “X” occur?
//
//private enum class Symbol(val decimalValue: Int) {
//    I(1),
//    IV(4),
//    V(5),
//    IX(9),
//    X(10),
//    XL(40),
//    L(50),
//    XC(90),
//    C(100),
//    CD(400),
//    D(500),
//    CM(900),
//    M(1000);
//
//    companion object {
//        fun closestBelow(value: Int) =
//            values()
//                .sortedByDescending { it.decimalValue }
//                .firstOrNull { value >= it.decimalValue }
//
//        fun highestStartingSymbol(value: String) =
//            values()
//                .sortedByDescending { it.decimalValue }
//                .firstOrNull { value.startsWith(it.name) }
//    }
//}
//
//fun Int.toRomanNumeral(): String = Symbol.closestBelow(this)
//    .let { symbol ->
//        if (symbol != null) {
//            "$symbol${(this - symbol.decimalValue).toRomanNumeral()}"
//        } else {
//            ""
//        }
//    }
//
//fun calculateOccurrencesOfX(x: Int): Int {
//    var count = 0
//    for (i in 9..x) {
//        count += i.toRomanNumeral().count { it == 'X' }
//    }
//    return count
//}
//
//
////Palindromes
////A palindrome is a word, number, phrase, or another sequence of characters which reads the same backward as forward, such as madam, racecar, or the number 10801
////
////What is the sum of all numeric palindromes that are less than 10,000?
//
//fun isPalindrome(number: Int): Boolean {
//    val numberString = number.toString()
//    return numberString == numberString.reversed()
//}
//
//fun sumPalindromes(n: Int): Int {
//    var sum = 0
//    for (i in 1..n) {
//        if (isPalindrome(i)) {
//            sum += i
//        }
//    }
//    return sum
//}
//
//
//fun countApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: Array<Int>, oranges: Array<Int>): Unit {
//    // Write your code here
//    var applesCount = 0
//    var orangesCount = 0
//    apples.forEach { apple ->
//        if (apple + a in s..t) {
//            applesCount++
//        }
//    }
//    oranges.forEach { orange ->
//        if (orange + b in s..t) {
//            orangesCount++
//        }
//    }
//    println(applesCount)
//    println(orangesCount)
//}
//
//fun maximumWealth(accounts: Array<IntArray>): Int {
//    var sumMaxClient = 0
//    accounts.forEach { client ->
//        val sumClient = client.sum()
//        if (sumClient > sumMaxClient) {
//            sumMaxClient = sumClient
//        }
//    }
//    return sumMaxClient
//}
//
//fun breakingRecords(scores: Array<Int>): Array<Int> {
//    var max = scores[0]
//    var maxCounter = 0
//    var min = scores[0]
//    var minCounter = 0
//    scores.forEach { game->
//        if(game > max){
//            max = game
//            maxCounter++
//        } else if (game < min){
//            min = game
//            minCounter++
//        }
//    }
//    return arrayOf(maxCounter, minCounter)
//}
//
////Write a function:
////
////fun solution(A: IntArray): Int
////
////that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
////
////For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
////
////Given A = [1, 2, 3], the function should return 4.
////
////Given A = [−1, −3], the function should return 1.
//
//fun solution(A: IntArray): Int {
//    val sortedArray = A.sorted()
//    var smallestPositive = 1
//    sortedArray.forEach { number ->
//        if (number == smallestPositive) {
//            smallestPositive++
//        }
//    }
//    return smallestPositive
//}