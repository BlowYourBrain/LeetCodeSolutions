package competition.missing_number_in_arithmetic_progression

import kotlin.test.assertEquals

fun main(){
    val solution = Solution()

    assertEquals(9, solution.missingNumber(intArrayOf(5,7,11,13)))
    assertEquals(14, solution.missingNumber(intArrayOf(15,13,12)))
    assertEquals(0, solution.missingNumber(intArrayOf(0, 0, 0, 0, 0)))
}

class Solution {

    private val NOT_FOUND = -1

    fun missingNumber(arr: IntArray): Int {
        if (arr.first() == arr.last()) return arr.first()

        val weight = kotlin.math.abs(arr.first() - arr.last()) / arr.size
        val logic =
                if (arr.first() > arr.last()){
                    ::compareDecreasing
                }else{
                    ::compareIncreasing
                }


        var index = 0

        do {
            if (index + 1 < arr.size ){
                logic(arr, index, weight).let {
                    if (it != NOT_FOUND){
                        return it
                    }
                }
            }
        }while(++index < arr.size)

        return -1
    }


    private fun compareIncreasing(arr: IntArray, index: Int, weight: Int): Int {
        return when{
            arr[index + 1] - arr[index] != weight -> arr[index] + weight
            else -> NOT_FOUND
        }
    }

    private fun compareDecreasing(arr: IntArray, index: Int, weight: Int): Int {
        return when{
            arr[index] - arr[index + 1] != weight -> arr[index] - weight
            else -> NOT_FOUND
        }
    }
}