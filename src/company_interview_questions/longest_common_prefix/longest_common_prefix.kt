package company_interview_questions.longest_common_prefix

fun main() {
    val data = arrayOf(
            "ab",
            "a"
    )
    Solution()
            .longestCommonPrefix(data)
            .let {
                println("longest prefix is $it")
            }
}

//https://leetcode.com/problems/longest-common-prefix/solution/
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }

        return getPrefix(strs)
    }

    fun getPrefix(strs: Array<String>): String {
        val maxPrefix = strs.first()
        val startIndex = 0
        var currentIndex = maxPrefix.length
        var endIndex = maxPrefix.length
        var prefix = ""

        while (true) {
            prefix = maxPrefix.substring(startIndex, currentIndex)

            if (hasElementsSamePrefix(strs, prefix)) {
                val newEndIndex = currentIndex + (endIndex - currentIndex) / 2
                if (currentIndex - newEndIndex == 0) {
                    return prefix
                }
                currentIndex = newEndIndex
            } else {
                if (currentIndex == 0) {
                    return ""
                }
                endIndex = currentIndex
                currentIndex /= 2
            }

        }

    }

    fun hasElementsSamePrefix(strs: Array<String>, prefix: String): Boolean {
        strs.forEach { string ->
            prefix.forEachIndexed { index, char ->
                if (index > string.lastIndex || string[index] != char) return false
            }
        }
        return true
    }

}