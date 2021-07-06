package company_interview_questions.pascals_triangle

class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        result.add(listOf<Int>(1))
        for (i in 1 until numRows){
            result.add(calculateRow(result.last()))
        }
        return result
    }

    private fun calculateRow(list: List<Int>): List<Int> {
        var lp = 0
        var rp = 1

        val newList = mutableListOf<Int>()
        newList.add(1)

        while(rp < list.size){
            newList.add(list[lp] + list[rp])
            lp++
            rp++
        }
        newList.add(1)
        return newList
    }
}