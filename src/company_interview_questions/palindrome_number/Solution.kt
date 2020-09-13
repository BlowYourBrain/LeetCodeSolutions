package company_interview_questions.palindrome_number

//https://leetcode.com/problems/palindrome-number/solution/

fun main() {
    Solution().isPalindrome(145641)
        .let { println(it) }
}

class Solution {

    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }

        val list = mutableListOf<Int>()

        var temp = x
        do {
            list.add(temp % 10)
            temp /= 10
        } while (temp > 0)

        return if (list.size % 2 == 0) {
            if (list.size > 0) {
                val upIndex = list.size / 2
                val downIndex = upIndex - 1
                isPalindrome(downIndex, upIndex, list)
            } else {
                false
            }
        } else {
            if (list.size > 1) {
                val downIndex = list.size / 2 - 1
                val upIndex = downIndex + 2
                isPalindrome(downIndex, upIndex, list)
            } else {
                true
            }
        }
    }

    private fun isPalindrome(downIndex: Int, upIndex: Int, array: List<Int>): Boolean {
        var downIndexLoop = downIndex
        var upIndexLoop = upIndex
        do {
            if (array[downIndexLoop] != array[upIndexLoop]) {
                return false
            }
        } while (--downIndexLoop >= 0 && ++upIndexLoop <= array.lastIndex)

        return true
    }

}