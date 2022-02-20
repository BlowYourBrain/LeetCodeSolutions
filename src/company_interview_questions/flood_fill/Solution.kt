package company_interview_questions.flood_fill
import java.util.ArrayDeque

//https://leetcode.com/problems/flood-fill/

class Solution {

    private class Position(val row: Int, val col: Int)

    private val tempColor = -1

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val rowSize = image.size
        val colSize = image[0].size
        val stack = ArrayDeque<Position>()
        var position: Position
        val oldColor = image[sr][sc]

        addIfInBounds(sr, sc, rowSize, colSize, stack, image, oldColor)

        while (!stack.isEmpty()) {
            position = stack.pop()

            if (image[position.row][position.col] == oldColor){
                image[position.row][position.col] = tempColor
            }

            addIfInBounds(position.row + 1, position.col, rowSize, colSize, stack, image, oldColor)
            addIfInBounds(position.row - 1, position.col, rowSize, colSize, stack, image, oldColor)
            addIfInBounds(position.row, position.col + 1, rowSize, colSize, stack, image, oldColor)
            addIfInBounds(position.row, position.col - 1, rowSize, colSize, stack, image, oldColor)
        }
        var row = 0
        var col = 0
        while(row < rowSize){
            while (col < colSize){
                if (image[row][col] == tempColor){
                    image[row][col] = newColor
                }

                col++
            }
            col = 0
            row++
        }

        return image
    }

    private fun addIfInBounds
                (
        row: Int,
        col: Int,
        rowSize: Int,
        colSize: Int,
        stack: ArrayDeque<Position>,
        image: Array<IntArray>,
        oldColor: Int
    )
    {
        if (
            row >= 0 && row < rowSize &&
            col >= 0 && col < colSize &&
            image[row][col] == oldColor
        ) {
            stack.push(Position(row, col))
        }
    }
}