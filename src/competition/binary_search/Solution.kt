package competition.binary_search

//https://leetcode.com/problems/binary-search/
//time complexity O(logN), space complexity O(1)

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var up = nums.size - 1

        var down = 0
        var middle = calculateMiddle(up, down)

        do {
            if (nums[middle] == target) return middle

            if (nums[middle] > target) {
                up = middle
            } else {
                down = middle
            }
            middle = calculateMiddle(up, down)

        } while (up - down > 1)

        if (nums[up] == target) return up
        if (nums[down] == target) return down

        return -1
    }

    private fun calculateMiddle(up: Int, down: Int): Int {
        return down + (up - down) / 2
    }
}