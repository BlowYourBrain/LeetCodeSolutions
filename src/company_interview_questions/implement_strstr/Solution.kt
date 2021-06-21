package company_interview_questions.implement_strstr

class Solution {

    private val NOT_FOUND = -1

    fun strStr(haystack: String, needle: String): Int {
        if (needle.isBlank()) return 0

        var i = 0
        var j = 0
        //i = 0
        //j = 1
        loop@ while(i < haystack.length){
            j = 0
            while(j < needle.length){
                if (i + j >= haystack.length) break@loop

                if (needle[j] != haystack[i + j]){
                    i++
                    continue@loop
                }
                j++
            }
            return i
        }

        return NOT_FOUND
    }
}