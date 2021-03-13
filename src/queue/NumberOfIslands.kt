package queue

import java.util.ArrayDeque
import kotlin.system.measureTimeMillis
import kotlin.test.assertEquals

fun main() {
    val solution = NumberOfIslands()
    val testCase1 = arrayOf(
            charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '0', '1', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0')
    )

    val testCase2 = arrayOf(
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '1', '0', '0'),
            charArrayOf('0', '0', '0', '1', '1')
    )

    val testCase3 = arrayOf(
            charArrayOf('1', '1', '1', '1', '1'),
            charArrayOf('1', '1', '0', '0', '1'),
            charArrayOf('1', '0', '0', '0', '1'),
            charArrayOf('1', '1', '1', '1', '1')
    )

    val testCase4 = arrayOf(
            charArrayOf('1', '1', '1'),
            charArrayOf('1', '1', '1'),
            charArrayOf('1', '1', '1')
    )

    val testCase5 = arrayOf(
            charArrayOf('0', '0', '0'),
            charArrayOf('0', '0', '0'),
            charArrayOf('0', '0', '0')
    )

    assertEquals(1, solution.numIslands(testCase1))
    assertEquals(3, solution.numIslands(testCase2))
    assertEquals(1, solution.numIslands(testCase3))
    assertEquals(1, solution.numIslands(testCase4))
    assertEquals(0, solution.numIslands(testCase5))
    measureTimeMillis { solution.numIslands(specialTestCase()) }.let { println("time is $it") }
}

class NumberOfIslands {

    private val ISLAND: Char = '1'
    private val CONSUMED_ISLAND = '2'
    private val directions = arrayOf(
            Position(0, 1), Position(1, 0), Position(-1, 0), Position(0, -1)
    )

    fun numIslands(grid: Array<CharArray>): Int {
        val queue = ArrayDeque<Position>()

        var row = 0
        var col = 0
        var pos: Position
        val newDir = Position(0, 0)
        var islandsCount = 0

        while (row < grid.size) {

            while (col < grid[row].size) {
                if (grid[row][col] == ISLAND) {
                    queue.add(Position(row, col))
                    grid[row][col] = CONSUMED_ISLAND
                    islandsCount++

                    while (queue.isNotEmpty()) {
                        pos = queue.poll()

                        directions.forEach { direction ->
                            newDir.row = pos.row + direction.row
                            newDir.col = pos.col + direction.col

                            if (grid.isIsland(newDir.row, newDir.col)) {
                                grid[newDir.row][newDir.col] = CONSUMED_ISLAND
                                queue.add(Position(newDir.row, newDir.col))
                            }
                        }
                    }
                }
                col++
            }
            col = 0

            row++
        }

        return islandsCount
    }

    private fun Array<CharArray>.isIsland(row: Int, col: Int): Boolean =
            row in indices &&
                    col in get(row).indices &&
                    get(row)[col] == ISLAND


    class Position(var row: Int, var col: Int)

}

fun specialTestCase() = arrayOf(
        charArrayOf('1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1', '1'),
        charArrayOf('0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '0'),
        charArrayOf('1', '0', '1', '1', '1', '0', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1'),
        charArrayOf('0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '0', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '0'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1')
)