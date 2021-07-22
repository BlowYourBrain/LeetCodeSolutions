package company_interview_questions.pascals_triangle_II

import kotlin.test.assertEquals

fun main(){
    Solution().getRow(3)
            .let {
                assertEquals(
                        listOf(1,3,3,1),
                        it
                )
            }
}

class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        if (rowIndex == 0) return listOf(1)

        return getListOfRowIndex(rowIndex)
    }

    private fun getListOfRowIndex(rowIndex: Int): List<Int> {
        return if (rowIndex == 1) {
            listOf(1,1)
        }else{
            val prevRow = getListOfRowIndex(rowIndex - 1)
            val list = MutableList<Int>(rowIndex + 1){1}
            for (i in 1 until rowIndex){
                list[i] = (prevRow[i - 1] + prevRow[i])
            }
            list
        }
    }
}