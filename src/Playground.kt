import java.util.*

fun main() {
//    val ints = intArrayOf(4, 5, 6, 7, 0, 2, 1, 3)
//    println(restoreString(s = "codeleet", indices = ints))
//
//    println( mostWordsFound(sentences = arrayOf("alice and bob love leetcode", "i think so too", "this is great thanks very much")))
//
//    println(pangrams("abc"))
//    println(pangrams("A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V W X Y and Z"))

//    println(gradingStudents(arrayOf(84,94,21,0,18,100,18,62,30,61,53,0,43,2,29,53,61,40,14,4,29,98,37,23,46,9,79,62,20,38,51,99,59,47,4,86,61,68,17,45,6,1,95,95)))

//    println(sumEpigram("Dealing with failure is easy: Work hard to improve. Success is also easy to handle: You’ve solved the wrong problem. Work hard to improve."))
    println(fibonacciSumOdd(10000))
//    println(calculateOccurrencesOfX(2660))
//    println(isPalindrome(121))
//    println(isPalindrome(1211))
//    println(sumPalindromes(10000))
//    println(countApplesAndOranges(s = 7, t = 11, a = 5, b = 15, apples = arrayOf(-2, 2, 1), oranges = arrayOf(5, -6)))
//    println(maximumWealth(accounts = arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1))))
    val linkedList = LinkedList<Int>()
}

fun restoreString(s: String, indices: IntArray): String {
    val chars = s.toCharArray()
    val hashMap: HashMap<Int, Char> = HashMap()

    for (i in chars.indices) {
        hashMap[indices[i]] = chars[i]
    }

    return hashMap.values.joinToString(separator = "")
}

fun mostWordsFound(sentences: Array<String>): Int {
    var maxWords = 0
    sentences.forEach { sentence ->
        val words = sentence.split(" ")
        if (words.size > maxWords) {
            maxWords = words.size
        }
    }
    return maxWords
}

fun pangrams(s: String): String {
    // Write your code here
    val chars = s.replace(" ", "").lowercase(Locale.getDefault()).toCharArray()
    val map = hashMapOf<Char, Int>()
    chars.forEach { character ->
        map[character] = 1
    }
    return if (map.size == 26) {
        "pangram"
    } else {
        "not pangram"
    }
}

fun gradingStudents(grades: Array<Int>): Array<Int> {
    // Write your code here
    val finalGrades: Array<Int> = Array(grades.size) { 0 }
    for (i in grades.indices) {
        if (grades[i] < 38) {
            finalGrades[i] = grades[i]
        } else if ((grades[i] + 1) % 5 == 0 || (grades[i] + 2) % 5 == 0) {
            if ((grades[i] + 1) % 5 == 0) {
                finalGrades[i] = grades[i] + 1
            } else {
                finalGrades[i] = grades[i] + 2
            }

        } else {
            finalGrades[i] = grades[i]
        }
    }
    return finalGrades
}


//Considering only the alphabetical characters, consonants having the value of their ASCII codes, and vowels having the inverse value of their ASCII codes, what is the sum of the sentence?
//
//Example: Taking the word “iffy”, the ASCII code of “i” is 105, it’s inverse is -105. The ASCII value of ‘f’ is 102. The ASCII y of “y” is 121. The sum of “iffy” = 220
fun Char.isVowel(): Boolean {
    return this.lowercaseChar() in "aeiou"
}

fun sumEpigram(sentence: String): Int {
    var sum = 0
    sentence.forEach { character ->
        if (character.isLetter()) {
            if (character.isVowel()) {
                sum -= character.code
            } else {
                sum += character.code
            }
        }
    }
    return sum
}


//Fibonacci
//The Fibonacci sequence begins like this: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 (each number is the sum of the previous two)
//
//What is the sum of all odd numbers in the Fibonacci sequence that are less than 10,000?

fun fibonacciSumOdd(n: Int): Int {
    if (n <= 0) return 0

    val fibonacci = IntArray(n + 1)
    fibonacci[0] = 0
    fibonacci[1] = 1

    var sum = fibonacci[0] + fibonacci[1]

    for (i in 2..n) {
        fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2]
        if (fibonacci[i] % 2 != 0 && fibonacci[i] < n) {
            sum += fibonacci[i]
        } else if (fibonacci[i] >= n) {
            break
        }
    }
    return sum
}

//Legionaries
//In the range 1 - 13 (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13) the digit 1 occurs 6 times.
//
//In the range, 1 - 2,660 (half the number of Romans in a legion), expressed in Roman numerals, how many times does the numeral “X” occur?

private enum class Symbol(val decimalValue: Int) {
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100),
    CD(400),
    D(500),
    CM(900),
    M(1000);

    companion object {
        fun closestBelow(value: Int) =
            values()
                .sortedByDescending { it.decimalValue }
                .firstOrNull { value >= it.decimalValue }

        fun highestStartingSymbol(value: String) =
            values()
                .sortedByDescending { it.decimalValue }
                .firstOrNull { value.startsWith(it.name) }
    }
}

fun Int.toRomanNumeral(): String = Symbol.closestBelow(this)
    .let { symbol ->
        if (symbol != null) {
            "$symbol${(this - symbol.decimalValue).toRomanNumeral()}"
        } else {
            ""
        }
    }

fun calculateOccurrencesOfX(x: Int): Int {
    var count = 0
    for (i in 9..x) {
        count += i.toRomanNumeral().count { it == 'X' }
    }
    return count
}


//Palindromes
//A palindrome is a word, number, phrase, or another sequence of characters which reads the same backward as forward, such as madam, racecar, or the number 10801
//
//What is the sum of all numeric palindromes that are less than 10,000?

fun isPalindrome(number: Int): Boolean {
    val numberString = number.toString()
    return numberString == numberString.reversed()
}

fun sumPalindromes(n: Int): Int {
    var sum = 0
    for (i in 1..n) {
        if (isPalindrome(i)) {
            sum += i
        }
    }
    return sum
}


fun countApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: Array<Int>, oranges: Array<Int>): Unit {
    // Write your code here
    var applesCount = 0
    var orangesCount = 0
    apples.forEach { apple ->
        if (apple + a in s..t) {
            applesCount++
        }
    }
    oranges.forEach { orange ->
        if (orange + b in s..t) {
            orangesCount++
        }
    }
    println(applesCount)
    println(orangesCount)
}

fun maximumWealth(accounts: Array<IntArray>): Int {
    var sumMaxClient = 0
    accounts.forEach { client ->
        val sumClient = client.sum()
        if (sumClient > sumMaxClient) {
            sumMaxClient = sumClient
        }
    }
    return sumMaxClient
}

fun breakingRecords(scores: Array<Int>): Array<Int> {
    var max = scores[0]
    var maxCounter = 0
    var min = scores[0]
    var minCounter = 0
    scores.forEach { game->
        if(game > max){
            max = game
            maxCounter++
        } else if (game < min){
            min = game
            minCounter++
        }
    }
    return arrayOf(maxCounter, minCounter)
}

//Write a function:
//
//fun solution(A: IntArray): Int
//
//that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
//
//For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//
//Given A = [1, 2, 3], the function should return 4.
//
//Given A = [−1, −3], the function should return 1.

fun solution(A: IntArray): Int {
    val sortedArray = A.sorted()
    var smallestPositive = 1
    sortedArray.forEach { number ->
        if (number == smallestPositive) {
            smallestPositive++
        }
    }
    return smallestPositive
}


