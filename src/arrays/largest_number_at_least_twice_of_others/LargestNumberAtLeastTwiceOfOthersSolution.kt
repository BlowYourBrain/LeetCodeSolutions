package arrays.largest_number_at_least_twice_of_others

class LargestNumberAtLeastTwiceOfOthersSolution {

    fun dominantIndex(nums: IntArray): Int {
        var previousMaxNumber = 0
        var maxNumber = 0
        var maxNumberIndex = 0

        var index = 0

        while (index < nums.size) {
            val value = nums[index]

            if (value > maxNumber) {
                val tempMaxNumber = maxNumber
                maxNumberIndex = index
                maxNumber = value
                previousMaxNumber = tempMaxNumber

                index++
                continue
            }

            if (previousMaxNumber < value) {
                previousMaxNumber = value
            }

            index++
        }

        if (previousMaxNumber * 2 > maxNumber) {
            return -1
        }

        return maxNumberIndex
    }

}