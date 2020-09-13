package company_interview_questions.reverse_integer

import kotlin.test.assertEquals

fun main() {
    Solution().reverse(-2147483412)
        .let {
            println(it)
            assertEquals(-2143847412, it)
        }
}

class Solution {
    fun reverse(x: Int): Int {
        if (x == 0) return 0

        var temp = x

        while (temp % 10 == 0) {
            temp /= 10
        }

        var result = 0

        do {
            val value = temp % 10

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && value > 7)) return 0
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && value < -8)) return 0

            result *= 10
            result += value

            temp /= 10

            if (temp == 0) {
                break
            }

        } while (true)

        return result
    }
}