package company_interview_questions.isomorphic_string

import kotlin.test.assertEquals

fun main(){
    Solution().apply {
        testCase("badc", "baba", false)
        testCase("paper", "title", true)
    }
}

fun Solution.testCase(s: String, t: String, expected: Boolean){
    isIsomorphic(s, t).let {
        assertEquals(expected, it)
    }
}

class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val map = mutableMapOf<Char, Char>()
        val usedValues = mutableSetOf<Char>()

        for (i in s.indices){
            map[s[i]]?.let { value ->
                if (value != t[i]){
                    return false
                }
            } ?: kotlin.run{
                if (usedValues.contains(t[i])){
                    return false
                }
                map[s[i]] = t[i]
                usedValues.add(t[i])
            }
        }

        return true
    }
}