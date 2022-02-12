package competition.excel_sheet_column_title

import kotlin.test.assertEquals

fun main() {
    assertEquals("ALL", Solution().convertToTitle(1000))
}

class Solution {
    companion object {
        private const val BEFORE_FIRST_SYMBOL_POSITION = 'A'.toInt() - 1
        private const val SYMBOLS_COUNT = 26
    }

    fun convertToTitle(columnNumber: Int): String {
        val sb = StringBuilder()

        addChar(columnNumber, sb)

        return sb.toString()
    }

    //1000
    //L
    private fun addChar(num: Int, sb: StringBuilder) {
        //num = 1000 //38 //1
        //div = 38   //1  //0
        //mod = 12   //12 //1
        val div = num / SYMBOLS_COUNT
        val mod = num % SYMBOLS_COUNT

        if (div > 0) {
            if (mod == 0) {
                if (div > 1) {
                    sb.append(getSymbol(div - 1))
                }
                sb.append('Z')
            } else {
                addChar(div, sb)
                sb.append(getSymbol(mod))
            }
        } else {
            sb.append(getSymbol(mod))
        }
    }

    //число от 1 до 26
    private fun getSymbol(number: Int): Char {
        return (number + BEFORE_FIRST_SYMBOL_POSITION).toChar()
    }
}