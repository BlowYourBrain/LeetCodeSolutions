package queue

import java.util.ArrayDeque

fun main() {
    val solution = GatesAndWalls()
    val testCase = arrayOf(intArrayOf(2147483647,0,2147483647,2147483647,0,2147483647,-1,2147483647))
    solution.wallsAndGates(testCase)
    val expectedAnswer = arrayOf(intArrayOf(1,0,1,1,0,1,-1,2147483647))
    testCase.contentEquals(expectedAnswer)
}


class GatesAndWalls {

    private val EMPTY = Int.MAX_VALUE
    private val GATE = 0

    private val directions = arrayOf(
        Position(1, 0), Position(-1, 0), Position(0, 1), Position(0, -1)
    )

    fun wallsAndGates(rooms: Array<IntArray>): Unit {
        val queue = ArrayDeque<Position>()

        var row = 0
        var col = 0
        val maxRows = rooms.size
        val maxColumns = rooms.first().size

        while (row < maxRows) {
            while (col < maxColumns) {
                if (rooms[row][col] == GATE) {
                    queue.add(Position(row = row, col = col))
                }
                col++
            }
            col = 0
            row++
        }

        while (queue.isNotEmpty()) {
            val point = queue.poll()

            for (direction in directions) {
                val newPoint = Position(
                    point.row + direction.row,
                    point.col + direction.col
                )

                if
                        (
                    newPoint.row < 0 || newPoint.col < 0 ||
                    newPoint.row >= maxRows || newPoint.col >= maxColumns ||
                    rooms[newPoint.row][newPoint.col] != EMPTY
                ) {
                    continue
                }

                rooms[newPoint.row][newPoint.col] = rooms[point.row][point.col] + 1
                queue.add(newPoint)
            }
        }

    }

    class Position(val row: Int, val col: Int)
}