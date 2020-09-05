package company_interview_questions.longest_substring_without_repeating_characters

//https://leetcode.com/problems/longest-substring-without-repeating-characters/

fun main(args: Array<String>) {
    val s = ""
    Solution()
        .lengthOfLongestSubstring(s)
        .let { println("result = $it") }
}


class Solution {

    fun lengthOfLongestSubstring(s: String): Int {
        var maxLengthSubstring = 0
        var index = 0

        while (index < s.length) {
            val subStringSymbols = mutableSetOf<Char>()

            for (innerIndex in index until s.length) {
                val innerLoopChar = s[innerIndex]

                if (subStringSymbols.contains(innerLoopChar)) {
                    maxLengthSubstring = maxOf(subStringSymbols.size, maxLengthSubstring)
                    index++
                    break
                } else {
                    subStringSymbols.add(innerLoopChar)
                    if (innerIndex == s.lastIndex) {
                        maxLengthSubstring = maxOf(subStringSymbols.size, maxLengthSubstring)
                        index++
                    }
                }
            }
        }
        return maxLengthSubstring
    }

}