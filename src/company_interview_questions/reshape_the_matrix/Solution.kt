package company_interview_questions.reshape_the_matrix

fun main(){
    Solution().matrixReshape(
            arrayOf(
                    intArrayOf(1,2),
                    intArrayOf(3,4)
            ),
            2,
            2
    )
}

class Solution {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val matCols = mat.first().size
        val matRows = mat.size

        if (matCols * matRows != r * c){
            return mat
        }

        val result = Array<IntArray>(r, {IntArray(c, {0})})
        var index: Int

        result.forEachIndexed { row, rowArr ->
            rowArr.forEachIndexed { col, _ ->
                index = columnIndex(row, col, c)
                rowArr[col] = mat[index / matCols].get(index % matCols)
            }
        }


        return result
    }

    private fun columnIndex(
            row: Int,
            col: Int,
            c: Int
    ): Int{

        return row * c + col
    }
}