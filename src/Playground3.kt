import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.abs


fun main() {

    fun freqSubstring(str: String, n: Int): String {
        val hashmap = hashMapOf<String, Int>() //Key: substring, Value: counter
        var pairResult: Pair<Int, String> = Pair(0, "") //Counter, Substring

        for (i in 0..(str.length - n)) { //O(n)
            val substring = str.substring(i, n + i)

            if (hashmap[substring] == null) {
                hashmap[substring] = 1
                if(substring > pairResult.second){
                    pairResult = Pair(1, substring)
                }
            } else {
                val counter = hashmap[substring]
                if (counter != null) {
                    hashmap[substring] = counter + 1
                    if (counter + 1 >= pairResult.first && substring > pairResult.second) {
                        pairResult = Pair(counter + 1, substring)
                    }
                }
            }
        }
        return pairResult.second
    }

    println(freqSubstring("engineer", 2))

}

//

/*
Write a method of signature `(string str, int n) -> string` that returns the most frequently occurring substring of length `n` in `str`.
For example, with `str` equal to `"inengineering"` and `n` = 2, the substrings would be:
```
in, ne, en, ng, gi, in, ne, ee, er, ri, in, ng
```
and the most frequently occuring substring is `in`.
 */


//If error throw exception
//