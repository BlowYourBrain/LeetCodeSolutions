package competition.squares_of_sorted_array

class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        var startIndex = 0
        var endIndex = nums.size - 1
        var resultEndIndex = nums.size - 1
        val result = IntArray(nums.size)

        while(true) {
            if (startIndex < endIndex)  {
                if (kotlin.math.abs(nums[startIndex]) < kotlin.math.abs(nums[endIndex])){
                    addToSquares(result, nums, endIndex, resultEndIndex)
                    endIndex--
                    resultEndIndex--
                }else{
                    addToSquares(result, nums, startIndex, resultEndIndex)
                    resultEndIndex--
                    startIndex++
                }
            }
            else {
                if (startIndex == endIndex) {
                    addToSquares(result, nums, startIndex, resultEndIndex)
                }

                break
            }
        }

        return result
    }

    private fun addToSquares(sqrArray: IntArray, numsArray: IntArray, index: Int, resultIndex: Int) {
        sqrArray[resultIndex] = numsArray[index] * numsArray[index]
    }
}