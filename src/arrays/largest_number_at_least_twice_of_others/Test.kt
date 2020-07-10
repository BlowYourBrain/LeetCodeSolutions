package arrays.largest_number_at_least_twice_of_others


fun main(args: Array<String>) {

    val testArray = arrayOf(0,0,2,3).toIntArray()

    val solution = LargestNumberAtLeastTwiceOfOthersSolution()

    println("dominant index = ${solution.dominantIndex(testArray)}")

}