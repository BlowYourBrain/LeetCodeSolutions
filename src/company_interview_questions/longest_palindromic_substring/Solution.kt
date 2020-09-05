package company_interview_questions.longest_palindromic_substring

//https://leetcode.com/problems/longest-palindromic-substring/submissions/

fun main() {

    Solution()
        .longestPalindrome("bbb")
        .let { println("result: $it") }

}

class Solution {

    fun longestPalindrome(s: String): String {

        var maxPalindromicSubstring = ""
        var index = 0

        while (index < s.length) {
            val nextIndex = index + 1
            val prevIndex = index - 1

            val oddPalindrome = if (prevIndex >= 0 && nextIndex <= s.lastIndex && s[prevIndex] == s[nextIndex]) {
                s.getPalindrome(prevIndex, nextIndex)
            } else {
                s[index].toString()
            }

            val evenPalindrome = if (nextIndex <= s.lastIndex && s[index] == s[nextIndex]) {
                s.getPalindrome(index, nextIndex)
            } else {
                s[index].toString()
            }

            val localMax = if (oddPalindrome.length > evenPalindrome.length) {
                oddPalindrome
            } else {
                evenPalindrome
            }

            if (localMax.length > maxPalindromicSubstring.length) {
                maxPalindromicSubstring = localMax
            }

            index++
        }

        return maxPalindromicSubstring
    }

    fun String.getPalindrome(downIndex: Int, upIndex: Int): String {
        var loopDownIndex = downIndex
        var loopUpIndex = upIndex

        do {
            if (get(loopDownIndex) != get(loopUpIndex)) {
                return substring(loopDownIndex + 1, loopUpIndex)
            }

            loopUpIndex++
            loopDownIndex--
        } while (loopDownIndex >= 0 && loopUpIndex <= lastIndex)

        return substring(loopDownIndex + 1, loopUpIndex)
    }

}