package company_interview_questions.two_sums

fun main(args: Array<String>) {

    Solution()
        .twoSum(intArrayOf(3, 3), 6)
        .run { println("[${first()}, ${last()}]") }
}


class Solution {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        //key = num's value, value = index
        val hashMap: HashMap<Int, Int> = hashMapOf()

        nums.forEachIndexed { index, num ->
            val pairedNum = target - num
            val pairedNumIndex = hashMap[pairedNum]

            if (pairedNumIndex != null) {
                return intArrayOf(pairedNumIndex, index)
            } else {
                hashMap[num] = index
            }

        }

        throw IllegalArgumentException("no solution")
    }


}