package competition.reverse_string

//https://leetcode.com/problems/reverse-string/submissions/
class Solution {
    fun reverseString(s: CharArray): Unit {
        var up = s.size - 1
        var down = 0
        var temp = '0'

        while(down <= up) {
            temp = s[up]
            s[up] = s[down]
            s[down] = temp
            up--
            down++
        }
    }
}