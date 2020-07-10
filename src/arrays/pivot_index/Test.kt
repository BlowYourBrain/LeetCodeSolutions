package arrays.pivot_index

fun main(args: Array<String>) {

    val testArray = arrayOf(-1, -1, 0, 1, 1, 0).toIntArray()

    val solution = FindPivotIndexSolution()

    println("pivot index = ${solution.pivotIndex(testArray)}")

}