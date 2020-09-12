package company_interview_questions.zigzag_conversion

import kotlin.test.assertEquals

//https://leetcode.com/problems/zigzag-conversion/

fun main() {
    val input = "PAYPALISHIRING"
    println("input: $input")

    Solution()
        .convert(input, 3)
        .let {
            println("output: $it")
            assertEquals("PAHNAPLSIIGYIR", it)
        }

}

class Solution {

    fun convert(s: String, numRows: Int): String {
        if (s.isEmpty()) return s

        val stringBuilder = StringBuilder(s.length)
        var index = 0
        var rowIndex = 0

        var indexDistanceEven = indexDistanceEven(numRows, rowIndex)
        var indexDistanceOdd = indexDistanceOdd(numRows, rowIndex)
        var isOdd = true
        do {
            if (index < s.length) {
                stringBuilder.append(s[index])
                index += if (isOdd) {
                    indexDistanceOdd
                } else {
                    indexDistanceEven
                }
                isOdd = !isOdd
            } else {
                rowIndex++
                isOdd = true
                index = rowIndex
                indexDistanceOdd = indexDistanceOdd(numRows, rowIndex)
                indexDistanceEven = indexDistanceEven(numRows, rowIndex)
            }
        } while (rowIndex < numRows)

        return stringBuilder.toString()
    }


    private fun indexDistanceEven(numRows: Int, rowIndex: Int) = nextLineDistance(numRows, numRows - rowIndex - 1)

    private fun indexDistanceOdd(numRows: Int, rowIndex: Int) = nextLineDistance(numRows, rowIndex)


    private fun nextLineDistance(numRows: Int, rowIndex: Int): Int {
        return if (rowIndex == numRows - 1) {
            if (rowIndex == 0) {
                1
            } else {
                nextLineDistance(numRows, 0)
            }
        } else {
            (numRows - rowIndex) * 2 - 2
        }
    }

}