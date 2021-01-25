package company_interview_questions.three_sum

//https://leetcode.com/problems/3sum/submissions/
fun main() {
    val data = intArrayOf(0,0)
    Solution()
        .threeSum(data)
        .let { println(it) }
}

class Solution {

    fun threeSum(nums: IntArray): List<List<Int>> {
        val numsHashMap: HashMap<Int, Int> = HashMap(nums.size)
        val resultList = mutableListOf<List<Int>>()

        nums.forEach { num ->
            val numsCount = numsHashMap.getOrDefault(num, 0)
            numsHashMap[num] = numsCount + 1
        }

        while (numsHashMap.isNotEmpty()) {
            val key = numsHashMap.keys.first()
            val availableCount = numsHashMap[key]!! - 1
            numsHashMap[key] = availableCount

            val twoSum = -key

            val uniqueValues: MutableSet<Int> = HashSet()
            //region find two sums
            numsHashMap.forEach { (secondKey, secondValue) ->
                if (secondValue > 0 && !uniqueValues.contains(secondKey)) {
                    numsHashMap[secondKey] = secondValue - 1

                    val thirdKey = twoSum - secondKey
                    val thirdValue = numsHashMap[thirdKey]
                    if (thirdValue != null && thirdValue > 0) {
                        uniqueValues.add(secondKey)
                        uniqueValues.add(thirdKey)
                        resultList.add(listOf(key, secondKey, thirdKey))
                    }

                    numsHashMap[secondKey] = secondValue
                }
            }
            //endregion

            numsHashMap.remove(key)
        }

        return resultList
    }

}