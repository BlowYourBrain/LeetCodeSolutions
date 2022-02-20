package company_interview_questions.max_area_of_island
import java.util.ArrayDeque

//https://leetcode.com/problems/max-area-of-island/solution/

class Solution {
    private val ISLAND = 1
    private val PROCESSED_MARK = -1

    private class Position(val row: Int, val col: Int)

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var row = 0
        var col = 0
        val stack = ArrayDeque<Position>()
        var maxArea = 0

        while(row < grid.size){
            while(col < grid[0].size){
                if (isIsland(row, col, grid)){
                    maxArea = maxOf(maxArea, islandArea(row, col, stack, grid))
                }
                col++
            }

            col = 0
            row++
        }

        return maxArea
    }

    private fun isIsland
                (
        row: Int,
        col: Int,
        grid: Array<IntArray>
    ): Boolean
    {
        return grid[row][col] == ISLAND
    }

    private fun islandArea
                (
        row: Int,
        col: Int,
        stack: ArrayDeque<Position>,
        grid: Array<IntArray>
    ): Int
    {
        addToStack(row, col, stack, grid)

        var position: Position
        var area = 0
        while(!stack.isEmpty()){
            position = stack.pop()
            area++
            addToStackIfIsland(position.row + 1, position.col, stack, grid)
            addToStackIfIsland(position.row - 1, position.col, stack, grid)
            addToStackIfIsland(position.row, position.col + 1, stack, grid)
            addToStackIfIsland(position.row, position.col - 1, stack, grid)
        }

        return area
    }

    private fun addToStackIfIsland
                (
        row: Int,
        col: Int,
        stack: ArrayDeque<Position>,
        grid: Array<IntArray>
    )
    {
        if (
            row >= 0 && row < grid.size &&
            col >= 0 && col < grid[0].size &&
            isIsland(row, col, grid)
        ){
            addToStack(row, col, stack, grid)
        }
    }

    private fun addToStack
                (
        row: Int,
        col: Int,
        stack: ArrayDeque<Position>,
        grid: Array<IntArray>
    ){
        grid[row][col] = PROCESSED_MARK
        stack.push(Position(row, col))
    }
}