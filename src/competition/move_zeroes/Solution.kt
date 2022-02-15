package competition.move_zeroes
//https://leetcode.com/problems/move-zeroes/submissions/
class Solution {

    private var num: Int = 0

    fun moveZeroes(nums: IntArray) {
        var index = 0
        var lastNonZeroFound = 0

        while(index < nums.size) {
            if (nums[index] != 0){
                swap(nums, index, lastNonZeroFound)
                lastNonZeroFound++
            }
            index++
        }
    }

    private fun swap(arr: IntArray, pos1: Int, pos2: Int){
        num = arr[pos1]
        arr[pos1] = arr[pos2]
        arr[pos2] = num
    }

}