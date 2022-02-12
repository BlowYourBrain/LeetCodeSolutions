package competition.majority_element

//https://leetcode.com/problems/majority-element/solution/
//Time Complexity O(n), Space Complexity O(n)
class Solution {
    fun majorityElement(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()

        nums.forEach { num ->
            map.put(num, (map.get(num) ?: 0) + 1)
        }

        var maxValue = 0
        var key = 0

        map.asIterable().forEach { entry ->
            if (entry.value > maxValue){
                maxValue = entry.value
                key = entry.key
            }
        }

        return key
    }
}