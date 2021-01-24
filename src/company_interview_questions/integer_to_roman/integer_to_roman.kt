package company_interview_questions.integer_to_roman

import java.lang.StringBuilder
import kotlin.test.assertEquals

//https://leetcode.com/problems/integer-to-roman/
fun main() {
    Solution()
            .intToRoman(1994)
            .let {
                println(it)
                assertEquals("MCMXCIV", it)
            }
}

class Solution {

    fun intToRoman(num: Int): String {
        val romanValues = listOf(
                1000 to "M",
                900 to "CM",
                500 to "D",
                400 to "CD",
                100 to "C",
                90 to "XC",
                50 to "L",
                40 to "XL",
                10 to "X",
                9 to "IX",
                5 to "V",
                4 to "IV",
                1 to "I"
        )

        val stringBuilder = StringBuilder()
        var number = num

        while (number > 0){
            for (value in romanValues){
                if (value.first <= number ){
                    number -= value.first
                    stringBuilder.append(value.second)
                    break
                }
            }

        }

        return stringBuilder.toString()
    }


}