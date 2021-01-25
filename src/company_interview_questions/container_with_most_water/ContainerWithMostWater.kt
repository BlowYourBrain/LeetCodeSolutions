package company_interview_questions.container_with_most_water

import kotlin.test.assertEquals

//https://leetcode.com/problems/container-with-most-water/submissions/
fun main(){
    val data = intArrayOf(1,8,6,2,5,4,8,3,7)
    val expectedResult = 49

    Solution()
        .maxArea(data)
        .let {
            println("answer is $it")
            assertEquals(expectedResult, it)
        }
}

class Solution {

    fun maxArea(height: IntArray): Int {
        var startHeightIndex = 0
        var endHeightIndex = height.lastIndex
        var square = calculateSquare(height, startHeightIndex, endHeightIndex)

        while(startHeightIndex < endHeightIndex){
            if (height[startHeightIndex] > height[endHeightIndex]){
                endHeightIndex--
            }else{
                startHeightIndex++
            }

            square = maxOf(calculateSquare(height, startHeightIndex, endHeightIndex), square)
        }

        return square
    }

    private fun calculateSquare(height: IntArray, startHeightIndex: Int, endHeightIndex: Int): Int{
        return minOf(height[startHeightIndex], height[endHeightIndex]) * (endHeightIndex - startHeightIndex)
    }

}