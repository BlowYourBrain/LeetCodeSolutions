package competition.search_insert_position

//https://leetcode.com/problems/search-insert-position/submissions/
class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var up = nums.size - 1
        var down = 0
        var middle = calculateMiddle(up, down)

        while (up - down > 1){
            if (nums[middle] == target){
                return middle
            }

            if (nums[middle] > target){
                up = middle
            }else{
                down = middle
            }

            middle = calculateMiddle(up, down)
        }

        if (nums[down] == target){
            return down
        }

        if (nums[up] == target){
            return up
        }

        return when{
            nums[up] < target -> up + 1
            nums[down] > target -> down
            else -> down + 1
        }
    }

    private fun calculateMiddle(up: Int, down: Int): Int {
        return down + (up - down) / 2
    }
}