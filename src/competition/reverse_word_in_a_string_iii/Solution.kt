package competition.reverse_word_in_a_string_iii

import kotlin.test.assertEquals

//https://leetcode.com/problems/reverse-words-in-a-string-iii/

fun main() {
    val given = "abc"
    val then = "cba"

    assertEquals(
        then,
        Solution().reverseWords(given)
    )
}


class Solution {

    private var end = 0
    private var start = 0

    fun reverseWords(s: String): String {
        var index = 0
        var startWordIndex = 0
        val sb = StringBuilder(s.length)
        val arr = CharArray(s.length)

        while (index < s.length) {
            if (s[index] == ' ') {
                arr[index] = s[index]
                reverseWord(s, arr, startWordIndex, index - 1)
                startWordIndex = index + 1
            }
            index++
        }

        if (startWordIndex < s.length) {
            reverseWord(s, arr, startWordIndex, index - 1)
        }
        arr.forEach {
            sb.append(it)
        }

        return sb.toString()
    }

    private fun reverseWord(
        s: String,
        arr: CharArray,
        startWordIndex: Int,
        endWordIndex: Int
    ) {
        start = startWordIndex
        end = endWordIndex

        while (start <= end) {
            arr[start] = s[end]
            arr[end] = s[start]

            start++
            end--
        }
    }
}