package arrays.plus_one

import kotlin.test.assertEquals

fun main() {

    Solution()
            .plusOne(intArrayOf(9, 9))
            .let {
                assertEquals(intArrayOf(1, 2, 4), it)
            }

}

class Solution {
    fun plusOne(digits: IntArray): IntArray {
        var hasOverflow = true

        var index = digits.lastIndex
        while (hasOverflow && index >= 0) {
            hasOverflow = digits[index] + (if (hasOverflow) 1 else 0) > 9

            if (hasOverflow) {
                digits[index] = 0
            } else {
                digits[index] += 1
                hasOverflow = false
            }

            index--
        }

        if (hasOverflow) {
            val newArray = IntArray(digits.size + 1)
            newArray[0] = 1
            for (i in 1 until newArray.size) {
                newArray[i] = digits[i - 1]
            }
            return newArray
        }

        return digits
    }
}