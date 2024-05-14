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