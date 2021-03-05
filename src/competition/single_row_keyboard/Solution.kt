package competition.single_row_keyboard

import kotlin.test.assertEquals

fun main(){
    val solution = Solution()
    solution.calculateTime("abcdefghijklmnopqrstuvwxyz", "cba")
        .let { assertEquals(4, it) }

    solution.calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode")
        .let { assertEquals(73, it) }
}

class Solution {

    fun calculateTime(keyboard: String, word: String): Int {
        val keyboardMap = HashMap<Char, Char>()

        keyboard.forEachIndexed { index, char ->
            keyboardMap[char] = index.toChar()
        }

        var movement = 0
        var currentPosition: Char = 0.toChar()
        var wordCharPosition: Char = 0.toChar()

        word.forEach{ char ->
            wordCharPosition = keyboardMap[char]!!
            movement += kotlin.math.abs(wordCharPosition - currentPosition)
            currentPosition = wordCharPosition
        }

        return movement
    }

}