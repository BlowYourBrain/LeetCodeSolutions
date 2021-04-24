package competition.count_binary_substrings

import kotlin.test.assertEquals

//https://leetcode.com/problems/count-binary-substrings/

fun main() {
    val solution = Solution()

    assertEquals(2, solution.countBinarySubstrings("00100"))
}

class Solution {

    fun countBinarySubstrings(s: String): Int {
        var totalCount = 0 //2
        var index = 0 //4
        var ones = 0 //2
        var zeros = 0 //1
        var char: Char = s.first() //1
        var onesOrZero: Char = char //1

        while (index < s.length) {
            char = s[index]

            if (char == onesOrZero && (ones != 0 && zeros != 0)) {
                totalCount += minOf(ones, zeros)
                index -= when (onesOrZero) {
                    '0' -> ones
                    else -> zeros
                }
                ones = 0
                zeros = 0
                onesOrZero = s[index]
                continue
            }

            when (char) {
                '0' -> zeros++
                '1' -> ones++
            }


            index++
        }

        totalCount += minOf(ones, zeros)

        return totalCount
    }
}