package company_interview_questions.valid_parentheses

import java.util.*
import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun main(){
    val solution = Solution()
    assertFalse(solution.isValid("([]){"))
    assertTrue(solution.isValid("(((())))"))
    assertFalse(solution.isValid("([)]"))
    assertTrue(solution.isValid("()(){}()[]"))
    assertTrue(solution.isValid("({((([])))})"))
    assertFalse(solution.isValid("["))
}

class Solution {

    fun isValid(s: String): Boolean {
        var stack = Stack<Char>()
        var charFromStack = ' '
        var intermediateAnswer: Boolean = false

        s.forEach{ char ->

            if (char == '[' || char == '(' || char == '{'){
                stack.push(char)
            }else{
                if (stack.isEmpty()){
                    return false
                }

                charFromStack = stack.pop()
                intermediateAnswer = char == ']' && charFromStack == '[' ||
                        char == ')' && charFromStack == '(' ||
                        char == '}' && charFromStack == '{'

                if (!intermediateAnswer){
                    return false
                }

            }
        }

        return stack.isEmpty()
    }

}