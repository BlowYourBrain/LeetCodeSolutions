package arrays.pivot_index

private const val UNKNOWN_INDEX = -1

class FindPivotIndexSolution {

    fun pivotIndex(nums: IntArray): Int = nums.findPivotIndex()

    //n^2 algorithm
    private fun IntArray.findPivotIndex(): Int {
        val sumToTheRightOfIndex: Map<Int, Int> = getRightSumOfIndex(this)

        var sum = 0

        //case for the element with index [0]
        if (sumToTheRightOfIndex[0] == sum) {
            return 0
        }

        var index = 1

        while (index <= lastIndex) {
            sum += get(index - 1)

            if (sum == sumToTheRightOfIndex.get(index)) {
                return index
            }

            index++
        }

        return UNKNOWN_INDEX
    }

    //key = index of element in the array, value = sum of values to the left of index.
    private fun getRightSumOfIndex(nums: IntArray): Map<Int, Int> {
        val map = HashMap<Int, Int>(nums.size)

        var sumToTheRightOfIndex = 0
        map[nums.lastIndex] = sumToTheRightOfIndex

        var index = nums.lastIndex - 1

        while (index >= 0) {
            sumToTheRightOfIndex += nums[index + 1]
            map[index] = sumToTheRightOfIndex
            index--
        }

        return map
    }

}