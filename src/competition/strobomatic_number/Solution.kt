package competition.strobomatic_number

import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun main() {
    val solution = Solution()
    assertTrue(solution.isStrobogrammatic("88"))
    assertTrue(solution.isStrobogrammatic("8"))
    assertTrue(solution.isStrobogrammatic("1"))
    assertTrue(solution.isStrobogrammatic("888"))
    assertFalse(solution.isStrobogrammatic("868"))
    assertTrue(solution.isStrobogrammatic("689"))
    assertTrue(solution.isStrobogrammatic("69"))
    assertTrue(solution.isStrobogrammatic("619"))
    assertFalse(solution.isStrobogrammatic("629"))
    assertTrue(solution.isStrobogrammatic("111"))
}

class Solution {

    private val strobogrammaticPairs = mapOf(
        '6' to '9',
        '9' to '6'
    )

    private val strobogrammaticDigit = setOf(
        '0', '1', '8'
    )

    fun isStrobogrammatic(num: String): Boolean {
        var index = 0
        val middle = num.length / 2

        while (index < middle) {
            if (!isStrobogrammaticDigits(num[index], num[num.lastIndex - index])) {
                return false
            }
            index++
        }

        if (num.length % 2 == 0) {
            return true
        }

        return isStrobogrammaticDigit(num[index])
    }

    private fun isStrobogrammaticDigits(char1: Char, char2: Char): Boolean {
        return strobogrammaticPairs[char1] == char2 || (char1 == char2 && isStrobogrammaticDigit(char1))
    }

    private fun isStrobogrammaticDigit(char: Char): Boolean {
        return strobogrammaticDigit.contains(char)
    }

}