package company_interview_questions.string_to_integer

import kotlin.test.assertEquals

//https://leetcode.com/problems/string-to-integer-atoi/submissions/
fun main() {
//    val input: Int = Int.MIN_VALUE
    val input = "-   234"
    Solution().myAtoi(
        "-   234")
        .let {
            println(it)
            assertEquals(0, it)
        }
}

class Solution {

    private val MAX_VALUE_DIV_10: Int = Int.MAX_VALUE / 10
    private var internalOverflow: Boolean = false

    fun myAtoi(str: String): Int {
        if (str.isEmpty()) return 0

        var sign = 0
        var lastDigit = 0
        var startIndex = 0
        var digitFound: Boolean = false

        loop@ do {
            val c = str[startIndex]

            when {
                c.isWhitespace() -> {
                    if (sign != 0){
                        return 0
                    }
                    continue@loop
                }

                c.isDigit() -> {
                    digitFound = true
                    break@loop
                }

                c == '+' -> {
                    if (sign == 0) {
                        sign = 1
                    } else {
                        return 0
                    }
                }
                c == '-' -> {
                    if (sign == 0) {
                        sign = -1
                    } else {
                        return 0
                    }
                }

                else -> {
                    return 0
                }
            }
        } while (++startIndex < str.length)

        if (!digitFound) return 0

        var result = 0
        var foundNonNilDigit = false
        loop@ do {
            val digit = str[startIndex].toDigit()

            if (digit < 0 || digit > 9) {
                return defineResult(result, sign)
            } else {
                if (!foundNonNilDigit) {
                    if (digit != 0) {
                        foundNonNilDigit = true
                    }
                }

                lastDigit = digit

                if (hasOverflow(result, sign, lastDigit)) {
                    return maxIntOfSign(sign)
                }

                if (result * 10 > MAX_VALUE_DIV_10) {
                    internalOverflow = true
                }

                result = result * 10 + digit
            }
        } while (++startIndex < str.length)

        return defineResult(result, sign)
    }

    private fun defineResult(result: Int, sign: Int): Int {
        return if (sign >= 0) {
            result
        } else {
            -result
        }
    }

    private fun hasOverflow(result: Int, sign: Int, lastDigit: Int): Boolean {
        return when {
            result < MAX_VALUE_DIV_10 -> false
            sign.isPositive() -> (lastDigit > 7 || internalOverflow).also { internalOverflow = true }
            !sign.isPositive() -> (lastDigit > 8 || internalOverflow).also { internalOverflow = true }
            else -> true
        }
    }

    private fun maxIntOfSign(sign: Int): Int = if (sign.isPositive()) Int.MAX_VALUE else Int.MIN_VALUE

    private fun Int.isPositive(): Boolean = this >= 0

    private fun Char.toDigit(): Int = this - '0'

}