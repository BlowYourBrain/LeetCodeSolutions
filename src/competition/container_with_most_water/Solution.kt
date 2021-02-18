package competition.container_with_most_water

import kotlin.test.assertEquals


fun main() {
    val s = Solution()

    assertEquals(49, s.maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
    assertEquals(1, s.maxArea(intArrayOf(1,2)))
    assertEquals(0, s.maxArea(intArrayOf(0,2)))
    assertEquals(2, s.maxArea(intArrayOf(2,2)))

}

class Solution {
    fun maxArea(height: IntArray): Int {
        var startIndex = 0
        var index = 1
        var area = 0

        height.forEach{ h ->

            while(index < height.size){
                area = maxOf(minOf(h, height[index]) * (index - startIndex), area)
                index++
            }

            startIndex++
            index = startIndex + 1
        }

        return area
    }
}