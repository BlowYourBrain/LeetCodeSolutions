package queue_and_stack

import java.util.*
import kotlin.test.assertEquals

fun main(){
    val case1 = arrayOf("2","1","+","3","*")
    val case2 = arrayOf("-1", "2", "/")
    Solution().apply {
        assertEquals(9,evalRPN(case1))
        assertEquals(0, evalRPN(case2))
    }

}

class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        var token: String
        var i = 0

        while(i < tokens.size){
            token = tokens[i]

            if (token.isNumber()){
                stack.push(token.toInt())
                i++
                continue
            }

            val operand1: Int = stack.pop()
            val operand2: Int = stack.pop()

            stack.push(
                    when(token){
                        "+" -> operand2 + operand1
                        "-" -> operand2 - operand1
                        "*" -> operand2 * operand1
                        "/" -> operand2 / operand1
                        else -> 0
                    }
            )
            i++
        }

        return stack.pop()
    }

    private fun String.isNumber(): Boolean {
        return if (length > 1){
            get(1)
        }else{
            get(0)
        }.isDigit()
    }
}