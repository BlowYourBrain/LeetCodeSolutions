package company_interview_questions.roman_to_integer

//https://leetcode.com/problems/roman-to-integer/submissions/

fun main() {
    Solution().run {
        romanToInt("MCMXCIV")
    }.let {
        assert(it == 1994)
        println(it)
    }
}

class Solution {

    val valuesHashMap = hashMapOf<String, Int>(
            "I" to 1,
            "V" to 5,
            "X" to 10,
            "L" to 50,
            "C" to 100,
            "D" to 500,
            "M" to 1000,
            "IV" to 4,
            "IX" to 9,
            "XL" to 40,
            "XC" to 90,
            "CD" to 400,
            "CM" to 900
    )

    fun romanToInt(s: String): Int {
        var number = 0
        var index = 0

        while (index < s.length) {
            val char = s[index]
            val couldCheckNextSymbol = index + 1 < s.length
            val key = if (couldCheckNextSymbol) {
                val nextChar = s[index + 1]
                val suffix = if (
                        (char == 'I' && (nextChar == 'X' || nextChar == 'V'))
                        ||
                        (char == 'X' && (nextChar == 'L' || nextChar == 'C'))
                        ||
                        (char == 'C' && (nextChar == 'D' || nextChar == 'M'))
                ) {
                    index++
                    nextChar
                } else {
                    null
                }

                "$char${suffix ?: ""}"

            } else {
                char.toString()
            }

            valuesHashMap[key]?.let { number += it }

            index++
        }

        return number
    }


}