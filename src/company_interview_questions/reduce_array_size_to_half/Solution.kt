package company_interview_questions.reduce_array_size_to_half

import kotlin.test.assertEquals

fun main(){
    Solution().minSetSize(
            intArrayOf(3,3,3,3,5,5,5,2,2,7)
    ).let {
        assertEquals(2, it)
    }
}

class Solution {
    fun minSetSize(arr: IntArray): Int {
        val map = mutableMapOf<Int, Int>()

        arr.forEach { entity ->
            map.put(entity, map.getOrDefault(entity,0) + 1)
        }

        val sortedMap = map.asSequence()
                .sortedByDescending { it.value }
                .map { it.value }
                .toList()

        val size = (arr.size + 1) / 2
        var calculatedSize = 0
        var index = 0

        while(calculatedSize < size){
            calculatedSize += sortedMap[index]
            index++
        }

        return index
    }
}