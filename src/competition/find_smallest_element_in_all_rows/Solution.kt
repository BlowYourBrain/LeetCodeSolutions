package competition.find_smallest_element_in_all_rows

import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    val test1 = arrayOf(
            intArrayOf(1,2,3,4,5),
            intArrayOf(2,4,5,8,10),
            intArrayOf(3,5,7,9,11),
            intArrayOf(1,3,5,7,9)
    )

    assertEquals(5, solution.smallestCommonElement(test1))

    val test2 = arrayOf(
            intArrayOf(1,2,3),
            intArrayOf(2,3,4),
            intArrayOf(2,3,5)
    )

    assertEquals(2, solution.smallestCommonElement(test2))
}

class Solution {

    fun smallestCommonElement(mat: Array<IntArray>): Int {
        val map = mutableMapOf<Int, Int>()

        mat.forEach { row ->
            row.forEach {
                map.compute(it) { key, oldValue -> (oldValue ?: 0) + 1 }
            }
        }

        var smallestNumber: Int? = null

        val rowsCount = mat.size
        map.forEach { (key, value) ->
            if (value == rowsCount && key < smallestNumber ?: Int.MAX_VALUE){
                smallestNumber = key
            }
        }

        return smallestNumber ?: -1
    }

}